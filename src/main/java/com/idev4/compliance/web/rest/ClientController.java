
package com.idev4.compliance.web.rest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.codahale.metrics.annotation.Timed;
import com.idev4.compliance.domain.MwAdtVst;
import com.idev4.compliance.dto.DvcRgstrDto;
import com.idev4.compliance.dto.LoanInfoDto;
import com.idev4.compliance.dto.TabDto;
import com.idev4.compliance.service.ComplianceService;
import com.idev4.compliance.service.ComplianceService.DVCDto;
import com.idev4.compliance.service.ComplianceService.PrvVstDto;

@RestController
@RequestMapping ( "/api" )
public class ClientController {
	
	
	@Autowired
	private ComplianceService comp_Ser;
	
	
	@GetMapping("/hello")
    public String getComplianceDataForTab() {
        return "Hello World";
    }
	@GetMapping("/getData/{id}")
    public List< MwAdtVst > getComplianceDataForWeb(@PathVariable Long id) {
        return comp_Ser.getAdtVisitsForBrnch(id);
    }
	
	@GetMapping("/getCompData/{id}")
    public TabDto getComplianceDataForCompWeb(@PathVariable String id) {
        return comp_Ser.getDataForTab(id);
    }
	@GetMapping("/getDvcRegData")
    public List<DvcRgstrDto> getDvcRgstr() {
        return comp_Ser.getDvcReg();
    }
	@GetMapping("/getOneDvcRegData/{id}")
    public DvcRgstrDto getOneDvcRgstr(@PathVariable String id) {
        return comp_Ser.getOneDvcRgstr(id);
    }
	
	
	@GetMapping("/getDVCReg")
    public List<DVCDto> getDVCRegList() {
        return comp_Ser.getDvc_reg();
    }
	@GetMapping("/getPrvVsts/{brnchSeq}")
    public List<PrvVstDto> getPrvVstList(@PathVariable Long brnchSeq) {
        return comp_Ser.getPrvVst(brnchSeq);
    }
	
	@GetMapping("/getDVCRegName/{id}")
    public DVCDto getNameAndPortOfDVCReg(@PathVariable Long id) {
        return comp_Ser.getDvcReg(id);
    }
	
	@GetMapping("/compliance-data")
    public TabDto getComplianceData() {
       // return ResponseEntity.ok().body(comp_Ser.getDataForTab(SecurityContextHolder.getContext().getAuthentication().getName()));
        return comp_Ser.getDataFor();

    }
//	@GetMapping("/compliance-data-for")
//    public ResponseEntity<TabDto> getComplianceDataFor() {
//        log.debug("REST request to get Data For Compliance");
//        return ResponseEntity.ok().body(comp_Ser.getDataForTab(SecurityContextHolder.getContext().getAuthentication().getName()));
//    }
//	
	
}

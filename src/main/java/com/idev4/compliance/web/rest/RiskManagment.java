package com.idev4.compliance.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idev4.compliance.domain.MwAdtVst;
import com.idev4.compliance.dto.AdtVstDto;
import com.idev4.compliance.dto.ComplianceLandingDto;
import com.idev4.compliance.dto.TabDto;
import com.idev4.compliance.service.ComplianceService;
import com.idev4.compliance.service.ComplianceService.SrvtDto;

@RestController
@RequestMapping ( "/api" )
public class RiskManagment {
	private final Logger log = LoggerFactory.getLogger(RiskManagment.class);
	
	private final ComplianceService complianceService;
	public RiskManagment(ComplianceService complianceService) {
		this.complianceService =complianceService;
	}
	 
	@GetMapping("/get-adt-trgt-listing")
	public ResponseEntity<List<ComplianceLandingDto>> getComplianceDataForTab() {
		log.debug("REST request to get ADT TRGT LISTING");
		return ResponseEntity.ok().body(complianceService.getListingForWeb());
	}
	
	@GetMapping("/get-adt-trgt-listing/{brnchSeq}")
	public ResponseEntity<List<MwAdtVst>> getAdtTrgtForBrnch(@PathVariable Long brnchSeq) {
		log.debug("REST request to get ADT VST For BRNCH");
		return ResponseEntity.ok().body(complianceService.getAdtVisitsForBrnch(brnchSeq));
	}
	
	
	@PostMapping("/add-brnch-vst")
    public ResponseEntity<MwAdtVst> addAdtVst(@RequestBody AdtVstDto dto) throws URISyntaxException {
		return ResponseEntity.ok().body(complianceService.addNewVst(dto, SecurityContextHolder.getContext().getAuthentication().getName()));
	}
	
	@PostMapping("/update-brnch-vst")
    public ResponseEntity updateAdtVst( @RequestBody AdtVstDto dto) throws URISyntaxException {
		return complianceService.updateBrnchVst(dto, SecurityContextHolder.getContext().getAuthentication().getName());
	}
	
	@DeleteMapping("/delete-brnch-vst/{vstSeq}")
	public ResponseEntity deleteBrnchVst(@PathVariable Long vstSeq) {
		return complianceService.deleteBrnchVst( vstSeq, SecurityContextHolder.getContext().getAuthentication().getName());
	}
	
	
	
	@GetMapping("/update-vst-status/{vstSeq}")
	public ResponseEntity updateVstStatus(@PathVariable Long vstSeq) {
		log.debug("REST request to update status ADT VST For BRNCH");
		return complianceService.updateStatusOfVst(vstSeq, SecurityContextHolder.getContext().getAuthentication().getName());
	}
	
	@PostMapping("/update-adt-vst")
	public ResponseEntity updateVstStatus(@RequestBody AdtVstDto dto) {
		log.debug("REST request to update ADT VST ");
		return complianceService.updateVst(dto, SecurityContextHolder.getContext().getAuthentication().getName());
	}
	
	@DeleteMapping("/delete-adt-vst/{vstSeq}")
	public ResponseEntity deleteVst(@PathVariable Long vstSeq) {
		log.debug("REST request to update status ADT VST For BRNCH");
		return complianceService.deleteVst(vstSeq, SecurityContextHolder.getContext().getAuthentication().getName());
	}
	
	@GetMapping("/get-vst-srvy/{vstSeq}")
	public List<SrvtDto> getVstSrvy(@PathVariable Long vstSeq) {
		log.debug("REST request to update status ADT VST For BRNCH");
		return complianceService.getVstSrvy(vstSeq);
	}
}

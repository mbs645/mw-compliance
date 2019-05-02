package com.idev4.compliance.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idev4.compliance.dto.TabDto;
import com.idev4.compliance.service.ComplianceService;

@RestController
@RequestMapping ( "/api" )
public class TabDataController {
	
	private final Logger log = LoggerFactory.getLogger(TabDataController.class);
	 private final ComplianceService complianceService;
	 public TabDataController(ComplianceService complianceService) {
		 this.complianceService =complianceService;
	 }
	 
	 
	@GetMapping("/compliance-data-tab")
    public ResponseEntity<TabDto> getComplianceDataForTab() {
        log.debug("REST request to get Data For Compliance");
        return ResponseEntity.ok().body(complianceService.getDataForTab());
    }
}

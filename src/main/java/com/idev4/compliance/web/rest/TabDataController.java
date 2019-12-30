
package com.idev4.compliance.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idev4.compliance.dto.LoanInfoDto;
import com.idev4.compliance.dto.TabDto;
import com.idev4.compliance.dto.tab.ComplianceSubmitDto;
import com.idev4.compliance.dto.tab.MwAdtVstDto;
import com.idev4.compliance.service.ComplianceService;

@RestController
@RequestMapping ( "/api" )
public class TabDataController {

    private final Logger log = LoggerFactory.getLogger( TabDataController.class );

    private final ComplianceService complianceService;

    public TabDataController( ComplianceService complianceService ) {
        this.complianceService = complianceService;
    }

    @GetMapping ( "/compliance-data-tab" )
    public ResponseEntity< TabDto > getComplianceDataForTab() {
        log.debug( "REST request to get Data For Compliance" );
        return ResponseEntity.ok()
                .body( complianceService.getDataForTab( SecurityContextHolder.getContext().getAuthentication().getName() ) );
    }

    /* @GetMapping ( "/calculate-score/{vstseq}/{brnch}" )
    @Timed
    public Long calculateScore( HttpServletResponse response, @PathVariable long vstseq, @PathVariable long brnch ) throws IOException {
        return complianceService.calScore( vstseq, brnch );
    
    }*/

    @GetMapping ( "/compliance-adt-vst" )
    public ResponseEntity< List< MwAdtVstDto > > getComplianceADTVstData() {
        log.debug( "REST request to get Data For Compliance" );
        return ResponseEntity.ok()
                .body( complianceService.getADTVstDataForTab( SecurityContextHolder.getContext().getAuthentication().getName() ) );
    }

    @GetMapping ( "/compliance-clnt-data/{brnchSeq}/{vstSeq}" )
    @Transactional
    public ResponseEntity< List< LoanInfoDto > > getComplianceClntData( @PathVariable Integer brnchSeq, @PathVariable Long vstSeq ) {
        log.debug( "REST request to get Data For Compliance" );
        return complianceService.updateVstStsViaTab( SecurityContextHolder.getContext().getAuthentication().getName(), brnchSeq, vstSeq );
    }

    @PostMapping ( "/submit-compliance-data" )
    public ResponseEntity submitComplianceData( @RequestBody ComplianceSubmitDto dto ) {
        log.debug( "REST request to submit-compliance-data " );
        return complianceService.submitDataForCompliance( dto, SecurityContextHolder.getContext().getAuthentication().getName() );
    }

    /*  @GetMapping ( "/calculate-score/{vstseq}/{brnch}" )
    @Timed
    <<<<<<< HEAD
    public Long calculateScore( HttpServletResponse response, @PathVariable long vstseq, @PathVariable long brnch ) throws IOException {
        return complianceService.calScore( vstseq, brnch );
    }*/

    // @GetMapping ( "/compliance-adt-vst" )
    // public ResponseEntity< List< MwAdtVstDto > > getComplianceADTVstData() {
    // log.debug( "REST request to get Data For Compliance" );
    // return ResponseEntity.ok()
    // .body( complianceService.getADTVstDataForTab( SecurityContextHolder.getContext().getAuthentication().getName() ) );
    // }

    @GetMapping ( "/compliance-clnt-data-for-brnch/{brnchSeq}" )
    public ResponseEntity< List< LoanInfoDto > > getComplianceClntDataByBrnch( @PathVariable Integer brnchSeq ) {
        log.debug( "REST request to get Data For Compliance" );
        return ResponseEntity.ok().body(
                complianceService.getClientDataForTab( SecurityContextHolder.getContext().getAuthentication().getName(), brnchSeq ) );
    }

    @PostMapping ( "/submit-compliance-data-new" )
    public ResponseEntity submitComplianceDataNew( @RequestBody ComplianceSubmitDto dto ) {
        log.debug( "REST request to submit-compliance-data " );
        return complianceService.submitDataForCompliance( dto, SecurityContextHolder.getContext().getAuthentication().getName() );
    }
}

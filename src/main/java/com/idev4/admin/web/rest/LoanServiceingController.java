
package com.idev4.admin.web.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.idev4.admin.domain.MwDthRpt;
import com.idev4.admin.dto.ReportDeathDTO;
import com.idev4.admin.service.LoanServiceingService;

@RestController
@RequestMapping ( "/api" )
public class LoanServiceingController {

    @Autowired
    LoanServiceingService loanServiceingService;

    @PostMapping ( "/report-death" )
    @Timed
    public ResponseEntity< Map > allActiveClnts( @RequestBody ReportDeathDTO dr ) {
        Map< String, Object > resp = new HashMap< String, Object >();
        String currUser = SecurityContextHolder.getContext().getAuthentication().getName();
        if ( dr.clntSeq == null || dr.clntSeq <= 0 ) {
            resp.put( "error", "Seems Incorrect Id !!" );
            return ResponseEntity.badRequest().body( resp );
        }
        if ( dr.deathDt == null || dr.deathDt.isEmpty() ) {
            resp.put( "error", "Death Date is Missing !!" );
            return ResponseEntity.badRequest().body( resp );
        }
        if ( dr.gender == null || dr.deathDt.isEmpty() ) {
            resp.put( "error", "Gender is Missing !!" );
            return ResponseEntity.badRequest().body( resp );
        }
        if ( dr.dethCase == null || dr.dethCase.isEmpty() ) {
            resp.put( "error", "Death Cause is Missing !!" );
            return ResponseEntity.badRequest().body( resp );
        }
        if ( dr.deathcertf == null || dr.deathcertf.isEmpty() ) {
            resp.put( "error", "Death Certificate is Missing !!" );
            return ResponseEntity.badRequest().body( resp );
        }

        MwDthRpt exp = loanServiceingService.addMwDthRpt( dr, currUser );
        resp.put( "expSeq", exp );
        return ResponseEntity.ok().body( resp );

    }

}

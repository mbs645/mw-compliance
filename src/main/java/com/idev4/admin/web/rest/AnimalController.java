
package com.idev4.admin.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.idev4.admin.domain.MwDthRpt;
import com.idev4.admin.dto.AnmlDeathReportDto;
import com.idev4.admin.dto.AnmlListingDto;
import com.idev4.admin.service.MwAnmlRgstrService;

@RestController
@RequestMapping ( "/api" )
public class AnimalController {

    @Autowired
    MwAnmlRgstrService mwAnmlRgstrService;

    @GetMapping ( "/clnts-anml-list/{clntSeq}" )
    @Timed
    public ResponseEntity< List< AnmlListingDto > > allActiveClnts( @PathVariable Long clntSeq ) {
        return new ResponseEntity<>( mwAnmlRgstrService.getAllAnml( clntSeq ), HttpStatus.OK );
    }

    @PostMapping ( "/report-anml-death" )
    @Timed
    public ResponseEntity< Map > allActiveClnts( @RequestBody AnmlDeathReportDto dr ) {
        Map< String, Object > resp = new HashMap< String, Object >();
        String currUser = SecurityContextHolder.getContext().getAuthentication().getName();
        if ( dr.anmlRgstrSeq == null || dr.anmlRgstrSeq <= 0 ) {
            resp.put( "error", "Seems Incorrect Id !!" );
            return ResponseEntity.badRequest().body( resp );
        }
        if ( dr.dthDt == null || dr.dthDt.isEmpty() ) {
            resp.put( "error", "Death Date is Missing !!" );
            return ResponseEntity.badRequest().body( resp );
        }
        if ( dr.dthCase == null || dr.dthCase.isEmpty() ) {
            resp.put( "error", "Death Cause is Missing !!" );
            return ResponseEntity.badRequest().body( resp );
        }

        MwDthRpt exp = mwAnmlRgstrService.addMwDthRpt( dr, currUser );
        resp.put( "expSeq", exp );
        return ResponseEntity.ok().body( resp );

    }

}

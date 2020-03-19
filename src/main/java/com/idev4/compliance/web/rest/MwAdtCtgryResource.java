
package com.idev4.compliance.web.rest;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.idev4.compliance.domain.MwAdtCtgry;
import com.idev4.compliance.domain.MwAdtSubCtgry;
import com.idev4.compliance.dto.AdtCtgryDto;
import com.idev4.compliance.dto.AdtCtgrySlbDto;
import com.idev4.compliance.dto.AdtIsuDto;
import com.idev4.compliance.dto.AdtSubCtgryDto;
import com.idev4.compliance.service.MwAdtCtgryService;
import com.idev4.compliance.domain.MwAdtIsu;
import com.idev4.compliance.domain.MwAdtCtgrySlbs;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing MwArea.
 */
@RestController
@RequestMapping ( "/api" )
public class MwAdtCtgryResource {

    private final Logger log = LoggerFactory.getLogger( MwAdtCtgryResource.class );

    private static final String ENTITY_NAME = "Mw_Adt_Ctgry";

    private final MwAdtCtgryService mwAdtCtgryService;

    public MwAdtCtgryResource( MwAdtCtgryService mwAdtCtgryService ) {
        this.mwAdtCtgryService = mwAdtCtgryService;
    }

    @PostMapping ( "/add-adt-ctgry" )
    @Timed
    public ResponseEntity< MwAdtCtgry > createMwAdtTrgt( @RequestBody AdtCtgryDto dto ) throws URISyntaxException {
        log.debug( "REST request to save MwAdtCtgry : {}", dto );
        return ResponseEntity.ok().body( mwAdtCtgryService.saveMwAdtCtgry( dto ) );
    }

    /**
     * GET /mw-trgts/:trgtYr/:brnchSeq : get the "id" MwAdtTrgt.
     *
     * @param id
     *            the id of the mwArea to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the mwArea, or with status 404 (Not Found)
     */
    @GetMapping ( "/mw-ctgry" )
    @Timed
    public ResponseEntity< List< MwAdtCtgry > > getMwArea() {
        return ResponseUtil.wrapOrNotFound( Optional.ofNullable( mwAdtCtgryService.getAllCtgry() ) );
    }

    @DeleteMapping ( "/mw-ctgry/{adtCtgrySeq}" )
    @Timed
    public ResponseEntity< Map > deleteMwAdtCtgry( @PathVariable Long adtCtgrySeq ) {
        log.debug( "REST request to delete MwArea : {}", adtCtgrySeq );
        Map< String, String > resp = new HashMap< String, String >();
        MwAdtCtgry ctgry = mwAdtCtgryService.deleteMwAdtCtgry( adtCtgrySeq );
        if ( ctgry != null ) {
            resp.put( "success", "Deleted Successfully" );
            return ResponseEntity.ok().body( resp );
        } else {
            resp.put( "error", "Invalid Adt Trgt Seq" );
            return ResponseEntity.badRequest().body( resp );
        }
    }

    @PostMapping ( "/add-adt-sub-ctgry" )
    @Timed
    public ResponseEntity< MwAdtSubCtgry > createMwAdtSubCtgry( @RequestBody AdtSubCtgryDto dto ) throws URISyntaxException {
        log.debug( "REST request to save MwAdtCtgry : {}", dto );
        return ResponseEntity.ok().body( mwAdtCtgryService.saveMwAdtSubCtgry( dto ) );
    }

    /**
     * GET /mw-trgts/:trgtYr/:brnchSeq : get the "id" MwAdtTrgt.
     *
     * @param id
     *            the id of the mwArea to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the mwArea, or with status 404 (Not Found)
     */
    @GetMapping ( "/mw-ctgry/{adtCtgrySeq}" )
    @Timed
    public ResponseEntity< List< MwAdtSubCtgry > > getMwAdtSubCtgry( @PathVariable Long adtCtgrySeq ) {
        return ResponseUtil.wrapOrNotFound( Optional.ofNullable( mwAdtCtgryService.getAllSubCtgry( adtCtgrySeq ) ) );
    }

    @DeleteMapping ( "/mw-sub-ctgry/{sbCtgrySeq}" )
    @Timed
    public ResponseEntity< Map > deleteMwAdtSubCtgry( @PathVariable Long sbCtgrySeq ) {
        log.debug( "REST request to delete MwAdtSubCtgry : {}", sbCtgrySeq );
        Map< String, String > resp = new HashMap< String, String >();
        MwAdtSubCtgry ctgry = mwAdtCtgryService.deleteMwAdtSubCtgry( sbCtgrySeq );
        if ( ctgry != null ) {
            resp.put( "success", "Deleted Successfully" );
            return ResponseEntity.ok().body( resp );
        } else {
            resp.put( "error", "Invalid Adt Trgt Seq" );
            return ResponseEntity.badRequest().body( resp );
        }
    }

    @PostMapping ( "/add-adt-isu" )
    @Timed
    public ResponseEntity< MwAdtIsu > createMwAdtIsu( @RequestBody AdtIsuDto dto ) throws URISyntaxException {
        log.debug( "REST request to save MwAdtIsu : {}", dto );
        return ResponseEntity.ok().body( mwAdtCtgryService.saveMwAdtIsu( dto ) );
    }
    @DeleteMapping ( "/mw-adt-isu/{adtIsuSeq}" )
    @Timed
    public ResponseEntity< Map > deleteMwAdtIsu( @PathVariable Long adtIsuSeq ) {
        log.debug( "REST request to delete MwAdtIsu : {}", adtIsuSeq );
        Map< String, String > resp = new HashMap< String, String >();
        MwAdtIsu ctgry = mwAdtCtgryService.deleteMwAdtIsu( adtIsuSeq );
        if ( ctgry != null ) {
            resp.put( "success", "Deleted Successfully" );
            return ResponseEntity.ok().body( resp );
        } else {
            resp.put( "error", "Invalid Adt Isuue Seq" );
            return ResponseEntity.badRequest().body( resp );
        }
    }
    @GetMapping ( "/get-mw-isu/{sbCtgrySeq}" )
    @Timed
    public ResponseEntity< List< MwAdtIsu > > getMwAdtIsu( @PathVariable Long sbCtgrySeq ) {
        return ResponseUtil.wrapOrNotFound( Optional.ofNullable( mwAdtCtgryService.getAllIsu( sbCtgrySeq ) ) );
    }

    
    
//    @PostMapping ( "/add-adt-ctgry-slb" )
//    @Timed
//    public ResponseEntity< MwAdtCtgrySlbs > createMwAdtCtgrySlb( @RequestBody AdtCtgrySlbDto dto ) throws URISyntaxException {
//        log.debug( "REST request to save MwAdtIsu : {}", dto );
//        return ResponseEntity.ok().body( mwAdtCtgryService.saveMwAdtCtgrySlb( dto ) );
//    }
//    
//    
 
    
    @PostMapping ( "/add-adt-ctgry-slb" )
    @Timed
    public ResponseEntity< List<MwAdtCtgrySlbs>  > createMwAdtCtgrySlb( @RequestBody List<AdtCtgrySlbDto> dto ) throws URISyntaxException {
//        log.debug( "REST request to save MwAdtIsu : {}", dto );
        return ResponseEntity.ok().body( mwAdtCtgryService.saveMwAdtCtgrySlb( dto ) );
    }
    @GetMapping ( "/get-adt-ctgry-slb/{adtCtgrySeq}" )
    @Timed
    public ResponseEntity< List< MwAdtCtgrySlbs > > getMwAdtCtgrySlbs( @PathVariable Long adtCtgrySeq ) {
        return ResponseUtil.wrapOrNotFound( Optional.ofNullable( mwAdtCtgryService.getAllCtgrySlbs( adtCtgrySeq ) ) );
    }
    
}

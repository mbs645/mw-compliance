
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
import com.idev4.compliance.domain.MwAdtTrgt;
import com.idev4.compliance.dto.AdtTrgrDto;
import com.idev4.compliance.service.MwAdtTrgtService;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing MwArea.
 */
@RestController
@RequestMapping ( "/api" )
public class MwAdtTrgtResource {

    private final Logger log = LoggerFactory.getLogger( MwAdtTrgtResource.class );

    private static final String ENTITY_NAME = "Mw_Adt_Trgt";

    private final MwAdtTrgtService mwAdtTrgtService;

    public MwAdtTrgtResource( MwAdtTrgtService mwAdtTrgtService ) {
        this.mwAdtTrgtService = mwAdtTrgtService;
    }

    /**
     * POST /add-adt-trgt : Create a new MwAdtTrgt.
     *
     * @param AdtTrgtDto
     *            the MwAdtTrgt to create
     * @return the ResponseEntity with status 201 (Created) and with body the new mwArea, or with status 400 (Bad Request) if the mwArea has
     *         already an ID
     * @throws URISyntaxException
     *             if the Location URI syntax is incorrect
     */
    @PostMapping ( "/add-adt-trgt" )
    @Timed
    public ResponseEntity< MwAdtTrgt > createMwAdtTrgt( @RequestBody AdtTrgrDto dto ) throws URISyntaxException {
        log.debug( "REST request to save MwArea : {}", dto );
        MwAdtTrgt trgt = null;
        if ( dto.adtTrgtSeq != null && dto.adtTrgtSeq.longValue() != 0 )
            trgt = mwAdtTrgtService.UpdateExistingTrgt( dto );
        else
            trgt = mwAdtTrgtService.addNewTrgt( dto );

        return ResponseEntity.ok().body( trgt );
    }

    /**
     * GET /mw-trgts/:trgtYr/:brnchSeq : get the "id" MwAdtTrgt.
     *
     * @param id
     *            the id of the mwArea to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the mwArea, or with status 404 (Not Found)
     */
    @GetMapping ( "/mw-trgts/{trgtYr}" )
    @Timed
    public ResponseEntity< List< MwAdtTrgt > > getMwArea( @PathVariable Long trgtYr ) {
        log.debug( "REST request to get MwAdtTrgt : {}", trgtYr );
        List< MwAdtTrgt > trgts = mwAdtTrgtService.getAllTrgtsForBrnch( trgtYr);
        return ResponseUtil.wrapOrNotFound( Optional.ofNullable( trgts ) );
    }

    @DeleteMapping ( "/mw-trgt/{adtTrgt}" )
    @Timed
    public ResponseEntity< Map > deleteMwArea( @PathVariable Long adtTrgt ) {
        log.debug( "REST request to delete MwArea : {}", adtTrgt );
        Map< String, String > resp = new HashMap< String, String >();
        MwAdtTrgt trgt = mwAdtTrgtService.delete( adtTrgt );
        if ( trgt != null ) {
            resp.put( "success", "Deleted Successfully" );
            return ResponseEntity.ok().body( resp );
        } else {
            resp.put( "error", "Invalid Adt Trgt Seq" );
            return ResponseEntity.badRequest().body( resp );
        }
    }

}

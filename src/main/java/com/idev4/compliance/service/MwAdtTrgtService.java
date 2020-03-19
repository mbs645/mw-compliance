package com.idev4.compliance.service;

import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idev4.compliance.domain.MwAdtTrgt;
import com.idev4.compliance.dto.AdtTrgrDto;
import com.idev4.compliance.repository.MwAdtTrgtRepository;
import com.idev4.compliance.web.rest.util.SequenceFinder;
import com.idev4.compliance.web.rest.util.Sequences;

/**
 * Service Implementation for managing MwAdtTrgt.
 */
@Service
@Transactional
public class MwAdtTrgtService {

    private final Logger log = LoggerFactory.getLogger( MwAdtTrgtService.class );

    private final MwAdtTrgtRepository mwAdtTrgtRepository;

    public MwAdtTrgtService( MwAdtTrgtRepository mwAdtTrgtRepository ) {
        this.mwAdtTrgtRepository = mwAdtTrgtRepository;
    }

    /**
     * Save a MwAdtTrgt.
     *
     * @param MwAdtTrgt
     *            the entity to save
     * @return the persisted entity
     */
    public MwAdtTrgt save( MwAdtTrgt mwAdtTrgt ) {
        log.debug( "Request to save MwAdtTrgt : {}", mwAdtTrgt );
        return mwAdtTrgtRepository.save( mwAdtTrgt );
    }

    /**
     * Get all the MwAdtTrgts.
     *
     * @param pageable
     *            the pagination information
     * @return the list of entities
     */
    @Transactional ( readOnly = true )
    public Page< MwAdtTrgt > findAll( Pageable pageable ) {
        log.debug( "Request to get all MwCities" );
        return mwAdtTrgtRepository.findAll( pageable );
    }

    /**
     * Get one MwAdtTrgt by id.
     *
     * @param id
     *            the id of the entity
     * @return the entity
     */
    @Transactional ( readOnly = true )
    public MwAdtTrgt findOne( Long adtTrgtSeq ) {
        log.debug( "Request to get MwAdtTrgt : {}", adtTrgtSeq );
        return mwAdtTrgtRepository.findOneByAdtTrgtSeqAndCrntRecFlg( adtTrgtSeq, true );
    }

    /**
     * Delete the MwAdtTrgt by id.
     *
     * @param id
     *            the id of the entity
     */
    public MwAdtTrgt delete( Long citySeq ) {
        log.debug( "Request to delete MwAdtTrgt : {}", citySeq );
        MwAdtTrgt trgt = mwAdtTrgtRepository.findOneByAdtTrgtSeqAndCrntRecFlg( citySeq, true );
        if ( trgt == null ) {
            return null;
        }
        trgt.setCrntRecFlg( false );
        trgt.setDelFlg( true );
        trgt.setLastUpdDt( Instant.now() );
        trgt.setLastUpdBy( SecurityContextHolder.getContext().getAuthentication().getName() );
        trgt.setEffEndDt( Instant.now() );
        return mwAdtTrgtRepository.save( trgt );
    }

    public MwAdtTrgt addNewTrgt( AdtTrgrDto dto ) {
        long seq = SequenceFinder.findNextVal( Sequences.ADT_TRGT_SEQ );
        String currUser = SecurityContextHolder.getContext().getAuthentication().getName();
        MwAdtTrgt trgt = new MwAdtTrgt();
        Instant currIns = Instant.now();
        trgt.setAdtTrgtSeq( seq );
        trgt.setCrntRecFlg( true );
        trgt.setCrtdBy( currUser );
        trgt.setCrtdDt( currIns );
        trgt.setDelFlg( false );
        trgt.setEffStartDt( currIns );
        trgt.setLastUpdBy( currUser );
        trgt.setLastUpdDt( currIns );
        trgt.setBrnchSeq( dto.brnchSeq );
        trgt.setTrgt( dto.trgt );
        trgt.setTrgtYr( dto.trgtYr );
        trgt.setVstTyp(dto.adtFlg);
        return mwAdtTrgtRepository.save( trgt );
    }

    @Transactional
    public MwAdtTrgt UpdateExistingTrgt( AdtTrgrDto dto ) {
        MwAdtTrgt exTrgt = findOne( dto.adtTrgtSeq );
        String currUser = SecurityContextHolder.getContext().getAuthentication().getName();
        Instant currIns = Instant.now();
        if ( exTrgt == null ) {
            return addNewTrgt( dto );
        }

        exTrgt.setCrntRecFlg( false );
        exTrgt.setEffEndDt( currIns );
        exTrgt.setLastUpdBy( currUser );
        exTrgt.setLastUpdDt( currIns );
        mwAdtTrgtRepository.save( exTrgt );

        MwAdtTrgt trgt = new MwAdtTrgt();
        trgt.setAdtTrgtSeq( dto.adtTrgtSeq );
        trgt.setCrntRecFlg( true );
        trgt.setCrtdBy( currUser );
        trgt.setCrtdDt( currIns );
        trgt.setDelFlg( false );
        trgt.setEffStartDt( currIns );
        trgt.setLastUpdBy( currUser );
        trgt.setLastUpdDt( currIns );
        trgt.setBrnchSeq( dto.brnchSeq );
        trgt.setTrgt( dto.trgt );
        trgt.setTrgtYr( dto.trgtYr );
        trgt.setVstTyp(dto.adtFlg);
        return mwAdtTrgtRepository.save( trgt );
    }

    public List< MwAdtTrgt > getAllTrgtsForBrnch( long trgtYr ) {
        return mwAdtTrgtRepository.findAllByTrgtYrAndCrntRecFlg( trgtYr, true );
    }
}

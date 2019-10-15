
package com.idev4.compliance.service;

import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idev4.compliance.domain.MwAdtCtgry;
import com.idev4.compliance.domain.MwAdtSubCtgry;
import com.idev4.compliance.dto.AdtCtgryDto;
import com.idev4.compliance.dto.AdtSubCtgryDto;
import com.idev4.compliance.repository.MwAdtCtgryRepository;
import com.idev4.compliance.repository.MwAdtSubCtgryRepository;
import com.idev4.compliance.web.rest.util.SequenceFinder;
import com.idev4.compliance.web.rest.util.Sequences;

/**
 * Service Implementation for managing MwAdtTrgt.
 */
@Service
@Transactional
public class MwAdtCtgryService {

    private final Logger log = LoggerFactory.getLogger( MwAdtCtgryService.class );

    private final MwAdtCtgryRepository mwAdtCtgryRepository;

    private final MwAdtSubCtgryRepository mwAdtSubCtgryRepository;

    public MwAdtCtgryService( MwAdtCtgryRepository mwAdtCtgryRepository, MwAdtSubCtgryRepository mwAdtSubCtgryRepository ) {
        this.mwAdtCtgryRepository = mwAdtCtgryRepository;
        this.mwAdtSubCtgryRepository = mwAdtSubCtgryRepository;
    }

    /**
     * String currUser = SecurityContextHolder.getContext().getAuthentication().getName(); Save a MwAdtTrgt.
     *
     * @param MwAdtTrgt
     *            the entity to save
     * @return the persisted entity
     */
    public List< MwAdtCtgry > getAllCtgry() {
        return mwAdtCtgryRepository.findAllByCrntRecFlg( true );
    }

    public MwAdtCtgry saveMwAdtCtgry( AdtCtgryDto dto ) {
        String currUser = SecurityContextHolder.getContext().getAuthentication().getName();
        Long seq = null;
        if ( dto.adtCtgrySeq != null ) {
            seq = dto.adtCtgrySeq;
            MwAdtCtgry exCtgry = mwAdtCtgryRepository.findOneByAdtCtgrySeqAndCrntRecFlg( dto.adtCtgrySeq, true );
            if ( exCtgry != null ) {
                exCtgry.setCrntRecFlg( false );
                exCtgry.setDelFlg( true );
                exCtgry.setLastUpdBy( currUser );
                exCtgry.setLastUpdDt( Instant.now() );
                exCtgry.setEffEndDt( Instant.now() );
                mwAdtCtgryRepository.save( exCtgry );
            }
        } else {
            seq = SequenceFinder.findNextVal( Sequences.ADT_CTGRY_SEQ );
        }
        MwAdtCtgry ctgry = new MwAdtCtgry();
        ctgry.setAdtCtgrySeq( seq );
        ctgry.setCalcTyp( dto.calcTyp );
        ctgry.setCrntRecFlg( true );
        ctgry.setCrtdBy( currUser );
        ctgry.setCrtdDt( Instant.now() );
        ctgry.setCtgryCmnt( dto.ctgryCmnt );
        ctgry.setCtgryId( dto.ctgryId );
        ctgry.setCtgryNm( dto.ctgryNm );
        ctgry.setCtgryScr( dto.ctgryScr );
        ctgry.setCtgryTyp( dto.ctgryTyp );
        ctgry.setDelFlg( false );
        ctgry.setEffStartDt( Instant.now() );
        ctgry.setLastUpdBy( currUser );
        ctgry.setLastUpdDt( Instant.now() );
        mwAdtCtgryRepository.save( ctgry );

        return ctgry;
    }

    public MwAdtCtgry deleteMwAdtCtgry( long seq ) {
        String currUser = SecurityContextHolder.getContext().getAuthentication().getName();
        MwAdtCtgry exCtgry = mwAdtCtgryRepository.findOneByAdtCtgrySeqAndCrntRecFlg( seq, true );
        if ( exCtgry != null ) {
            exCtgry.setCrntRecFlg( false );
            exCtgry.setDelFlg( true );
            exCtgry.setLastUpdBy( currUser );
            exCtgry.setLastUpdDt( Instant.now() );
            exCtgry.setEffEndDt( Instant.now() );
            return mwAdtCtgryRepository.save( exCtgry );
        } else {
            return null;
        }
    }

    public List< MwAdtSubCtgry > getAllSubCtgry( long seq ) {
        return mwAdtSubCtgryRepository.findAllByAdtCtgrySeqAndCrntRecFlg( seq, true );
    }

    public MwAdtSubCtgry saveMwAdtSubCtgry( AdtSubCtgryDto dto ) {
        String currUser = SecurityContextHolder.getContext().getAuthentication().getName();
        Long seq = null;
        if ( dto.sbCtgrySeq != null ) {
            seq = dto.sbCtgrySeq;
            MwAdtSubCtgry exCtgry = mwAdtSubCtgryRepository.findAllBySbCtgrySeqAndCrntRecFlg( dto.sbCtgrySeq, true );
            if ( exCtgry != null ) {
                exCtgry.setCrntRecFlg( false );
                exCtgry.setDelFlg( true );
                exCtgry.setLastUpdBy( currUser );
                exCtgry.setLastUpdDt( Instant.now() );
                exCtgry.setEffEndDt( Instant.now() );
                mwAdtSubCtgryRepository.save( exCtgry );
            }
        } else {
            seq = SequenceFinder.findNextVal( Sequences.SB_CTGRY_SEQ );
        }
        MwAdtSubCtgry ctgry = new MwAdtSubCtgry();
        ctgry.setSbCtgrySeq( seq );
        ctgry.setAdtCtgrySeq( dto.adtCtgrySeq );
        ctgry.setSubCtgryCmnt( dto.subCtgryCmnt );
        ctgry.setSubCtgryId( dto.subCtgryId );
        ctgry.setSubCtgryNm( dto.subCtgryNm );
        ctgry.setCrntRecFlg( true );
        ctgry.setCrtdBy( currUser );
        ctgry.setCrtdDt( Instant.now() );
        ctgry.setDelFlg( false );
        ctgry.setEffStartDt( Instant.now() );
        ctgry.setLastUpdBy( currUser );
        ctgry.setLastUpdDt( Instant.now() );
        mwAdtSubCtgryRepository.save( ctgry );

        return ctgry;
    }

    public MwAdtSubCtgry deleteMwAdtSubCtgry( long seq ) {
        String currUser = SecurityContextHolder.getContext().getAuthentication().getName();
        MwAdtSubCtgry exCtgry = mwAdtSubCtgryRepository.findAllBySbCtgrySeqAndCrntRecFlg( seq, true );
        if ( exCtgry != null ) {
            exCtgry.setCrntRecFlg( false );
            exCtgry.setDelFlg( true );
            exCtgry.setLastUpdBy( currUser );
            exCtgry.setLastUpdDt( Instant.now() );
            exCtgry.setEffEndDt( Instant.now() );
            return mwAdtSubCtgryRepository.save( exCtgry );
        } else {
            return null;
        }
    }
}

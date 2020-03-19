
package com.idev4.compliance.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idev4.compliance.domain.MwAdtCtgry;
import com.idev4.compliance.domain.MwAdtCtgrySlbs;
import com.idev4.compliance.domain.MwAdtIsu;
import com.idev4.compliance.domain.MwAdtSubCtgry;
import com.idev4.compliance.dto.AdtCtgryDto;
import com.idev4.compliance.dto.AdtCtgrySlbDto;
import com.idev4.compliance.dto.AdtIsuDto;
import com.idev4.compliance.dto.AdtSubCtgryDto;
import com.idev4.compliance.repository.MwAdtCtgryRepository;
import com.idev4.compliance.repository.MwAdtCtgrySlbsRepository;
import com.idev4.compliance.repository.MwAdtIsuRepository;
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
    
    private final MwAdtIsuRepository mwAdtIsuRepository;

    private final MwAdtCtgrySlbsRepository mwAdtCtgrySlbsRepository;
    public MwAdtCtgryService( MwAdtCtgryRepository mwAdtCtgryRepository, MwAdtSubCtgryRepository mwAdtSubCtgryRepository,MwAdtIsuRepository mwAdtIsuRepository,MwAdtCtgrySlbsRepository mwAdtCtgrySlbsRepository ) {
        this.mwAdtCtgryRepository = mwAdtCtgryRepository;
        this.mwAdtSubCtgryRepository = mwAdtSubCtgryRepository;
        this.mwAdtIsuRepository=mwAdtIsuRepository;
        this.mwAdtCtgrySlbsRepository=mwAdtCtgrySlbsRepository;
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
//            MwAdtCtgry exCtgry = mwAdtCtgryRepository.findOneByAdtCtgrySeqAndCtgryIdAndCrntRecFlg( dto.adtCtgrySeq,dto.ctgryId, true );

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
        ctgry.setCtgryId(seq+"" );
        ctgry.setCtgryNm( dto.ctgryNm );
        ctgry.setCtgryScr( dto.ctgryScr );
        ctgry.setCtgryTyp( dto.ctgryTyp );
        ctgry.setDelFlg( false );
        ctgry.setEffStartDt( Instant.now() );
        ctgry.setLastUpdBy( currUser );
        ctgry.setLastUpdDt( Instant.now() );
        ctgry.setCtgryEntyFlg(dto.ctgryEntyFlg);
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
        ctgry.setSubCtgryId( seq+"" );
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
    
    
    public MwAdtIsu saveMwAdtIsu( AdtIsuDto dto ) {
   	 String currUser = SecurityContextHolder.getContext().getAuthentication().getName();
        Long seq = null;
        if ( dto.adtIsuSeq != null ) {
            seq = dto.adtIsuSeq;

       	 MwAdtIsu exIsu=mwAdtIsuRepository.findAllByAdtIsuSeqAndCrntRecFlg(dto.adtIsuSeq,true);
       	 if(exIsu!=null) {
       		 exIsu.setCrntRecFlg( false );
       		 exIsu.setDelFlg( true );
       		 exIsu.setLastUpdBy( currUser );
       		 exIsu.setLastUpdDt( Instant.now() );
       		 exIsu.setEffEndDt( Instant.now() );
       		 mwAdtIsuRepository.save( exIsu );
       	 }
        }
       	 else {
                seq = SequenceFinder.findNextVal( Sequences.ADT_ISU_SEQ );
            }
       	 MwAdtIsu mwAdtIsu=new MwAdtIsu();
       	 mwAdtIsu.setAdtIsuSeq(seq);
       	 mwAdtIsu.setSbCtgrySeq( dto.sbCtgrySeq );
       	 mwAdtIsu.setIsuId(seq+"" );
       	 mwAdtIsu.setIsuNm( dto.isuNm );
       	 mwAdtIsu.setCrntRecFlg( true );
       	 mwAdtIsu.setCrtdBy( currUser );
       	 mwAdtIsu.setCrtdDt( Instant.now() );
       	 mwAdtIsu.setDelFlg( false );
       	 mwAdtIsu.setEffStartDt( Instant.now() );
       	 mwAdtIsu.setLastUpdBy( currUser );
       	 mwAdtIsu.setLastUpdDt( Instant.now() );
       	 mwAdtIsuRepository.save( mwAdtIsu );

            return mwAdtIsu;
        
   }

    public MwAdtIsu deleteMwAdtIsu( long seq ) {
        String currUser = SecurityContextHolder.getContext().getAuthentication().getName();
        MwAdtIsu exCtgry = mwAdtIsuRepository.findAllByAdtIsuSeqAndCrntRecFlg( seq, true );
        if ( exCtgry != null ) {
            exCtgry.setCrntRecFlg( false );
            exCtgry.setDelFlg( true );
            exCtgry.setLastUpdBy( currUser );
            exCtgry.setLastUpdDt( Instant.now() );
            exCtgry.setEffEndDt( Instant.now() );
            return mwAdtIsuRepository.save( exCtgry );
        } else {
            return null;
        }
    }
    
    
    public List< MwAdtIsu > getAllIsu( long seq ) {
        return mwAdtIsuRepository.findAllBySbCtgrySeqAndCrntRecFlg(seq,true);
    }
    
    public List< MwAdtCtgrySlbs > getAllCtgrySlbs( long seq ) {
        return mwAdtCtgrySlbsRepository.findAllByAdtCtgrySeqAndCrntRecFlgOrderByStartLmtAsc(seq,true);
    }
    public MwAdtCtgrySlbs saveMwAdtCtgrySlb( AdtCtgrySlbDto dto ) {
      	 String currUser = SecurityContextHolder.getContext().getAuthentication().getName();
           Long seq = null;
           if ( dto.catSlbSeq != null ) {
               seq = dto.catSlbSeq;

//          	 MwAdtCtgrySlbs exIsu=mwAdtCtgrySlbsRepository.findOneByAdtCtgrySlbsSeqAndCrntRecFlg(dto.catSlbSeq,true);
          	 List<MwAdtCtgrySlbs> exIsus=mwAdtCtgrySlbsRepository.findAllByAdtCtgrySeqAndCrntRecFlgOrderByStartLmtAsc(dto.adtCtgrySeq,true);

          	 for(MwAdtCtgrySlbs exIsu: exIsus) {
          		 exIsu.setCrntRecFlg( false );
          		 exIsu.setDelFlg( true );
          		 exIsu.setLastUpdBy( currUser );
          		 exIsu.setLastUpdDt( Instant.now() );
          		 exIsu.setEffEndDt( Instant.now() );
          		mwAdtCtgrySlbsRepository.save( exIsu );
          	 }
           }
          	 else {
                   seq = SequenceFinder.findNextVal( Sequences.ADT_CTGRY_SLBS_SEQ );
               } 
           MwAdtCtgrySlbs mwAdtCtgrySlbs=new MwAdtCtgrySlbs();
          	 mwAdtCtgrySlbs.setAdtCtgrySlbsSeq(seq);
          	 mwAdtCtgrySlbs.setAdtCtgrySeq(dto.adtCtgrySeq);
          	mwAdtCtgrySlbs.setDedScr(dto.val);
          	mwAdtCtgrySlbs.setStartLmt(dto.startLmt);
          	mwAdtCtgrySlbs.setEndLmt(dto.endLmt);
          	 mwAdtCtgrySlbs.setCrntRecFlg( true );
          	 mwAdtCtgrySlbs.setCrtdBy( currUser );
          	 mwAdtCtgrySlbs.setCrtdDt( Instant.now() );
          	 mwAdtCtgrySlbs.setDelFlg( false );
          	 mwAdtCtgrySlbs.setEffStartDt( Instant.now() );
          	 mwAdtCtgrySlbs.setLastUpdBy( currUser );
          	 mwAdtCtgrySlbs.setLastUpdDt( Instant.now() );
          	mwAdtCtgrySlbsRepository.save( mwAdtCtgrySlbs );

              return mwAdtCtgrySlbs;
           
      }

    public List<MwAdtCtgrySlbs> saveMwAdtCtgrySlb( List<AdtCtgrySlbDto> dto ) {
     	 String currUser = SecurityContextHolder.getContext().getAuthentication().getName();
     	List<MwAdtCtgrySlbs> adtCtgrySlbList=new ArrayList();
              List<MwAdtCtgrySlbs> exIsus=mwAdtCtgrySlbsRepository.findAllByAdtCtgrySeqAndCrntRecFlgOrderByStartLmtAsc(dto.get(0).adtCtgrySeq,true);

           	 for(MwAdtCtgrySlbs exIsu: exIsus) {
           		 exIsu.setCrntRecFlg( false );
           		 exIsu.setDelFlg( true );
           		 exIsu.setLastUpdBy( currUser );
           		 exIsu.setLastUpdDt( Instant.now() );
           		 exIsu.setEffEndDt( Instant.now() );
           		mwAdtCtgrySlbsRepository.save( exIsu );
           	 }

             for(int i=0;i<dto.size();i++) {
                 Long seq = SequenceFinder.findNextVal( Sequences.ADT_CTGRY_SLBS_SEQ );
              MwAdtCtgrySlbs mwAdtCtgrySlbs=new MwAdtCtgrySlbs();
          	 mwAdtCtgrySlbs.setAdtCtgrySlbsSeq(seq);
          	 mwAdtCtgrySlbs.setAdtCtgrySeq(dto.get(i).adtCtgrySeq);
          	mwAdtCtgrySlbs.setDedScr(dto.get(i).val);
          	mwAdtCtgrySlbs.setStartLmt(dto.get(i).startLmt);
          	mwAdtCtgrySlbs.setEndLmt(dto.get(i).endLmt);
          	 mwAdtCtgrySlbs.setCrntRecFlg( true );
          	 mwAdtCtgrySlbs.setCrtdBy( currUser );
          	 mwAdtCtgrySlbs.setCrtdDt( Instant.now() );
          	 mwAdtCtgrySlbs.setDelFlg( false );
          	 mwAdtCtgrySlbs.setEffStartDt( Instant.now() );
          	 mwAdtCtgrySlbs.setLastUpdBy( currUser );
          	 mwAdtCtgrySlbs.setLastUpdDt( Instant.now() );
       		adtCtgrySlbList.add(mwAdtCtgrySlbs);

          	mwAdtCtgrySlbsRepository.save( mwAdtCtgrySlbs );


          }
          return adtCtgrySlbList;
          
         
          
     }

}

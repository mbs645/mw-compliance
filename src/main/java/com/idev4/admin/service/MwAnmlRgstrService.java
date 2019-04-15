
package com.idev4.admin.service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idev4.admin.domain.MwDthRpt;
import com.idev4.admin.dto.AnmlDeathReportDto;
import com.idev4.admin.dto.AnmlListingDto;
import com.idev4.admin.repository.MwDthRptRepository;
import com.idev4.admin.web.rest.util.SequenceFinder;
import com.idev4.admin.web.rest.util.Sequences;

@Service
public class MwAnmlRgstrService {

    @Autowired
    MwDthRptRepository mwDthRptRepository;

    @Autowired
    EntityManager em;

    @Autowired
    Utils utils;

    public List< AnmlListingDto > getAllAnml( long clntSeq ) {

        Query anmlsListQury = em.createNativeQuery(
                "select ar.anml_rgstr_seq,ar.rgstr_cd,ar.tag_num, knd.ref_cd_dscr knd,typ.ref_cd_dscr typ,ar.ANML_BRD,ar.prch_dt, ar.age_yr, ar.age_mnth, ar.prch_amt,dr.dt_of_dth,dr.cause_of_dth \r\n"
                        + "from mw_anml_rgstr ar\r\n" + "join mw_ref_cd_val knd on knd.ref_cd_seq=ar.anml_knd and knd.crnt_rec_flg=1\r\n"
                        + "join mw_ref_cd_val typ on typ.ref_cd_seq=ar.anml_typ and typ.crnt_rec_flg=1\r\n"
                        + "join mw_loan_app la on la.loan_app_seq = ar.loan_app_seq and la.crnt_rec_flg = 1\r\n"
                        + "left outer join mw_dth_rpt dr on dr.clnt_seq =ar.anml_rgstr_seq and dr.clnt_nom_flg=3\r\n"
                        + "where ar.crnt_rec_flg = 1 and la.clnt_seq=:clntSeq" )
                .setParameter( "clntSeq", clntSeq );

        List< Object[] > anmlList = anmlsListQury.getResultList();
        List< AnmlListingDto > listing = new ArrayList< AnmlListingDto >();
        anmlList.forEach( a -> {
            AnmlListingDto dto = new AnmlListingDto();
            dto.anmlRgstrSeq = a[ 0 ] == null ? 0 : new BigDecimal( a[ 0 ].toString() ).longValue();

            dto.rgstrCd = a[ 1 ] == null ? "" : a[ 1 ].toString();

            dto.tagNum = a[ 2 ] == null ? "" : a[ 2 ].toString();

            dto.anmlKnd = a[ 3 ] == null ? "" : a[ 3 ].toString();

            dto.anmlTyp = a[ 4 ] == null ? "" : a[ 4 ].toString();

            dto.anmlBrd = a[ 5 ] == null ? "" : a[ 5 ].toString();

            dto.prchDt = a[ 6 ] == null ? "" : a[ 6 ].toString();

            dto.ageYr = a[ 7 ] == null ? 0 : new BigDecimal( a[ 7 ].toString() ).longValue();

            dto.ageMnth = a[ 8 ] == null ? 0 : new BigDecimal( a[ 8 ].toString() ).longValue();

            dto.prchAmt = a[ 9 ] == null ? 0 : new BigDecimal( a[ 9 ].toString() ).longValue();

            dto.dthDt = a[ 10 ] == null ? "" : a[ 10 ].toString();

            dto.dthCase = a[ 11 ] == null ? "" : a[ 11 ].toString();
            listing.add( dto );
        } );

        return listing;

    }

    public MwDthRpt addMwDthRpt( AnmlDeathReportDto dr, String user ) {
        long seq = SequenceFinder.findNextVal( Sequences.DTH_RPT_SEQ );
        MwDthRpt entity = new MwDthRpt();
        Instant now = Instant.now();
        entity.setDthRptSeq( seq );
        entity.setClntSeq( dr.anmlRgstrSeq );
        entity.setEffStartDt( now );
        entity.setClntNomFlg( 3 );
        entity.setDtOfDth( utils.parseStringDate( dr.dthDt ) );
        entity.setCauseOfDth( dr.dthCase );
        entity.setDthCertNum( null );
        entity.setCrtdBy( user );
        entity.setCrtdDt( now );
        entity.setLastUpdBy( user );
        entity.setLastUpdDt( now );
        entity.setDelFlg( false );
        entity.setCrntRecFlg( true );
        entity.setAmt( 0L );
        return mwDthRptRepository.save( entity );

    }

}

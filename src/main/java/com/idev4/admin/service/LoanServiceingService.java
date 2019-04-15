
package com.idev4.admin.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idev4.admin.domain.MwDthRpt;
import com.idev4.admin.dto.ReportDeathDTO;
import com.idev4.admin.repository.MwDthRptRepository;
import com.idev4.admin.web.rest.util.SequenceFinder;
import com.idev4.admin.web.rest.util.Sequences;

@Service
public class LoanServiceingService {

    @Autowired
    MwDthRptRepository mwDthRptRepository;

    @Autowired
    EntityManager em;

    @Autowired
    ServiceClient serviceClient;

    @Autowired
    Utils utils;

    private final long FUNREAL_CHARGES = 5000;

    public MwDthRpt addMwDthRpt( ReportDeathDTO dr, String user, String token ) {
        long seq = SequenceFinder.findNextVal( Sequences.DTH_RPT_SEQ );
        MwDthRpt entity = new MwDthRpt();
        Instant now = Instant.now();
        entity.setDthRptSeq( seq );
        entity.setClntSeq( dr.clntSeq );
        entity.setEffStartDt( now );
        entity.setClntNomFlg( dr.gender );
        entity.setDtOfDth( utils.parseStringDateToInstant( dr.deathDt ) );
        entity.setCauseOfDth( dr.dethCase );
        entity.setDthCertNum( dr.deathcertf );
        entity.setCrtdBy( user );
        entity.setCrtdDt( now );
        entity.setLastUpdBy( user );
        entity.setLastUpdDt( now );
        entity.setDelFlg( false );
        entity.setCrntRecFlg( true );
        entity.setAmt( payFunral( dr.clntSeq ) );
        String date = new SimpleDateFormat( "dd-MM-yyyy" ).format( utils.parseStringDateToDate( dr.deathDt ) );
        serviceClient.reverseAdvanceRecoveries( dr.clntSeq, date, token );
        return mwDthRptRepository.save( entity );

    }

    private long payFunral( long clntSeq ) {
        Query query = em.createNativeQuery( "select sum(sum(psc.amt)-sum(rd.pymt_amt))\r\n" + "from mw_loan_app la\r\n"
                + "join mw_pymt_sched_hdr psh on la.loan_app_seq=psh.loan_app_seq and psh.crnt_rec_flg=1\r\n"
                + "join mw_pymt_sched_dtl psd on psh.pymt_sched_hdr_seq=psd.pymt_sched_hdr_seq and psd.crnt_rec_flg=1\r\n"
                + "join mw_pymt_sched_chrg psc on psd.pymt_sched_dtl_seq=psc.pymt_sched_dtl_seq and psc.crnt_rec_flg=1\r\n"
                + "left outer join mw_rcvry_dtl rd on rd.pymt_sched_dtl_seq=psd.pymt_sched_dtl_seq and rd.CHRG_TYP_KEY=psc.CHRG_TYPS_SEQ and rd.crnt_rec_flg=1\r\n"
                + "where la.clnt_seq=:clntSeq and la.crnt_rec_flg=1\r\n" + "group by psc.CHRG_TYPS_SEQ" )
                .setParameter( "clntSeq", clntSeq );
        Object chargs = query.getSingleResult();

        return FUNREAL_CHARGES - ( chargs == null ? 0 : new BigDecimal( chargs.toString() ).longValue() );
    }

}

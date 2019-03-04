
package com.idev4.admin.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idev4.admin.dto.LoanServingDTO;
import com.idev4.admin.repository.ClientRepository;

@Service
public class MwClntService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    EntityManager em;

    public List< LoanServingDTO > getAllActiveClint( String user ) {
        Query query = em.createNativeQuery( "SELECT clnt_id,\r\n" + "         clnt_seq,\r\n" + "         frst_nm,\r\n"
                + "         last_nm,\r\n" + "         SUM (ppal_amt_due),\r\n" + "         SUM (tot_chrg_due),\r\n"
                + "         max (rcvd_amt),\r\n" + "         dth_rpt_seq,\r\n" + "         MAX (amt),\r\n" + "         brnch_seq,\r\n"
                + "         exp_seq,\r\n" + "         LISTAGG (prd_cmnt, ',') WITHIN GROUP (ORDER BY clnt_seq)     prd_cmnt,\r\n"
                + "         loan_app_sts_dt,\r\n" + "         rel_typ_flg\r\n" + "    FROM (  SELECT clnt.clnt_id,\r\n"
                + "                   clnt.clnt_seq,\r\n" + "                   clnt.frst_nm,\r\n" + "                   clnt.last_nm,\r\n"
                + "                   SUM (ppal_amt_due)\r\n" + "                       ppal_amt_due,\r\n"
                + "                   SUM (tot_chrg_due)\r\n" + "                       tot_chrg_due,\r\n"
                + "                   max (rcvry_amt) rcvd_amt,\r\n" + "                   dr.dth_rpt_seq,\r\n"
                + "                   MAX (dr.amt)\r\n" + "                       amt,\r\n" + "                   brnch.brnch_seq,\r\n"
                + "                   e.exp_seq,\r\n" + "                   prd_cmnt,\r\n"
                + "                   TRUNC (app.loan_app_sts_dt)\r\n" + "                       loan_app_sts_dt,\r\n"
                + "                   rel.rel_typ_flg\r\n" + "              FROM mw_clnt clnt\r\n"
                + "                   JOIN mw_loan_app app\r\n"
                + "                       ON app.clnt_seq = clnt.clnt_seq AND app.crnt_rec_flg = 1\r\n"
                + "                   JOIN mw_pymt_sched_hdr psh\r\n"
                + "                       ON     app.loan_app_seq = psh.loan_app_seq\r\n"
                + "                          AND psh.crnt_rec_flg = 1\r\n" + "                   JOIN mw_pymt_sched_dtl psd\r\n"
                + "                       ON     psh.pymt_sched_hdr_seq = psd.pymt_sched_hdr_seq\r\n"
                + "                          AND psd.crnt_rec_flg = 1\r\n" + "                   JOIN mw_ref_cd_val val\r\n"
                + "                       ON     val.ref_cd_seq = app.loan_app_sts\r\n"
                + "                          AND val.crnt_rec_flg = 1\r\n" + "                          AND val.del_flg = 0\r\n"
                + "                          AND val.ref_cd = '0005'\r\n" + "                   JOIN mw_ref_cd_grp grp\r\n"
                + "                       ON     grp.ref_cd_grp_seq = val.ref_cd_grp_key\r\n"
                + "                          AND grp.crnt_rec_flg = 1\r\n" + "                          AND grp.ref_cd_grp = '0106'\r\n"
                + "                   JOIN mw_prd p\r\n" + "                       ON p.prd_seq = app.prd_seq AND p.crnt_rec_flg = 1\r\n"
                + "                   JOIN mw_port port\r\n"
                + "                       ON port.port_seq = clnt.port_key AND port.crnt_rec_flg = 1\r\n"
                + "                   JOIN mw_brnch brnch\r\n" + "                       ON     brnch.brnch_seq = port.brnch_seq\r\n"
                + "                          AND brnch.crnt_rec_flg = 1\r\n" + "                   JOIN mw_acl acl\r\n"
                + "                       ON acl.port_seq = app.port_seq AND acl.user_id =:user\r\n"
                + "                   left outer join (SELECT pymt_ref clnt_seq,SUM(pymt_amt) rcvry_amt FROM mw_rcvry_trx WHERE crnt_rec_flg = 1 group by pymt_ref) rcvry on\r\n"
                + "                          rcvry.clnt_seq=clnt.clnt_seq\r\n" + "                   LEFT OUTER JOIN mw_dth_rpt dr\r\n"
                + "                       ON dr.clnt_seq = clnt.clnt_seq AND dr.crnt_rec_flg = 1 and dr.crtd_dt>app.crtd_dt\r\n"
                + "                   LEFT OUTER JOIN mw_exp e\r\n"
                + "                       ON e.exp_ref = clnt.clnt_seq AND e.crnt_rec_flg = 1  and e.CRTD_DT>app.CRTD_DT\r\n"
                + "                   LEFT OUTER JOIN mw_clnt_rel rel\r\n"
                + "                       ON     rel.loan_app_seq = app.prnt_loan_app_seq\r\n"
                + "                          AND rel.crnt_rec_flg = 1\r\n" + "                          AND rel.rel_typ_flg = 1\r\n"
                + "             WHERE clnt.crnt_rec_flg = 1\r\n" + "          GROUP BY clnt.clnt_id,\r\n"
                + "                   clnt.clnt_seq,\r\n" + "                   clnt.frst_nm,\r\n" + "                   clnt.last_nm,\r\n"
                + "                   dr.dth_rpt_seq,\r\n" + "                   brnch.brnch_seq,\r\n" + "                   e.exp_seq,\r\n"
                + "                   prd_cmnt,\r\n" + "                   TRUNC (app.loan_app_sts_dt),\r\n"
                + "                   rel.rel_typ_flg)\r\n" + "GROUP BY clnt_id,\r\n" + "         clnt_seq,\r\n" + "         frst_nm,\r\n"
                + "         last_nm,\r\n" + "         dth_rpt_seq,\r\n" + "         brnch_seq,\r\n" + "         exp_seq,\r\n"
                + "         loan_app_sts_dt,\r\n" + "         rel_typ_flg" ).setParameter( "user", user );
        List< Object[] > clnts = query.getResultList();

        List< LoanServingDTO > dtoList = new ArrayList();
        clnts.forEach( c -> {
            LoanServingDTO dto = new LoanServingDTO();
            dto.clntId = c[ 0 ].toString();
            dto.clntSeq = c[ 1 ].toString();
            dto.frstNm = c[ 2 ] == null ? "" : c[ 2 ].toString();
            dto.lastNm = c[ 3 ] == null ? "" : c[ 3 ].toString();
            dto.loanAmt = c[ 4 ] == null ? 0 : new BigDecimal( c[ 4 ].toString() ).longValue();
            dto.sercvChrgs = c[ 5 ] == null ? 0 : new BigDecimal( c[ 5 ].toString() ).longValue();
            dto.rcvdAmt = c[ 6 ] == null ? 0 : new BigDecimal( c[ 6 ].toString() ).longValue();
            dto.dthRptSeq = c[ 7 ] == null ? 0 : new BigDecimal( c[ 7 ].toString() ).longValue();
            dto.amt = c[ 8 ] == null ? 0 : new BigDecimal( c[ 8 ].toString() ).longValue();
            dto.brnchSeq = c[ 9 ] == null ? 0 : new BigDecimal( c[ 9 ].toString() ).longValue();
            dto.paid = c[ 10 ] == null ? false : true;
            dto.prd = c[ 11 ] == null ? "" : c[ 11 ].toString();
            dto.disDate = c[ 12 ] == null ? "" : c[ 12 ].toString();
            dto.relTypFlg = c[ 13 ] == null ? 0 : new BigDecimal( c[ 13 ].toString() ).longValue();
            dtoList.add( dto );
        } );
        return dtoList;

    }

    private String getFormaedDate( String input ) {
        String date = "";
        DateFormat inputFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.S" );
        try {
            date = new SimpleDateFormat( "dd-MM-yyyy" ).format( inputFormat.parse( input ) );
        } catch ( ParseException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

}

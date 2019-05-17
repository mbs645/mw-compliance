
package com.idev4.compliance.dto.tab;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;

import com.idev4.compliance.domain.MwAdtVstSrvy;
import com.idev4.compliance.web.rest.util.Common;

public class MwAdtVstSrvyDto {

    public Long adt_vst_srvy_seq;
    
    public Long adt_vst_seq;

    public String eff_start_dt;

    public Integer enty_typ_flg;

    public Long enty_seq;

    public Long qst_seq;

    public Long answr_seq;

    public String last_upd_by;

    public String last_upd_dt;

    public String eff_end_dt;

    public String crtd_by;

    public String crtd_dt;
    
    public String cmnt;

    public Integer crnt_rec_flg;

    public Integer del_flg;

    public MwAdtVstSrvy DtoToDomain( DateFormat formatter, DateFormat simpleFormatter ) {
    	MwAdtVstSrvy dom = new MwAdtVstSrvy();
    	dom.setAdtVstSeq(adt_vst_seq);
    	dom.setAdtVstSrvySeq(adt_vst_srvy_seq);
    	dom.setAnswrSeq(answr_seq);
    	dom.setCmnt(cmnt);
    	dom.setCrntRecFlg(( crnt_rec_flg == null ) ? true : ( crnt_rec_flg == 1 ) ? true : false);
        dom.setCrtdBy(crtd_by);
        dom.setDelFlg(( del_flg == null ) ? false : ( del_flg == 1 ) ? true : false );
        dom.setEntySeq(enty_seq);
        dom.setEntyTypFlg(enty_typ_flg);
        dom.setLastUpdBy(last_upd_by);
        dom.setQstSeq(qst_seq);
        
        try {
            dom.setLastUpdDt( Instant.now() );
            dom.setEffStartDt(
                    ( eff_start_dt == null ) ? Instant.now() : Common.getZonedInstant( formatter.parse( eff_start_dt ).toInstant() ) );
            dom.setCrtdDt( Common.getZonedInstant( formatter.parse( crtd_dt ).toInstant() ) );
        } catch ( ParseException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dom;
    }

    public void DomainToDto( MwAdtVstSrvy dom ) {
        adt_vst_srvy_seq= dom.getAdtVstSrvySeq();
		adt_vst_seq= dom.getAdtVstSeq();
		eff_start_dt= ( dom.getEffStartDt() == null ) ? "" : Common.GetFormattedDateForTab( dom.getEffStartDt(), false );
		enty_typ_flg= dom.getEntyTypFlg();
		enty_seq= dom.getEntySeq();
		qst_seq= dom.getQstSeq();
		answr_seq= dom.getAnswrSeq();
		last_upd_by= dom.getLastUpdBy();
		last_upd_dt= ( dom.getLastUpdDt() == null ) ? "" : Common.GetFormattedDateForTab( dom.getLastUpdDt(), false );
		eff_end_dt= ( dom.getEffEndDt() == null ) ? "" : Common.GetFormattedDateForTab( dom.getEffEndDt(), false );
		crtd_by= dom.getCrtdBy();
		crtd_dt= ( dom.getCrtdDt() == null ) ? "" : Common.GetFormattedDateForTab( dom.getCrtdDt(), false );
		cmnt= dom.getCmnt();
		crnt_rec_flg= ( dom.getCrntRecFlg() == null ) ? 0 : ( dom.getCrntRecFlg() ? 1 : 0 );
		del_flg= ( dom.getDelFlg() == null ) ? 0 : ( dom.getDelFlg() ? 1 : 0 );
    }
}

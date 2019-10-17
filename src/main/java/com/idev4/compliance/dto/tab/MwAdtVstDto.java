
package com.idev4.compliance.dto.tab;

import java.text.DateFormat;

import com.idev4.compliance.domain.MwAdtVst;
import com.idev4.compliance.web.rest.util.Common;

public class MwAdtVstDto {

    public Long adt_vst_seq;

    public String eff_start_dt;

    public Long brnch_seq;

    public String vst_id;

    public String strt_dt;

    public String end_dt;

    public String actl_strt_dt;

    public String actl_end_dt;

    public Long asgn_to;

    public Long vst_sts_key;

    public Long adt_flg;

    public String crtd_by;

    public String crtd_dt;

    public String last_upd_by;

    public String last_upd_dt;

    public Integer del_flg;

    public String eff_end_dt;

    public Integer crnt_rec_flg;

    public MwAdtVst DtoToDomain( DateFormat formatter, DateFormat simpleFormatter ) {
        MwAdtVst dom = new MwAdtVst();
        // dom.set
        return dom;
    }

    public void DomainToDto( MwAdtVst dom ) {
        adt_vst_seq = dom.getAdtVstSeq();
        eff_start_dt = ( dom.getEffStartDt() == null ) ? "" : Common.GetFormattedDateForTab( dom.getEffStartDt(), false );
        last_upd_by = dom.getLastUpdBy();
        last_upd_dt = ( dom.getLastUpdDt() == null ) ? "" : Common.GetFormattedDateForTab( dom.getLastUpdDt(), false );
        eff_end_dt = ( dom.getEffEndDt() == null ) ? "" : Common.GetFormattedDateForTab( dom.getEffEndDt(), false );
        crtd_by = dom.getCrtdBy();
        crtd_dt = ( dom.getCrtdDt() == null ) ? "" : Common.GetFormattedDateForTab( dom.getCrtdDt(), false );
        crnt_rec_flg = ( dom.getCrntRecFlg() == null ) ? 0 : ( dom.getCrntRecFlg() ? 1 : 0 );
        del_flg = ( dom.getDelFlg() == null ) ? 0 : ( dom.getDelFlg() ? 1 : 0 );
        brnch_seq = dom.getBrnchSeq();
        vst_id = dom.getVstId();
        strt_dt = ( dom.getStrtDt() == null ) ? "" : Common.GetFormattedDateForTab( dom.getStrtDt(), false );
        end_dt = ( dom.getEndDt() == null ) ? "" : Common.GetFormattedDateForTab( dom.getEndDt(), false );
        actl_strt_dt = ( dom.getActlStrtDt() == null ) ? "" : Common.GetFormattedDateForTab( dom.getActlStrtDt(), false );
        actl_end_dt = ( dom.getActlEndDt() == null ) ? "" : Common.GetFormattedDateForTab( dom.getActlEndDt(), false );
        asgn_to = dom.getAsgnTo();
        vst_sts_key = dom.getVstStsKey();
        adt_flg = dom.getAdtFlg();
    }
}

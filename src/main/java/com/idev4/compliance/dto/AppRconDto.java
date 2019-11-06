
package com.idev4.compliance.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;

import com.idev4.compliance.domain.MwAppRcon;
import com.idev4.compliance.web.rest.util.Common;

public class AppRconDto {

    public Long app_rcon_seq;

    public String eff_start_dt;

    public Integer attribute_indx;

    public String attribute_nm;

    public String attribute_val;

    public Integer valid_flg;

    public Long adt_vst_seq;

    public Long app_info_seq;

    public String crtd_by;

    public String crtd_dt;

    public String last_upd_by;

    public String last_upd_dt;

    public Integer del_flg;

    public String eff_end_dt;

    public Integer crnt_rec_flg;

    public MwAppRcon DtoToDomain( DateFormat formatter, DateFormat simpleFormatter ) {
        MwAppRcon rcon = new MwAppRcon();
        rcon.setAppRconSeq( app_rcon_seq );
        rcon.setAttributeIndx( attribute_indx );
        rcon.setAttributeNm( attribute_nm );
        rcon.setAttributeVal( attribute_val );
        rcon.setValidFlg( ( valid_flg == null ) ? true : ( valid_flg == 1 ) ? true : false );
        rcon.setAdtVstSeq( adt_vst_seq );
        rcon.setAppInfoSeq( app_info_seq );

        rcon.setCrntRecFlg( ( crnt_rec_flg == null ) ? true : ( crnt_rec_flg == 1 ) ? true : false );
        rcon.setCrtdBy( crtd_by );
        rcon.setDelFlg( ( del_flg == null ) ? false : ( del_flg == 1 ) ? true : false );
        rcon.setLastUpdBy( last_upd_by );
        try {
            rcon.setLastUpdDt( Instant.now() );
            rcon.setEffStartDt(
                    ( eff_start_dt == null ) ? Instant.now() : Common.getZonedInstant( formatter.parse( eff_start_dt ).toInstant() ) );
            rcon.setCrtdDt( Common.getZonedInstant( formatter.parse( crtd_dt ).toInstant() ) );
        } catch ( ParseException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rcon;
    }

    public void DomainToDto( MwAppRcon rcon ) {
        app_rcon_seq = rcon.getAppRconSeq();
        eff_start_dt = ( rcon.getEffStartDt() == null ) ? "" : Common.GetFormattedDateForTab( rcon.getEffStartDt(), false );
        attribute_indx = rcon.getAttributeIndx();
        attribute_nm = rcon.getAttributeNm();
        attribute_val = rcon.getAttributeVal();
        valid_flg = ( rcon.getValidFlg() == null ) ? 0 : ( rcon.getValidFlg() ? 1 : 0 );
        adt_vst_seq = rcon.getAdtVstSeq();
        app_info_seq = rcon.getAppInfoSeq();
        crtd_by = rcon.getCrtdBy();
        crtd_dt = ( rcon.getCrtdDt() == null ) ? "" : Common.GetFormattedDateForTab( rcon.getCrtdDt(), false );
        last_upd_by = rcon.getLastUpdBy();
        last_upd_dt = ( rcon.getLastUpdDt() == null ) ? "" : Common.GetFormattedDateForTab( rcon.getLastUpdDt(), false );
        eff_end_dt = ( rcon.getEffEndDt() == null ) ? "" : Common.GetFormattedDateForTab( rcon.getEffEndDt(), false );
        crnt_rec_flg = ( rcon.getCrntRecFlg() == null ) ? 0 : ( rcon.getCrntRecFlg() ? 1 : 0 );
        del_flg = ( rcon.getDelFlg() == null ) ? 0 : ( rcon.getDelFlg() ? 1 : 0 );
    }

}

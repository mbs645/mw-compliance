package com.idev4.compliance.dto.tab;

import java.text.DateFormat;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Id;

import com.idev4.compliance.domain.MwAdtVst;

public class MwAdtVstDto {
	
	public Long adt_vst_seq;

	public String eff_start_dt;
    
    public Long brnch_seq;

    public String vst_id;

    public String strt_dt;
    
    public String end_dt;
    
    public String actual_strt_dt;
    
    public String actual_end_dt;
    
    public Long assigned_to;
    
    public Long visit_sts_key;
    
    public Long adt_flg;
	
	public String crtd_by;

	public String crtd_dt;

	public String last_upd_by;

	public String last_upd_dt;

	public Integer del_flg;

	public String eff_end_dt;

	public Integer crnt_rec_flg;
	
	public MwAdtVst DtoToDomain(DateFormat formatter, DateFormat simpleFormatter) {
		MwAdtVst dom = new MwAdtVst();
//		dom.set
		return dom;
	}
}

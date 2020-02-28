package com.idev4.compliance.dto.tab;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;

import com.idev4.compliance.domain.MwAdcChcks;
import com.idev4.compliance.domain.MwAdtFndng;
import com.idev4.compliance.web.rest.util.Common;

public class MwAdcChcksDto {
	
	public Long adc_chks_seq;

	public String eff_start_dt;

	public Long adt_vst_seq;

	public String inst_nm;

	public String adc_agnt_id;

	public String adc_agnt_nm;

	public String adc_addr;
	public String rmrks;


	public String crtd_by;

	public String crtd_dt;

	public String last_upd_by;

	public String last_upd_dt;

	public Integer del_flg;

	public String eff_end_dt;

	public Integer crnt_rec_flg;


	public MwAdcChcks DtoToDomain(DateFormat formatter, DateFormat simpleFormatter) {
		MwAdcChcks adc = new MwAdcChcks();
		adc.setAdcChksSeq(adc_chks_seq);
		adc.setRmrks(rmrks);
		adc.setCrntRecFlg((crnt_rec_flg == null) ? true : (crnt_rec_flg == 1) ? true : false);
		adc.setCrtdBy(crtd_by);
		adc.setDelFlg((del_flg == null) ? false : (del_flg == 1) ? true : false);
		adc.setAdcAddr(adc_addr);
		adc.setInstNm(inst_nm);
		adc.setAdcAgntId(adc_agnt_id);
		adc.setAdcAgntNm(adc_agnt_nm);
		adc.setLastUpdBy(last_upd_by);
		adc.setAdtVstSeq(adt_vst_seq);
		
		
		try {
			adc.setLastUpdDt(Instant.now());
			adc.setEffStartDt((eff_start_dt == null) ? Instant.now()
					: Common.getZonedInstant(formatter.parse(eff_start_dt).toInstant()));
			adc.setCrtdDt(Common.getZonedInstant(formatter.parse(crtd_dt).toInstant()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adc;
	}

	public void DomainToDto(MwAdcChcks adc) {
		adc_chks_seq = adc.getAdcChksSeq();
		eff_start_dt = (adc.getEffStartDt() == null) ? "" : Common.GetFormattedDateForTab(adc.getEffStartDt(),false);
		adc_addr = adc.getAdcAddr();
		inst_nm = adc.getInstNm();
		rmrks = adc.getRmrks();
		adc_agnt_id = adc.getAdcAgntId();
		adc_agnt_nm = adc.getAdcAgntNm();
		crtd_by = adc.getCrtdBy();
		crtd_dt = (adc.getCrtdDt() == null) ? "" : Common.GetFormattedDateForTab(adc.getCrtdDt(), false);
		last_upd_by = adc.getLastUpdBy();
		last_upd_dt = (adc.getLastUpdDt() == null) ? "" : Common.GetFormattedDateForTab(adc.getLastUpdDt(), false);
		eff_end_dt = (adc.getEffEndDt() == null) ? "" : Common.GetFormattedDateForTab(adc.getEffEndDt(), false);
		crnt_rec_flg = (adc.getCrntRecFlg() == null) ? 0 : (adc.getCrntRecFlg() ? 1 : 0);
		del_flg = (adc.getDelFlg() == null) ? 0 : (adc.getDelFlg() ? 1 : 0);
		adt_vst_seq=adc.getAdtVstSeq();
		
		
	}

}

package com.idev4.compliance.dto.tab;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;

import com.idev4.compliance.domain.MwAdcChckQstnr;
import com.idev4.compliance.domain.MwAdcChcks;
import com.idev4.compliance.web.rest.util.Common;

public class MwAdcChckQstnrDto {
	public Long adc_chks_qstnr_seq;

	public String eff_start_dt;

	public Long adc_chks_seq;

	public Long qst_seq;

	public Long answr_seq;

	public String answr_val;

	public String crtd_by;

	public String crtd_dt;

	public String last_upd_by;

	public String last_upd_dt;

	public Integer del_flg;

	public String eff_end_dt;

	public Integer crnt_rec_flg;


	public MwAdcChckQstnr DtoToDomain(DateFormat formatter, DateFormat simpleFormatter) {
		MwAdcChckQstnr adc = new MwAdcChckQstnr();
		adc.setAdcChksSeq(adc_chks_seq);
		adc.setAdcChksQstnrSeq(adc_chks_qstnr_seq);
		adc.setCrntRecFlg((crnt_rec_flg == null) ? true : (crnt_rec_flg == 1) ? true : false);
		adc.setCrtdBy(crtd_by);
		adc.setDelFlg((del_flg == null) ? false : (del_flg == 1) ? true : false);
		adc.setQstSeq(qst_seq);
		adc.setAnswrSeq(answr_seq);
		adc.setAnswrVal(answr_val);
		adc.setLastUpdBy(last_upd_by);
		
		
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

	public void DomainToDto(MwAdcChckQstnr adc) {
		adc_chks_seq = adc.getAdcChksSeq();
		eff_start_dt = (adc.getEffStartDt() == null) ? "" : Common.GetFormattedDateForTab(adc.getEffStartDt(),false);
		adc_chks_qstnr_seq = adc.getAdcChksQstnrSeq();
		qst_seq = adc.getQstSeq();
		answr_seq = adc.getAnswrSeq();
		answr_val = adc.getAnswrVal();
		crtd_by = adc.getCrtdBy();
		crtd_dt = (adc.getCrtdDt() == null) ? "" : Common.GetFormattedDateForTab(adc.getCrtdDt(), false);
		last_upd_by = adc.getLastUpdBy();
		last_upd_dt = (adc.getLastUpdDt() == null) ? "" : Common.GetFormattedDateForTab(adc.getLastUpdDt(), false);
		eff_end_dt = (adc.getEffEndDt() == null) ? "" : Common.GetFormattedDateForTab(adc.getEffEndDt(), false);
		crnt_rec_flg = (adc.getCrntRecFlg() == null) ? 0 : (adc.getCrntRecFlg() ? 1 : 0);
		del_flg = (adc.getDelFlg() == null) ? 0 : (adc.getDelFlg() ? 1 : 0);
		
		
	}

}

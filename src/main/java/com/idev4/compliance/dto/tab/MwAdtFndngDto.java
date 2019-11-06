package com.idev4.compliance.dto.tab;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Id;

import com.idev4.compliance.domain.MwAdtFndng;
import com.idev4.compliance.domain.MwAdtVstSrvy;
import com.idev4.compliance.web.rest.util.Common;

public class MwAdtFndngDto {

	public Long adt_fndng_seq;

	public String eff_start_dt;

	public Long finding_typ_key;

	public Long issue_key;

	public String cmnt;

	public Integer enty_typ_flg;

	public Long enty_seq;

	public String crtd_by;

	public String crtd_dt;

	public String last_upd_by;

	public String last_upd_dt;

	public Integer del_flg;

	public String eff_end_dt;

	
	public Long adt_vst_seq;
	
	public Long scr;
	public Long svrtyKey;


	public Integer crnt_rec_flg;


	public MwAdtFndng DtoToDomain(DateFormat formatter, DateFormat simpleFormatter) {
		MwAdtFndng fnd = new MwAdtFndng();
		fnd.setAdtFndngSeq(adt_fndng_seq);
		fnd.setCmnt(cmnt);
		fnd.setCrntRecFlg((crnt_rec_flg == null) ? true : (crnt_rec_flg == 1) ? true : false);
		fnd.setCrtdBy(crtd_by);
		fnd.setDelFlg((del_flg == null) ? false : (del_flg == 1) ? true : false);
		fnd.setEntySeq(enty_seq);
		fnd.setEntyTypFlg(enty_typ_flg);
		fnd.setFindingTypKey(finding_typ_key);
		fnd.setIssueKey(issue_key);
		fnd.setLastUpdBy(last_upd_by);
		fnd.setAdtVstSeq(adt_vst_seq);
		fnd.setScr(scr);
		fnd.setSvrtyKey(svrtyKey);
		
		try {
			fnd.setLastUpdDt(Instant.now());
			fnd.setEffStartDt((eff_start_dt == null) ? Instant.now()
					: Common.getZonedInstant(formatter.parse(eff_start_dt).toInstant()));
			fnd.setCrtdDt(Common.getZonedInstant(formatter.parse(crtd_dt).toInstant()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fnd;
	}

	public void DomainToDto(MwAdtFndng fnd) {
		adt_fndng_seq = fnd.getAdtFndngSeq();
		eff_start_dt = (fnd.getEffStartDt() == null) ? "" : Common.GetFormattedDateForTab(fnd.getEffStartDt(), false);
		finding_typ_key = fnd.getFindingTypKey();
		issue_key = fnd.getIssueKey();
		cmnt = fnd.getCmnt();
		enty_typ_flg = fnd.getEntyTypFlg();
		enty_seq = fnd.getEntySeq();
		crtd_by = fnd.getCrtdBy();
		crtd_dt = (fnd.getCrtdDt() == null) ? "" : Common.GetFormattedDateForTab(fnd.getCrtdDt(), false);
		last_upd_by = fnd.getLastUpdBy();
		last_upd_dt = (fnd.getLastUpdDt() == null) ? "" : Common.GetFormattedDateForTab(fnd.getLastUpdDt(), false);
		eff_end_dt = (fnd.getEffEndDt() == null) ? "" : Common.GetFormattedDateForTab(fnd.getEffEndDt(), false);
		crnt_rec_flg = (fnd.getCrntRecFlg() == null) ? 0 : (fnd.getCrntRecFlg() ? 1 : 0);
		del_flg = (fnd.getDelFlg() == null) ? 0 : (fnd.getDelFlg() ? 1 : 0);
		adt_vst_seq=fnd.getAdtVstSeq();
		scr=fnd.getScr();
		svrtyKey=fnd.getSvrtyKey();
		
	}

}

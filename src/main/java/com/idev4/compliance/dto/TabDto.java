package com.idev4.compliance.dto;

import java.util.List;

import com.idev4.compliance.domain.MwAnswr;
import com.idev4.compliance.domain.MwBrnch;
import com.idev4.compliance.domain.MwEmp;
import com.idev4.compliance.domain.MwQst;
import com.idev4.compliance.domain.MwQstnr;
import com.idev4.compliance.domain.MwRefCdVal;

public class TabDto {
	public List<LoanInfoDto> app_info;
	public List<MwAnswr> mw_answr;
	public List<MwBrnch> mw_brnch;
	public List<MwEmp> mw_emp;
	public List<MwQstnr> mw_qstnr;
	public List<MwQst> mw_qst;
	public List<MwRefCdVal> mw_ref_cd_val;
	
}

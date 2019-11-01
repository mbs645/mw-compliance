package com.idev4.compliance.dto.tab;

import java.util.List;

import com.idev4.compliance.domain.MwAppRcon;
import com.idev4.compliance.dto.AppRconDto;


public class ComplianceSubmitDto {

	public List<MwAdtVstSrvyDto> mw_adt_vst_srvy;
	
	public List<MwAdtFndngDto> mw_adt_fndng;
	
	public MwAdtVstDto  mw_adt_vst;
	public List<MwAdtVstDto>  mw_adt_vst_list;

	public List<AppRconDto> mw_app_rcon;
}

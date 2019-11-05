
package com.idev4.compliance.dto;

import java.util.List;

import com.idev4.compliance.domain.MwAdtCtgry;
import com.idev4.compliance.domain.MwAdtIsu;
import com.idev4.compliance.domain.MwAdtSbCtgry;
import com.idev4.compliance.domain.MwAnswr;
import com.idev4.compliance.domain.MwBrnch;
import com.idev4.compliance.domain.MwEmp;
import com.idev4.compliance.domain.MwQst;
import com.idev4.compliance.domain.MwQstnr;
import com.idev4.compliance.domain.MwRefCdGrp;
import com.idev4.compliance.domain.MwRefCdVal;
import com.idev4.compliance.dto.tab.MwAdtVstDto;
import com.idev4.compliance.service.ComplianceService.PrvVstDto;

public class TabDto {

    public List< LoanInfoDto > app_info;

    public List< MwAnswr > mw_answr;

    public List< MwBrnch > mw_brnch;

    public List< MwEmp > mw_emp;

    public List< MwQstnr > mw_qstnr;

    public List< MwQst > mw_qst;

    public List< MwRefCdVal > mw_ref_cd_val;
    
    public List< MwRefCdGrp > mw_ref_cd_grp;

    public List< MwAdtVstDto > mw_adt_vst;
    
    public List< PrvVstDto > mw_prv_vst;
    
    public List< MwAdtIsu > mw_adt_isu;

    public List< MwAdtCtgry > mw_adt_ctgry;

    public List< MwAdtSbCtgry > mw_adt_sb_ctgry;


}

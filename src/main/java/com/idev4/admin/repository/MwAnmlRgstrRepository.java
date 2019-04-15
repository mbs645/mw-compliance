
package com.idev4.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.idev4.admin.domain.MwAnmlRgstr;

@Repository
public interface MwAnmlRgstrRepository extends JpaRepository< MwAnmlRgstr, Long > {

    @Query ( value = "select ar.ANML_RGSTR_SEQ, ar.EFF_START_DT, ar.LOAN_APP_SEQ, ar.RGSTR_CD, ar.TAG_NUM, ar.ANML_KND, ar.ANML_TYP, ar.ANML_CLR, ar.ANML_BRD, ar.PRCH_DT, ar.AGE_YR, ar.AGE_MNTH, ar.PRCH_AMT, ar.PIC_DT, ar.ANML_PIC, ar.TAG_PIC, ar.CRTD_BY, ar.CRTD_DT, ar.LAST_UPD_BY, ar.LAST_UPD_DT, ar.DEL_FLG, ar.EFF_END_DT, ar.CRNT_REC_FLG\r\n"
            + "from mw_anml_rgstr ar\r\n" + "join mw_loan_app la on la.LOAN_APP_SEQ = ar.LOAN_APP_SEQ and la.CRNT_REC_FLG = 1\r\n"
            + "where ar.CRNT_REC_FLG = 1 and la.CLNT_SEQ=?", nativeQuery = true )
    public List< MwAnmlRgstr > findAllByClntSeq( long clntSeq );

}

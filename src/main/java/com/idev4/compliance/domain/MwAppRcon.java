package com.idev4.compliance.domain;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table ( name = "MW_APP_RCON" )
//@IdClass ( MwAdtCtgryId.class )
public class MwAppRcon implements Serializable  {
	
	 private static final long serialVersionUID = 1L;

    @Id
    @Column ( name = "APP_RCON_SEQ" )
    private Long appRconSeq;

    @Id
    @Column ( name = "eff_start_dt" )
    private Instant effStartDt;

    @Column ( name = "ATTRIBUTE_INDX" )
    private Integer attributeIndx;

    @Column ( name = "ATTRIBUTE_NM" )
    private String attributeNm;

    @Column ( name = "ATTRIBUTE_VAL" )
    private String attributeVal;

    @Column ( name = "VALID_FLG" )
    private Boolean validFlg;

    @Column ( name = "ADT_VST_SEQ" )
    private Long adtVstSeq;

    @Column ( name = "APP_INFO_SEQ" )
    private Long appInfoSeq;

    @Column ( name = "crtd_by" )
    private String crtdBy;

    @Column ( name = "crtd_dt" )
    private Instant crtdDt;

    @Column ( name = "last_upd_by" )
    private String lastUpdBy;

    @Column ( name = "last_upd_dt" )
    private Instant lastUpdDt;

    @Column ( name = "del_flg" )
    private Boolean delFlg;

    @Column ( name = "eff_end_dt" )
    private Instant effEndDt;

    @Column ( name = "crnt_rec_flg" )
    private Boolean crntRecFlg;

	public Long getAppRconSeq() {
		return appRconSeq;
	}

	public void setAppRconSeq(Long appRconSeq) {
		this.appRconSeq = appRconSeq;
	}

	public Instant getEffStartDt() {
		return effStartDt;
	}

	public void setEffStartDt(Instant effStartDt) {
		this.effStartDt = effStartDt;
	}

	public Integer getAttributeIndx() {
		return attributeIndx;
	}

	public void setAttributeIndx(Integer attributeIndx) {
		this.attributeIndx = attributeIndx;
	}

	public String getAttributeNm() {
		return attributeNm;
	}

	public void setAttributeNm(String attributeNm) {
		this.attributeNm = attributeNm;
	}

	public String getAttributeVal() {
		return attributeVal;
	}

	public void setAttributeVal(String attributeVal) {
		this.attributeVal = attributeVal;
	}

	public Boolean getValidFlg() {
		return validFlg;
	}

	public void setValidFlg(Boolean validFlg) {
		this.validFlg = validFlg;
	}

	public Long getAdtVstSeq() {
		return adtVstSeq;
	}

	public void setAdtVstSeq(Long adtVstSeq) {
		this.adtVstSeq = adtVstSeq;
	}

	public Long getAppInfoSeq() {
		return appInfoSeq;
	}

	public void setAppInfoSeq(Long appInfoSeq) {
		this.appInfoSeq = appInfoSeq;
	}

	public String getCrtdBy() {
		return crtdBy;
	}

	public void setCrtdBy(String crtdBy) {
		this.crtdBy = crtdBy;
	}

	public Instant getCrtdDt() {
		return crtdDt;
	}

	public void setCrtdDt(Instant crtdDt) {
		this.crtdDt = crtdDt;
	}

	public String getLastUpdBy() {
		return lastUpdBy;
	}

	public void setLastUpdBy(String lastUpdBy) {
		this.lastUpdBy = lastUpdBy;
	}

	public Instant getLastUpdDt() {
		return lastUpdDt;
	}

	public void setLastUpdDt(Instant lastUpdDt) {
		this.lastUpdDt = lastUpdDt;
	}

	public Boolean getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(Boolean delFlg) {
		this.delFlg = delFlg;
	}

	public Instant getEffEndDt() {
		return effEndDt;
	}

	public void setEffEndDt(Instant effEndDt) {
		this.effEndDt = effEndDt;
	}

	public Boolean getCrntRecFlg() {
		return crntRecFlg;
	}

	public void setCrntRecFlg(Boolean crntRecFlg) {
		this.crntRecFlg = crntRecFlg;
	}

}

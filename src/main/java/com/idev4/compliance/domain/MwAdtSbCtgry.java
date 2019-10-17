package com.idev4.compliance.domain;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;

import com.idev4.compliance.ids.MwAdtSbCtgryId;

@Entity
@Table(name = "MW_ADT_SB_CTGRY")
@IdClass(MwAdtSbCtgryId.class)
public class MwAdtSbCtgry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "SB_CTGRY_SEQ")
    private Long sbCtgrySeq;

    @Id
    @Column(name = "eff_start_dt")
    private Instant effStartDt;
    
    @Column(name = "ADT_CTGRY_SEQ")
    private Long adtCtgrySeq;
    
	@Column(name = "SB_CTGRY_ID")
    private String sbCtgryId;
    
    @Column(name = "SB_CTGRY_NM")
    private String sbCtgryNm;
    
    @Column(name = "SB_CTGRY_CMNT")
    private String sbCtgryCmnt;
    
    @Column(name = "crtd_by")
    private String crtdBy;

    @Column(name = "crtd_dt")
    private Instant crtdDt;
    
    
    @Column(name = "last_upd_by")
    private String lastUpdBy;

    @Column(name = "last_upd_dt")
    private Instant lastUpdDt;

    @Column(name = "del_flg")
    private Boolean delFlg;

    @Column(name = "eff_end_dt")
    private Instant effEndDt;

    @Column(name = "crnt_rec_flg")
    private Boolean crntRecFlg;
    
    public Long getAdtCtgrySeq() {
  		return adtCtgrySeq;
  	}

  	public void setAdtCtgrySeq(Long adtCtgrySeq) {
  		this.adtCtgrySeq = adtCtgrySeq;
  	}


	public Long getSbCtgrySeq() {
		return sbCtgrySeq;
	}

	public void setSbCtgrySeq(Long sbCtgrySeq) {
		this.sbCtgrySeq = sbCtgrySeq;
	}

	public Instant getEffStartDt() {
		return effStartDt;
	}

	public void setEffStartDt(Instant effStartDt) {
		this.effStartDt = effStartDt;
	}

	public String getSbCtgryId() {
		return sbCtgryId;
	}

	public void setSbCtgryId(String sbCtgryId) {
		this.sbCtgryId = sbCtgryId;
	}

	public String getSbCtgryNm() {
		return sbCtgryNm;
	}

	public void setSbCtgryNm(String sbCtgryNm) {
		this.sbCtgryNm = sbCtgryNm;
	}

	public String getSbCtgryCmnt() {
		return sbCtgryCmnt;
	}

	public void setSbCtgryCmnt(String sbCtgryCmnt) {
		this.sbCtgryCmnt = sbCtgryCmnt;
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

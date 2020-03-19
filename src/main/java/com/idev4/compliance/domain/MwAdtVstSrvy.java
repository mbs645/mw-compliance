package com.idev4.compliance.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.idev4.compliance.ids.MwAdtVstSrvyId;

@Entity
@Table(name = "MW_ADT_VST_SRVY")
@IdClass(MwAdtVstSrvyId.class)
public class MwAdtVstSrvy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ADT_VST_SRVY_SEQ")
    private Long adtVstSrvySeq;

    @Id
    @Column(name = "eff_start_dt")
    private Instant effStartDt;
    
    @Column(name = "ADT_VST_SEQ")
    private Long adtVstSeq;

    @Column(name = "ENTY_TYP_FLG")
    private Integer entyTypFlg;

    @Column(name = "ENTY_SEQ")
    private Long entySeq;
    
    @Column(name = "QST_SEQ")
    private Long qstSeq;
    
    @Column(name = "ANSWR_SEQ")
    private Long answrSeq;
    
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
    
    @Column(name = "CMNT")
    private String cmnt;


    @Column(name = "ANSWR_VAL")
    private String answrVal;
    
	public String getAnswrVal() {
		return answrVal;
	}

	public void setAnswrVal(String answrVal) {
		this.answrVal = answrVal;
	}

	public Long getAdtVstSrvySeq() {
		return adtVstSrvySeq;
	}

	public void setAdtVstSrvySeq(Long adtVstSrvySeq) {
		this.adtVstSrvySeq = adtVstSrvySeq;
	}

	public Instant getEffStartDt() {
		return effStartDt;
	}

	public void setEffStartDt(Instant effStartDt) {
		this.effStartDt = effStartDt;
	}

	public Long getAdtVstSeq() {
		return adtVstSeq;
	}

	public void setAdtVstSeq(Long adtVstSeq) {
		this.adtVstSeq = adtVstSeq;
	}

	public Integer getEntyTypFlg() {
		return entyTypFlg;
	}

	public void setEntyTypFlg(Integer entyTypFlg) {
		this.entyTypFlg = entyTypFlg;
	}

	public Long getEntySeq() {
		return entySeq;
	}

	public void setEntySeq(Long entySeq) {
		this.entySeq = entySeq;
	}

	public Long getQstSeq() {
		return qstSeq;
	}

	public void setQstSeq(Long qstSeq) {
		this.qstSeq = qstSeq;
	}

	public Long getAnswrSeq() {
		return answrSeq;
	}

	public void setAnswrSeq(Long answrSeq) {
		this.answrSeq = answrSeq;
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

	public String getCmnt() {
		return cmnt;
	}

	public void setCmnt(String cmnt) {
		this.cmnt = cmnt;
	}
    
    

}

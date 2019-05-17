package com.idev4.compliance.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.idev4.compliance.ids.MwAdtVstId;

@Entity
@Table(name = "MW_ADT_VST")
@IdClass(MwAdtVstId.class)
public class MwAdtVst implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ADT_VST_SEQ")
    private Long adtVstSeq;

    @Id
    @Column(name = "eff_start_dt")
    private Instant effStartDt;
    
    @Column(name = "BRNCH_SEQ")
    private Long brnchSeq;

    @Column(name = "VST_ID")
    private String vstId;

    @Column(name = "START_DT")
    private Instant strtDt;
    
    @Column(name = "END_DT")
    private Instant endDt;
    
    @Column(name = "ACTUAL_START_DT")
    private Instant actualStrtDt;
    
    @Column(name = "ACTUAL_END_DT")
    private Instant actualEndDt;
    
    @Column(name = "ASSIGNED_TO")
    private Long assignedTo;
    
    @Column(name = "VISIT_STS_KEY")
    private Long visitStsKey;
    
    @Column(name = "ADT_FLG")
    private Long adtFlg;
    
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

	public Long getAdtVstSeq() {
		return adtVstSeq;
	}

	public void setAdtVstSeq(Long adtVstSeq) {
		this.adtVstSeq = adtVstSeq;
	}

	public Instant getEffStartDt() {
		return effStartDt;
	}

	public void setEffStartDt(Instant effStartDt) {
		this.effStartDt = effStartDt;
	}

	public Long getBrnchSeq() {
		return brnchSeq;
	}

	public void setBrnchSeq(Long brnchSeq) {
		this.brnchSeq = brnchSeq;
	}

	public String getVstId() {
		return vstId;
	}

	public void setVstId(String vstId) {
		this.vstId = vstId;
	}

	public Instant getStrtDt() {
		return strtDt;
	}

	public void setStrtDt(Instant strtDt) {
		this.strtDt = strtDt;
	}

	public Instant getEndDt() {
		return endDt;
	}

	public void setEndDt(Instant endDt) {
		this.endDt = endDt;
	}

	public Instant getActualStrtDt() {
		return actualStrtDt;
	}

	public void setActualStrtDt(Instant actualStrtDt) {
		this.actualStrtDt = actualStrtDt;
	}

	public Instant getActualEndDt() {
		return actualEndDt;
	}

	public void setActualEndDt(Instant actualEndDt) {
		this.actualEndDt = actualEndDt;
	}

	public Long getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Long assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Long getVisitStsKey() {
		return visitStsKey;
	}

	public void setVisitStsKey(Long visitStsKey) {
		this.visitStsKey = visitStsKey;
	}

	public Long getAdtFlg() {
		return adtFlg;
	}

	public void setAdtFlg(Long adtFlg) {
		this.adtFlg = adtFlg;
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

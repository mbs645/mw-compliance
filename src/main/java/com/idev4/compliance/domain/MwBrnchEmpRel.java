package com.idev4.compliance.domain;

import java.io.Serializable;
import java.time.Instant;

import com.idev4.compliance.ids.MwBrnchEmpRelId;
import javax.persistence.*;


@Entity
@Table(name = "mw_brnch_emp_rel")
@IdClass(MwBrnchEmpRelId.class)

public class MwBrnchEmpRel implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "brnch_emp_seq")
    private long brnchEmpSeq;
    
    @Column(name = "eff_start_dt")
    private Instant effStartDt;
    
    @Column(name= "brnch_seq")
    private long brnchSeq;

    @Column(name ="emp_seq")
    private long empSeq;

    @Column(name ="covering_emp_seq")
    private String coveringEmpSeq;

    @Column(name ="covering_emp_from_dt")
    private Instant coveringEmpFromDt;

    @Column(name = "covering_emp_to_dt")
    private Instant coveringEmpToDt;

    @Column(name = "eff_end_dt")
    private Instant effEndDt;
    
    @Column(name = "crnt_rec_flg")
    private Boolean crntRecFlg;
    
    @Column(name = "crtd_by")
    private String crtdBy;

    @Column(name = "crtd_dt")
    private Instant crtdDt;

    @Column(name = "last_upd_by")
    private String lastUpdBy;

    @Column(name = "last_upd_dt")
    private Instant lastUpdDt;

	public long getBrnchEmpSeq() {
		return brnchEmpSeq;
	}

	public void setBrnchEmpSeq(long brnchEmpSeq) {
		this.brnchEmpSeq = brnchEmpSeq;
	}

	public Instant getEffStartDt() {
		return effStartDt;
	}

	public void setEffStartDt(Instant effStartDt) {
		this.effStartDt = effStartDt;
	}

	public long getBrnchSeq() {
		return brnchSeq;
	}

	public void setBrnchSeq(long brnchSeq) {
		this.brnchSeq = brnchSeq;
	}

	public long getEmpSeq() {
		return empSeq;
	}

	public void setEmpSeq(long empSeq) {
		this.empSeq = empSeq;
	}

	public String getCoveringEmpSeq() {
		return coveringEmpSeq;
	}

	public void setCoveringEmpSeq(String coveringEmpSeq) {
		this.coveringEmpSeq = coveringEmpSeq;
	}

	public Instant getCoveringEmpFromDt() {
		return coveringEmpFromDt;
	}

	public void setCoveringEmpFromDt(Instant coveringEmpFromDt) {
		this.coveringEmpFromDt = coveringEmpFromDt;
	}

	public Instant getCoveringEmpToDt() {
		return coveringEmpToDt;
	}

	public void setCoveringEmpToDt(Instant coveringEmpToDt) {
		this.coveringEmpToDt = coveringEmpToDt;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

   
}

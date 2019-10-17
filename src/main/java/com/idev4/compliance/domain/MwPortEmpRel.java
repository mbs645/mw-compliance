package com.idev4.compliance.domain;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;

import com.idev4.compliance.ids.MwPortEmpRelId;

@Entity
@Table(name = "mw_port_emp_rel")
@IdClass(MwPortEmpRelId.class)
public class MwPortEmpRel implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "port_emp_seq")
    private long portEmpSeq;
    
    @Column(name = "eff_start_dt")
    private Instant effStartDt;
    
    @Column(name= "emp_seq")
    private long empSeq;

    @Column(name ="covering_emp_seq")
    private String coveringEmpSeq;

    @Column(name= "port_seq")
    private long portSeq;

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

	public long getPortEmpSeq() {
		return portEmpSeq;
	}

	public void setPortEmpSeq(long portEmpSeq) {
		this.portEmpSeq = portEmpSeq;
	}

	public Instant getEffStartDt() {
		return effStartDt;
	}

	public void setEffStartDt(Instant effStartDt) {
		this.effStartDt = effStartDt;
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

	public long getPortSeq() {
		return portSeq;
	}

	public void setPortSeq(long portSeq) {
		this.portSeq = portSeq;
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

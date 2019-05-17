package com.idev4.compliance.domain;


import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.idev4.compliance.ids.MwAdtTrgtId;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

/**
 * A MwBrnch.
 */
@Entity
@Table(name = "MW_ADT_TRGT")
@IdClass(MwAdtTrgtId.class)
public class MwAdtTrgt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ADT_TRGT_SEQ")
    private Long adtTrgtSeq;

    @Id
    @Column(name = "eff_start_dt")
    private Instant effStartDt;
    
    @Column(name = "BRNCH_SEQ")
    private Long brnchSeq;

    @Column(name = "TRGT")
    private Long trgt;

    @Column(name = "TRGT_YR")
    private Long trgtYr;
    
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

	public Long getAdtTrgtVst() {
		return adtTrgtSeq;
	}

	public void setAdtTrgtVst(Long adtTrgtSeq) {
		this.adtTrgtSeq = adtTrgtSeq;
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

	public Long getTrgt() {
		return trgt;
	}

	public void setTrgt(Long trgt) {
		this.trgt = trgt;
	}

	public Long getTrgtYr() {
		return trgtYr;
	}

	public void setTrgtYr(Long trgtYr) {
		this.trgtYr = trgtYr;
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

package com.idev4.compliance.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.idev4.compliance.ids.MwAdtFndngId;

@Entity
@Table(name = "MW_ADT_FNDNG")
@IdClass(MwAdtFndngId.class)
public class MwAdtFndng implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ADT_FNDNG_SEQ")
    private Long adtFndngSeq;

    @Id
    @Column(name = "eff_start_dt")
    private Instant effStartDt;
    
    @Column(name = "FINDING_TYP_KEY")
    private Long findingTypKey;

    @Column(name = "ISSUE_KEY")
    private Long issueKey;
    
    @Column(name = "CMNT")
    private String cmnt;
    
    @Column(name = "ENTY_TYP_FLG")
    private Integer entyTypFlg;
    
    @Column(name = "ENTY_SEQ")
    private Long entySeq;
    
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
    
    @Column(name = "ADT_VST_SEQ")
    private Long adtVstSeq;
    
    @Column(name = "SCR")
    private Integer scr;
    
    @Column(name = "SVRTY_KEY")
    private Long svrtyKey;

	public Integer getScr() {
		return scr;
	}

	public void setScr(Integer scr) {
		this.scr = scr;
	}

	public Long getSvrtyKey() {
		return svrtyKey;
	}

	public void setSvrtyKey(Long svrtyKey) {
		this.svrtyKey = svrtyKey;
	}

	public Long getAdtVstSeq() {
		return adtVstSeq;
	}

	public void setAdtVstSeq(Long adtVstSeq) {
		this.adtVstSeq = adtVstSeq;
	}

	public Long getAdtFndngSeq() {
		return adtFndngSeq;
	}

	public void setAdtFndngSeq(Long adtFndngSeq) {
		this.adtFndngSeq = adtFndngSeq;
	}

	public Instant getEffStartDt() {
		return effStartDt;
	}

	public void setEffStartDt(Instant effStartDt) {
		this.effStartDt = effStartDt;
	}

	public Long getFindingTypKey() {
		return findingTypKey;
	}

	public void setFindingTypKey(Long findingTypKey) {
		this.findingTypKey = findingTypKey;
	}

	public Long getIssueKey() {
		return issueKey;
	}

	public void setIssueKey(Long issueKey) {
		this.issueKey = issueKey;
	}

	public String getCmnt() {
		return cmnt;
	}

	public void setCmnt(String cmnt) {
		this.cmnt = cmnt;
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

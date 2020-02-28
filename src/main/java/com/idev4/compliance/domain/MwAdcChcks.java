package com.idev4.compliance.domain;


import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.idev4.compliance.ids.MwAdcChcksId;


@Entity
@Table ( name = "MW_ADC_CHCKS" )
@IdClass ( MwAdcChcksId.class )
public class MwAdcChcks  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column ( name = "ADC_CHKS_SEQ" )
    private Long adcChksSeq;

    @Id
    @Column ( name = "eff_start_dt" )
    private Instant effStartDt;

    @Column ( name = "ADT_VST_SEQ" )
    private Long adtVstSeq;

    @Column ( name = "INST_NM" )
    private String instNm;

    @Column ( name = "ADC_AGNT_ID" )
    private String adcAgntId;

    @Column ( name = "ADC_AGNT_NM" )
    private String adcAgntNm;

    @Column ( name = "ADC_ADDR" )
    private String adcAddr;

    @Column ( name = "RMRKS" )
    private String rmrks;

    
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

	public Long getAdcChksSeq() {
		return adcChksSeq;
	}

	public void setAdcChksSeq(Long adcChksSeq) {
		this.adcChksSeq = adcChksSeq;
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

	public String getInstNm() {
		return instNm;
	}

	public void setInstNm(String instNm) {
		this.instNm = instNm;
	}

	public String getAdcAgntId() {
		return adcAgntId;
	}

	public void setAdcAgntId(String adcAgntId) {
		this.adcAgntId = adcAgntId;
	}

	public String getAdcAgntNm() {
		return adcAgntNm;
	}

	public void setAdcAgntNm(String adcAgntNm) {
		this.adcAgntNm = adcAgntNm;
	}

	public String getAdcAddr() {
		return adcAddr;
	}

	public void setAdcAddr(String adcAddr) {
		this.adcAddr = adcAddr;
	}

	public String getRmrks() {
		return rmrks;
	}

	public void setRmrks(String rmrks) {
		this.rmrks = rmrks;
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

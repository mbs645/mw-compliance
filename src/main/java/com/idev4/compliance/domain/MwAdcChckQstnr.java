package com.idev4.compliance.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.idev4.compliance.ids.MwAdcChckQstnrId;
import com.idev4.compliance.ids.MwAdcChcksId;


@Entity
@Table ( name = "MW_ADC_CHCK_QSTNR" )
@IdClass ( MwAdcChckQstnrId.class )
public class MwAdcChckQstnr implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column ( name = "ADC_CHKS_QSTNR_SEQ" )
    private Long adcChksQstnrSeq;

    @Id
    @Column ( name = "eff_start_dt" )
    private Instant effStartDt;

    @Id
    @Column ( name = "ADC_CHKS_SEQ" )
    private Long adcChksSeq;

    @Column ( name = "QST_SEQ" )
    private Long qstSeq;

    @Column ( name = "ANSWR_SEQ" )
    private Long answrSeq;

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

    @Column ( name = "ANSWR_VAL" )
    private String answrVal;

	public Long getAdcChksQstnrSeq() {
		return adcChksQstnrSeq;
	}

	public void setAdcChksQstnrSeq(Long adcChksQstnrSeq) {
		this.adcChksQstnrSeq = adcChksQstnrSeq;
	}

	public Instant getEffStartDt() {
		return effStartDt;
	}

	public void setEffStartDt(Instant effStartDt) {
		this.effStartDt = effStartDt;
	}

	public Long getAdcChksSeq() {
		return adcChksSeq;
	}

	public void setAdcChksSeq(Long adcChksSeq) {
		this.adcChksSeq = adcChksSeq;
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

	public String getAnswrVal() {
		return answrVal;
	}

	public void setAnswrVal(String answrVal) {
		this.answrVal = answrVal;
	}

    

}

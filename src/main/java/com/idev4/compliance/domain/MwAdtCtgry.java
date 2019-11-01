package com.idev4.compliance.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.idev4.compliance.ids.MwAdtCtgryId;

@Entity
@Table ( name = "MW_ADT_CTGRY" )
@IdClass ( MwAdtCtgryId.class )
public class MwAdtCtgry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column ( name = "ADT_CTGRY_SEQ" )
    private Long adtCtgrySeq;

    @Id
    @Column ( name = "eff_start_dt" )
    private Instant effStartDt;

    @Column ( name = "CTGRY_TYP" )
    private Long ctgryTyp;

    @Column ( name = "CTGRY_ID" )
    private String ctgryId;

    @Column ( name = "CTGRY_NM" )
    private String ctgryNm;

    @Column ( name = "CTGRY_CMNT" )
    private String ctgryCmnt;

    @Column ( name = "CTGRY_SCR" )
    private String ctgryScr;

    @Column ( name = "CALC_TYP" )
    private Integer calcTyp;

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
    
    @Column ( name = "CTGRY_ENTY_FLG" )
    private Integer ctgryEntyFlg;
    

    public Integer getCtgryEntyFlg() {
		return ctgryEntyFlg;
	}

	public void setCtgryEntyFlg(Integer ctgryEntyFlg) {
		this.ctgryEntyFlg = ctgryEntyFlg;
	}

	public Long getAdtCtgrySeq() {
        return adtCtgrySeq;
    }

    public void setAdtCtgrySeq( Long adtCtgrySeq ) {
        this.adtCtgrySeq = adtCtgrySeq;
    }

    public Instant getEffStartDt() {
        return effStartDt;
    }

    public void setEffStartDt( Instant effStartDt ) {
        this.effStartDt = effStartDt;
    }

    public Long getCtgryTyp() {
        return ctgryTyp;
    }

    public void setCtgryTyp( Long ctgryTyp ) {
        this.ctgryTyp = ctgryTyp;
    }

    public String getCtgryId() {
        return ctgryId;
    }

    public void setCtgryId( String ctgryId ) {
        this.ctgryId = ctgryId;
    }

    public String getCtgryNm() {
        return ctgryNm;
    }

    public void setCtgryNm( String ctgryNm ) {
        this.ctgryNm = ctgryNm;
    }

    public String getCtgryCmnt() {
        return ctgryCmnt;
    }

    public void setCtgryCmnt( String ctgryCmnt ) {
        this.ctgryCmnt = ctgryCmnt;
    }

    public String getCtgryScr() {
        return ctgryScr;
    }

    public void setCtgryScr( String ctgryScr ) {
        this.ctgryScr = ctgryScr;
    }

    public Integer getCalcTyp() {
        return calcTyp;
    }

    public void setCalcTyp( Integer calcTyp ) {
        this.calcTyp = calcTyp;
    }

    public String getCrtdBy() {
        return crtdBy;
    }

    public void setCrtdBy( String crtdBy ) {
        this.crtdBy = crtdBy;
    }

    public Instant getCrtdDt() {
        return crtdDt;
    }

    public void setCrtdDt( Instant crtdDt ) {
        this.crtdDt = crtdDt;
    }

    public String getLastUpdBy() {
        return lastUpdBy;
    }

    public void setLastUpdBy( String lastUpdBy ) {
        this.lastUpdBy = lastUpdBy;
    }

    public Instant getLastUpdDt() {
        return lastUpdDt;
    }

    public void setLastUpdDt( Instant lastUpdDt ) {
        this.lastUpdDt = lastUpdDt;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg( Boolean delFlg ) {
        this.delFlg = delFlg;
    }

    public Instant getEffEndDt() {
        return effEndDt;
    }

    public void setEffEndDt( Instant effEndDt ) {
        this.effEndDt = effEndDt;
    }

    public Boolean getCrntRecFlg() {
        return crntRecFlg;
    }

    public void setCrntRecFlg( Boolean crntRecFlg ) {
        this.crntRecFlg = crntRecFlg;
    }


}

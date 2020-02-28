
package com.idev4.compliance.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.idev4.compliance.ids.MwAdtVstRnkngId;

@Entity
@Table ( name = "MW_ADT_VST_RKNG" )
@IdClass ( MwAdtVstRnkngId.class )
public class MwAdtVstRanking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column ( name = "VST_RKNG_SEQ" )
    private Long vstRkngSeq;

    @Id
    @Column ( name = "eff_start_dt" )
    private Instant effStartDt;

    @Column ( name = "VST_SEQ" )
    private Long vstSeq;

    @Column ( name = "CTGRY_TYP_SEQ" )
    private Long ctgryTypSeq;

    @Column ( name = "SCR" )
    private Long scr;

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

    public Long getVstRkngSeq() {
        return vstRkngSeq;
    }

    public void setVstRkngSeq( Long vstRkngSeq ) {
        this.vstRkngSeq = vstRkngSeq;
    }

    public Instant getEffStartDt() {
        return effStartDt;
    }

    public void setEffStartDt( Instant effStartDt ) {
        this.effStartDt = effStartDt;
    }

    public Long getVstSeq() {
        return vstSeq;
    }

    public void setVstSeq( Long vstSeq ) {
        this.vstSeq = vstSeq;
    }

    public Long getCtgryTypSeq() {
        return ctgryTypSeq;
    }

    public void setCtgryTypSeq( Long ctgryTypSeq ) {
        this.ctgryTypSeq = ctgryTypSeq;
    }

    public Long getScr() {
        return scr;
    }

    public void setScr( Long scr ) {
        this.scr = scr;
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

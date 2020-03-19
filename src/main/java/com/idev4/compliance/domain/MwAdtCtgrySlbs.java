
package com.idev4.compliance.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.idev4.compliance.ids.MwAdtCtgrySlbsId;

@Entity
@Table ( name = "MW_ADT_CTGRY_SLBS" )
@IdClass ( MwAdtCtgrySlbsId.class )
public class MwAdtCtgrySlbs implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column ( name = "ADT_CTGRY_SLBS_SEQ" )
    private Long adtCtgrySlbsSeq;

    @Id
    @Column ( name = "eff_start_dt" )
    private Instant effStartDt;

    @Column ( name = "ADT_CTGRY_SEQ" )
    private Long adtCtgrySeq;

    @Column ( name = "START_LMT" )
    private Double startLmt;

    @Column ( name = "END_LMT" )
    private Double endLmt;

    @Column ( name = "DED_SCR" )
    private Integer dedScr;

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

    public Long getAdtCtgrySlbsSeq() {
        return adtCtgrySlbsSeq;
    }

    public void setAdtCtgrySlbsSeq( Long adtCtgrySlbsSeq ) {
        this.adtCtgrySlbsSeq = adtCtgrySlbsSeq;
    }

    public Instant getEffStartDt() {
        return effStartDt;
    }

    public void setEffStartDt( Instant effStartDt ) {
        this.effStartDt = effStartDt;
    }

    public Long getAdtCtgrySeq() {
        return adtCtgrySeq;
    }

    public void setAdtCtgrySeq( Long adtCtgrySeq ) {
        this.adtCtgrySeq = adtCtgrySeq;
    }

    public Double getStartLmt() {
        return startLmt;
    }

    public void setStartLmt( Double startLmt ) {
        this.startLmt = startLmt;
    }

    public Double getEndLmt() {
        return endLmt;
    }

    public void setEndLmt( Double endLmt ) {
        this.endLmt = endLmt;
    }

    public Integer getDedScr() {
        return dedScr;
    }

    public void setDedScr( Integer dedScr ) {
        this.dedScr = dedScr;
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

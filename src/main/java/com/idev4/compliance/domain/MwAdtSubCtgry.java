
package com.idev4.compliance.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.idev4.compliance.ids.MwAdtSubCtgryId;

@Entity
@Table ( name = "MW_ADT_SB_CTGRY" )
@IdClass ( MwAdtSubCtgryId.class )
public class MwAdtSubCtgry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column ( name = "SB_CTGRY_SEQ" )
    private Long sbCtgrySeq;

    @Id
    @Column ( name = "eff_start_dt" )
    private Instant effStartDt;

    @Column ( name = "ADT_CTGRY_SEQ" )
    private Long adtCtgrySeq;

    @Column ( name = "SB_CTGRY_ID" )
    private String subCtgryId;

    @Column ( name = "SB_CTGRY_NM" )
    private String subCtgryNm;

    @Column ( name = "SB_CTGRY_CMNT" )
    private String subCtgryCmnt;

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

    public Long getSbCtgrySeq() {
        return sbCtgrySeq;
    }

    public void setSbCtgrySeq( Long sbCtgrySeq ) {
        this.sbCtgrySeq = sbCtgrySeq;
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

    public String getSubCtgryId() {
        return subCtgryId;
    }

    public void setSubCtgryId( String subCtgryId ) {
        this.subCtgryId = subCtgryId;
    }

    public String getSubCtgryNm() {
        return subCtgryNm;
    }

    public void setSubCtgryNm( String subCtgryNm ) {
        this.subCtgryNm = subCtgryNm;
    }

    public String getSubCtgryCmnt() {
        return subCtgryCmnt;
    }

    public void setSubCtgryCmnt( String subCtgryCmnt ) {
        this.subCtgryCmnt = subCtgryCmnt;
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

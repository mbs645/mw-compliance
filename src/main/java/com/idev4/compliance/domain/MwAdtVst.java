
package com.idev4.compliance.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.idev4.compliance.ids.MwAdtVstId;

@Entity
@Table ( name = "MW_ADT_VST" )
@IdClass ( MwAdtVstId.class )
public class MwAdtVst implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column ( name = "ADT_VST_SEQ" )
    private Long adtVstSeq;

    @Id
    @Column ( name = "eff_start_dt" )
    private Instant effStartDt;

    @Column ( name = "BRNCH_SEQ" )
    private Long brnchSeq;

    @Column ( name = "VST_ID" )
    private String vstId;

    @Column ( name = "START_DT" )
    private Instant strtDt;

    @Column ( name = "END_DT" )
    private Instant endDt;

    @Column ( name = "ACTL_START_DT" )
    private Instant actlStrtDt;

    @Column ( name = "ACTL_END_DT" )
    private Instant actlEndDt;

    @Column ( name = "ASGN_TO" )
    private Long asgnTo;

    @Column ( name = "VST_STS_KEY" )
    private Long vstStsKey;

    @Column ( name = "DATA_CHK_DT" )
    private Instant dataChkDt;

    @Column ( name = "VST_SCR" )
    private Long vstScr;

    @Column ( name = "ADT_FLG" )
    private Long adtFlg;

    @Column ( name = "RNKNG" )
    private Long rnkng;

    @Column ( name = "TRGT_CLNT" )
    private Long trgtClnt;

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

    public Long getAdtVstSeq() {
        return adtVstSeq;
    }

    public void setAdtVstSeq( Long adtVstSeq ) {
        this.adtVstSeq = adtVstSeq;
    }

    public Instant getEffStartDt() {
        return effStartDt;
    }

    public void setEffStartDt( Instant effStartDt ) {
        this.effStartDt = effStartDt;
    }

    public Long getBrnchSeq() {
        return brnchSeq;
    }

    public void setBrnchSeq( Long brnchSeq ) {
        this.brnchSeq = brnchSeq;
    }

    public String getVstId() {
        return vstId;
    }

    public void setVstId( String vstId ) {
        this.vstId = vstId;
    }

    public Instant getStrtDt() {
        return strtDt;
    }

    public void setStrtDt( Instant strtDt ) {
        this.strtDt = strtDt;
    }

    public Instant getEndDt() {
        return endDt;
    }

    public void setEndDt( Instant endDt ) {
        this.endDt = endDt;
    }

    public Instant getActlStrtDt() {
        return actlStrtDt;
    }

    public void setActlStrtDt( Instant actlStrtDt ) {
        this.actlStrtDt = actlStrtDt;
    }

    public Instant getActlEndDt() {
        return actlEndDt;
    }

    public void setActlEndDt( Instant actlEndDt ) {
        this.actlEndDt = actlEndDt;
    }

    public Long getAsgnTo() {
        return asgnTo;
    }

    public void setAsgnTo( Long asgnTo ) {
        this.asgnTo = asgnTo;
    }

    public Long getVstStsKey() {
        return vstStsKey;
    }

    public void setVstStsKey( Long vstStsKey ) {
        this.vstStsKey = vstStsKey;
    }

    public Instant getDataChkDt() {
        return dataChkDt;
    }

    public void setDataChkDt( Instant dataChkDt ) {
        this.dataChkDt = dataChkDt;
    }

    public Long getVstScr() {
        return vstScr;
    }

    public void setVstScr( Long vstScr ) {
        this.vstScr = vstScr;
    }

    public Long getAdtFlg() {
        return adtFlg;
    }

    public void setAdtFlg( Long adtFlg ) {
        this.adtFlg = adtFlg;
    }

    public Long getRnkng() {
        return rnkng;
    }

    public void setRnkng( Long rnkng ) {
        this.rnkng = rnkng;
    }

    public Long getTrgtClnt() {
        return trgtClnt;
    }

    public void setTrgtClnt( Long trgtClnt ) {
        this.trgtClnt = trgtClnt;
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}

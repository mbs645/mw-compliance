
package com.idev4.compliance.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "MW_ADT_BRNCH_RKNG" )
public class MwAdtBrnchRnkng implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column ( name = "ADT_BRNCH_RKNG_SEQ" )
    private Long adtBrcnhRnkgSeq;

    @Column ( name = "RNKNG_DT" )
    private Instant rnkngDte;

    @Column ( name = "BRNCH_SEQ" )
    private Long brnchSeq;

    @Column ( name = "LAST_VST_SEQ" )
    private Long lstVstSeq;

    @Column ( name = "BRNCH_SCR" )
    private Long BrnchScr;

    @Column ( name = "BRNCH_RKNG" )
    private Long brnchRnkng;

    @Column ( name = "crnt_rec_flg" )
    private Boolean crntRecFlg;

    public Long getAdtBrcnhRnkgSeq() {
        return adtBrcnhRnkgSeq;
    }

    public void setAdtBrcnhRnkgSeq( Long adtBrcnhRnkgSeq ) {
        this.adtBrcnhRnkgSeq = adtBrcnhRnkgSeq;
    }

    public Instant getRnkngDte() {
        return rnkngDte;
    }

    public void setRnkngDte( Instant rnkngDte ) {
        this.rnkngDte = rnkngDte;
    }

    public Long getBrnchSeq() {
        return brnchSeq;
    }

    public void setBrnchSeq( Long brnchSeq ) {
        this.brnchSeq = brnchSeq;
    }

    public Long getLstVstSeq() {
        return lstVstSeq;
    }

    public void setLstVstSeq( Long lstVstSeq ) {
        this.lstVstSeq = lstVstSeq;
    }

    public Long getBrnchScr() {
        return BrnchScr;
    }

    public void setBrnchScr( Long brnchScr ) {
        BrnchScr = brnchScr;
    }

    public Long getBrnchRnkng() {
        return brnchRnkng;
    }

    public void setBrnchRnkng( Long brnchRnkng ) {
        this.brnchRnkng = brnchRnkng;
    }

    public Boolean getCrntRecFlg() {
        return crntRecFlg;
    }

    public void setCrntRecFlg( Boolean crntRecFlg ) {
        this.crntRecFlg = crntRecFlg;
    }

}

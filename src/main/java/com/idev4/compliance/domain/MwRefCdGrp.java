package com.idev4.compliance.domain;


import com.idev4.compliance.ids.MwRefCdGrpId;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.persistence.*;

/**
 * A MwRefCdGrp.
 */
@Entity
@Table(name = "mw_ref_cd_grp")
@IdClass(MwRefCdGrpId.class)
public class MwRefCdGrp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ref_cd_grp_seq")
    private Long refCdGrpSeq;

    @Id
    @Column(name = "eff_start_dt")
    private Instant effStartDt;
    
    @Column(name = "ref_cd_grp")
    private String refCdGrp;

    @Column(name = "ref_cd_grp_nm")
    private String refCdGrpName;

    @Column(name = "REF_CD_GRP_DSCR")
    private String refCdGrpCmnt;

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
    
    
    @Column(name = "REF_CD_GRP_ACTIVE_FLG")
    private Boolean refCdGrpActiveFlg;

    public Boolean getRefCdGrpActiveFlg() {
		return refCdGrpActiveFlg;
	}

	public void setRefCdGrpActiveFlg(Boolean refCdGrpActiveFlg) {
		this.refCdGrpActiveFlg = refCdGrpActiveFlg;
	}

	public Long getRefCdGrpSeq() {
        return refCdGrpSeq;
    }

    public MwRefCdGrp refCdGrpSeq(Long refCdGrpSeq) {
        this.refCdGrpSeq = refCdGrpSeq;
        return this;
    }

    public void setRefCdGrpSeq(Long refCdGrpSeq) {
        this.refCdGrpSeq = refCdGrpSeq;
    }

    public String getRefCdGrp() {
        return refCdGrp;
    }

    public MwRefCdGrp refCdGrp(String refCdGrp) {
        this.refCdGrp = refCdGrp;
        return this;
    }

    public void setRefCdGrp(String refCdGrp) {
        this.refCdGrp = refCdGrp;
    }

    public String getRefCdGrpName() {
        return refCdGrpName;
    }

    public MwRefCdGrp refCdGrpName(String refCdGrpName) {
        this.refCdGrpName = refCdGrpName;
        return this;
    }

    public void setRefCdGrpName(String refCdGrpName) {
        this.refCdGrpName = refCdGrpName;
    }

    public String getRefCdGrpCmnt() {
        return refCdGrpCmnt;
    }

    public MwRefCdGrp refCdGrpCmnt(String refCdGrpCmnt) {
        this.refCdGrpCmnt = refCdGrpCmnt;
        return this;
    }

    public void setRefCdGrpCmnt(String refCdGrpCmnt) {
        this.refCdGrpCmnt = refCdGrpCmnt;
    }

    public String getCrtdBy() {
        return crtdBy;
    }

    public MwRefCdGrp crtdBy(String crtdBy) {
        this.crtdBy = crtdBy;
        return this;
    }

    public void setCrtdBy(String crtdBy) {
        this.crtdBy = crtdBy;
    }

    public Instant getCrtdDt() {
        return crtdDt;
    }

    public MwRefCdGrp crtdDt(Instant crtdDt) {
        this.crtdDt = crtdDt;
        return this;
    }

    public void setCrtdDt(Instant crtdDt) {
        this.crtdDt = crtdDt;
    }

    public String getLastUpdBy() {
        return lastUpdBy;
    }

    public MwRefCdGrp lastUpdBy(String lastUpdBy) {
        this.lastUpdBy = lastUpdBy;
        return this;
    }

    public void setLastUpdBy(String lastUpdBy) {
        this.lastUpdBy = lastUpdBy;
    }

    public Instant getLastUpdDt() {
        return lastUpdDt;
    }

    public MwRefCdGrp lastUpdDt(Instant lastUpdDt) {
        this.lastUpdDt = lastUpdDt;
        return this;
    }

    public void setLastUpdDt(Instant lastUpdDt) {
        this.lastUpdDt = lastUpdDt;
    }

    public Boolean isDelFlg() {
        return delFlg;
    }

    public MwRefCdGrp delFlg(Boolean delFlg) {
        this.delFlg = delFlg;
        return this;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Instant getEffStartDt() {
        return effStartDt;
    }

    public MwRefCdGrp effStartDt(Instant effStartDt) {
        this.effStartDt = effStartDt;
        return this;
    }

    public void setEffStartDt(Instant effStartDt) {
        this.effStartDt = effStartDt;
    }

    public Instant getEffEndDt() {
        return effEndDt;
    }

    public MwRefCdGrp effEndDt(Instant effEndDt) {
        this.effEndDt = effEndDt;
        return this;
    }

    public void setEffEndDt(Instant effEndDt) {
        this.effEndDt = effEndDt;
    }

    public Boolean isCrntRecFlg() {
        return crntRecFlg;
    }

    public MwRefCdGrp crntRecFlg(Boolean crntRecFlg) {
        this.crntRecFlg = crntRecFlg;
        return this;
    }

    public void setCrntRecFlg(Boolean crntRecFlg) {
        this.crntRecFlg = crntRecFlg;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MwRefCdGrp mwRefCdGrp = (MwRefCdGrp) o;
        if (mwRefCdGrp.getRefCdGrpSeq() == null || getRefCdGrpSeq() == null) {
            return false;
        }
        return Objects.equals(getRefCdGrpSeq(), mwRefCdGrp.getRefCdGrpSeq());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getRefCdGrpSeq());
    }

    @Override
    public String toString() {
        return "MwRefCdGrp{" +
            "id=" + getRefCdGrpSeq() +
            ", refCdGrpSeq='" + getRefCdGrpSeq() + "'" +
            ", refCdGrp='" + getRefCdGrp() + "'" +
            ", refCdGrpName='" + getRefCdGrpName() + "'" +
            ", refCdGrpCmnt='" + getRefCdGrpCmnt() + "'" +
            ", crtdBy='" + getCrtdBy() + "'" +
            ", crtdDt='" + getCrtdDt() + "'" +
            ", lastUpdBy='" + getLastUpdBy() + "'" +
            ", lastUpdDt='" + getLastUpdDt() + "'" +
            ", delFlg='" + isDelFlg() + "'" +
            ", effStartDt='" + getEffStartDt() + "'" +
            ", effEndDt='" + getEffEndDt() + "'" +
            ", crntRecFlg='" + isCrntRecFlg() + "'" +
            "}";
    }
}

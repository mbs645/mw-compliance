package com.idev4.compliance.domain;

import java.io.Serializable;
import java.time.Instant;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;

import com.idev4.compliance.ids.MwDvcRgstrId;

@Entity
@Table(name = "mw_dvc_rgstr")
@IdClass(MwDvcRgstrId.class)
public class MwDvcRgstr implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dvc_rgstr_seq")
    private long dvcRgstrSeq;
    
	@Column(name = "eff_start_dt")
    private Instant effStartDt;
    
    @Column(name= "dvc_addr")
    private String dvcAddr;

    @Column(name ="enty_typ_flg")
    private int entyTypFlg;

    @Column(name ="enty_typ_seq")
    private long entyTypSeq;

    @Column(name ="del_flg")
    private boolean delFlg;

    @Column(name = "sync_dt")
    private Instant syncDt;

    @Column(name = "stp_sync_dt")
    private Instant stpSyncDt;
    
    @Column(name = "sync_tmp_dt")
    private Instant syncTmpDt;
    
    
    @Column(name = "stp_sync_tmp_dt")
    private Instant stpSyncTmpDt;
    
    @Column(name = "eff_end_dt")
    private Instant effEndDt;
    
    @Column(name = "crnt_rec_flg")
    private Boolean crntRecFlg;
    
    @Column(name = "crtd_by")
    private String crtdBy;

    @Column(name = "crtd_dt")
    private Instant crtdDt;

    @Column(name = "last_upd_by")
    private String lastUpdBy;

    @Column(name = "last_upd_dt")
    private Instant lastUpdDt;
    
    public long getDvcRgstrSeq() {
		return dvcRgstrSeq;
	}

	public void setDvcRgstrSeq(long dvcRgstrSeq) {
		this.dvcRgstrSeq = dvcRgstrSeq;
	}

	public Instant getEffStartDt() {
		return effStartDt;
	}

	public void setEffStartDt(Instant effStartDt) {
		this.effStartDt = effStartDt;
	}

	public String getDvcAddr() {
		return dvcAddr;
	}

	public void setDvcAddr(String dvcAddr) {
		this.dvcAddr = dvcAddr;
	}

	public int getEntyTypFlg() {
		return entyTypFlg;
	}

	public void setEntyTypFlg(int entyTypFlg) {
		this.entyTypFlg = entyTypFlg;
	}

	public long getEntyTypSeq() {
		return entyTypSeq;
	}

	public void setEntyTypSeq(long entyTypSeq) {
		this.entyTypSeq = entyTypSeq;
	}

	public boolean isDelFlg() {
		return delFlg;
	}

	public void setDelFlg(boolean delFlg) {
		this.delFlg = delFlg;
	}

	public Instant getSyncDt() {
		return syncDt;
	}

	public void setSyncDt(Instant syncDt) {
		this.syncDt = syncDt;
	}

	public Instant getStpSyncDt() {
		return stpSyncDt;
	}

	public void setStpSyncDt(Instant stpSyncDt) {
		this.stpSyncDt = stpSyncDt;
	}

	public Instant getSyncTmpDt() {
		return syncTmpDt;
	}

	public void setSyncTmpDt(Instant syncTmpDt) {
		this.syncTmpDt = syncTmpDt;
	}

	public Instant getStpSyncTmpDt() {
		return stpSyncTmpDt;
	}

	public void setStpSyncTmpDt(Instant stpSyncTmpDt) {
		this.stpSyncTmpDt = stpSyncTmpDt;
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

}

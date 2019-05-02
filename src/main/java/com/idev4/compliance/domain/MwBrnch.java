package com.idev4.compliance.domain;


import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.idev4.compliance.ids.MwBrnchId;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

/**
 * A MwBrnch.
 */
@Entity
@Table(name = "mw_brnch")
@IdClass(MwBrnchId.class)
public class MwBrnch implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "brnch_seq")
    private Long brnchSeq;

    @Column(name = "brnch_cd")
    private String brnchCd;

    @Column(name = "brnch_nm")
    private String brnchNm;

    @Column(name = "brnch_dscr")
    private String brnchDscr;
    
    @Column(name = "brnch_sts_Key")
    private Long brnchStsKey;
    
    @Column(name = "brnch_typ_Key")
    private Long brnchTypKey;
    
    @Column(name = "brnch_PH_num")
    private String brnchPhNum;

    @Column(name = "area_seq")
    private Long areaSeq;

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

    @Id
    @Column(name = "eff_start_dt")
    private Instant effStartDt;

    @Column(name = "eff_end_dt")
    private Instant effEndDt;

    @Column(name = "crnt_rec_flg")
    private Boolean crntRecFlg;
    
//    @OneToMany 
//    @JoinColumns({
//	@JoinColumn(name = "brnch_seq") ,
//    @JoinColumn(name = "eff_start_dt") })
//    @LazyCollection(LazyCollectionOption.FALSE)
//	private List<MwPort> ports = new LinkedList<MwPort>();
//
//    
//    
//	public List<MwPort> getPorts() {
//		return ports;
//	}
//
//	public void setPorts(List<MwPort> ports) {
//		this.ports = ports;
//	}

	public Long getBrnchSeq() {
		return brnchSeq;
	}

	public void setBrnchSeq(Long brnchSeq) {
		this.brnchSeq = brnchSeq;
	}

	public String getBrnchCd() {
		return brnchCd;
	}

	public void setBrnchCd(String brnchCd) {
		this.brnchCd = brnchCd;
	}

	public String getBrnchNm() {
		return brnchNm;
	}

	public void setBrnchNm(String brnchNm) {
		this.brnchNm = brnchNm;
	}

	public String getBrnchDscr() {
		return brnchDscr;
	}

	public void setBrnchDscr(String brnchDscr) {
		this.brnchDscr = brnchDscr;
	}

	public Long getBrnchStsKey() {
		return brnchStsKey;
	}

	public void setBrnchStsKey(Long brnchStsKey) {
		this.brnchStsKey = brnchStsKey;
	}

	public Long getBrnchTypKey() {
		return brnchTypKey;
	}

	public void setBrnchTypKey(Long brnchTypKey) {
		this.brnchTypKey = brnchTypKey;
	}

	public String getBrnchPhNum() {
		return brnchPhNum;
	}

	public void setBrnchPhNum(String brnchPhNum) {
		this.brnchPhNum = brnchPhNum;
	}

	public Long getAreaSeq() {
		return areaSeq;
	}

	public void setAreaSeq(Long areaSeq) {
		this.areaSeq = areaSeq;
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

	public Instant getEffStartDt() {
		return effStartDt;
	}

	public void setEffStartDt(Instant effStartDt) {
		this.effStartDt = effStartDt;
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

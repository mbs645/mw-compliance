package com.idev4.compliance.domain;


import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;


import com.idev4.compliance.ids.MwAdtIsuId;
import com.idev4.compliance.ids.MwAdtVstId;

@Entity
@Table(name = "MW_ADT_ISU")
@IdClass(MwAdtIsuId.class)
public class MwAdtIsu implements Serializable {

	    private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name = "ADT_ISU_SEQ")
	    private Long adtIsuSeq;

		@Id
	    @Column(name = "eff_start_dt")
	    private Instant effStartDt;
	    

	    @Column(name = "SB_CTGRY_SEQ")
	    private Long sbCtgrySeq;
	    
	    @Column(name = "ISU_ID")
	    private String isuId;
	    
	    
	    @Column(name = "ISU_NM")
	    private String IsuNm;
	    
	    @Column(name = "ISU_CMNT")
	    private String isuCmnt;
	    
	    @Column(name = "ISU_SCR")
	    private String isuScr;

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
	    
	    
	   
	    public String getIsuScr() {
			return isuScr;
		}

		public void setIsuScr(String isuScr) {
			this.isuScr = isuScr;
		}
		
	    public Long getAdtIsuSeq() {
			return adtIsuSeq;
		}

		public void setAdtIsuSeq(Long adtIsuSeq) {
			this.adtIsuSeq = adtIsuSeq;
		}

		public Instant getEffStartDt() {
			return effStartDt;
		}

		public void setEffStartDt(Instant effStartDt) {
			this.effStartDt = effStartDt;
		}

		public Long getSbCtgrySeq() {
			return sbCtgrySeq;
		}

		public void setSbCtgrySeq(Long sbCtgrySeq) {
			this.sbCtgrySeq = sbCtgrySeq;
		}

		public String getIsuId() {
			return isuId;
		}

		public void setIsuId(String isuId) {
			this.isuId = isuId;
		}

		public String getIsuNm() {
			return IsuNm;
		}

		public void setIsuNm(String isuNm) {
			IsuNm = isuNm;
		}

		public String getIsuCmnt() {
			return isuCmnt;
		}

		public void setIsuCmnt(String isuCmnt) {
			this.isuCmnt = isuCmnt;
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
}

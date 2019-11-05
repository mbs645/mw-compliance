
package com.idev4.compliance.web.rest.util;

public class Queries {

	public static String complianceLoansQuery = "select ap.loan_app_seq,  \r\n" + 
			"						       clnt.frst_nm||' '||clnt.last_nm clnt_nm ,  \r\n" + 
			"						       clnt_id,  \r\n" + 
			"						       msts.ref_cd_dscr mrtl_sts,  \r\n" + 
			"						       occ.ref_cd_dscr occ,  \r\n" + 
			"						       GET_CLNT_CMNTY(ap.loan_app_seq) cmnty_nm,  \r\n" + 
			"						       prt.port_nm,  \r\n" + 
			"						       get_od_info(ap.loan_app_seq,sysdate,'d') od_days,  \r\n" + 
			"						       prd.prd_seq,  \r\n" + 
			"						       nvl((select distinct 1 from mw_clnt_rel crl where crl.crnt_rec_flg=1 and crl.rel_typ_flg=2 and crl.loan_app_seq=ap.loan_app_seq),0) nkin_flg,  \r\n" + 
			"						       nvl((select 1 From mw_biz_aprsl aprsl join mw_loan_app la on la.loan_app_seq=aprsl.loan_app_seq and la.crnt_rec_flg=1 and la.loan_cycl_num=ap.loan_cycl_num-1 and la.loan_app_seq=ap.loan_app_seq join mw_ref_cd_val acty on acty.ref_cd_seq=aprsl.acty_key where aprsl.crnt_rec_flg=1),0) biz_chng_flg,  \r\n" + 
			"						       get_clnt_addr(ap.loan_app_seq),  \r\n" + 
			"						       res.ref_cd_dscr res_sts,  \r\n" + 
			"						       nvl(clnt.yrs_res,0)*100+nvl(clnt.mnths_res,0) res_tnr,  \r\n" + 
			"						       NUM_OF_DPND tot_fmly_memb,   \r\n" + 
			"						       ERNG_MEMB num_of_ernrs,  \r\n" + 
			"						       prd.prd_nm,  \r\n" + 
			"						       lst_loan_aprvd_amt(ap.loan_app_seq) prev_amt,  \r\n" + 
			"						       ap.loan_cycl_num,  \r\n" + 
			"						       ap.rqstd_loan_amt,  \r\n" + 
			"						       ap.aprvd_loan_amt,  \r\n" + 
			"						       plan_nm,  \r\n" + 
			"						       ap.tbl_scrn_flg scrn_flg,  \r\n" + 
			"						       clnt.cnic_num,  \r\n" + 
			"						       clnt.cnic_expry_dt,  \r\n" + 
			"						       clnt.dob,  \r\n" + 
			"						       gndr.ref_cd_dscr gndr,  \r\n" + 
			"                               case when get_biz_tnr(ap.loan_app_seq) > 0 then get_app_acty(ap.loan_app_seq) when get_biz_tnr(ap.loan_app_seq)>0 then 'School' else null end biz_acty,\r\n" + 
			"                               case when get_biz_tnr(ap.loan_app_seq) > 0 then get_biz_tnr(ap.loan_app_seq) when get_sch_tnr(ap.loan_app_seq)>0 then get_sch_tnr(ap.loan_app_seq) else 0 end  biz_tnr,\r\n" + 
			"                               case when get_biz_addr(ap.loan_app_seq) is not null then get_biz_addr(ap.loan_app_seq) when get_sch_addr(ap.loan_app_seq) is not null then get_sch_addr(ap.loan_app_seq) else null end biz_addr,  \r\n" + 
			"						       case when get_biz_incm(ap.loan_app_seq) > 0 then get_biz_incm(ap.loan_app_seq) when get_sch_incm(ap.loan_app_seq)>0 then get_sch_incm(ap.loan_app_seq) else 0 end biz_incm,  \r\n" + 
			"						       case when get_biz_ownr(ap.loan_app_seq) is not null then get_biz_ownr(ap.loan_app_seq) when get_sch_ownr(ap.loan_app_seq) is not null then get_sch_ownr(ap.loan_app_seq) else null end prsn_run_biz,  \r\n" + 
			"						       case when get_prm_incm(ap.loan_app_seq) > 0 then get_prm_incm(ap.loan_app_seq) when get_sch_prm_incm(ap.loan_app_seq)>0 then get_sch_prm_incm(ap.loan_app_seq) else 0 end prm_incm,  \r\n" + 
			"						       case when get_sec_incm(ap.loan_app_seq) > 0 then get_sec_incm(ap.loan_app_seq) when get_sch_sec_incm(ap.loan_app_seq)>0 then get_sch_sec_incm(ap.loan_app_seq) else 0 end sec_incm,  \r\n" + 
			"						       case when get_hsld_exp(ap.loan_app_seq) > 0 then get_hsld_exp(ap.loan_app_seq) when get_sch_hsld_exp(ap.loan_app_seq)>0 then get_sch_hsld_exp(ap.loan_app_seq) else 0 end hsld,  \r\n" + 
			"						       dsbmt.srvs_chrg,  \r\n" + 
			"						       dsbmt.pybl_amt,  \r\n" + 
			"						       dsbmt.inst_num,  \r\n" + 
			"						       dsbmt.dsbmt_dt,  \r\n" + 
			"						       dsbmt.cmplt_dt ,  \r\n" + 
			"						       pg.prd_grp_id prd_id, \r\n" + 
			"			                   (select round(months_between(sysdate,max(eff_start_dt)),0) from mw_adt_vst_srvy srvy where srvy.crnt_rec_flg=1 and enty_seq=ap.clnt_seq and enty_typ_flg=1) month_lst_vst, \r\n" + 
			"			                   inst_adv, \r\n" + 
			"			                   (select crdt_scr from mw_loan_app_crdt_scr scr where scr.crnt_rec_flg=1 and scr.loan_app_seq=ap.loan_app_seq) crdt_scr, \r\n" + 
			"			                    GET_APP_ACTY_KEY(ap.loan_app_seq) acty_key, \r\n" + 
			"			                    lst_loan_biz_acty(ap.loan_app_seq) prv_biz_acty,\r\n" + 
			"                                case when get_od_info(ap.loan_app_seq,sysdate,'psc')>0 then loan_app_ost(ap.loan_app_seq,sysdate,'psc') else 0 end par_1_day,\r\n" + 
			"                                case when get_od_info(ap.loan_app_seq,sysdate,'psc')>29 then loan_app_ost(ap.loan_app_seq,sysdate,'psc') else 0 end par_30_day,\r\n" + 
			"                                prt.port_cd,\r\n" + 
			"                                emp.emp_nm bdo_nm,\r\n" + 
			"                                erl.eff_start_dt last_rotated,\r\n" + 
			"                                (select count(distinct pymt_sched_dtl_seq) from mw_pymt_sched_hdr psh join mw_pymt_sched_dtl psd on psd.pymt_sched_hdr_seq=psh.pymt_sched_hdr_seq and psd.crnt_rec_flg=1 and psd.pymt_sts_key=948 where psh.crnt_rec_flg=1 and psh.loan_app_seq=ap.loan_app_seq) od_inst\r\n" + 
			"                        from mw_loan_app ap  \r\n" + 
			"						join mw_port prt on prt.port_seq = ap.port_seq and prt.crnt_rec_flg=1 and prt.brnch_seq=:Brnch_seq\r\n" + 
			"                        join mw_port_emp_rel erl on erl.port_seq=prt.port_seq and erl.crnt_rec_flg=1\r\n" + 
			"                        join mw_emp emp on emp.emp_seq=erl.emp_seq\r\n" + 
			"						join mw_clnt clnt on clnt.clnt_seq=ap.clnt_seq and clnt.crnt_rec_flg=1  \r\n" + 
			"						join mw_ref_cd_val msts on msts.ref_cd_seq=clnt.mrtl_sts_key and msts.crnt_rec_flg=1  \r\n" + 
			"						join mw_ref_cd_val occ on occ.ref_cd_seq=clnt.occ_key and occ.crnt_rec_flg=1  \r\n" + 
			"						join mw_ref_cd_val res on res.ref_cd_seq=clnt.res_typ_key and res.crnt_rec_flg=1  \r\n" + 
			"						join mw_ref_cd_val gndr on gndr.ref_cd_seq=clnt.gndr_key and gndr.crnt_rec_flg=1  \r\n" + 
			"						join mw_addr_rel adrl on adrl.enty_key=clnt.clnt_seq and adrl.enty_typ='Client' and adrl.crnt_rec_flg=1  \r\n" + 
			"						join mw_prd prd on prd.prd_seq=ap.prd_seq and prd.crnt_rec_flg=1  \r\n" + 
			"						join mw_prd_grp pg on pg.prd_grp_seq=prd.prd_grp_seq and pg.crnt_rec_flg=1  \r\n" + 
			"						left outer join (select hlth.loan_app_seq,pln.plan_nm from mw_clnt_hlth_insr hlth join mw_hlth_insr_plan pln on pln.hlth_insr_plan_seq=hlth.hlth_insr_plan_seq and pln.crnt_rec_flg=1 where hlth.crnt_rec_flg=1) pln on pln.loan_app_seq=ap.loan_app_seq  \r\n" + 
			"						join (  \r\n" + 
			"						        select psh.loan_app_seq,  \r\n" + 
			"						               count(psd.inst_num) inst_num,  \r\n" + 
			"			                           count(distinct case when psd.pymt_sts_key=947 then psh.loan_app_seq else null end) inst_adv, \r\n" + 
			"						               sum(nvl(psd.ppal_amt_due,0)+nvl(psd.tot_chrg_due,0)+nvl(othc.oth_amt,0)) pybl_amt,  \r\n" + 
			"						               sum(nvl(psd.tot_chrg_due,0)) srvs_chrg,  \r\n" + 
			"						               max(due_dt) cmplt_dt,  \r\n" + 
			"						               (select dsbmt_dt from mw_dsbmt_vchr_hdr vdr where vdr.crnt_rec_flg=1 and vdr.dsbmt_vchr_typ = 0 and vdr.loan_app_seq=psh.loan_app_seq) dsbmt_dt  \r\n" + 
			"						          from mw_pymt_sched_hdr psh  \r\n" + 
			"						          join mw_pymt_sched_dtl psd on psd.pymt_sched_hdr_seq=psh.pymt_sched_hdr_seq and psd.crnt_rec_flg=1  \r\n" + 
			"						          join (select pymt_sched_dtl_seq,sum(amt) oth_amt from mw_pymt_sched_chrg chrg where chrg.crnt_rec_flg=1 group by pymt_sched_dtl_seq) othc on  \r\n" + 
			"						                         othc.pymt_sched_dtl_seq=psd.pymt_sched_dtl_seq  \r\n" + 
			"						        group by psh.loan_app_seq  \r\n" + 
			"						) dsbmt on dsbmt.loan_app_seq=ap.loan_app_seq  \r\n" + 
			"						where ap.crnt_rec_flg=1";
	
	
	public static String complianceLandingQuery = "SELECT\r\n" + 
			"   brnch.brnch_seq, brnch.brnch_cd,brnch.brnch_nm, trgt.trgt, (select count(1) from mw_adt_vst vst join mw_ref_cd_val val on val.ref_cd_seq=vst.VST_STS_KEY and val.ref_cd='01385' and val.crnt_rec_flg=1 where vst.brnch_seq=trgt.brnch_seq and vst.crnt_rec_flg=1) as completed_visits\r\n" + 
			" FROM\r\n" + 
			"    mw_adt_trgt trgt\r\n" + 
			"    JOIN mw_brnch brnch ON brnch.brnch_seq = trgt.brnch_seq\r\n" + 
			"                           AND brnch.crnt_rec_flg = 1";
	
	
	public static String adtSrvy = "select (select qst.qst_str from mw_qst qst where qst.qst_seq=srvy.qst_seq and qst.crnt_rec_flg=1) as qst_str,(select ans.answr_str from mw_answr ans where ans.answr_seq = srvy.answr_seq and ans.crnt_rec_flg=1) as answr,clnt.frst_nm,clnt.last_nm,app.loan_id from MW_ADT_VST_SRVY srvy\r\n" + 
			"join mw_loan_app app on app.loan_app_seq= srvy.enty_seq and app.crnt_rec_flg=1\r\n" + 
			"join mw_clnt clnt on clnt.clnt_seq= app.clnt_seq\r\n" + 
			"where srvy.crnt_rec_flg=1\r\n" + 
			"and srvy.adt_vst_seq=";
	
	public static String dvc_arr="select rgstr.DVC_ADDR,rgstr.enty_typ_seq as seq,\n" + 
			"case rgstr.enty_typ_flg\n" + 
			"when 1\n" + 
			"then \n" + 
			"'BDO > ' || (select emp.emp_lan_id from mw_emp emp join mw_port_emp_rel prel on prel.emp_seq=emp.emp_seq and prel.port_seq=rgstr.enty_typ_seq and prel.crnt_rec_flg=1) \n" + 
			"when 2\n" + 
			"then \n" + 
			"' BM > ' || (select emp.emp_lan_id from mw_emp emp join mw_brnch_emp_rel brel on brel.emp_seq=emp.emp_seq and brel.brnch_seq=rgstr.enty_typ_seq and brel.crnt_rec_flg=1 and brel.del_flg\n" + 
			"=0) \n" + 
			"when 3\n" + 
			"then \n" + 
			"'COM > ' || (select emp.emp_lan_id from mw_emp emp where emp.emp_seq=rgstr.enty_typ_seq) \n" + 
			"end\n" + 
			" from mw_dvc_rgstr rgstr\n" + 
			" where rgstr.crnt_rec_flg=1";
	public static String dvc_reg="select rgstr.DVC_ADDR,rgstr.enty_typ_seq as seq,\n" + 
			"case rgstr.enty_typ_flg\n" + 
			"when 1\n" + 
			"then \n" + 
			"'BDO > ' || (select emp.emp_lan_id from mw_emp emp join mw_port_emp_rel prel on prel.emp_seq=emp.emp_seq and prel.port_seq=rgstr.enty_typ_seq and prel.crnt_rec_flg=1) \n" + 
			"when 2\n" + 
			"then \n" + 
			"' BM > ' || (select emp.emp_lan_id from mw_emp emp join mw_brnch_emp_rel brel on brel.emp_seq=emp.emp_seq and brel.brnch_seq=rgstr.enty_typ_seq and brel.crnt_rec_flg=1 and brel.del_flg\n" + 
			"=0) \n" + 
			"when 3\n" + 
			"then \n" + 
			"'COM > ' || (select emp.emp_lan_id from mw_emp emp where emp.emp_seq=rgstr.enty_typ_seq) \n" + 
			"end\n" + 
			" from mw_dvc_rgstr rgstr\n" + 
			" where rgstr.crnt_rec_flg=1\n" + 
			" and rgstr.dvc_addr=";
	
	
	public static String prev_vst="select vst.vst_id ,vst.rnkng,  \r\n" + 
			"			       vst_scr,  \r\n" + 
			"			       vst.actl_start_dt lst_vst_dt,  \r\n" + 
			"			       emp.emp_nm lst_vst_by,  \r\n" + 
			"			       vst.data_chk_dt,  \r\n" + 
			"			       prt.port_cd,  \r\n" + 
			"			       prt.port_nm,  \r\n" + 
			"			       bdo.emp_nm,  \r\n" + 
			"			       count(distinct app.clnt_seq) clnt_vstd,  \r\n" + 
			"			       count(distinct cmnty.cmnty_nm) cmnt_cnt  \r\n" + 
			"			from mw_adt_vst vst  \r\n" + 
			"			join mw_emp emp on emp.emp_seq=vst.asgn_to  \r\n" + 
			"			join mw_adt_vst_srvy srv on srv.adt_vst_seq=vst.adt_vst_seq and srv.crnt_rec_flg=1  \r\n" + 
			"			join mw_loan_app app on app.loan_app_seq=srv.enty_seq and app.crnt_rec_flg=1  \r\n" + 
			"			join mw_port prt on prt.port_seq=app.port_seq and prt.crnt_rec_flg=1  \r\n" + 
			"			join mw_port_emp_rel erl on erl.port_seq=app.port_seq and erl.crnt_rec_flg=1  \r\n" + 
			"			join mw_emp bdo on bdo.emp_seq=erl.emp_seq   \r\n" + 
			"			join mw_addr_rel adrel on app.clnt_seq=adrel.enty_key and enty_typ='Client' and adrel.crnt_rec_flg=1 and adrel.del_flg=0  \r\n" + 
			"			join mw_addr ad on ad.addr_seq=adrel.addr_seq and ad.crnt_rec_flg=1 and ad.del_flg=0  \r\n" + 
			"			join mw_cmnty cmnty on cmnty.cmnty_seq = ad.cmnty_seq and cmnty.crnt_rec_flg=1 and cmnty.del_flg=0  \r\n" + 
			"			where vst.crnt_rec_flg=1 and vst.brnch_seq=:Brnch_seq\r\n" + 
			"			and to_date(vst.actl_end_dt)=(select to_date(max(actl_end_dt)) from mw_adt_vst pvst where pvst.crnt_rec_flg=1 and pvst.vst_sts_key=1387)  \r\n" + 
			"			group by vst.vst_id,vst.rnkng,  \r\n" + 
			"			       vst_scr,  \r\n" + 
			"			       vst.actl_start_dt,  \r\n" + 
			"			       emp.emp_nm ,  \r\n" + 
			"			       vst.data_chk_dt,  \r\n" + 
			"			       prt.port_cd,  \r\n" + 
			"			       prt.port_nm,  \r\n" + 
			"			       bdo.emp_nm";
	
}
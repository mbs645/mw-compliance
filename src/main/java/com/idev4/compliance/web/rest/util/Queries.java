
package com.idev4.compliance.web.rest.util;

public class Queries {

	public static String complianceLoansQuery = "select ap.loan_app_seq,  \r\n" + 
			"						       clnt.frst_nm||' '||clnt.last_nm clnt_nm ,  \r\n" + 
			"						       clnt_id,  \r\n" + 
			"						       msts.ref_cd_dscr mrtl_sts,  \r\n" + 
			"						       occ.ref_cd_dscr occ,  \r\n" + 
			"						       addr.cmnty_nm,  \r\n" + 
			"						       prt.port_nm,  \r\n" + 
			"						       get_od_info(ap.loan_app_seq,sysdate,'d') od_days,  \r\n" + 
			"						       prd.prd_seq,  \r\n" + 
			"						       nvl((select distinct 1 from mw_clnt_rel crl where crl.crnt_rec_flg=1 and crl.rel_typ_flg=2 and crl.loan_app_seq=ap.loan_app_seq),0) nkin_flg,  \r\n" + 
			"						       nvl((select 1 From mw_biz_aprsl aprsl join mw_loan_app la on la.loan_app_seq=aprsl.loan_app_seq and la.crnt_rec_flg=1 and la.loan_cycl_num=ap.loan_cycl_num-1 and la.loan_app_seq=ap.loan_app_seq join mw_ref_cd_val acty on acty.ref_cd_seq=aprsl.acty_key where aprsl.crnt_rec_flg=1),0) biz_chng_flg,  \r\n" + 
			"						       addr.clnt_address,  \r\n" + 
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
			"						       gndr.ref_cd_dscr gndr,    \r\n" + 
			"						       case when baprsl.loan_app_seq is not null then baprsl.biz_acty else (case when saprsl.loan_app_seq is not null then saprsl.sch_acty else null end) end biz_acty,  \r\n" + 
			"						       case when baprsl.loan_app_seq is not null then baprsl.biz_tnr else (case when saprsl.loan_app_seq is not null then saprsl.biz_tnr else null end) end biz_tnr,  \r\n" + 
			"						       case when baprsl.loan_app_seq is not null then baprsl.biz_addr else (case when saprsl.loan_app_seq is not null then saprsl.sch_addr else null end) end biz_addr,  \r\n" + 
			"						       case when baprsl.loan_app_seq is not null then baprsl.biz_incm else (case when saprsl.loan_app_seq is not null then saprsl.sch_biz_incm else 0 end) end biz_incm,  \r\n" + 
			"						       case when baprsl.loan_app_seq is not null then baprsl.biz_ownr else (case when saprsl.loan_app_seq is not null then saprsl.sch_ownr else null end) end prsn_run_biz,  \r\n" + 
			"						       case when baprsl.loan_app_seq is not null then baprsl.prm_incm else (case when saprsl.loan_app_seq is not null then saprsl.sch_prm_incm else 0 end) end prm_incm,  \r\n" + 
			"						       case when baprsl.loan_app_seq is not null then baprsl.sec_incm else (case when saprsl.loan_app_seq is not null then saprsl.sch_sec_incm else 0 end) end sec_incm,  \r\n" + 
			"						       case when baprsl.loan_app_seq is not null then baprsl.hsld_exp else (case when saprsl.loan_app_seq is not null then saprsl.sch_hsld_exp else 0 end) end hsld_exp,  \r\n" + 
			"						       dsbmt.srvs_chrg,  \r\n" + 
			"						       dsbmt.pybl_amt,  \r\n" + 
			"						       dsbmt.inst_num,  \r\n" + 
			"						       dsbmt.dsbmt_dt,  \r\n" + 
			"						       dsbmt.cmplt_dt ,  \r\n" + 
			"						       pg.prd_grp_id prd_id, \r\n" + 
			"			                   (select round(months_between(sysdate,max(eff_start_dt)),0) from mw_adt_vst_srvy srvy where srvy.crnt_rec_flg=1 and enty_seq=ap.clnt_seq and enty_typ_flg=1) month_lst_vst, \r\n" + 
			"			                   inst_adv, \r\n" + 
			"			                   (select crdt_scr from mw_loan_app_crdt_scr scr where scr.crnt_rec_flg=1 and scr.loan_app_seq=ap.loan_app_seq) crdt_scr, \r\n" + 
			"			                    acty_key, \r\n" + 
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
			"						-- address  \r\n" + 
			"						join (  \r\n" + 
			"						    select adrl.enty_key clnt_seq,  \r\n" + 
			"						    cmnty.cmnty_nm,  \r\n" + 
			"						    adr.hse_num||' '||adr.strt||' '||cmnty_nm||' '||adr.oth_dtl||' '||city.city_nm clnt_address   \r\n" + 
			"						    from mw_addr_rel adrl   \r\n" + 
			"						    join mw_addr adr on adr.addr_seq=adrl.addr_seq and adr.crnt_rec_flg=1  \r\n" + 
			"						    join mw_cmnty cmnty on cmnty.cmnty_seq=adr.cmnty_seq and cmnty.crnt_rec_flg=1  \r\n" + 
			"						    join mw_city_uc_rel crl on crl.city_uc_rel_seq=adr.city_seq and crl.crnt_rec_flg=1  \r\n" + 
			"						    join mw_city city on city.city_seq=crl.city_seq and city.crnt_rec_flg=1      \r\n" + 
			"						    where enty_typ='Client'   \r\n" + 
			"						      --and enty_key=9800000082  \r\n" + 
			"						      and adrl.crnt_rec_flg=1  \r\n" + 
			"						) addr on addr.clnt_seq=clnt.clnt_seq  \r\n" + 
			"						join (  \r\n" + 
			"						        select psh.loan_app_seq,  \r\n" + 
			"						               count(psd.inst_num) inst_num,  \r\n" + 
			"			                           count(distinct case when psd.pymt_sts_key=947 then psh.loan_app_seq else null end) inst_adv, \r\n" + 
			"						               sum(nvl(psd.ppal_amt_due,0)+nvl(psd.tot_chrg_due,0)+nvl(othc.oth_amt,0)) pybl_amt,  \r\n" + 
			"						               sum(nvl(psd.tot_chrg_due,0)) srvs_chrg,  \r\n" + 
			"						               max(due_dt) cmplt_dt,  \r\n" + 
			"						               (select dsbmt_dt from mw_dsbmt_vchr_hdr vdr where vdr.crnt_rec_flg=1 and vdr.dsbmt_vchr_typ = 0 and vdr.loan_app_seq=psh.loan_app_seq) dsbmt_dt  \r\n" + 
			"						          from mw_pymt_sched_hdr psh  \r\n" + 
			"                                  join mw_loan_app ap on ap.loan_app_seq=psh.loan_app_seq and ap.crnt_rec_flg=1\r\n" + 
			"                                  join mw_port prt on prt.port_seq=ap.port_seq and prt.crnt_rec_flg=1 and prt.brnch_seq=:Brnch_seq\r\n" + 
			"						          join mw_pymt_sched_dtl psd on psd.pymt_sched_hdr_seq=psh.pymt_sched_hdr_seq and psd.crnt_rec_flg=1  \r\n" + 
			"						          join (select pymt_sched_dtl_seq,sum(amt) oth_amt from mw_pymt_sched_chrg chrg where chrg.crnt_rec_flg=1 group by pymt_sched_dtl_seq) othc on  \r\n" + 
			"						                         othc.pymt_sched_dtl_seq=psd.pymt_sched_dtl_seq  \r\n" + 
			"						        group by psh.loan_app_seq  \r\n" + 
			"						) dsbmt on dsbmt.loan_app_seq=ap.loan_app_seq  \r\n" + 
			"						left outer join (  \r\n" + 
			"						-------- biz aprsl -----  \r\n" + 
			"						        select ap.loan_app_seq,  \r\n" + 
			"						               ba.biz_aprsl_seq, \r\n" + 
			"			                           ba.acty_key, \r\n" + 
			"						               prb.ref_cd_dscr,  \r\n" + 
			"						               acty.ref_cd_dscr biz_acty,  \r\n" + 
			"						               nvl(ba.yrs_in_biz,0)*12+nvl(ba.mnth_in_biz,0) biz_tnr,  \r\n" + 
			"						               addr.cmnty_nm biz_cmnty,  \r\n" + 
			"						               addr.address biz_addr,  \r\n" + 
			"						               prb.ref_cd_dscr biz_ownr,  \r\n" + 
			"						               bizinc.biz_incm,  \r\n" + 
			"						               bizinc.prm_incm,  \r\n" + 
			"						               bizinc.sec_incm,  \r\n" + 
			"						               biz_exp,      \r\n" + 
			"						               hsld_exp  \r\n" + 
			"						        from mw_biz_aprsl ba  \r\n" + 
			"						        join mw_ref_cd_val acty on acty.ref_cd_seq=ba.acty_key and acty.crnt_rec_flg=1  \r\n" + 
			"                                join mw_loan_app ap on ap.loan_app_seq=ba.loan_app_seq and ap.crnt_rec_flg=1\r\n" + 
			"                                join mw_port prt on prt.port_seq=ap.port_seq and prt.crnt_rec_flg=1 and prt.brnch_seq=:Brnch_seq\r\n" + 
			"						        join mw_ref_cd_val prb on prb.ref_cd_seq=ba.prsn_run_the_biz and prb.crnt_rec_flg=1  \r\n" + 
			"						        left outer join (  \r\n" + 
			"						                    select adrl.enty_key biz_aprsl_seq,  \r\n" + 
			"						                    adr.hse_num||' '||adr.strt||'/'||cmnty_nm||' '||adr.oth_dtl||' '||city.city_nm address,  \r\n" + 
			"						                    cmnty.cmnty_nm  \r\n" + 
			"						                    from mw_addr_rel adrl   \r\n" + 
			"						                    join mw_addr adr on adr.addr_seq=adrl.addr_seq and adr.crnt_rec_flg=1  \r\n" + 
			"						                    join mw_cmnty cmnty on cmnty.cmnty_seq=adr.cmnty_seq and cmnty.crnt_rec_flg=1  \r\n" + 
			"						                    join mw_city_uc_rel crl on crl.city_uc_rel_seq=adr.city_seq and crl.crnt_rec_flg=1  \r\n" + 
			"						                    join mw_city city on city.city_seq=crl.city_seq and city.crnt_rec_flg=1  \r\n" + 
			"						                    where enty_typ='Business'   \r\n" + 
			"						                      and adrl.crnt_rec_flg=1  \r\n" + 
			"						        ) addr on addr.biz_aprsl_seq=ap.loan_app_seq \r\n" + 
			"						        left outer join (  \r\n" + 
			"						                SELECT aprsl.biz_aprsl_seq,  \r\n" + 
			"						                    sum((case when incm_ctgry_key=1 then incm_amt else 0 end)) prm_incm,  \r\n" + 
			"						                    sum((case when incm_ctgry_key=2 then incm_amt else 0 end)) sec_incm,  \r\n" + 
			"						                    max((hdr.max_mnth_sal_amt * hdr.max_sal_num_of_mnth + hdr.min_mnth_sal_amt *  hdr.min_sal_num_of_mnth) / 12) biz_incm,  \r\n" + 
			"						                    sum((case when exp_ctgry_key=1 then exp_amt else 0 end)) biz_exp,  \r\n" + 
			"						                    sum((case when exp_ctgry_key=2 then exp_amt else 0 end)) hsld_exp  \r\n" + 
			"						                FROM mw_biz_aprsl aprsl  \r\n" + 
			"						                 left outer join mw_biz_exp_dtl exp_dtl on exp_dtl.biz_aprsl_seq=aprsl.biz_aprsl_seq AND exp_dtl.crnt_rec_flg = 1 and exp_dtl.enty_typ_flg = 1   \r\n" + 
			"						                 left outer join mw_biz_aprsl_incm_hdr hdr on aprsl.biz_aprsl_seq = hdr.biz_aprsl_seq AND hdr.crnt_rec_flg = 1   \r\n" + 
			"						                 left outer join mw_biz_aprsl_incm_dtl dtl on hdr.incm_hdr_seq = dtl.incm_hdr_seq and dtl.crnt_rec_flg = 1 and dtl.enty_typ_flg = 1   \r\n" + 
			"						                WHERE aprsl.crnt_rec_flg = 1    \r\n" + 
			"						                group by aprsl.biz_aprsl_seq  \r\n" + 
			"						        ) bizinc on bizinc.biz_aprsl_seq=ba.biz_aprsl_seq  \r\n" + 
			"						where ba.crnt_rec_flg=1  \r\n" + 
			"						) baprsl on baprsl.loan_app_seq=ap.loan_app_seq \r\n" + 
			"                        left outer join (  \r\n" + 
			"						        -- School Aprsl  \r\n" + 
			"						        select ap.loan_app_seq,  \r\n" + 
			"						               ba.sch_aprsl_seq,  \r\n" + 
			"						               'School' sch_acty,  \r\n" + 
			"						               ba.sch_age biz_tnr,  \r\n" + 
			"						               addr.cmnty_nm sch_cmnty,  \r\n" + 
			"						               addr.address sch_addr,  \r\n" + 
			"						               prb.ref_cd_dscr sch_ownr,  \r\n" + 
			"						               sincm.sch_prm_incm,  \r\n" + 
			"						               sincm.sch_sec_incm,  \r\n" + 
			"						               sincm.sch_biz_incm,  \r\n" + 
			"						               sch_biz_exp,  \r\n" + 
			"						               sch_hsld_exp  \r\n" + 
			"						        from mw_sch_aprsl ba  \r\n" + 
			"                                join mw_loan_app ap on ap.loan_app_seq=ba.loan_app_seq and ap.crnt_rec_flg=1\r\n" + 
			"                                join mw_port prt on prt.port_seq=ap.port_seq and prt.crnt_rec_flg=1 and prt.brnch_seq=:Brnch_seq\r\n" + 
			"						        join mw_ref_cd_val prb on prb.ref_cd_seq=ba.sch_ppal_key and prb.crnt_rec_flg=1  \r\n" + 
			"						        left outer join (  \r\n" + 
			"						                    select adrl.enty_key sch_aprsl_seq,adr.hse_num,  \r\n" + 
			"						                    adr.hse_num||' '||adr.strt||'/'||cmnty_nm||' '||adr.oth_dtl||' '||city.city_nm address,  \r\n" + 
			"						                    cmnty.cmnty_nm  \r\n" + 
			"						                    from mw_addr_rel adrl   \r\n" + 
			"						                    join mw_addr adr on adr.addr_seq=adrl.addr_seq and adr.crnt_rec_flg=1  \r\n" + 
			"						                    join mw_cmnty cmnty on cmnty.cmnty_seq=adr.cmnty_seq and cmnty.crnt_rec_flg=1  \r\n" + 
			"						                    join mw_city_uc_rel crl on crl.city_uc_rel_seq=adr.city_seq and crl.crnt_rec_flg=1  \r\n" + 
			"						                    join mw_city city on city.city_seq=crl.city_seq and city.crnt_rec_flg=1  \r\n" + 
			"						                    where enty_typ='SchoolAppraisal'   \r\n" + 
			"						                      and adrl.crnt_rec_flg=1  \r\n" + 
			"						        ) addr on addr.sch_aprsl_seq=ap.loan_app_seq  \r\n" + 
			"						        left outer join (  \r\n" + 
			"						                SELECT aprsl.sch_aprsl_seq,  \r\n" + 
			"						                    sum((case when incm_ctgry_key=1 then incm_amt else 0 end)) sch_prm_incm,  \r\n" + 
			"						                    sum((case when incm_ctgry_key=2 then incm_amt else 0 end )) sch_sec_incm,  \r\n" + 
			"						                    sum((grd.tot_fem_stdnt + grd.tot_male_stdnt-grd.no_fee_stdnt)*grd.avg_grd_fee) sch_biz_incm,  \r\n" + 
			"						                    max(to_number(to_char(aprsl.crtd_dt,'YYYY'))-aprsl.sch_yr) sch_age,  \r\n" + 
			"						                    sum((case when exp_ctgry_key=1 then exp_amt else 0 end)) sch_biz_exp,  \r\n" + 
			"						                    sum((case when exp_ctgry_key=2 then exp_amt else 0 end)) sch_hsld_exp  \r\n" + 
			"						                FROM mw_sch_aprsl aprsl   \r\n" + 
			"						                join mw_sch_grd grd on grd.sch_aprsl_seq = aprsl.sch_aprsl_seq and grd.crnt_rec_flg = 1  \r\n" + 
			"						                left outer join mw_biz_exp_dtl exp_dtl on exp_dtl.biz_aprsl_seq=aprsl.sch_aprsl_seq AND exp_dtl.crnt_rec_flg = 1 and exp_dtl.enty_typ_flg = 2   \r\n" + 
			"						                left outer join mw_biz_aprsl_incm_dtl dtl on aprsl.sch_aprsl_seq = dtl.incm_hdr_seq and dtl.crnt_rec_flg = 1 and dtl.enty_typ_flg = 2   \r\n" + 
			"						                WHERE aprsl.crnt_rec_flg = 1 group by aprsl.sch_aprsl_seq  \r\n" + 
			"						        ) sincm on sincm.sch_aprsl_seq=ba.sch_aprsl_seq  \r\n" + 
			"						        where ba.crnt_rec_flg=1  \r\n" + 
			"						) saprsl on saprsl.loan_app_seq=ap.loan_app_seq  \r\n" + 
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
package com.idev4.compliance.web.rest.util;

public class Queries {
	public static String complianceLoansQuery = "select ap.loan_app_seq,\r\n" + 
			"       clnt.frst_nm||' '||clnt.last_nm clnt_nm,\r\n" + 
			"       clnt_id,\r\n" + 
			"       msts.ref_cd_dscr mrtl_sts,\r\n" + 
			"       occ.ref_cd_dscr occ,\r\n" + 
			"       addr.cmnty_nm,\r\n" + 
			"       prt.port_nm,\r\n" + 
			"       (select distinct 1 from mw_pymt_sched_hdr hdr\r\n" + 
			"                 join mw_pymt_sched_dtl dtl on dtl.pymt_sched_hdr_seq=hdr.pymt_sched_hdr_seq and dtl.crnt_rec_flg=1\r\n" + 
			"                 join mw_ref_cd_val psts on psts.ref_cd_seq=dtl.pymt_sts_key and psts.crnt_rec_flg=1\r\n" + 
			"                 where hdr.crnt_rec_flg=1 and sysdate>due_dt and psts.ref_cd='0945' and hdr.loan_app_seq=ap.loan_app_seq) od_flg,\r\n" + 
			"       prd.prd_seq,\r\n" + 
			"       nvl((select distinct 1 from mw_clnt_rel crl where crl.crnt_rec_flg=1 and crl.rel_typ_flg=2 and crl.loan_app_seq=ap.loan_app_seq),0) nkin_flg,\r\n" + 
			"       nvl((select 1 From mw_biz_aprsl aprsl join mw_loan_app la on la.loan_app_seq=aprsl.loan_app_seq and la.crnt_rec_flg=1 and la.loan_cycl_num=ap.loan_cycl_num-1 and la.loan_app_seq=ap.loan_app_seq join mw_ref_cd_val acty on acty.ref_cd_seq=aprsl.acty_key where aprsl.crnt_rec_flg=1),0) biz_chng_flg,\r\n" + 
			"       addr.clnt_address,\r\n" + 
			"       res.ref_cd_dscr res_sts,\r\n" + 
			"       nvl(clnt.yrs_res,0)*100+nvl(clnt.mnths_res,0) res_tnr,\r\n" + 
			"       NUM_OF_DPND tot_fmly_memb, \r\n" + 
			"       ERNG_MEMB num_of_ernrs,\r\n" + 
			"       prd.prd_nm,\r\n" + 
			"       case when ap.loan_cycl_num > 1 then (select aprvd_loan_amt from mw_loan_app where crnt_rec_flg=1 and loan_app_seq=ap.loan_app_seq and loan_cycl_num = ap.loan_cycl_num-1) else 0 end prev_amt,\r\n" + 
			"       ap.loan_cycl_num,\r\n" + 
			"       ap.rqstd_loan_amt,\r\n" + 
			"       ap.aprvd_loan_amt,\r\n" + 
			"       plan_nm,\r\n" + 
			"       ap.tbl_scrn_flg scrn_flg,\r\n" + 
			"       clnt.cnic_num,\r\n" + 
			"       clnt.cnic_expry_dt,\r\n" + 
			"       clnt.dob,\r\n" + 
			"       gndr.ref_cd_dscr gndr,  \r\n" + 
			"       case when baprsl.loan_app_seq is not null then baprsl.biz_acty else (case when saprsl.loan_app_seq is not null then saprsl.sch_acty else null end) end biz_acty,\r\n" + 
			"       case when baprsl.loan_app_seq is not null then baprsl.biz_tnr else (case when saprsl.loan_app_seq is not null then saprsl.biz_tnr else null end) end biz_tnr,\r\n" + 
			"       case when baprsl.loan_app_seq is not null then baprsl.biz_addr else (case when saprsl.loan_app_seq is not null then saprsl.sch_addr else null end) end biz_addr,\r\n" + 
			"       case when baprsl.loan_app_seq is not null then baprsl.biz_incm else (case when saprsl.loan_app_seq is not null then saprsl.sch_biz_incm else 0 end) end biz_incm,\r\n" + 
			"       case when baprsl.loan_app_seq is not null then baprsl.biz_ownr else (case when saprsl.loan_app_seq is not null then saprsl.sch_ownr else null end) end prsn_run_biz,\r\n" + 
			"       case when baprsl.loan_app_seq is not null then baprsl.prm_incm else (case when saprsl.loan_app_seq is not null then saprsl.sch_prm_incm else 0 end) end prm_incm,\r\n" + 
			"       case when baprsl.loan_app_seq is not null then baprsl.sec_incm else (case when saprsl.loan_app_seq is not null then saprsl.sch_sec_incm else 0 end) end sec_incm,\r\n" + 
			"       case when baprsl.loan_app_seq is not null then baprsl.hsld_exp else (case when saprsl.loan_app_seq is not null then saprsl.sch_hsld_exp else 0 end) end hsld_exp,\r\n" + 
			"       dsbmt.srvs_chrg,\r\n" + 
			"       dsbmt.pybl_amt,\r\n" + 
			"       dsbmt.inst_num,\r\n" + 
			"       dsbmt.dsbmt_dt,\r\n" + 
			"       dsbmt.cmplt_dt\r\n" + 
			"       \r\n" + 
			"from mw_loan_app ap\r\n" + 
			"join mw_port prt on prt.port_seq = ap.port_seq and prt.crnt_rec_flg=1 and prt.brnch_seq=98\r\n" + 
			"join mw_clnt clnt on clnt.clnt_seq=ap.clnt_seq and clnt.crnt_rec_flg=1\r\n" + 
			"join mw_ref_cd_val msts on msts.ref_cd_seq=clnt.mrtl_sts_key and msts.crnt_rec_flg=1\r\n" + 
			"join mw_ref_cd_val occ on occ.ref_cd_seq=clnt.occ_key and occ.crnt_rec_flg=1\r\n" + 
			"join mw_ref_cd_val res on res.ref_cd_seq=clnt.res_typ_key and res.crnt_rec_flg=1\r\n" + 
			"join mw_ref_cd_val gndr on gndr.ref_cd_seq=clnt.gndr_key and gndr.crnt_rec_flg=1\r\n" + 
			"join mw_addr_rel adrl on adrl.enty_key=clnt.clnt_seq and adrl.enty_typ='Client' and adrl.crnt_rec_flg=1\r\n" + 
			"join mw_port prt on prt.port_seq=ap.port_seq and prt.crnt_rec_flg=1\r\n" + 
			"join mw_prd prd on prd.prd_seq=ap.prd_seq and prd.crnt_rec_flg=1\r\n" + 
			"left outer join (select hlth.loan_app_seq,pln.plan_nm from mw_clnt_hlth_insr hlth join mw_hlth_insr_plan pln on pln.hlth_insr_plan_seq=hlth.hlth_insr_plan_seq where hlth.crnt_rec_flg=1) pln on pln.loan_app_seq=ap.loan_app_seq\r\n" + 
			"-- address\r\n" + 
			"join (\r\n" + 
			"    select adrl.enty_key clnt_seq,\r\n" + 
			"    cmnty.cmnty_nm,\r\n" + 
			"    adr.hse_num||' '||adr.strt||' '||cmnty_nm||' '||adr.oth_dtl||' '||city.city_nm clnt_address \r\n" + 
			"    from mw_addr_rel adrl \r\n" + 
			"    join mw_addr adr on adr.addr_seq=adrl.addr_seq and adr.crnt_rec_flg=1\r\n" + 
			"    join mw_cmnty cmnty on cmnty.cmnty_seq=adr.cmnty_seq and cmnty.crnt_rec_flg=1\r\n" + 
			"    join mw_city_uc_rel crl on crl.city_uc_rel_seq=adr.city_seq and crl.crnt_rec_flg=1\r\n" + 
			"    join mw_city city on city.city_seq=crl.city_seq and city.crnt_rec_flg=1    \r\n" + 
			"    where enty_typ='Client' \r\n" + 
			"      and adrl.crnt_rec_flg=1\r\n" + 
			") addr on addr.clnt_seq=clnt.clnt_seq\r\n" + 
			"join (\r\n" + 
			"        select psh.loan_app_seq,\r\n" + 
			"               count(psd.inst_num) inst_num,\r\n" + 
			"               sum(nvl(psd.ppal_amt_due,0)+nvl(psd.tot_chrg_due,0)+nvl(othc.oth_amt,0)) pybl_amt,\r\n" + 
			"               sum(nvl(psd.tot_chrg_due,0)) srvs_chrg,\r\n" + 
			"               max(due_dt) cmplt_dt,\r\n" + 
			"               (select dsbmt_dt from mw_dsbmt_vchr_hdr vdr where vdr.crnt_rec_flg=1 and vdr.loan_app_seq=psh.loan_app_seq) dsbmt_dt\r\n" + 
			"          from mw_pymt_sched_hdr psh\r\n" + 
			"          join mw_pymt_sched_dtl psd on psd.pymt_sched_hdr_seq=psh.pymt_sched_hdr_seq and psd.crnt_rec_flg=1\r\n" + 
			"          join (select pymt_sched_dtl_seq,sum(amt) oth_amt from mw_pymt_sched_chrg chrg where chrg.crnt_rec_flg=1 group by pymt_sched_dtl_seq) othc on\r\n" + 
			"                         othc.pymt_sched_dtl_seq=psd.pymt_sched_dtl_seq\r\n" + 
			"        group by psh.loan_app_seq\r\n" + 
			") dsbmt on dsbmt.loan_app_seq=ap.loan_app_seq\r\n" + 
			"left outer join (\r\n" + 
			"-------- biz aprsl -----\r\n" + 
			"        select ba.loan_app_seq,\r\n" + 
			"               ba.biz_aprsl_seq,\r\n" + 
			"               prb.ref_cd_dscr,\r\n" + 
			"               acty.ref_cd_dscr biz_acty,\r\n" + 
			"               nvl(ba.yrs_in_biz,0)*12+nvl(ba.mnth_in_biz,0) biz_tnr,\r\n" + 
			"               addr.cmnty_nm biz_cmnty,\r\n" + 
			"               addr.address biz_addr,\r\n" + 
			"               prb.ref_cd_dscr biz_ownr,\r\n" + 
			"               bizinc.biz_incm,\r\n" + 
			"               bizinc.prm_incm,\r\n" + 
			"               bizinc.sec_incm,\r\n" + 
			"               biz_exp,    \r\n" + 
			"               hsld_exp\r\n" + 
			"        from mw_biz_aprsl ba\r\n" + 
			"        join mw_ref_cd_val acty on acty.ref_cd_seq=ba.acty_key and acty.crnt_rec_flg=1\r\n" + 
			"        join mw_ref_cd_val prb on prb.ref_cd_seq=ba.prsn_run_the_biz and prb.crnt_rec_flg=1\r\n" + 
			"        left outer join (\r\n" + 
			"                    select adrl.enty_key biz_aprsl_seq,\r\n" + 
			"                    adr.hse_num||' '||adr.strt||'/'||cmnty_nm||' '||adr.oth_dtl||' '||city.city_nm address,\r\n" + 
			"                    cmnty.cmnty_nm\r\n" + 
			"                    from mw_addr_rel adrl \r\n" + 
			"                    join mw_addr adr on adr.addr_seq=adrl.addr_seq and adr.crnt_rec_flg=1\r\n" + 
			"                    join mw_cmnty cmnty on cmnty.cmnty_seq=adr.cmnty_seq and cmnty.crnt_rec_flg=1\r\n" + 
			"                    join mw_city_uc_rel crl on crl.city_uc_rel_seq=adr.city_seq and crl.crnt_rec_flg=1\r\n" + 
			"                    join mw_city city on city.city_seq=crl.city_seq and city.crnt_rec_flg=1\r\n" + 
			"                    where enty_typ='Business' \r\n" + 
			"                      and adrl.crnt_rec_flg=1\r\n" + 
			"        ) addr on addr.biz_aprsl_seq=ba.biz_aprsl_seq\r\n" + 
			"        left outer join (\r\n" + 
			"                SELECT aprsl.biz_aprsl_seq,\r\n" + 
			"                    sum((case when incm_ctgry_key=1 then incm_amt else 0 end)) prm_incm,\r\n" + 
			"                    sum((case when incm_ctgry_key=2 then incm_amt else 0 end)) sec_incm,\r\n" + 
			"                    max((hdr.max_mnth_sal_amt * hdr.max_sal_num_of_mnth + hdr.min_mnth_sal_amt * hdr.min_sal_num_of_mnth) / 12) biz_incm,\r\n" + 
			"                    sum((case when exp_ctgry_key=1 then exp_amt else 0 end)) biz_exp,\r\n" + 
			"                    sum((case when exp_ctgry_key=2 then exp_amt else 0 end)) hsld_exp\r\n" + 
			"                FROM mw_biz_aprsl aprsl\r\n" + 
			"                 left outer join mw_biz_exp_dtl exp_dtl on exp_dtl.biz_aprsl_seq=aprsl.biz_aprsl_seq AND exp_dtl.crnt_rec_flg = 1 and exp_dtl.enty_typ_flg = 1 \r\n" + 
			"                 left outer join mw_biz_aprsl_incm_hdr hdr on aprsl.biz_aprsl_seq = hdr.biz_aprsl_seq AND hdr.crnt_rec_flg = 1 \r\n" + 
			"                 left outer join mw_biz_aprsl_incm_dtl dtl on hdr.incm_hdr_seq = dtl.incm_hdr_seq and dtl.crnt_rec_flg = 1 and dtl.enty_typ_flg = 1 \r\n" + 
			"                WHERE aprsl.crnt_rec_flg = 1  \r\n" + 
			"                group by aprsl.biz_aprsl_seq\r\n" + 
			"        ) bizinc on bizinc.biz_aprsl_seq=ba.biz_aprsl_seq\r\n" + 
			"where ba.crnt_rec_flg=1\r\n" + 
			") baprsl on baprsl.loan_app_seq=ap.loan_app_seq\r\n" + 
			"left outer join (\r\n" + 
			"        -- School Aprsl\r\n" + 
			"        select ba.loan_app_seq,\r\n" + 
			"               ba.sch_aprsl_seq,\r\n" + 
			"               'School' sch_acty,\r\n" + 
			"               ba.sch_age biz_tnr,\r\n" + 
			"               addr.cmnty_nm sch_cmnty,\r\n" + 
			"               addr.address sch_addr,\r\n" + 
			"               prb.ref_cd_dscr sch_ownr,\r\n" + 
			"               sincm.sch_prm_incm,\r\n" + 
			"               sincm.sch_sec_incm,\r\n" + 
			"               sincm.sch_biz_incm,\r\n" + 
			"               sch_biz_exp,\r\n" + 
			"               sch_hsld_exp\r\n" + 
			"        from mw_sch_aprsl ba\r\n" + 
			"        join mw_ref_cd_val prb on prb.ref_cd_seq=ba.sch_ppal_key and prb.crnt_rec_flg=1\r\n" + 
			"        left outer join (\r\n" + 
			"                    select adrl.enty_key sch_aprsl_seq,adr.hse_num,\r\n" + 
			"                    adr.hse_num||' '||adr.strt||'/'||cmnty_nm||' '||adr.oth_dtl||' '||city.city_nm address,\r\n" + 
			"                    cmnty.cmnty_nm\r\n" + 
			"                    from mw_addr_rel adrl \r\n" + 
			"                    join mw_addr adr on adr.addr_seq=adrl.addr_seq and adr.crnt_rec_flg=1\r\n" + 
			"                    join mw_cmnty cmnty on cmnty.cmnty_seq=adr.cmnty_seq and cmnty.crnt_rec_flg=1\r\n" + 
			"                    join mw_city_uc_rel crl on crl.city_uc_rel_seq=adr.city_seq and crl.crnt_rec_flg=1\r\n" + 
			"                    join mw_city city on city.city_seq=crl.city_seq and city.crnt_rec_flg=1\r\n" + 
			"                    where enty_typ='SchoolAppraisal' \r\n" + 
			"                      and adrl.crnt_rec_flg=1\r\n" + 
			"        ) addr on addr.sch_aprsl_seq=ba.sch_aprsl_seq\r\n" + 
			"        left outer join (\r\n" + 
			"                SELECT aprsl.sch_aprsl_seq,\r\n" + 
			"                    sum((case when incm_ctgry_key=1 then incm_amt else 0 end)) sch_prm_incm,\r\n" + 
			"                    sum((case when incm_ctgry_key=2 then incm_amt else 0 end )) sch_sec_incm,\r\n" + 
			"                    sum((grd.tot_fem_stdnt + grd.tot_male_stdnt-grd.no_fee_stdnt)*grd.avg_grd_fee) sch_biz_incm,\r\n" + 
			"                    max(to_number(to_char(aprsl.crtd_dt,'YYYY'))-aprsl.sch_yr) sch_age,\r\n" + 
			"                    sum((case when exp_ctgry_key=1 then exp_amt else 0 end)) sch_biz_exp,\r\n" + 
			"                    sum((case when exp_ctgry_key=2 then exp_amt else 0 end)) sch_hsld_exp\r\n" + 
			"                FROM mw_sch_aprsl aprsl \r\n" + 
			"                join mw_sch_grd grd on grd.sch_aprsl_seq = aprsl.sch_aprsl_seq and grd.crnt_rec_flg = 1\r\n" + 
			"                left outer join mw_biz_exp_dtl exp_dtl on exp_dtl.biz_aprsl_seq=aprsl.sch_aprsl_seq AND exp_dtl.crnt_rec_flg = 1 and exp_dtl.enty_typ_flg = 2 \r\n" + 
			"                left outer join mw_biz_aprsl_incm_dtl dtl on aprsl.sch_aprsl_seq = dtl.incm_hdr_seq and dtl.crnt_rec_flg = 1 and dtl.enty_typ_flg = 2 \r\n" + 
			"                WHERE aprsl.crnt_rec_flg = 1 group by aprsl.sch_aprsl_seq\r\n" + 
			"        ) sincm on sincm.sch_aprsl_seq=ba.sch_aprsl_seq\r\n" + 
			"        where ba.crnt_rec_flg=1\r\n" + 
			") saprsl on saprsl.loan_app_seq=ap.loan_app_seq\r\n" + 
			"where ap.crnt_rec_flg=1";
}

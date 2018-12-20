package com.idev4.admin.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idev4.admin.dto.LoanServingDTO;
import com.idev4.admin.repository.ClientRepository;


@Service
public class MwClntService {
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	EntityManager em;

	public List<LoanServingDTO> getAllActiveClint(String user) {
		Query query = em.createNativeQuery(
				"select clnt.clnt_id,clnt.clnt_seq,clnt.frst_nm, clnt.last_nm,sum(app.aprvd_loan_amt) loan_amt, sum(rcv.pymt_amt) rcvd_amt,dr.dth_rpt_seq\r\n" + 
				"from mw_clnt clnt\r\n" + 
				"join mw_loan_app app on app.clnt_seq=clnt.clnt_seq and app.crnt_rec_flg=1 \r\n" + 
				"join mw_acl acl on acl.PORT_SEQ=app.PORT_SEQ and acl.USER_ID=:user\r\n" + 
				"join mw_ref_cd_val val on val.ref_cd_seq=app.loan_app_sts and val.crnt_rec_flg=1 and val.del_flg=0 and val.ref_cd ='0005'\r\n" + 
				"join mw_ref_cd_grp grp on grp.ref_cd_grp_seq = val.ref_cd_grp_key and grp.crnt_rec_flg=1 and grp.ref_cd_grp = '0106'\r\n" + 
				"join mw_rcvry_trx rcv on rcv.pymt_ref=clnt.clnt_seq and rcv.crnt_rec_flg = 1\r\n" + 
				"left outer join mw_dth_rpt dr on  dr.clnt_seq=clnt.clnt_seq and dr.crnt_rec_flg=1  \r\n" + 
				"where clnt.crnt_rec_flg=1  \r\n" + 
				"group by clnt.clnt_id,clnt.clnt_seq,clnt.frst_nm, clnt.last_nm,dr.dth_rpt_seq").setParameter("user", user);
		List< Object[] > clnts = query.getResultList();

		List<LoanServingDTO> dtoList = new ArrayList();
		clnts.forEach(c -> {
			LoanServingDTO dto = new LoanServingDTO();
			dto.clntId = c[0].toString();
			dto.clntSeq= c[1].toString();
			dto.frstNm=c[2]==null?"":c[2].toString();
			dto.lastNm=c[3]==null?"":c[3].toString();
			dto.loanAmt=new BigDecimal( c[ 4 ].toString() ).longValue();
			dto.rcvdAmt=new BigDecimal( c[ 5 ].toString() ).longValue();
			dto.dthRptSeq=c[ 6 ]==null?0:new BigDecimal( c[ 6 ].toString() ).longValue();
			dtoList.add(dto);
		});
		return dtoList;

	}

}

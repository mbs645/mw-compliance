package com.idev4.compliance.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.idev4.compliance.dto.LoanInfoDto;
import com.idev4.compliance.dto.TabDto;
import com.idev4.compliance.repository.MwAnswrRepository;
import com.idev4.compliance.repository.MwBrnchRepository;
import com.idev4.compliance.repository.MwEmpRepository;
import com.idev4.compliance.repository.MwQstRepository;
import com.idev4.compliance.repository.MwQstnrRepository;
import com.idev4.compliance.repository.MwRefCdValRepository;
import com.idev4.compliance.web.rest.util.Queries;

@Service
public class ComplianceService {

    private final EntityManager em;

    private final MwQstnrRepository mwQstnrRepository;

    private final MwQstRepository mwQstRepository;

    private final MwAnswrRepository mwAnswrRepository;

    private final MwRefCdValRepository mwRefCdValRepository;

    private final MwEmpRepository mwEmpRepository;

    private final MwBrnchRepository mwBrnchRepository;

    public ComplianceService(EntityManager em, MwQstnrRepository mwQstnrRepository,
    		MwQstRepository mwQstRepository, MwAnswrRepository mwAnswrRepository, 
    		MwRefCdValRepository mwRefCdValRepository, MwEmpRepository mwEmpRepository,
    		MwBrnchRepository mwBrnchRepository) {
    	this.em=em;
    	this.mwQstnrRepository = mwQstnrRepository;
    	this.mwQstRepository= mwQstRepository;
    	this.mwAnswrRepository = mwAnswrRepository;
    	this.mwRefCdValRepository =mwRefCdValRepository;
    	this.mwEmpRepository = mwEmpRepository;
    	this.mwBrnchRepository = mwBrnchRepository;
    }
    public TabDto getDataForTab() {
    	TabDto dto = new TabDto();
    	dto.app_info = complianceData();
    	dto.mw_answr = mwAnswrRepository.findAllByDelFlgAndCrntRecFlg(false, true);
    	dto.mw_brnch = mwBrnchRepository.findAllByCrntRecFlg(true);
    	dto.mw_emp = mwEmpRepository.findAll();
    	dto.mw_qstnr = mwQstnrRepository.findAllByCrntRecFlg(true);
    	dto.mw_qst = mwQstRepository.findAllByDelFlgAndCrntRecFlg(false, true);
    	dto.mw_ref_cd_val = mwRefCdValRepository.findAllByCrntRecFlgOrderByRefCdSeq(true);
    	return dto;
    }
    public List<LoanInfoDto> complianceData(){
    	String query = Queries.complianceLoansQuery;
    	Query q = em.createNativeQuery( query );
        List< Object[] > result = q.getResultList();
        List<LoanInfoDto> resp = new ArrayList< LoanInfoDto >();
        for ( Object[] obj : result ) {
        	LoanInfoDto dto = new LoanInfoDto();
    		dto.loanAppSeq = obj[ 0 ] == null ? "" : obj[ 0 ].toString();
    		dto.clntNm = obj[ 1 ] == null ? "" : obj[ 1 ].toString(); 
    		dto.clntId = obj[ 2 ] == null ? "" : obj[ 2 ].toString();
    		dto.mrtlSts = obj[ 3 ] == null ? "" : obj[ 3 ].toString(); 
    		dto.occ = obj[ 4 ] == null ? "" : obj[ 4 ].toString();
    		dto.cmntyNm = obj[ 5 ] == null ? "" : obj[ 5 ].toString(); 
    		dto.portNm = obj[ 6 ] == null ? "" : obj[ 6 ].toString();
    		dto.odFlg = obj[ 7 ] == null ? "" : obj[ 7 ].toString(); 
    		dto.prdSeq = obj[ 8 ] == null ? "" : obj[ 8 ].toString();
    		dto.nkinFlg = obj[ 9 ] == null ? "" : obj[ 9 ].toString(); 
    		dto.bizChngFlg = obj[ 10 ] == null ? "" : obj[ 10 ].toString();
    		dto.clntAddr = obj[ 11 ] == null ? "" : obj[ 11 ].toString();
    		dto.resSts = obj[ 12 ] == null ? "" : obj[ 12 ].toString();
    		dto.resTnr = obj[ 13 ] == null ? "" : obj[ 13 ].toString(); 
    		dto.totFmlyMemb = obj[ 14 ] == null ? "" : obj[ 14 ].toString();
    		dto.numOfErnrs = obj[ 15 ] == null ? "" : obj[ 15 ].toString(); 
    		dto.prdNm = obj[ 16 ] == null ? "" : obj[ 16 ].toString();
    		dto.prevAmt = obj[ 17 ] == null ? "" : obj[ 17 ].toString(); 
    		dto.loanCyclNum = obj[ 18 ] == null ? "" : obj[ 18 ].toString();
    		dto.rqstdLoanAmt = obj[ 19 ] == null ? "" : obj[ 19 ].toString(); 
    		dto.aprvdLoanAmt = obj[ 20 ] == null ? "" : obj[ 20 ].toString();
    		dto.planNm = obj[ 21 ] == null ? "" : obj[ 21 ].toString(); 
    		dto.scrnFlg = obj[ 22 ] == null ? "" : obj[ 22 ].toString();
    		dto.cnicNum = obj[ 23 ] == null ? "" : obj[ 23 ].toString(); 
    		dto.cnicExpryDt = obj[ 24 ] == null ? "" : obj[ 24 ].toString();
    		dto.dob = obj[ 25 ] == null ? "" : obj[ 25 ].toString(); 
    		dto.gndr = obj[ 26 ] == null ? "" : obj[ 26 ].toString();
    		dto.bizActy = obj[ 27 ] == null ? "" : obj[ 27 ].toString();
    		dto.bizTnr = obj[ 28 ] == null ? "" : obj[ 28 ].toString(); 
    		dto.bizAddr = obj[ 29 ] == null ? "" : obj[ 29 ].toString();
    		dto.bizIncm = obj[ 30 ] == null ? "" : obj[ 30 ].toString(); 
    		dto.prsnRunBiz = obj[ 31 ] == null ? "" : obj[ 31 ].toString();
    		dto.prmIncm = obj[ 32 ] == null ? "" : obj[ 32 ].toString();
    		dto.secIncm = obj[ 33 ] == null ? "" : obj[ 33 ].toString();
    		dto.hsldExp = obj[ 34 ] == null ? "" : obj[ 34 ].toString();
    		dto.srvsChrg = obj[ 35 ] == null ? "" : obj[ 35 ].toString();
    		dto.pyblAmt = obj[ 36 ] == null ? "" : obj[ 36 ].toString();
    		dto.instNum = obj[ 37 ] == null ? "" : obj[ 37 ].toString();
    		dto.dsbmtDt = obj[ 38 ] == null ? "" : obj[ 38 ].toString();
    		dto.cmpltDt = obj[ 39 ] == null ? "" : obj[ 39 ].toString();
    		resp.add(dto);
        }
        return resp;
    }
    
}

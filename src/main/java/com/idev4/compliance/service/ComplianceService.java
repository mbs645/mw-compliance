
package com.idev4.compliance.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idev4.compliance.domain.MwAdtFndng;
import com.idev4.compliance.domain.MwAdtVst;
import com.idev4.compliance.domain.MwAdtVstSrvy;
import com.idev4.compliance.domain.MwEmp;
import com.idev4.compliance.domain.MwRefCdVal;
import com.idev4.compliance.dto.AdtVstDto;
import com.idev4.compliance.dto.ComplianceLandingDto;
import com.idev4.compliance.dto.LoanInfoDto;
import com.idev4.compliance.dto.TabDto;
import com.idev4.compliance.dto.tab.ComplianceSubmitDto;
import com.idev4.compliance.dto.tab.MwAdtVstDto;
import com.idev4.compliance.repository.MwAdtFndngRepository;
import com.idev4.compliance.repository.MwAdtVstRepository;
import com.idev4.compliance.repository.MwAdtVstSrvyRepository;
import com.idev4.compliance.repository.MwAnswrRepository;
import com.idev4.compliance.repository.MwBrnchRepository;
import com.idev4.compliance.repository.MwEmpRepository;
import com.idev4.compliance.repository.MwQstRepository;
import com.idev4.compliance.repository.MwQstnrRepository;
import com.idev4.compliance.repository.MwRefCdValRepository;
import com.idev4.compliance.web.rest.util.Queries;
import com.idev4.compliance.web.rest.util.SequenceFinder;
import com.idev4.compliance.web.rest.util.Sequences;

@Service
public class ComplianceService {

    private final EntityManager em;

    private final MwQstnrRepository mwQstnrRepository;

    private final MwQstRepository mwQstRepository;

    private final MwAnswrRepository mwAnswrRepository;

    private final MwRefCdValRepository mwRefCdValRepository;

    private final MwEmpRepository mwEmpRepository;

    private final MwBrnchRepository mwBrnchRepository;

    private final MwAdtVstRepository mwAdtVstRepository;

    private final MwAdtVstSrvyRepository mwAdtVstSrvyRepository;

    private final MwAdtFndngRepository mwAdtFndngRepository;

    private final DateFormat formatter = new SimpleDateFormat( "dd-MM-yyyy hh:mm:ss" );

    private final DateFormat formatterDate = new SimpleDateFormat( "dd-MM-yyyy" );

    // private final MwBrnchRepository mwBrnchRepository;

    public ComplianceService( EntityManager em, MwQstnrRepository mwQstnrRepository, MwQstRepository mwQstRepository,
            MwAnswrRepository mwAnswrRepository, MwRefCdValRepository mwRefCdValRepository, MwEmpRepository mwEmpRepository,
            MwBrnchRepository mwBrnchRepository, MwAdtVstRepository mwAdtVstRepository, MwAdtVstSrvyRepository mwAdtVstSrvyRepository,
            MwAdtFndngRepository mwAdtFndngRepository ) {
        this.em = em;
        this.mwQstnrRepository = mwQstnrRepository;
        this.mwQstRepository = mwQstRepository;
        this.mwAnswrRepository = mwAnswrRepository;
        this.mwRefCdValRepository = mwRefCdValRepository;
        this.mwEmpRepository = mwEmpRepository;
        this.mwBrnchRepository = mwBrnchRepository;
        this.mwAdtVstRepository = mwAdtVstRepository;
        this.mwAdtVstSrvyRepository = mwAdtVstSrvyRepository;
        this.mwAdtFndngRepository = mwAdtFndngRepository;
    }

    public TabDto getDataForTab( String lanId ) {
        TabDto dto = new TabDto();
        dto.app_info = complianceData();
        dto.mw_answr = mwAnswrRepository.findAllByDelFlgAndCrntRecFlg( false, true );
        dto.mw_brnch = mwBrnchRepository.findAllByCrntRecFlg( true );
        dto.mw_emp = mwEmpRepository.findAll();
        dto.mw_qstnr = mwQstnrRepository.findAllByCrntRecFlg( true );
        dto.mw_qst = mwQstRepository.findAllByDelFlgAndCrntRecFlg( false, true );
        dto.mw_ref_cd_val = mwRefCdValRepository.findAllByCrntRecFlgOrderByRefCdSeq( true );
        MwEmp emp = mwEmpRepository.findOneByEmpLanId( lanId );
        if ( emp != null ) {
            List< MwAdtVst > mw_adt_vsts = mwAdtVstRepository.findAllByAssignedToAndCrntRecFlg( emp.getEmpSeq(), true );
            dto.mw_adt_vst = new ArrayList<>();
            mw_adt_vsts.forEach( vst -> {
                MwAdtVstDto sdto = new MwAdtVstDto();
                sdto.DomainToDto( vst );
                dto.mw_adt_vst.add( sdto );
            } );
        }
        return dto;
    }

    @Transactional
    public ResponseEntity submitDataForCompliance( ComplianceSubmitDto dto, String curUser ) {

        if ( dto.mw_adt_vst == null ) {
            return ResponseEntity.badRequest().body( "{\"error\":\"MwAdtVst Data not found.\"}" );
        }
        if ( dto.mw_adt_vst.adt_vst_seq == null ) {
            return ResponseEntity.badRequest().body( "{\"error\":\"MwAdtVstSeq Not Found.\"}" );
        }

        MwAdtVst vst = mwAdtVstRepository.findOneByAdtVstSeqAndCrntRecFlg( dto.mw_adt_vst.adt_vst_seq, true );
        if ( vst == null ) {
            return ResponseEntity.badRequest().body( "{\"error\":\"MwAdtVst not found against MwAdtVstSeq.\"}" );
        }
        Long complSts = 0L;
        MwRefCdVal val = mwRefCdValRepository.findRefCdByGrpAndVal( "0358", "01387" );
        if ( val != null )
            complSts = val.getRefCdSeq();
        vst.setActualEndDt( Instant.now() );
        vst.setLastUpdBy( curUser );
        vst.setLastUpdDt( Instant.now() );

        if ( dto.mw_adt_vst_srvy != null ) {
            dto.mw_adt_vst_srvy.forEach( srvDto -> {
                if ( srvDto.adt_vst_srvy_seq != null ) {
                    MwAdtVstSrvy exSrvy = mwAdtVstSrvyRepository.findOneByAdtVstSrvySeqAndCrntRecFlg( srvDto.adt_vst_srvy_seq, true );
                    if ( exSrvy != null ) {
                        exSrvy.setCrntRecFlg( false );
                        exSrvy.setDelFlg( true );
                        exSrvy.setLastUpdBy( curUser );
                        exSrvy.setLastUpdDt( Instant.now() );
                        mwAdtVstSrvyRepository.save( exSrvy );
                    }
                    MwAdtVstSrvy srvy = srvDto.DtoToDomain( formatter, formatterDate );
                    mwAdtVstSrvyRepository.save( srvy );
                }
            } );
        }
        if ( dto.mw_adt_fndng != null ) {
            dto.mw_adt_fndng.forEach( fndDto -> {
                if ( fndDto.adt_fndng_seq != null ) {
                    MwAdtFndng exFnd = mwAdtFndngRepository.findOneByAdtFndngSeqAndCrntRecFlg( fndDto.adt_fndng_seq, true );
                    if ( exFnd != null ) {
                        exFnd.setCrntRecFlg( false );
                        exFnd.setDelFlg( true );
                        exFnd.setLastUpdBy( curUser );
                        exFnd.setLastUpdDt( Instant.now() );
                        mwAdtFndngRepository.save( exFnd );
                    }
                    MwAdtFndng fnd = fndDto.DtoToDomain( formatter, formatterDate );
                    mwAdtFndngRepository.save( fnd );
                }
            } );
        }
        return ResponseEntity.ok().body( "{\"body\":\"Success\"}" );
    }

    public List< LoanInfoDto > complianceData() {
        String query = Queries.complianceLoansQuery;
        Query q = em.createNativeQuery( query );
        q.setMaxResults( 100 );
        List< Object[] > result = q.getResultList();
        List< LoanInfoDto > resp = new ArrayList< LoanInfoDto >();
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
            dto.prdId = obj[ 40 ] == null ? "" : obj[ 40 ].toString();
            resp.add( dto );
        }
        return resp;
    }

    public List< ComplianceLandingDto > getListingForWeb() {
        String query = Queries.complianceLandingQuery;
        Query q = em.createNativeQuery( query );
        List< Object[] > result = q.getResultList();
        List< ComplianceLandingDto > resp = new ArrayList< ComplianceLandingDto >();
        for ( Object[] obj : result ) {
            ComplianceLandingDto dto = new ComplianceLandingDto();
            dto.brnchSeq = obj[ 0 ] == null ? 0 : Long.valueOf( obj[ 0 ].toString() );
            dto.brnchCd = obj[ 1 ] == null ? "" : obj[ 1 ].toString();
            dto.brnchNm = obj[ 2 ] == null ? "" : obj[ 2 ].toString();
            dto.trgt = obj[ 3 ] == null ? 0 : Long.valueOf( obj[ 3 ].toString() );
            dto.cmpltdVsts = obj[ 4 ] == null ? 0 : Long.valueOf( obj[ 4 ].toString() );
            resp.add( dto );
        }
        return resp;
    }

    public MwAdtVst addNewVst( AdtVstDto dto, String curUser ) {
        Long pendingStsKey = 0L;
        MwRefCdVal val = mwRefCdValRepository.findRefCdByGrpAndVal( "0358", "01385" );
        if ( val != null )
            pendingStsKey = val.getRefCdSeq();
        MwAdtVst vst = new MwAdtVst();
        Long seq = SequenceFinder.findNextVal( Sequences.ADT_VST_SEQ );
        vst.setAdtVstSeq( seq );
        vst.setAdtFlg( dto.adtFlg );
        vst.setAssignedTo( dto.assignedTo );
        vst.setBrnchSeq( dto.brnchSeq );
        vst.setCrntRecFlg( true );
        vst.setCrtdBy( curUser );
        vst.setCrtdDt( Instant.now() );
        vst.setDelFlg( false );
        vst.setEffStartDt( Instant.now() );
        vst.setStrtDt( dto.startDt.toInstant() );
        vst.setEndDt( dto.endDt.toInstant() );
        vst.setLastUpdBy( curUser );
        vst.setLastUpdDt( Instant.now() );
        vst.setVisitStsKey( pendingStsKey );
        vst.setVstId( String.format( "%04d", seq ) );
        mwAdtVstRepository.save( vst );
        return vst;
    }

    public List< MwAdtVst > getAdtVisitsForBrnch( long brnchSeq ) {
        return mwAdtVstRepository.findAllByBrnchSeqAndCrntRecFlg( brnchSeq, true );
    }

    public ResponseEntity updateStatusOfVst( Long vstSeq, String curUser ) {
        MwAdtVst exVst = mwAdtVstRepository.findOneByAdtVstSeqAndCrntRecFlg( vstSeq, true );
        if ( exVst != null ) {
            Long pendingStsKey = 0L;
            MwRefCdVal val = mwRefCdValRepository.findRefCdByGrpAndVal( "0358", "01385" );
            if ( val != null )
                pendingStsKey = val.getRefCdSeq();

            Long inProgressStatusKey = 0L;
            val = mwRefCdValRepository.findRefCdByGrpAndVal( "0358", "01386" );
            if ( val != null )
                inProgressStatusKey = val.getRefCdSeq();

            List< MwAdtVst > vsts = mwAdtVstRepository.findAllByAssignedToAndVisitStsKeyAndCrntRecFlg( exVst.getAssignedTo(),
                    inProgressStatusKey, true );
            if ( vsts != null && vsts.size() > 0 ) {
                return ResponseEntity.badRequest().body( "{\"error\":\"Employee Already has a Visit in Progress.\"}" );
            }

            exVst.setCrntRecFlg( false );
            exVst.setDelFlg( true );
            exVst.setEffEndDt( Instant.now() );
            exVst.setLastUpdBy( curUser );
            exVst.setLastUpdDt( Instant.now() );
            mwAdtVstRepository.save( exVst );
            MwAdtVst vst = new MwAdtVst();
            vst.setCrntRecFlg( true );
            vst.setDelFlg( false );
            vst.setEffStartDt( Instant.now() );
            vst.setLastUpdBy( curUser );
            vst.setLastUpdDt( Instant.now() );
            vst.setCrtdBy( curUser );
            vst.setActualStrtDt( Instant.now() );
            vst.setAdtFlg( exVst.getAdtFlg() );
            vst.setAdtVstSeq( exVst.getAdtVstSeq() );
            vst.setAssignedTo( exVst.getAssignedTo() );
            vst.setBrnchSeq( exVst.getBrnchSeq() );
            vst.setCrtdDt( Instant.now() );
            vst.setStrtDt( exVst.getStrtDt() );
            vst.setEndDt( exVst.getEndDt() );
            vst.setVisitStsKey( inProgressStatusKey );
            vst.setVstId( exVst.getVstId() );
            mwAdtVstRepository.save( vst );

            return ResponseEntity.ok().body( vst );
        }
        return ResponseEntity.badRequest().body( "{\"error\":\"Vst not found.\"}" );
    }

    public ResponseEntity updateVst( AdtVstDto dto, String curUser ) {
        MwAdtVst exVst = mwAdtVstRepository.findOneByAdtVstSeqAndCrntRecFlg( dto.adtVstSeq, true );
        if ( exVst != null ) {
            exVst.setCrntRecFlg( false );
            exVst.setDelFlg( true );
            exVst.setEffEndDt( Instant.now() );
            exVst.setLastUpdBy( curUser );
            exVst.setLastUpdDt( Instant.now() );
            mwAdtVstRepository.save( exVst );
            MwAdtVst vst = new MwAdtVst();
            vst.setCrntRecFlg( true );
            vst.setDelFlg( false );
            vst.setEffStartDt( Instant.now() );
            vst.setLastUpdBy( curUser );
            vst.setLastUpdDt( Instant.now() );
            vst.setCrtdBy( curUser );
            vst.setAdtFlg( dto.adtFlg );
            vst.setAdtVstSeq( exVst.getAdtVstSeq() );
            vst.setAssignedTo( dto.assignedTo );
            vst.setBrnchSeq( exVst.getBrnchSeq() );
            vst.setCrtdDt( Instant.now() );
            vst.setStrtDt( dto.startDt.toInstant() );
            vst.setEndDt( dto.endDt.toInstant() );
            vst.setVisitStsKey( exVst.getVisitStsKey() );
            vst.setVstId( exVst.getVstId() );
            mwAdtVstRepository.save( vst );

            return ResponseEntity.ok().body( vst );
        }
        return ResponseEntity.badRequest().body( "{\"error\":\"Vst not found.\"}" );
    }

    public ResponseEntity deleteVst( Long seq, String curUser ) {
        MwAdtVst exVst = mwAdtVstRepository.findOneByAdtVstSeqAndCrntRecFlg( seq, true );
        if ( exVst != null ) {
            exVst.setCrntRecFlg( false );
            exVst.setDelFlg( true );
            exVst.setEffEndDt( Instant.now() );
            exVst.setLastUpdBy( curUser );
            exVst.setLastUpdDt( Instant.now() );
            mwAdtVstRepository.save( exVst );
            return ResponseEntity.ok().body( exVst );
        }
        return ResponseEntity.badRequest().body( "{\"error\":\"Vst not found.\"}" );
    }

    public List< SrvtDto > getVstSrvy( Long seq ) {
        String query = Queries.adtSrvy + seq;
        Query q = em.createNativeQuery( query );
        List< Object[] > result = q.getResultList();
        List< SrvtDto > resp = new ArrayList< SrvtDto >();
        for ( Object[] obj : result ) {
            SrvtDto dto = new SrvtDto();
            dto.qstStr = obj[ 0 ] == null ? "" : obj[ 0 ].toString();
            dto.ansStr = obj[ 1 ] == null ? "" : obj[ 1 ].toString();
            dto.frstNm = obj[ 2 ] == null ? "" : obj[ 2 ].toString();
            dto.lstNm = obj[ 3 ] == null ? "" : obj[ 3 ].toString();
            dto.loanId = obj[ 4 ] == null ? "" : obj[ 4 ].toString();
            resp.add( dto );
        }
        return resp;
    }

    public class SrvtDto {

        public String qstStr;

        public String ansStr;

        public String frstNm;

        public String lstNm;

        public String loanId;
    }
}

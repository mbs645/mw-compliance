
package com.idev4.compliance.service;

import java.math.BigDecimal;
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

import com.idev4.compliance.domain.MwAdcChckQstnr;
import com.idev4.compliance.domain.MwAdcChcks;
import com.idev4.compliance.domain.MwAdtFndng;
import com.idev4.compliance.domain.MwAdtVst;
import com.idev4.compliance.domain.MwAdtVstSrvy;
import com.idev4.compliance.domain.MwAppRcon;
import com.idev4.compliance.domain.MwBrnchEmpRel;
import com.idev4.compliance.domain.MwDvcRgstr;
import com.idev4.compliance.domain.MwEmp;
import com.idev4.compliance.domain.MwPortEmpRel;
import com.idev4.compliance.domain.MwRefCdVal;
import com.idev4.compliance.dto.AdtVstDto;
import com.idev4.compliance.dto.ComplianceLandingDto;
import com.idev4.compliance.dto.DvcRgstrDto;
import com.idev4.compliance.dto.LoanInfoDto;
import com.idev4.compliance.dto.TabDto;
import com.idev4.compliance.dto.tab.ComplianceSubmitDto;
import com.idev4.compliance.dto.tab.MwAdtVstDto;
import com.idev4.compliance.repository.MwAdcChckQstnrRepository;
import com.idev4.compliance.repository.MwAdcChcksRepository;
import com.idev4.compliance.repository.MwAdtBrnchRnkngRepository;
import com.idev4.compliance.repository.MwAdtCtgryRepository;
import com.idev4.compliance.repository.MwAdtFndngRepository;
import com.idev4.compliance.repository.MwAdtIsuRepository;
import com.idev4.compliance.repository.MwAdtSbCtgryRepository;
import com.idev4.compliance.repository.MwAdtVstRepository;
import com.idev4.compliance.repository.MwAdtVstSrvyRepository;
import com.idev4.compliance.repository.MwAnswrRepository;
import com.idev4.compliance.repository.MwAppRconRepository;
import com.idev4.compliance.repository.MwBrnchEmpRelRepository;
import com.idev4.compliance.repository.MwBrnchRepository;
import com.idev4.compliance.repository.MwDvcRgstrRepository;
import com.idev4.compliance.repository.MwEmpRepository;
import com.idev4.compliance.repository.MwPortEmpRelRespository;
import com.idev4.compliance.repository.MwQstRepository;
import com.idev4.compliance.repository.MwQstnrRepository;
import com.idev4.compliance.repository.MwRefCdGrpRepository;
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

    private final MwRefCdGrpRepository mwRefCdGrpRepository;

    private final MwEmpRepository mwEmpRepository;

    private final MwBrnchRepository mwBrnchRepository;

    private final MwAdtVstRepository mwAdtVstRepository;

    private final MwAdtVstSrvyRepository mwAdtVstSrvyRepository;

    private final MwAdtFndngRepository mwAdtFndngRepository;

    private final MwBrnchEmpRelRepository mwbrnchEmpRelRepository;

    private final MwPortEmpRelRespository mwPortEmpRelRepository;

    private final MwDvcRgstrRepository mwDvcRgstryRepository;

    private final MwAdtIsuRepository mwAdtIsuRepository;

    private final MwAdtCtgryRepository mwAdtCtgryRepository;

    private final MwAdtSbCtgryRepository mwAdtSbCtgryRepository;

    private final MwAppRconRepository mwAppRconRepository;

    private final MwAdtBrnchRnkngRepository mwAdtBrnchRnkngRepository;

    private final MwAdcChcksRepository mwAdcChcksRepository;

    private final MwAdcChckQstnrRepository mwAdcChckQstnrRepository;

    private final DateFormat formatter = new SimpleDateFormat( "dd-MM-yyyy hh:mm:ss" );

    private final DateFormat formatterDate = new SimpleDateFormat( "dd-MM-yyyy" );

    private static long totSum = 0L;

    // private final MwBrnchRepository mwBrnchRepository;

    public ComplianceService( EntityManager em, MwQstnrRepository mwQstnrRepository, MwQstRepository mwQstRepository,
            MwAnswrRepository mwAnswrRepository, MwRefCdValRepository mwRefCdValRepository, MwEmpRepository mwEmpRepository,
            MwBrnchRepository mwBrnchRepository, MwAdtVstRepository mwAdtVstRepository, MwAdtVstSrvyRepository mwAdtVstSrvyRepository,
            MwAdtFndngRepository mwAdtFndngRepository, MwBrnchEmpRelRepository mwbrnchEmpRelRepository,
            MwPortEmpRelRespository mwPortEmpRelRepository, MwDvcRgstrRepository mwDvcRgstryRepository,
            MwAdtIsuRepository mwAdtIsuRepository, MwAdtCtgryRepository mwAdtCtgryRepository, MwAdtSbCtgryRepository mwAdtSbCtgryRepository,
            MwAppRconRepository mwAppRconRepository, MwAdtBrnchRnkngRepository mwAdtBrnchRnkngRepository,
            MwRefCdGrpRepository mwRefCdGrpRepository, MwAdcChcksRepository mwAdcChcksRepository,
            MwAdcChckQstnrRepository mwAdcChckQstnrRepository ) {
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
        this.mwbrnchEmpRelRepository = mwbrnchEmpRelRepository;
        this.mwPortEmpRelRepository = mwPortEmpRelRepository;
        this.mwDvcRgstryRepository = mwDvcRgstryRepository;
        this.mwAdtIsuRepository = mwAdtIsuRepository;
        this.mwAdtSbCtgryRepository = mwAdtSbCtgryRepository;
        this.mwAppRconRepository = mwAppRconRepository;
        this.mwAdtBrnchRnkngRepository = mwAdtBrnchRnkngRepository;
        this.mwRefCdGrpRepository = mwRefCdGrpRepository;
        this.mwAdcChcksRepository = mwAdcChcksRepository;
        this.mwAdcChckQstnrRepository = mwAdcChckQstnrRepository;

        this.mwAdtCtgryRepository = mwAdtCtgryRepository;
    }

    public TabDto getDataForTab( String lanId ) {
        TabDto dto = new TabDto();
        // dto.mw_prv_vst=getPrvVst();
        // dto.app_info = complianceData();
        dto.mw_answr = mwAnswrRepository.findAllByDelFlgAndCrntRecFlg( false, true );
        dto.mw_brnch = mwBrnchRepository.findAllByCrntRecFlg( true );
        dto.mw_emp = mwEmpRepository.findAll();
        dto.mw_qstnr = mwQstnrRepository.findAllByCrntRecFlg( true );
        dto.mw_qst = mwQstRepository.findAllByDelFlgAndCrntRecFlg( false, true );
        dto.mw_ref_cd_grp = mwRefCdGrpRepository.findAllByCrntRecFlg( true );
        dto.mw_ref_cd_val = mwRefCdValRepository.findAllByCrntRecFlgOrderByRefCdSeq( true );
        dto.mw_adt_isu = mwAdtIsuRepository.findAllByCrntRecFlg( true );
        dto.mw_adt_ctgry = mwAdtCtgryRepository.findAllByCrntRecFlg( true );
        dto.mw_adt_sb_ctgry = mwAdtSbCtgryRepository.findAllByCrntRecFlg( true );
        MwEmp emp = mwEmpRepository.findOneByEmpLanId( lanId );
        if ( emp != null ) {
            List< MwAdtVst > mw_adt_vsts = mwAdtVstRepository.findAllByAsgnToAndCrntRecFlg( emp.getEmpSeq(), true );
            dto.mw_adt_vst = new ArrayList<>();
            mw_adt_vsts.forEach( vst -> {
                MwAdtVstDto sdto = new MwAdtVstDto();
                sdto.DomainToDto( vst );
                dto.mw_adt_vst.add( sdto );
            } );
        }
        return dto;
    }

    public List< MwAdtVstDto > getADTVstDataForTab( String lanId ) {
        List< MwAdtVstDto > dto = new ArrayList<>();

        MwEmp emp = mwEmpRepository.findOneByEmpLanId( lanId );
        if ( emp != null ) {
            List< MwAdtVst > mw_adt_vsts = mwAdtVstRepository.findAllByAsgnToAndCrntRecFlg( emp.getEmpSeq(), true );
            // dto = new ArrayList<>();
            for ( MwAdtVst vst : mw_adt_vsts ) {
                MwAdtVstDto sdto = new MwAdtVstDto();
                sdto.DomainToDto( vst );
                dto.add( sdto );
            }
        }
        return dto;
    }

    @Transactional
    public ResponseEntity updateVstStsViaTab( String curUser, Integer brnchSeq, Long vstSeq ) {
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

            List< MwAdtVst > vsts = mwAdtVstRepository.findAllByAsgnToAndVstStsKeyAndCrntRecFlg( exVst.getAsgnTo(), inProgressStatusKey,
                    true );
            if ( vsts != null && vsts.size() > 0 ) {
                return ResponseEntity.badRequest().body( "{\"error\":\"Employee Already has a Visit in Progress.\"}" );
            }

            List< LoanInfoDto > app_info = complianceData( brnchSeq );
            if ( app_info.size() <= 0 )
                return ResponseEntity.badRequest().body( "{\"error\":\"No Data Found For Visit.\"}" );

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
            vst.setActlStrtDt( Instant.now() );
            vst.setAdtFlg( exVst.getAdtFlg() );
            vst.setAdtVstSeq( exVst.getAdtVstSeq() );
            vst.setAsgnTo( exVst.getAsgnTo() );
            vst.setBrnchSeq( exVst.getBrnchSeq() );
            vst.setCrtdDt( Instant.now() );
            vst.setStrtDt( exVst.getStrtDt() );
            vst.setEndDt( exVst.getEndDt() );
            vst.setVstStsKey( inProgressStatusKey );
            vst.setVstId( exVst.getVstId() );
            mwAdtVstRepository.save( vst );

            return ResponseEntity.ok().body( app_info );
        }
        return ResponseEntity.badRequest().body( "{\"error\":\"Vst not found.\"}" );
    }

    public List< LoanInfoDto > getClientDataForTab( String lanId, Integer brnchSeq ) {
        List< LoanInfoDto > app_info = new ArrayList<>();

        app_info = complianceData( brnchSeq );
        return app_info;
    }

    public TabDto getDataFor() {
        TabDto dto = new TabDto();
        dto.mw_prv_vst = getPrvVst( 98L );
        dto.app_info = complianceData( 1 );
        return dto;
    }

    public List< DvcRgstrDto > getDvcReg() {
        List< DvcRgstrDto > dto = new ArrayList< DvcRgstrDto >();
        List< MwDvcRgstr > dvc1 = mwDvcRgstryRepository.findAllByCrntRecFlgAndDelFlg( true, false );
        if ( dvc1 != null ) {
            for ( int j = 0; j < dvc1.size(); j++ ) {
                DvcRgstrDto obj = new DvcRgstrDto();
                obj.dvcAddr = dvc1.get( j ).getDvcAddr() == null ? "" : dvc1.get( j ).getDvcAddr().toString();
                if ( dvc1.get( j ).getEntyTypFlg() == 1 ) {
                    MwPortEmpRel port = mwPortEmpRelRepository.findOneByPortSeqAndCrntRecFlg( dvc1.get( j ).getEntyTypSeq(), true );
                    MwEmp emp = mwEmpRepository.findOneByEmpSeq( port.getEmpSeq() );
                    obj.seq = emp.getEmpSeq();
                    obj.type = "BDO > " + emp.getEmpLanId();
                } else if ( dvc1.get( j ).getEntyTypFlg() == 2 ) {
                    MwBrnchEmpRel brnch = mwbrnchEmpRelRepository.findOneByBrnchSeqAndCrntRecFlg( dvc1.get( j ).getEntyTypSeq(), true );
                    MwEmp emp = mwEmpRepository.findOneByEmpSeq( brnch.getEmpSeq() );
                    obj.seq = emp.getEmpSeq();
                    obj.type = "BM > " + emp.getEmpLanId();
                }
                dto.add( obj );
            }
        }
        return dto;
    }

    public DvcRgstrDto getOneDvcRgstr( String id ) {
        DvcRgstrDto dto = new DvcRgstrDto();
        MwDvcRgstr dvc1 = mwDvcRgstryRepository.findOneByDvcAddrAndCrntRecFlgAndDelFlg( id, true, false );
        dto.dvcAddr = dvc1.getDvcAddr();
        if ( dvc1 != null ) {
            if ( dvc1.getEntyTypFlg() == 1 ) {
                MwPortEmpRel port = mwPortEmpRelRepository.findOneByPortSeqAndCrntRecFlg( dvc1.getEntyTypSeq(), true );
                MwEmp emp = mwEmpRepository.findOneByEmpSeq( port.getEmpSeq() );
                dto.seq = emp.getEmpSeq();
                dto.type = "BDO > " + emp.getEmpLanId();
            } else if ( dvc1.getEntyTypFlg() == 2 ) {
                MwBrnchEmpRel brnch = mwbrnchEmpRelRepository.findOneByBrnchSeqAndCrntRecFlg( dvc1.getEntyTypSeq(), true );
                MwEmp emp = mwEmpRepository.findOneByEmpSeq( brnch.getEmpSeq() );
                dto.seq = emp.getEmpSeq();
                dto.type = "BM > " + emp.getEmpLanId();
            }

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
        vst.setActlEndDt( Instant.now() );
        vst.setLastUpdBy( curUser );
        vst.setLastUpdDt( Instant.now() );
        vst.setVstStsKey( complSts );

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

        if ( dto.mw_app_rcon != null ) {
            dto.mw_app_rcon.forEach( rconDto -> {
                if ( rconDto.app_rcon_seq != null ) {
                    MwAppRcon appRcon = mwAppRconRepository.findOneByAppRconSeqAndCrntRecFlg( rconDto.app_rcon_seq, true );
                    if ( appRcon != null ) {
                        appRcon.setCrntRecFlg( false );
                        appRcon.setDelFlg( true );
                        appRcon.setLastUpdBy( curUser );
                        appRcon.setLastUpdDt( Instant.now() );
                        mwAppRconRepository.save( appRcon );
                    }
                    MwAppRcon rco = rconDto.DtoToDomain( formatter, formatterDate );

                    mwAppRconRepository.save( rco );
                }
            } );
        }

        if ( dto.mw_adc_chcks != null ) {
            dto.mw_adc_chcks.forEach( adcDto -> {
                if ( adcDto.adc_chks_seq != null ) {
                    MwAdcChcks adcChcks = mwAdcChcksRepository.findOneByAdcChksSeqAndCrntRecFlg( adcDto.adc_chks_seq, true );
                    if ( adcChcks != null ) {
                        adcChcks.setCrntRecFlg( false );
                        adcChcks.setDelFlg( true );
                        adcChcks.setLastUpdBy( curUser );
                        adcChcks.setLastUpdDt( Instant.now() );
                        mwAdcChcksRepository.save( adcChcks );
                    }
                    MwAdcChcks rco = adcDto.DtoToDomain( formatter, formatterDate );

                    mwAdcChcksRepository.save( rco );
                }
            } );
        }

        if ( dto.mw_adc_chck_qstnr != null ) {
            dto.mw_adc_chck_qstnr.forEach( adcDto -> {
                if ( adcDto.adc_chks_qstnr_seq != null ) {
                    MwAdcChckQstnr adcChcks = mwAdcChckQstnrRepository.findOneByAdcChksQstnrSeqAndCrntRecFlg( adcDto.adc_chks_qstnr_seq,
                            true );
                    if ( adcChcks != null ) {
                        adcChcks.setCrntRecFlg( false );
                        adcChcks.setDelFlg( true );
                        adcChcks.setLastUpdBy( curUser );
                        adcChcks.setLastUpdDt( Instant.now() );
                        mwAdcChckQstnrRepository.save( adcChcks );
                    }
                    MwAdcChckQstnr rco = adcDto.DtoToDomain( formatter, formatterDate );

                    mwAdcChckQstnrRepository.save( rco );
                }
            } );
        }

        calScore( vst.getAdtVstSeq(), vst.getBrnchSeq() );
        return ResponseEntity.ok().body( "{\"body\":\"Success\"}" );
    }

    public List< LoanInfoDto > complianceData( Integer brnchSeq ) {
        String query = Queries.complianceLoansQuery;
        Query q = em.createNativeQuery( query ).setParameter( "Brnch_seq", brnchSeq );
        // q.setMaxResults( 100 );
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
            dto.odDays = obj[ 7 ] == null ? 0 : ( ( BigDecimal ) obj[ 7 ] ).intValue();
            dto.prdSeq = obj[ 8 ] == null ? "" : obj[ 8 ].toString();
            dto.nkinFlg = obj[ 9 ] == null ? "" : obj[ 9 ].toString();
            dto.bizChngFlg = obj[ 10 ] == null ? "" : obj[ 10 ].toString();
            dto.clntAddr = obj[ 11 ] == null ? "" : obj[ 11 ].toString();
            dto.resSts = obj[ 12 ] == null ? "" : obj[ 12 ].toString();
            dto.resTnr = obj[ 13 ] == null ? "" : obj[ 13 ].toString();
            dto.totFmlyMemb = obj[ 14 ] == null ? "" : obj[ 14 ].toString();
            dto.numOfErnrs = obj[ 15 ] == null ? "" : obj[ 15 ].toString();
            dto.prdNm = obj[ 16 ] == null ? "" : obj[ 16 ].toString();
            dto.prevAmt = obj[ 17 ] == null ? 0 : ( ( BigDecimal ) obj[ 17 ] ).intValue();
            dto.loanCyclNum = obj[ 18 ] == null ? "" : obj[ 18 ].toString();
            dto.rqstdLoanAmt = obj[ 19 ] == null ? "" : obj[ 19 ].toString();
            dto.aprvdLoanAmt = obj[ 20 ] == null ? 0 : ( ( BigDecimal ) obj[ 20 ] ).intValue();
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
            dto.monthLstVst = obj[ 41 ] == null ? "" : obj[ 41 ].toString();
            dto.instAdv = obj[ 42 ] == null ? "" : obj[ 42 ].toString();
            dto.crdtScr = obj[ 43 ] == null ? "" : obj[ 43 ].toString();
            dto.actKey = obj[ 44 ] == null ? "" : obj[ 44 ].toString();
            dto.prvBizActy = obj[ 45 ] == null ? "" : obj[ 45 ].toString();
            dto.par1Day = obj[ 46 ] == null ? "" : obj[ 46 ].toString();
            dto.par30Day = obj[ 47 ] == null ? "" : obj[ 47 ].toString();
            dto.portCd = obj[ 48 ] == null ? "" : obj[ 48 ].toString();
            dto.bdoNm = obj[ 49 ] == null ? "" : obj[ 49 ].toString();
            dto.lastRotated = obj[ 50 ] == null ? "" : obj[ 50 ].toString();
            dto.odInst = obj[ 51 ] == null ? "" : obj[ 51 ].toString();

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
        vst.setAsgnTo( dto.assignedTo );
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
        vst.setVstStsKey( pendingStsKey );
        vst.setVstId( String.format( "%04d", seq ) );
        vst.setTrgtClnt( ( long ) dto.minNumCli );
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

            List< MwAdtVst > vsts = mwAdtVstRepository.findAllByAsgnToAndVstStsKeyAndCrntRecFlg( exVst.getAsgnTo(), inProgressStatusKey,
                    true );
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
            vst.setActlStrtDt( Instant.now() );
            vst.setAdtFlg( exVst.getAdtFlg() );
            vst.setAdtVstSeq( exVst.getAdtVstSeq() );
            vst.setAsgnTo( exVst.getAsgnTo() );
            vst.setBrnchSeq( exVst.getBrnchSeq() );
            vst.setCrtdDt( Instant.now() );
            vst.setStrtDt( exVst.getStrtDt() );
            vst.setEndDt( exVst.getEndDt() );
            vst.setVstStsKey( inProgressStatusKey );
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
            vst.setAsgnTo( dto.assignedTo );
            vst.setBrnchSeq( exVst.getBrnchSeq() );
            vst.setCrtdDt( Instant.now() );
            vst.setStrtDt( dto.startDt.toInstant() );
            vst.setEndDt( dto.endDt.toInstant() );
            vst.setVstStsKey( exVst.getVstStsKey() );
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

    public List< DVCDto > getDvc_reg() {
        String query = Queries.dvc_arr;
        Query q = em.createNativeQuery( query );
        List< Object[] > result = q.getResultList();
        List< DVCDto > resp = new ArrayList< DVCDto >();
        for ( Object[] obj : result ) {
            DVCDto dto = new DVCDto();
            dto.dvcAddr = obj[ 0 ] == null ? "" : obj[ 0 ].toString();
            dto.portSeq = obj[ 1 ] == null ? "" : obj[ 1 ].toString();

            dto.id = obj[ 2 ] == null ? "" : obj[ 2 ].toString();
            resp.add( dto );

        }
        return resp;
    }

    public DVCDto getDvcReg( Long id ) {
        String query = Queries.dvc_reg + "'" + id + "'";
        Query q = em.createNativeQuery( query );
        List< Object[] > result = q.getResultList();
        DVCDto dto = new DVCDto();
        for ( Object[] obj : result ) {
            dto.dvcAddr = obj[ 0 ] == null ? "" : obj[ 0 ].toString();
            dto.portSeq = obj[ 1 ] == null ? "" : obj[ 1 ].toString();
            dto.id = obj[ 2 ] == null ? "" : obj[ 2 ].toString();
        }
        return dto;
    }

    public List< PrvVstDto > getPrvVst( Long brnchSeq ) {
        String query = Queries.prev_vst;
        Query q = em.createNativeQuery( query ).setParameter( "Brnch_seq", brnchSeq );
        List< Object[] > result = q.getResultList();
        List< PrvVstDto > resp = new ArrayList< PrvVstDto >();
        for ( Object[] obj : result ) {
            PrvVstDto dto = new PrvVstDto();
            dto.vstId = obj[ 0 ] == null ? "" : obj[ 0 ].toString();
            dto.rnkng = obj[ 1 ] == null ? "" : obj[ 1 ].toString();
            dto.vstScr = obj[ 2 ] == null ? "" : obj[ 2 ].toString();
            dto.lstVstDt = obj[ 3 ] == null ? "" : obj[ 3 ].toString();
            dto.lstVstBy = obj[ 4 ] == null ? "" : obj[ 4 ].toString();

            dto.dataChkDt = obj[ 5 ] == null ? "" : obj[ 5 ].toString();
            dto.portCd = obj[ 6 ] == null ? "" : obj[ 6 ].toString();
            dto.portNm = obj[ 7 ] == null ? "" : obj[ 7 ].toString();
            dto.empNm = obj[ 8 ] == null ? "" : obj[ 8 ].toString();
            dto.clntVstd = obj[ 9 ] == null ? "" : obj[ 9 ].toString();
            dto.cmntCnt = obj[ 10 ] == null ? "" : obj[ 10 ].toString();
            resp.add( dto );

        }
        return resp;
    }

    public class PrvVstDto {

        public String vstId;

        public String rnkng;

        public String vstScr;

        public String lstVstDt;

        public String lstVstBy;

        public String dataChkDt;

        public String portCd;

        public String portNm;

        public String empNm;

        public String clntVstd;

        public String cmntCnt;

    }

    public class DVCDto {

        public String dvcAddr;

        public String portSeq;

        public String id;

    }

    public class SrvtDto {

        public String qstStr;

        public String ansStr;

        public String frstNm;

        public String lstNm;

        public String loanId;
    }

    public void calScore( Long vstSeq, Long brnchSeq ) {

        // Long brnchScr = mwAdtFndngRepository.getVstScrSum( vstSeq );
        // List< MwAdtBrnchRnkng > brnchRnkngList = mwAdtBrnchRnkngRepository.findOneByBrnchSeqAndCrntRecFlg( brnchSeq, true );
        //
        // brnchRnkngList.stream().filter( brnch -> brnchSeq.longValue() == brnch.getBrnchSeq().longValue() )
        // .peek( brnch -> brnch.setBrnchScr( brnchScr ) ).collect( Collectors.toList() );

        long totalSum = 0L;
        Query rs = em.createNativeQuery( "select ctg.ADT_CTGRY_SEQ,round(count(fnding.issue_key)/\r\n"
                + "(select count(ENTY_SEQ) from MW_ADT_VST_SRVY avs where avs.ADT_VST_SEQ=fnding.ADT_VST_SEQ and avs.enty_typ_flg=1) *100,0) as cal_score \r\n"
                + "from MW_ADT_FNDNG fnding \r\n" + "join MW_ADT_ISU isu on isu.ISU_ID = fnding.ISSUE_KEY AND isu.CRNT_REC_FLG = 1\r\n"
                + "join MW_ADT_SB_CTGRY sctg on sctg.ADT_CTGRY_SEQ = isu.ADT_ISU_SEQ AND sctg.CRNT_REC_FLG = 1\r\n"
                + "join MW_ADT_CTGRY ctg on ctg.ADT_CTGRY_SEQ = sctg.ADT_CTGRY_SEQ AND ctg.CRNT_REC_FLG = 1 AND ctg.CTGRY_ENTY_FLG =1\r\n"
                + "--join MW_ADT_VST_SRVY avs on avs.ADT_VST_SEQ = fnding.ADT_VST_SEQ and avs.CRNT_REC_FLG = 1\r\n"
                + "where fnding.CRNT_REC_FLG = 1 and fnding.ADT_VST_SEQ=:vstSeq\r\n" + "and fnding.finding_typ_key=0\r\n"
                + "group by ctg.ADT_CTGRY_SEQ,fnding.ADT_VST_SEQ " ).setParameter( "vstSeq", vstSeq );

        List< Object[] > obj = rs.getResultList();

        for ( Object[] o : obj ) {

            Query scr = em
                    .createNativeQuery( "select ded_scr\r\n" + "from mw_adt_ctgry_slbs sl\r\n" + "where sl.crnt_rec_flg=1\r\n"
                            + "and sl.adt_ctgry_seq = :ctgseq\r\n" + "and :scr between sl.start_lmt and nvl(sl.end_lmt,99999999)" )
                    .setParameter( "ctgseq", new BigDecimal( o[ 0 ].toString() ).longValue() )
                    .setParameter( "scr", new BigDecimal( o[ 1 ].toString() ).longValue() );
            try {
                Object scrObj = scr.getSingleResult();
                if ( scrObj != null ) {

                    Long totScr = ( scrObj == null ) ? 0L : new BigDecimal( scrObj.toString() ).longValue();

                    totalSum = totalSum + totScr;
                }
            } catch ( Exception e ) {
            }

        }

        long totalSum1 = 0L;
        Query res = em.createNativeQuery( " select ctg.ADT_CTGRY_SEQ,round(count(fnding.issue_key)/ \r\n"
                + "  (select count(ENTY_SEQ) from MW_ADT_VST_SRVY avs where avs.ADT_VST_SEQ=fnding.ADT_VST_SEQ and avs.enty_typ_flg=1) *100,0) as cal_score  \r\n"
                + "  from MW_ADT_FNDNG fnding    join MW_ADT_ISU isu on isu.ISU_ID = fnding.ISSUE_KEY AND isu.CRNT_REC_FLG = 1 \r\n"
                + "join MW_ADT_SB_CTGRY sctg on sctg.ADT_CTGRY_SEQ = isu.ADT_ISU_SEQ AND sctg.CRNT_REC_FLG = 1 \r\n"
                + "join MW_ADT_CTGRY ctg on ctg.ADT_CTGRY_SEQ = sctg.ADT_CTGRY_SEQ AND ctg.CRNT_REC_FLG = 1 AND ctg.CTGRY_ENTY_FLG =2 \r\n"
                + "--join MW_ADT_VST_SRVY avs on avs.ADT_VST_SEQ = fnding.ADT_VST_SEQ and avs.CRNT_REC_FLG = 1 \r\n"
                + " where fnding.CRNT_REC_FLG = 1 and fnding.ADT_VST_SEQ=:vstSeq   \r\n" + " and fnding.finding_typ_key=0\r\n"
                + " group by ctg.ADT_CTGRY_SEQ,fnding.ADT_VST_SEQ " ).setParameter( "vstSeq", vstSeq );

        List< Object[] > ob = res.getResultList();

        for ( Object[] b : ob ) {

            Query scr2 = em
                    .createNativeQuery( "select ded_scr\r\n" + "from mw_adt_ctgry_slbs sl\r\n" + "where sl.crnt_rec_flg=1\r\n"
                            + "and sl.adt_ctgry_seq = :ctgseq\r\n" + "and :scr between sl.start_lmt and nvl(sl.end_lmt,99999999)" )
                    .setParameter( "ctgseq", new BigDecimal( b[ 0 ].toString() ).longValue() )
                    .setParameter( "scr", new BigDecimal( b[ 1 ].toString() ).longValue() );
            try {
                Object scrOb = scr2.getSingleResult();
                if ( scrOb != null ) {

                    Long totScr1 = ( scrOb == null ) ? 0L : new BigDecimal( scrOb.toString() ).longValue();

                    totalSum1 = totalSum1 + totScr1;
                }
            } catch ( Exception e ) {
            }

        }
        //
        // MwAdtVst brnchRnk = mwAdtVstRepository.findOneBybrnchSeqAndCrntRecFlg( brnchSeq, true );
        // if ( brnchRnk != null ) {
        // brnchRnk.setCrntRecFlg( false );
        // mwAdtVstRepository.save( brnchRnk );
        // }
        // MwAdtBrnchRnkng b = new MwAdtBrnchRnkng();
        // Long seq = SequenceFinder.findNextVal( Sequences.ADT_BRNCH_RKNG_SEQ );
        // b.setAdtBrcnhRnkgSeq( seq );
        // b.setBrnchSeq( brnchSeq );
        // b.setLstVstSeq( vstSeq );
        // b.setRnkngDte( Instant.now() );
        // b.setBrnchScr( 100 - ( totalSum + totalSum1 ) );
        // b.setCrntRecFlg( true );
        // mwAdtBrnchRnkngRepository.save( b );

        MwAdtVst vst = new MwAdtVst();
        MwAdtVst seq = mwAdtVstRepository.findOneByAdtVstSeqAndCrntRecFlg( vstSeq, true );
        if ( seq != null ) {
            seq.setVstScr( 100 - ( totalSum + totalSum1 ) );
            mwAdtVstRepository.save( seq );
        }

    }
}

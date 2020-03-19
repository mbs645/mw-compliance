package com.idev4.compliance.repository;

import java.time.Instant;
import java.util.List;

import com.idev4.compliance.domain.MwAdtCtgry;
import com.idev4.compliance.domain.MwAdtSbCtgry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the MwArea entity.
 */
@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtCtgryRepository extends JpaRepository< MwAdtCtgry, Long > {

    public MwAdtCtgry findOneByAdtCtgrySeqAndCrntRecFlg( Long seq, boolean flag );
    public MwAdtCtgry findOneByAdtCtgrySeqAndCtgryIdAndCrntRecFlg( Long seq,String id, boolean flag );

    public List< MwAdtCtgry > findAllByCrntRecFlg( boolean flag );
    public List< MwAdtCtgry > findAllByLastUpdDtAfterAndCrntRecFlgOrLastUpdDtAfterAndDelFlg( Instant date, boolean crntRecFlg, Instant ldate,boolean delFlg );

}

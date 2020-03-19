
package com.idev4.compliance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwAdtCtgry;
import com.idev4.compliance.domain.MwAdtCtgrySlbs;

@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtCtgrySlbsRepository extends JpaRepository< MwAdtCtgrySlbs, Long > {

//    public MwAdtCtgry findOneByAdtCtgrySlbsSeqAndCrntRecFlg( Long seq, boolean flag );

    public MwAdtCtgrySlbs findOneByAdtCtgrySlbsSeqAndCrntRecFlg( Long seq, boolean flag );

    public List<MwAdtCtgrySlbs> findAllByAdtCtgrySeqAndCrntRecFlgOrderByStartLmtAsc( Long seq, boolean flag );

    public  MwAdtCtgrySlbs  findOneByCrntRecFlg( boolean flag );

    public List< MwAdtCtgrySlbs > findAllByCrntRecFlg( boolean flag );
}

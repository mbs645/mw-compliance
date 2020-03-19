
package com.idev4.compliance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwAdtTrgt;

/**
 * Spring Data JPA repository for the MwArea entity.
 */
@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtTrgtRepository extends JpaRepository< MwAdtTrgt, Long > {

    public List< MwAdtTrgt > findAllByTrgtYrAndBrnchSeqAndCrntRecFlg( long trgtYr, long brnchSeq, boolean flag );

    public List< MwAdtTrgt > findAllByTrgtYrAndCrntRecFlg( long trgtYr, boolean flag );

    
    public List< MwAdtTrgt > findAllByCrntRecFlg( boolean flag );

    public MwAdtTrgt findOneByAdtTrgtSeqAndCrntRecFlg( long seq, boolean flag );

}

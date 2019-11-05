
package com.idev4.compliance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwRefCdGrp;

/**
 * Spring Data JPA repository for the MwRefCdGrp entity.
 */
@SuppressWarnings ( "unused" )
@Repository
public interface MwRefCdGrpRepository extends JpaRepository< MwRefCdGrp, Long > {

    public MwRefCdGrp findOneByRefCdGrpSeqAndCrntRecFlg( long seq, boolean flag );

    public MwRefCdGrp findOneByRefCdGrpNameAndCrntRecFlg( String name, boolean flag );

    public List< MwRefCdGrp > findAllByCrntRecFlg( boolean flag );

}

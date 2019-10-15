
package com.idev4.compliance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwAdtCtgry;

/**
 * Spring Data JPA repository for the MwArea entity.
 */
@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtCtgryRepository extends JpaRepository< MwAdtCtgry, Long > {

    public MwAdtCtgry findOneByAdtCtgrySeqAndCrntRecFlg( Long seq, boolean flag );

    public List< MwAdtCtgry > findAllByCrntRecFlg( boolean flag );
}

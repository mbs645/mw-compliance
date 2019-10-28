
package com.idev4.compliance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwAdtBrnchRnkng;

/**
 * Spring Data JPA repository for the MwAnswr entity.
 */
@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtBrnchRnkngRepository extends JpaRepository< MwAdtBrnchRnkng, Long > {

    public MwAdtBrnchRnkng findOneByBrnchSeqAndCrntRecFlg( Long seq, boolean flag );

}

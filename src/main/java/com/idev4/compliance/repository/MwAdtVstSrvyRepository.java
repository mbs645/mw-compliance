
package com.idev4.compliance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwAdtVstSrvy;

/**
 * Spring Data JPA repository for the MwAnswr entity.
 */
@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtVstSrvyRepository extends JpaRepository< MwAdtVstSrvy, Long > {

    public MwAdtVstSrvy findOneByAdtVstSrvySeqAndCrntRecFlg( Long seq, boolean flag );

}

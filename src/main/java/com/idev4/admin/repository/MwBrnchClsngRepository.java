
package com.idev4.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.admin.domain.MwBrnchClsng;

/**
 * Spring Data JPA repository for the MwEmp entity.
 */
@SuppressWarnings ( "unused" )
@Repository
public interface MwBrnchClsngRepository extends JpaRepository< MwBrnchClsng, Long > {

    public MwBrnchClsng findOneByBrnchSeqAndBrnchOpnFlg( Long seq, boolean flag );

}

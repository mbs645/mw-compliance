
package com.idev4.compliance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwAdtSubCtgry;

/**
 * Spring Data JPA repository for the MwArea entity.
 */
@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtSubCtgryRepository extends JpaRepository< MwAdtSubCtgry, Long > {

    public List< MwAdtSubCtgry > findAllByAdtCtgrySeqAndCrntRecFlg( long seq, boolean flag );

    public MwAdtSubCtgry findAllBySbCtgrySeqAndCrntRecFlg( long seq, boolean flag );

}

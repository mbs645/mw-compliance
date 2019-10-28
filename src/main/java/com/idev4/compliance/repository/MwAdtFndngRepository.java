
package com.idev4.compliance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwAdtFndng;

/**
 * Spring Data JPA repository for the MwAnswr entity.
 */
@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtFndngRepository extends JpaRepository< MwAdtFndng, Long > {

    public MwAdtFndng findOneByAdtFndngSeqAndCrntRecFlg( Long seq, boolean flag );
    //
    // @Query ( value = "select SUM(SCR) from MW_ADT_FNDNG fnd where fnd.ADT_VST_SEQ = :vstSeq and fnd.CRNT_REC_FLG=1", nativeQuery = true )
    // Long getVstScrSum( @Param ( "vstSeq" ) long vstSeq );

}

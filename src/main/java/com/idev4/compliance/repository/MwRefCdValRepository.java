
package com.idev4.compliance.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwRefCdVal;

/**
 * Spring Data JPA repository for the MwRefCdVal entity.
 */
@SuppressWarnings ( "unused" )
@Repository
public interface MwRefCdValRepository extends JpaRepository< MwRefCdVal, Long > {

    public MwRefCdVal findOneByRefCdSeqAndRefCdGrpKeyAndCrntRecFlg( long seq, long refCdGrpKey, boolean flag );

    public MwRefCdVal findOneByRefCdSeqAndCrntRecFlg( long seq, boolean flag );

    public List< MwRefCdVal > findAllByRefCdGrpKeyAndCrntRecFlg( Long groupKey, boolean flag );

    public List< MwRefCdVal > findAllByRefCdGrpKeyAndActiveStatusAndCrntRecFlgOrderBySortOrder( Long groupKey, boolean status,
            boolean flag );

    public List< MwRefCdVal > findAllByCrntRecFlgOrderByRefCdSeq( boolean flag );

    public List< MwRefCdVal > findAllByCrntRecFlgOrderByRefCdSeqDesc( boolean flag );

    public List< MwRefCdVal > findAllByLastUpdDtAfterAndCrntRecFlgOrLastUpdDtAfterAndDelFlg( Instant date, boolean crntRecFlg,
            Instant ldate, boolean delFlg );
}

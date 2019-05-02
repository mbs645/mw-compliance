
package com.idev4.compliance.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwQstnr;

@SuppressWarnings ( "unused" )
@Repository
public interface MwQstnrRepository extends JpaRepository< MwQstnr, Long > {

    public MwQstnr findOneByQstnrSeqAndCrntRecFlg( Long seq, boolean flag );

    public List< MwQstnr > findAllByQstnrSeq( Long seq );

    public List< MwQstnr > findAllByCrntRecFlg( boolean recflag );

    public List< MwQstnr > findAllByLastUpdDtAfterAndCrntRecFlgOrLastUpdDtAfterAndDelFlg( Instant date, boolean crntRecFlg, Instant ldate,
            boolean delFlg );
}

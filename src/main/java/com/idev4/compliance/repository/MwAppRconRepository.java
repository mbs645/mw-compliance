
package com.idev4.compliance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwAppRcon;

@SuppressWarnings ( "unused" )
@Repository
public interface MwAppRconRepository extends JpaRepository< MwAppRcon, Long > {

    public MwAppRcon findOneByAppRconSeqAndCrntRecFlg( Long seq, boolean flag );

}

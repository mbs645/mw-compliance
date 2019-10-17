<<<<<<< HEAD
package com.idev4.compliance.repository;

import java.util.List;
=======

package com.idev4.compliance.repository;

import java.util.List;

>>>>>>> b28b1e0de1f2b111fda8106ffb2927ec3a14bf5c
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwAdtCtgry;
<<<<<<< HEAD
@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtCtgryRepository  extends JpaRepository< MwAdtCtgry, Long >{
	public List< MwAdtCtgry > findAllByAdtCtgrySeqAndCrntRecFlg(long adtCtgrySeq,boolean crntFlg);
	public List< MwAdtCtgry > findAllByCrntRecFlg(boolean crntFlg);

=======

/**
 * Spring Data JPA repository for the MwArea entity.
 */
@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtCtgryRepository extends JpaRepository< MwAdtCtgry, Long > {

    public MwAdtCtgry findOneByAdtCtgrySeqAndCrntRecFlg( Long seq, boolean flag );

    public List< MwAdtCtgry > findAllByCrntRecFlg( boolean flag );
>>>>>>> b28b1e0de1f2b111fda8106ffb2927ec3a14bf5c
}


package com.idev4.compliance.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwAdtFndng;

/**
 * Spring Data JPA repository for the MwAnswr entity.
 */
@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtFndngRepository extends JpaRepository< MwAdtFndng, Long > {
	
	public MwAdtFndng findOneByAdtFndngSeqAndCrntRecFlg(Long seq, boolean flag);
	public List<MwAdtFndng> findAllByAdtVstSeqAndCrntRecFlg(Long seq, boolean flag);

	
}


package com.idev4.compliance.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwAdtVst;

/**
 * Spring Data JPA repository for the MwAnswr entity.
 */
@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtVstRepository extends JpaRepository< MwAdtVst, Long > {
	
	public List<MwAdtVst> findAllByBrnchSeqAndCrntRecFlg(Long brnchSeq, boolean flag);
	
	public List<MwAdtVst> findAllByAssignedToAndCrntRecFlg(Long empSeq, boolean flag);
	
	public List<MwAdtVst> findAllByAssignedToAndVisitStsKeyAndCrntRecFlg(Long empSeq,Long vstSts, boolean flag);
	
	public MwAdtVst findOneByAdtVstSeqAndCrntRecFlg(Long adtVstSeq, boolean flag);
}

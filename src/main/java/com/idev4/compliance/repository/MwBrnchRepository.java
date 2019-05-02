package com.idev4.compliance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwBrnch;


/**
 * Spring Data JPA repository for the MwBrnch entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MwBrnchRepository extends JpaRepository<MwBrnch, Long> {

	public List<MwBrnch> findAllByAreaSeqAndCrntRecFlgOrderByBrnchSeqDesc(long areaSeq,boolean flag);
	
	public List<MwBrnch> findAllByCrntRecFlg(boolean flag);

	public MwBrnch findTopByOrderByBrnchSeqDesc();
	
	public MwBrnch findOneByBrnchSeqAndCrntRecFlg(long seq, boolean flag);
	
	public List<MwBrnch> findAllByBrnchSeq(long seq);

	public List<MwBrnch> findAllByAreaSeqAndCrntRecFlg(Long id, boolean b);
}

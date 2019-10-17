package com.idev4.compliance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwBrnchEmpRel;
@SuppressWarnings("unused")
@Repository
public interface MwBrnchEmpRelRepository extends JpaRepository< MwBrnchEmpRel , Long>{
	
	public List< MwBrnchEmpRel > findAllByEmpSeqAndCrntRecFlg(Long empSeq,boolean crntFlg);
	
//	public List<MwBrnchEmpRel> findAllByEmpSeqAndBrnchSeqAndCrntRecFlg(Long long1,long brnchSeq, boolean crntFlg);
	
	public MwBrnchEmpRel findOneByBrnchSeqAndCrntRecFlg(long brnchSeq, boolean crntFlg);

	

}

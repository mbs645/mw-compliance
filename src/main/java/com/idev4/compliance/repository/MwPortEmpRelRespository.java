package com.idev4.compliance.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwPortEmpRel;

@SuppressWarnings("unused")
@Repository
public interface MwPortEmpRelRespository  extends JpaRepository< MwPortEmpRel , Long>{
	
	public List< MwPortEmpRel > findAllByEmpSeqAndCrntRecFlg(long empSeq,boolean crntFlg);
	
//	public List<MwPortEmpRel> findAllByEmpSeqAndPortSeqAndCrntRecFlg(long empSeq,long portSeq, boolean crntFlg);
	
	public MwPortEmpRel findOneByPortSeqAndCrntRecFlg(long portSeq, boolean crntFlg);

	

}
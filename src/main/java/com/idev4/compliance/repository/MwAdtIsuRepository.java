package com.idev4.compliance.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwAdtIsu;

@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtIsuRepository extends JpaRepository< MwAdtIsu, Long >{
	public List< MwAdtIsu > findAllByAdtIsuSeqAndCrntRecFlg(long adtIsuSeq,boolean crntFlg);
	public List< MwAdtIsu > findAllByCrntRecFlg(boolean crntFlg);


}

package com.idev4.compliance.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwAdtCtgry;
@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtCtgryRepository  extends JpaRepository< MwAdtCtgry, Long >{
	public List< MwAdtCtgry > findAllByAdtCtgrySeqAndCrntRecFlg(long adtCtgrySeq,boolean crntFlg);
	public List< MwAdtCtgry > findAllByCrntRecFlg(boolean crntFlg);

}

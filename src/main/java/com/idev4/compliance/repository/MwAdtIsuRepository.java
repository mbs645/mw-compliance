package com.idev4.compliance.repository;

import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwAdtIsu;
import com.idev4.compliance.domain.MwQst;

@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtIsuRepository extends JpaRepository< MwAdtIsu, Long >{
	public List< MwAdtIsu > findAllBySbCtgrySeqAndCrntRecFlg(long adtIsuSeq,boolean crntFlg);
	public MwAdtIsu findAllByAdtIsuSeqAndCrntRecFlg(long adtIsuSeq,boolean crntFlg);

	public List< MwAdtIsu > findAllByCrntRecFlg(boolean crntFlg);
    public List< MwAdtIsu > findAllByLastUpdDtAfterAndCrntRecFlgOrLastUpdDtAfterAndDelFlg( Instant date, boolean crntRecFlg, Instant ldate,boolean delFlg );


}

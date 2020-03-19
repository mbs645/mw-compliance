package com.idev4.compliance.repository;

import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwAdtIsu;
import com.idev4.compliance.domain.MwAdtSbCtgry;

@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtSbCtgryRepository extends JpaRepository< MwAdtSbCtgry, Long >{
	
	public List< MwAdtSbCtgry > findAllBySbCtgrySeqAndCrntRecFlg(long sbCtgrySeq,boolean crntFlg);
	public List< MwAdtSbCtgry > findAllByCrntRecFlg(boolean crntFlg);
    public List< MwAdtSbCtgry > findAllByLastUpdDtAfterAndCrntRecFlgOrLastUpdDtAfterAndDelFlg( Instant date, boolean crntRecFlg, Instant ldate,boolean delFlg );


}

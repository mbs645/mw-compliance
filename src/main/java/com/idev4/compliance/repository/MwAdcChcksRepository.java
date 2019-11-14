package com.idev4.compliance.repository;

import com.idev4.compliance.domain.MwAdcChcks;

@SuppressWarnings ( "unused" )
@Repository
public interface MwAdcChcksRepository extends JpaRepository< MwAdcChcks, Long > {
	
    public MwAdcChcks findOneByCrntRecFlg(boolean flag );
    public MwAdcChcks findOneByAdcChksSeqAndCrntRecFlg(Long adc_seq,boolean flg)


}

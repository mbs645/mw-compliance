package com.idev4.compliance.repository;

import com.idev4.compliance.domain.MwAdcChckQstnr;

@SuppressWarnings ( "unused" )
@Repository
public interface MwAdcChckQstnrRepository extends JpaRepository< MwAdcChckQstnr, Long > {
	
    public MwAdcChckQstnr findOneByCrntRecFlg(boolean flag );
}

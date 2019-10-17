package com.idev4.compliance.repository;

import java.util.List;

import com.idev4.compliance.domain.MwDvcRgstr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@SuppressWarnings("unused")
@Repository
public interface MwDvcRgstrRepository extends JpaRepository< MwDvcRgstr , Long>{
	
	public  List<MwDvcRgstr> findAllByEntyTypFlgAndCrntRecFlgAndDelFlg(int entyFlg,boolean crntFlg,boolean delFlg);
	public  MwDvcRgstr findOneByDvcAddrAndCrntRecFlgAndDelFlg(String addr,boolean crntFlg,boolean delFlg);
//	public  List<String> findAllByEntyTypFlgAndCrntRecFlgAndDelFlg(int entyFlg,boolean crntFlg,boolean delFlg);

	public List<MwDvcRgstr> findAllByCrntRecFlgAndDelFlg(boolean crntFlg,boolean delFlg);


}

package com.idev4.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.admin.domain.MwDthRpt;

@Repository
public interface  MwDthRptRepository extends JpaRepository< MwDthRpt, Long >{
	


}

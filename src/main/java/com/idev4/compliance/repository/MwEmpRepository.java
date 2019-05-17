
package com.idev4.compliance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwEmp;

/**
 * Spring Data JPA repository for the MwEmp entity.
 */
@SuppressWarnings ( "unused" )
@Repository
public interface MwEmpRepository extends JpaRepository< MwEmp, Long > {

    public List< MwEmp > findAllByEmpNmContaining( String chars );

    public MwEmp findOneByEmpNmContaining( String chars );

    public MwEmp findOneByEmpSeq( Long seq );
    
    public MwEmp findOneByEmpLanId(String lanId);
}

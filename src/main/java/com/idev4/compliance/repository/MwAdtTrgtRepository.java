
package com.idev4.compliance.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idev4.compliance.domain.MwAdtTrgt;

/**
 * Spring Data JPA repository for the MwAnswr entity.
 */
@SuppressWarnings ( "unused" )
@Repository
public interface MwAdtTrgtRepository extends JpaRepository< MwAdtTrgt, Long > {

}

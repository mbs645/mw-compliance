
package com.idev4.admin.service;

import java.util.Map;

import javax.ws.rs.core.HttpHeaders;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient ( name = "recoverydisbursementservice", url = "http://localhost:8080/recoverydisbursementservice" )
public interface ServiceClient {

    @RequestMapping ( value = "/api/death-adjustment-advance/{id}" )
    ResponseEntity< Map > reverseAdvanceRecoveries( @PathVariable ( value = "id" ) Long id,
            @RequestHeader ( HttpHeaders.AUTHORIZATION ) String token );

}
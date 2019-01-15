
package com.idev4.admin.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.idev4.admin.dto.LoanServingDTO;
import com.idev4.admin.service.MwClntService;

@RestController
@RequestMapping ( "/api" )
public class ClientController {

    @Autowired
    MwClntService mwClntService;

    @CrossOrigin
    @GetMapping ( "/all-active-clnts/{id}" )
    @Timed
    public ResponseEntity< List< LoanServingDTO > > allActiveClnts( @PathVariable String id ) {
        return new ResponseEntity<>( mwClntService.getAllActiveClint( id ), HttpStatus.OK );
    }

}

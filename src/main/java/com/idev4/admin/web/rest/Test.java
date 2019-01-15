
package com.idev4.admin.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.idev4.admin.web.rest.util.HeaderUtil;

@RestController
@RequestMapping ( "/api" )
public class Test {

    @GetMapping ( "/hello" )
    public ResponseEntity< String > sayHello( @RequestParam ( "username" ) String username ) {

        return ResponseEntity.ok().headers( HeaderUtil.createEntityUpdateAlert( "Test", "Hello Mr/Mrs " + username ) )
                .body( "Hello World" );
    }

    @GetMapping ( "/test" )
    public String test() {

        return "Admin Service";
    }
}

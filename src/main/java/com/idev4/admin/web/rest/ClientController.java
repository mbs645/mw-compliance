
package com.idev4.admin.web.rest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.idev4.admin.domain.MwBrnchClsng;
import com.idev4.admin.dto.LoanServingDTO;
import com.idev4.admin.repository.MwBrnchClsngRepository;
import com.idev4.admin.service.MwClntService;

@RestController
@RequestMapping ( "/api" )
public class ClientController {

    @Autowired
    MwClntService mwClntService;

    @Autowired
    MwBrnchClsngRepository mwBrnchClsngRepository;

    @CrossOrigin
    @GetMapping ( "/all-active-clnts/{id}" )
    @Timed
    public ResponseEntity< List< LoanServingDTO > > allActiveClnts( @PathVariable String id ) {
        return new ResponseEntity<>( mwClntService.getAllActiveClint( id ), HttpStatus.OK );
    }

    @GetMapping ( "/close-branch/{id}" )
    @Timed
    public ResponseEntity< List< Screen > > closeBranch( @PathVariable Long id ) {
        MwBrnchClsng clsng = mwBrnchClsngRepository.findOneByBrnchSeqAndBrnchOpnFlg( id, true );
        List< Screen > screens = new ArrayList< Screen >();
        if ( clsng == null ) {
            return new ResponseEntity<>( null, HttpStatus.BAD_REQUEST );
        }
        clsng.setBrnchClsdDt( LocalDateTime.from( LocalDateTime.now( ZoneId.of( "Asia/Karachi" ) ) ) );
        clsng.setBrnchOpnFlg( false );
        clsng.setBrnchClsdBy( SecurityContextHolder.getContext().getAuthentication().getName() );
        mwBrnchClsngRepository.save( clsng );
        screens.add( new Screen( "Home", "dashboard/bm", true, true, true ) );
        screens.add( new Screen( "Process Applications", "loan-origination", true, true, true ) );
        screens.add( new Screen( "Reports", "reports", true, true, true ) );
        return new ResponseEntity<>( screens, HttpStatus.OK );
    }

    public class Screen {

        public String name;

        public String url;

        public boolean readFlag;

        public boolean writeFlag;

        public boolean deleteFlag;

        public String getName() {
            return name;
        }

        public Screen() {
            super();
        }

        public Screen( String name, String url, boolean readFlag, boolean writeFlag, boolean deleteFlag ) {
            super();
            this.name = name;
            this.url = url;
            this.readFlag = readFlag;
            this.writeFlag = writeFlag;
            this.deleteFlag = deleteFlag;
        }

        public void setName( String name ) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl( String url ) {
            this.url = url;
        }

        public boolean isReadFlag() {
            return readFlag;
        }

        public void setReadFlag( boolean readFlag ) {
            this.readFlag = readFlag;
        }

        public boolean isWriteFlag() {
            return writeFlag;
        }

        public void setWriteFlag( boolean writeFlag ) {
            this.writeFlag = writeFlag;
        }

        public boolean isDeleteFlag() {
            return deleteFlag;
        }

        public void setDeleteFlag( boolean deleteFlag ) {
            this.deleteFlag = deleteFlag;
        }

    }

}

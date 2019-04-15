
package com.idev4.admin.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Utils {

    public Instant parseStringDateToInstant( String input ) {
        Date date = null;
        try {
            date = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" ).parse( input );
        } catch ( ParseException e ) {
            System.out.println( e );
        }
        return date.toInstant();
    }

    public Date parseStringDateToDate( String input ) {
        Date date = null;
        try {
            date = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" ).parse( input );
        } catch ( ParseException e ) {
            System.out.println( e );
        }
        return date;
    }
}

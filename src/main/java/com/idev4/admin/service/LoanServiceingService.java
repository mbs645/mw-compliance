package com.idev4.admin.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idev4.admin.domain.MwDthRpt;
import com.idev4.admin.dto.ReportDeathDTO;
import com.idev4.admin.repository.MwDthRptRepository;
import com.idev4.admin.web.rest.util.SequenceFinder;
import com.idev4.admin.web.rest.util.Sequences;


@Service
public class LoanServiceingService {
	@Autowired
	MwDthRptRepository mwDthRptRepository;

public long addMwDthRpt(ReportDeathDTO dr,String user) {
	long seq=SequenceFinder.findNextVal( Sequences.DTH_RPT_SEQ );
	MwDthRpt entity=new MwDthRpt();
	Instant now=Instant.now();
	entity.setDthRptSeq(seq);
	entity.setClntSeq(dr.clntSeq);
	entity.setEffStartDt(now);
	entity.setClntNomFlg(dr.gender);
	entity.setDtOfDth(parseStringDate( dr.deathDt));
	entity.setCauseOfDth(dr.dethCase);
	entity.setDthCertNum(dr.deathcertf);
	entity.setCrtdBy(user);
	entity.setCrtdDt(now);
	entity.setLastUpdBy(user);
	entity.setLastUpdDt(now);
	entity.setDelFlg(false);
	entity.setCrntRecFlg(true);
	
	return mwDthRptRepository.save(entity).getDthRptSeq();	
	
}

private Instant parseStringDate(String input) {
	 Date date = null;
     try {
         date = new SimpleDateFormat( "dd/MM/yyyy" ).parse( input );
     } catch ( ParseException e ) {

     }
     return date.toInstant();
}

}

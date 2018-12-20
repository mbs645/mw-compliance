package com.idev4.admin.web.rest.util;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SequenceFinder {

	private static EntityManager em;
	
	public SequenceFinder(EntityManager em) {
		SequenceFinder.em = em;
	}
	
	public static long findNextVal(String sequence) {
		System.out.println("select "+ sequence +".nextval from dual");
		Query q = em.createNativeQuery("select "+ sequence +".nextval from dual");
		long seq = Long.valueOf(q.getSingleResult().toString());
		System.out.println("Sequence found is: " + seq);
		return seq;
	}
}

package com.idev4.compliance.ids;


import java.io.Serializable;
import java.time.Instant;

/**
 * A MwEmp.
 */

public class MwEmpId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long empSeq;

	private Instant effStartDt;
}

package com.cts.audit.model;

import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author Jayasurya
 *A bean class to bind AuditBenchMark data
 */
@ToString
@Component
@NoArgsConstructor
@Data
@AllArgsConstructor
public class AuditBenchMark {
	
	private String auditType;
	private int benchmarkNoAnswers;

}


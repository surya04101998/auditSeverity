package com.cts.audit.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Component
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AuditResponse {
	
	
	private String projectExecutionStatus;
	private String remedialActionDuration;
	private long auditId;



}

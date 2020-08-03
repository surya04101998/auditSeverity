package com.cts.audit.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.audit.model.AuditRequest;
import com.cts.audit.model.AuditResponse;
import com.cts.audit.services.SeverityService;
/** This is the rest Controller
 *  For mapping HTTP requests **/
@RestController
public class AuditSeverityController {
	
	/**
	 * This provides object of SeverityService
	 */
	@Autowired
	private SeverityService service;           
	/**
	 * 
	 */
	protected AuditSeverityController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param auditRequest
	 * @param token
	 * @return
	 */
	@PostMapping("/ProjectExecutionStatus")
	public AuditResponse auditSeverityCheck(@RequestBody final AuditRequest auditRequest,@RequestHeader("Authorization") final String token) {
	return service.generateAuditResponse(auditRequest, token);
	}
}

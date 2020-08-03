package com.cts.audit.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.audit.exception.FeignServiceException;
import com.cts.audit.exception.RequestInvalidException;
import com.cts.audit.exception.TokenInvalidException;
import com.cts.audit.feigns.BenchMarkFeign;
import com.cts.audit.feigns.SecurityFeign;
import com.cts.audit.model.AuditBenchMark;
import com.cts.audit.model.AuditDetail;
import com.cts.audit.model.AuditRequest;
import com.cts.audit.model.AuditResponse;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class SeverityService  { /* A Service class for handling logic */
	static Long lastAuditId=(long)0;
	@Autowired
	private BenchMarkFeign benchMarkServ;

	@Autowired
	SecurityFeign securityServ;
	private static final String INVALIDMESSAGE = "Invalid_JWT_token";  
	private static final String INVALIDREQUEST = "Invalid_REQUEST_values";  
	private static final String FEIGNSERVICEDOWN="One of the services which has been integrated, is down";
	public SeverityService() {
		super();
	}

	public AuditResponse performSeverityCheck(AuditRequest auditRequest,String token) {
			log.debug("request input= "+auditRequest);
			AuditDetail auditDetail=auditRequest.getAuditDetail();
			List<String> auditQuestions= auditDetail.getAuditQuestions();
			int numberOfNo= auditQuestions.size();
			String auditType=auditDetail.getAuditType();
			List<AuditBenchMark> benchMarkList= fetchBenchMarks(token);
			Integer benchMarkForThisCase=0;
			for(AuditBenchMark benchMark:benchMarkList) {
				if(benchMark.getAuditType().equalsIgnoreCase(auditType)) {
					benchMarkForThisCase=benchMark.getBenchmarkNoAnswers();
				}
			}
			AuditResponse auditResponse= generateUniqueAuditResponse();
		  if(auditType.equalsIgnoreCase("Internal")) {
			  if(numberOfNo<benchMarkForThisCase) {
				  auditResponse.setProjectExecutionStatus("Green");
				  auditResponse.setRemedialActionDuration("No action needed"); }
			  else {
					  auditResponse.setProjectExecutionStatus("RED");
					  auditResponse.setRemedialActionDuration("Action to be taken in 2 weeks"); }
		  	}else 
		  		if(auditType.equalsIgnoreCase("SOX")){
		  			{ 
		  			if(numberOfNo<benchMarkForThisCase) {
		  				auditResponse.setProjectExecutionStatus("Green");
		  				auditResponse.setRemedialActionDuration("No action needed"); }
		  			else {
		  				auditResponse.setProjectExecutionStatus("RED");
		  				auditResponse.setRemedialActionDuration("Action to be taken in 1 week"); } }
		  		}
		  		else throw new RequestInvalidException(INVALIDREQUEST);
		 log.debug("Response output= "+auditResponse); 			
		 return auditResponse;
	}

	
	public Boolean performSecurityCheck(String token) {
		
		if(!checkAuthenticity(token)) {
			log.info("Token is invalid");
			throw new TokenInvalidException(INVALIDMESSAGE);
		}
		else {
			log.info("Token validated");
			return true;
		}
		
	}
	public Boolean checkAuthenticity(String token) {
		Boolean response=false;
		try {
			response=securityServ.validateToken(token);
		}catch (FeignException e) {
			log.error(FEIGNSERVICEDOWN);
			throw new FeignServiceException(424, e.getMessage());
		}
		return response;
	}
	
	public AuditResponse generateAuditResponse(final AuditRequest auditRequest,final String token) {
		AuditResponse auditResponse=null;
			performSecurityCheck(token);
			auditResponse=performSeverityCheck(auditRequest,token);
		log.info("Repsonse is successfully generated");
		return auditResponse;
	}
	
	public List<AuditBenchMark> fetchBenchMarks(String token){
		List<AuditBenchMark> list=null;
		try {
			list=benchMarkServ.getAuditBenchmark(token);
			log.info("BenchMark details fetched successfully");
		}catch (FeignException e) {
			throw new FeignServiceException(e.status(), e.getMessage());
		}
		return list;
	}
	
	public AuditResponse generateUniqueAuditResponse(){
		AuditResponse auditResponse=new AuditResponse();
		auditResponse.setAuditId(++lastAuditId);
		return auditResponse;
	}
	
	
	
	
}

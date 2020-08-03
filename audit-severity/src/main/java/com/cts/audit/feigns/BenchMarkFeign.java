package com.cts.audit.feigns;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.audit.model.AuditBenchMark;
/**
 * 
 * @author Jayasurya
 *	Feign class for serving AuditBenchMark microservices API's
 */
@FeignClient(name="audit-benchmark-service",url="http://localhost:8010")
public interface BenchMarkFeign {
	/**
	 * 
	 * @param authorization
	 * @return List of AuditBenchMark objects
	 */
	@GetMapping("/AuditBenchmark")
	List<AuditBenchMark> getAuditBenchmark(@RequestHeader("Authorization") String authorization);	
	
}

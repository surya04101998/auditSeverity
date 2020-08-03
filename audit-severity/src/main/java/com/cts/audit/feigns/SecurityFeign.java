package com.cts.audit.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * 
 * @author Jayasurya
 *Feign service to access AuthenticationService microservice's API's
 */
@FeignClient(name="authentication-service",url = "http://localhost:8900")
public interface SecurityFeign {
	/**
	 * 
	 * @param token
	 * @return boolean value of Authenticity of the token
	 */
	@PostMapping("/validate")
	Boolean validateToken(@RequestHeader("Authorization") String token);
}

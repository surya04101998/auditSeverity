package com.cts.audit;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



/** Microservice to find AuditSeverity**/
@EnableFeignClients("com.cts")
@SpringBootApplication
public class AuditSeverityApplication {
/**
 * 
 * 
 * 
 * @param args
 */
	
	public static void main(final String[] args) {
		SpringApplication.run(AuditSeverityApplication.class, args);
	}

public AuditSeverityApplication() {
	super();
	// TODO Auto-generated constructor stub
}

}

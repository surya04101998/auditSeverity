package com.cts.audit.exception;


import java.util.Date;

import feign.FeignException;
/**
 * 
 * @author Jayasurya
 * This exception handler exposes inability of other microservices to communicate
 */
public class FeignServiceException extends FeignException{
	private static final long serialVersionUID = 1L;
	private int status=424;
	private String error="Service down";
	private String message="Service is down,please try again later";
	private Date timestamp=new Date();
	
	@Override
	public String toString() {
		return "FeignServiceException [status=" + status + ", error=" + error + ", message=" + message + ", timestamp="
				+ timestamp + "]";
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * 
	 * @param status
	 * @param message
	 */
	public FeignServiceException(int status, String message) {
		super(status, message);
		// TODO Auto-generated constructor stub
	}

	
	
	
}

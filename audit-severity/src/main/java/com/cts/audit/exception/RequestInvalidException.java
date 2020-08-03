package com.cts.audit.exception;


/**
 * 
 * @author Jayasurya
 * This exception handler helps to send response to invalid unauthorized requests
 */
public class RequestInvalidException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	/**
	 * @param msg
	 */
	public RequestInvalidException(final String msg) {
		super(msg);
	}
}

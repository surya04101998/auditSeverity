package com.cts.audit.exception;


/**
 * 
 * @author Jayasurya
 * This exception handler helps to send response to invalid unauthorized requests based on token
 */
public class TokenInvalidException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param msg
	 */
	public TokenInvalidException(final String msg) {
		super(msg);
	}
}

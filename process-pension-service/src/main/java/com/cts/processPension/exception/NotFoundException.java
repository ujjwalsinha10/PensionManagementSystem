package com.cts.processPension.exception;

/**
 * NotFoundException when details are incorrect
 * 
 *  @author Ujjwal Sinha
 *  @author 857152
 *
 */
public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 2142151L;

	public NotFoundException(String msg) {
		super(msg);
	}
}
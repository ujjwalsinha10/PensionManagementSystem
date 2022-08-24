package com.cts.disbursepension.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This class is used by global exception handler to send error response
 * 
 *  @author Ujjwal Sinha
 *  @author 857152
 *
 */
@Getter
@AllArgsConstructor
public class ErrorResponseNoFieldErrors {
	private LocalDateTime timestamp;
	private String message;
	
	
	public ErrorResponseNoFieldErrors(String message) {
		this.timestamp = LocalDateTime.now();
		this.message = message;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	

}

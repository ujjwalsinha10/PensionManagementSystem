package com.cts.processPension.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class for customizing error response in exception handler
 * 
 *  @author Ujjwal Sinha
 *  @author 857152
 *
 */
@Getter
@Setter
//@NoArgsConstructor
public class ErrorResponse {

	private String message;
	private LocalDateTime timestamp;

	public ErrorResponse(String message) {
		this.timestamp = LocalDateTime.now();
		this.message = message;
	}

	/**
	 * Used only for input validation errors
	 */
	@JsonInclude(Include.NON_NULL)
	private List<String> fieldErrors;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public List<String> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<String> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
	public ErrorResponse() {
		
	}

	public ErrorResponse(String message, LocalDateTime timestamp, List<String> fieldErrors) {
	
		this.message = message;
		this.timestamp = timestamp;
		this.fieldErrors = fieldErrors;
	}
	
}

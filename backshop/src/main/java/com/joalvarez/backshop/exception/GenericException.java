package com.joalvarez.backshop.exception;

import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException {

	private HttpStatus httpStatus;
	private InternalCode internalCode;
	private LogLevel logLevel;

	public GenericException(final HttpStatus httpStatus, final InternalCode internalCode, final LogLevel logLevel,
							final String message) {
		super(message);
		this.httpStatus = httpStatus;
		this.internalCode = internalCode;
		this.logLevel = logLevel;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public InternalCode getInternalCode() {
		return internalCode;
	}

	public void setInternalCode(InternalCode internalCode) {
		this.internalCode = internalCode;
	}

	public LogLevel getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(LogLevel logLevel) {
		this.logLevel = logLevel;
	}
}
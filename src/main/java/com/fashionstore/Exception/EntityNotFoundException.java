package com.fashionstore.Exception;

public class EntityNotFoundException extends RuntimeException {
	
	private String errorCode;
	private String errorDescription;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public EntityNotFoundException(String errorCode, String errorDescription) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
	public EntityNotFoundException() {
	
	}
	
	
	
	

}

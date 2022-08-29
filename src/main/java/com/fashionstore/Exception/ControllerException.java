package com.fashionstore.Exception;

public class ControllerException  extends RuntimeException{
	
	private String errorCode;
	private String errorDescription;
	
	public String getErrorCodeString() {
		return errorCode;
	}
	public void setErrorCodeString(String errorCodeString) {
		this.errorCode = errorCodeString;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
	public ControllerException(String errorCodeString, String errorDescription) {
		super();
		this.errorCode = errorCodeString;
		this.errorDescription = errorDescription;
	}
	
	public ControllerException() {
		
	}
}



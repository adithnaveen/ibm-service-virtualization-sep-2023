package com.ibm.businesslogic;

public class NameInvalidException extends RuntimeException {
	private String message; 
	
	public NameInvalidException() {
		this.message = "Sorry Invalid Name"; 
	}
	
	public NameInvalidException(String message) {
		this.message = message; 
	}

	@Override
	public String toString() {
		return "NameInvalidException [message=" + message + "]";
	}

	@Override
	public String getMessage() {
		return this.message; 
	}
	
	
}

package com.htc.springjpausinghibernate.exceptions;

public class StudentNotFoundException extends Exception {
	private String errorMsg;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public StudentNotFoundException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "StudentNotFoundException [errorMsg=" + errorMsg + "]";
	}
	

}
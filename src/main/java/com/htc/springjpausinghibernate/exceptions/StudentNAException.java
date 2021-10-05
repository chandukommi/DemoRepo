package com.htc.springjpausinghibernate.exceptions;

public class StudentNAException extends Exception {
	private String errorMsg;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public StudentNAException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "StudentNAException [errorMsg=" + errorMsg + "]";
	}

	public StudentNAException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentNAException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public StudentNAException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StudentNAException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}

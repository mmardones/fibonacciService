package com.matias.testrestservice.error;

public class FibonacciException extends Exception {
	
	protected int responseStatusCode;

	public FibonacciException(String message) {
	    super(message);
	    this.responseStatusCode = 400;   
	}

	public int getResponseStatusCode() {
		return responseStatusCode;
	}

	public void setResponseStatusCode(int responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}
	
	
}





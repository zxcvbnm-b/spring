package com.test.utils;
public class MyException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MyException() {
		super();
	}
	public MyException(String message, Throwable cause) {
		super(message, cause);
	}
	public MyException(String message) {
		super(message);
	}
	public MyException(Throwable cause) {
		super(cause);
	}

}

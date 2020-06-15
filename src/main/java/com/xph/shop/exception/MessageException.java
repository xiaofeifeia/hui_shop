package com.xph.shop.exception;

import com.xph.shop.vo.StatusCode;

public class MessageException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	private int status = StatusCode.ERROR.getStatus();

	public MessageException(String message) {
		this.message = message;
	}

	public MessageException(String message, Throwable e) {
		super(message, e);
		this.message = message;
	}

	public MessageException(int status, String message) {
		super(message);
		this.message = message;
		this.status = status;
	}

	public MessageException(int status, String message, Throwable e) {
		super(message, e);
		this.message = message;
		this.status = status;
	}

	public MessageException(StatusCode sc) {
		this.message = sc.getMessage();
		this.status = sc.getStatus();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}

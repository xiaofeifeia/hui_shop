package com.xph.shop.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 描述
 *
 * @author 三国的包子
 * @version 1.0
 * @package entity *
 * @since 1.0
 */
@Data
public class Result implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer code;// 返回码
	private String message;// 返回消息
	private Object data;// 返回数据

	public Result() {
		super();
	}

	public Result(Integer code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Result(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Result(StatusCode statusCode) {
		this.code = statusCode.getStatus();
		this.message = statusCode.getMessage();
	}

	public Result(StatusCode statusCode, Object data) {
		this.code = statusCode.getStatus();
		this.message = statusCode.getMessage();
		this.data = data;
	}

	public static Result build(Integer code, String message, Object data) {
		return new Result(code, message, data);
	}

	public static Result build(StatusCode statusCode, Object data) {
		return new Result(statusCode, data);
	}

	public static Result build(Object data) {
		return new Result(StatusCode.SUCCESS, data);
	}

	public static Result success() {
		return new Result(StatusCode.SUCCESS);
	}

	public static Result success(String message) {
		Result result = new Result(StatusCode.SUCCESS);
		result.setMessage(message);
		return result;
	}
	
	public static Result error() {
		return new Result(StatusCode.ERROR);
	}

	public static Result error(String message) {
		Result result = new Result(StatusCode.ERROR);
		result.setMessage(message);
		return result;
	}
	
	public static Result error(StatusCode statusCode) {
		return  new Result(statusCode);
	}

}

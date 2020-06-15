package com.xph.shop.exception;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.xph.shop.vo.Result;

@RestControllerAdvice
public class MessageExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(MessageExceptionHandler.class);

	@ExceptionHandler({ Exception.class })
	public Result handle(Exception e, HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
			sb.append("\n*** [request param] ");
			sb.append(entry.getKey());
			sb.append(" = ");
			sb.append(String.join(",", entry.getValue()));
		}
		logger.error(StringUtils.EMPTY + "\n*** url = {" + request.getRequestURL() + "}" + "{" + sb.toString() + "}", e);
		return Result.error(e.getMessage());
	}
}

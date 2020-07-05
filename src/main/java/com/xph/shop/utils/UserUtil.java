package com.xph.shop.utils;

import io.jsonwebtoken.Claims;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.xph.shop.entity.User;
import com.xph.shop.exception.MessageException;
import com.xph.shop.vo.StatusCode;

public class UserUtil {

	/**
	 * @return
	 */
	public static User getLoginUser() {

		try {
			ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpServletRequest request = servletRequestAttributes.getRequest();
			Cookie[] cookies = request.getCookies();
			for (Cookie c : cookies) {
				if (c.getName().equals(Constants.Authorization)) {
					String value = c.getValue();
					Claims claims = JwtUtil.parseJWT(value);
					return JSON.parseObject(claims.getSubject(), User.class);
				}
			}
			throw new MessageException(StatusCode.USER_NOT_LOGIN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MessageException(StatusCode.USER_LOGIN_INFO_ERROR);
		}
	}
}

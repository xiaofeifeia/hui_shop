package com.xph.shop.utils;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public class Constants {

	public static final String uuid=UUID.randomUUID().toString().replaceAll("-",StringUtils.EMPTY);
	public static final String Authorization="Authorization";
	public static final String INIT_PASSWORD="123456";
}

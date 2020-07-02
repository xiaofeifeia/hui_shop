package com.xph.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xph.shop.vo.IdWorker;

@Configuration
public class ShopConfig {

	private static final int workId = 1;
	private static final int datacenterId = 1;

	@Bean
	public IdWorker idWorker() {
		return new IdWorker(workId, datacenterId);
	}
}

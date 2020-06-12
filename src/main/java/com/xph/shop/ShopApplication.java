package com.xph.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.xph.shop.dao")
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
@EnableScheduling
@EnableTransactionManagement
@EnableFeignClients
public class ShopApplication {

	public static void main(String[] args) {
		System.setProperty("nacos.standalone", "true");
		SpringApplication.run(ShopApplication.class, args);
	}
}

package com.xph.shop.vo;

import lombok.Data;

import com.xph.shop.entity.Sku;

@Data
public class SkuVo extends Sku{

	private String spuName;
	
	private String brandName;
}

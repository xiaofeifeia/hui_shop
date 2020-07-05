package com.xph.shop.vo;

import java.util.List;

import lombok.Data;

import com.xph.shop.entity.Sku;

@Data
public class Goods {

	private SpuVo spu;
	
	private List<Sku> skus;
}

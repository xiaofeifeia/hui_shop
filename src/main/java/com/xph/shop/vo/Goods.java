package com.xph.shop.vo;

import java.util.List;

import lombok.Data;

import com.xph.shop.entity.Sku;
import com.xph.shop.entity.Spu;

@Data
public class Goods {

	private Spu spu;
	
	private List<Sku> skus;
}

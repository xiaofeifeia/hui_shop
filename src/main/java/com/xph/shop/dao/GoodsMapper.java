package com.xph.shop.dao;

import java.util.List;

import com.xph.shop.entity.Sku;
import com.xph.shop.entity.Spu;
import com.xph.shop.vo.GoodsEs;
import com.xph.shop.vo.SkuVo;
import com.xph.shop.vo.SpuVo;

public interface GoodsMapper {

	public List<SpuVo> findSpuPage(Spu spu);
	
	public List<SkuVo> findSkuPage(Sku sku);
	
	public List<GoodsEs> getGoodsList();
}

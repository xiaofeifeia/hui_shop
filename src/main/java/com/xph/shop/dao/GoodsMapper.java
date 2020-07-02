package com.xph.shop.dao;

import java.util.List;

import com.xph.shop.vo.SkuVo;

public interface GoodsMapper {

	public List<SkuVo> findPage(SkuVo skuVo);
}

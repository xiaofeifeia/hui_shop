package com.xph.shop.dao;

import java.util.List;

import com.xph.shop.entity.Spu;
import com.xph.shop.vo.SpuVo;

public interface GoodsMapper {

	public List<SpuVo> findPage(Spu spu);
}

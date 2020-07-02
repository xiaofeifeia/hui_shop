package com.xph.shop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xph.shop.vo.Goods;
import com.xph.shop.vo.SkuVo;

public interface GoodsService {

	/**
	 * 创建商品
	 * 
	 * @param goods
	 */
	public void create(Goods goods);

	/**
	 * sku商品信息
	 * 
	 * @param skuVo
	 * @param page
	 * @param size
	 * @return
	 */
	public PageInfo<SkuVo> findPage(SkuVo skuVo, int page, int size);

	/**
	 * 更新状态
	 * @param id
	 * @param status
	 */
	public void updateStatus(String id, String status);
	
	/**
	 * 更新状态
	 * @param ids
	 * @param status
	 */
	public void updateStatus(List<String> ids, String status);
}

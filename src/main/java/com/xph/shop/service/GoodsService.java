package com.xph.shop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xph.shop.vo.Goods;
import com.xph.shop.vo.GoodsEs;
import com.xph.shop.vo.SpuVo;

public interface GoodsService {

	/**
	 * 创建修改商品
	 * 
	 * @param goods
	 */
	public void createOrUpdate(Goods goods);

	/**
	 * sku商品信息
	 * 
	 * @param skuVo
	 * @param page
	 * @param size
	 * @return
	 */
	public PageInfo<SpuVo> findPage(SpuVo spuVo, int page, int size);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void deleteGoods(String id);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	public void deleteGoodsList(List<String> ids);

	/**
	 * 上架下架
	 * 
	 * @param id
	 * @param isMarketable
	 */
	public void setMarketable(String id, String isMarketable);

	/**
	 * 审核
	 * 
	 * @param id
	 * @param auditStatus
	 */
	public void audit(String id, Integer auditStatus, String auditInfo);

	/**
	 * 获取商品信息
	 * 
	 * @param id
	 * @return
	 */
	public Goods getGoodsInfo(String id);
	
	/**
	 * 获取商品列表
	 * @return
	 */
	public List<GoodsEs> getGoodsList();
}

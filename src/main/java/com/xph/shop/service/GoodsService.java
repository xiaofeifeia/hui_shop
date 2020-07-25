package com.xph.shop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xph.shop.entity.Sku;
import com.xph.shop.vo.Goods;
import com.xph.shop.vo.GoodsEs;
import com.xph.shop.vo.SkuVo;
import com.xph.shop.vo.SpuVo;

public interface GoodsService {

	/**
	 * 创建修改商品
	 * 
	 * @param goods
	 */
	public void createOrUpdate(Goods goods);

	/**
	 * spu商品信息
	 * 
	 * @param skuVo
	 * @param page
	 * @param size
	 * @return
	 */
	public PageInfo<SpuVo> findSpuPage(SpuVo spuVo, int page, int size);
	
	/**
	 * sku商品信息
	 * 
	 * @param skuVo
	 * @param page
	 * @param size
	 * @return
	 */
	public PageInfo<SkuVo> findSkuPage(SkuVo skuVo, int page, int size);

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

	/**
	 * 热门商品
	 * @param skuId
	 * @param isHot
	 */
	public void setHot(String skuId, boolean isHot);
	
	/**
	 * 新的商品
	 * @param skuId
	 * @param isNew
	 */
	public void setNew(String skuId, boolean isNew);
	
	/**
	 * 推荐商品
	 * @param skuId
	 * @param isRecommend
	 */
	public void setRecommend(String skuId, boolean isRecommend);
	
	public List<Sku> findHotGoods();
	
	public List<Sku> findNewGoods();
	
	public List<Sku> findRecommendGoods();
}

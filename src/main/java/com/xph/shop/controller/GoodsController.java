package com.xph.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.xph.shop.entity.Sku;
import com.xph.shop.entity.Spu;
import com.xph.shop.service.GoodsService;
import com.xph.shop.vo.Goods;
import com.xph.shop.vo.Result;
import com.xph.shop.vo.SkuVo;
import com.xph.shop.vo.SpuVo;

@RestController
@RequestMapping("/goods")
@CrossOrigin
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	/**
	 * Category分页条件搜索实现
	 * 
	 * @param category
	 * @param page
	 * @param size
	 * @return
	 */
	@PostMapping(value = "/findSpuPage/{page}/{size}")
	public Result findSpuPage(@RequestBody(required = false) SpuVo spuVo, @PathVariable int page, @PathVariable int size) {
		// 调用CategoryService实现分页条件查询Category
		PageInfo<SpuVo> pageInfo = goodsService.findSpuPage(spuVo, page, size);
		return Result.build(pageInfo);
	}

	/**
	 * Category分页条件搜索实现
	 * 
	 * @param category
	 * @param page
	 * @param size
	 * @return
	 */
	@PostMapping(value = "/findSkuPage/{page}/{size}")
	public Result findSkuPage(@RequestBody(required = false) SkuVo skuVo, @PathVariable int page, @PathVariable int size) {
		// 调用CategoryService实现分页条件查询Category
		PageInfo<SkuVo> pageInfo = goodsService.findSkuPage(skuVo, page, size);
		return Result.build(pageInfo);
	}

	/**
	 * 创建或者修改
	 * 
	 * @param json
	 * @return
	 */
	@PostMapping("createOrUpdate")
	public Result createOrUpdate(@RequestBody String json) {
		JSONObject jsobj = JSON.parseObject(json);
		String spuStr = jsobj.getString("spu");
		SpuVo spu = JSON.parseObject(spuStr, SpuVo.class);
		if (spu != null) {
			spu.setSpecItems(JSON.parseObject(spuStr).getString("specItems"));
			spu.setParaItems(JSON.parseObject(spuStr).getString("paraItems"));
		}
		String skusStr = jsobj.getString("skus");
		List<Sku> skus = JSON.parseArray(skusStr, Sku.class);
		JSONArray parseArray = JSON.parseArray(skusStr);
		if (skus != null && skus.size() > 0) {
			for (int i = 0; i < skus.size(); i++) {
				skus.get(i).setSpec(parseArray.getJSONObject(i).getString("spec"));
			}
		}
		Goods goods = new Goods();
		goods.setSpu(spu);
		goods.setSkus(skus);
		goodsService.createOrUpdate(goods);
		return Result.success();
	}

	/**
	 * 上架下架
	 * 
	 * @param id
	 * @param isMarketable
	 * @return
	 */
	@PostMapping("setMarketable/{id}")
	public Result setMarketable(@PathVariable String id, String isMarketable) {
		goodsService.setMarketable(id, isMarketable);
		return Result.success();
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("deleteGoods/{id}")
	public Result deleteGoods(@PathVariable String id) {
		goodsService.deleteGoods(id);
		return Result.success();
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@PostMapping("deleteGoodsList")
	public Result deleteGoodsList(@RequestBody List<String> ids) {
		goodsService.deleteGoodsList(ids);
		return Result.success();
	}

	/**
	 * 审核
	 * 
	 * @param id
	 * @param auditStatus
	 * @param auditInfo
	 * @return
	 */
	@PostMapping("audit")
	public Result audit(@RequestBody Spu spu) {
		goodsService.audit(spu.getId(), spu.getAuditStatus(), spu.getAuditInfo());
		return Result.success();
	}

	/**
	 * 获取商品详情
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("getGoodsInfo/{id}")
	public Result getGoodsInfo(@PathVariable String id) {
		Goods goods = goodsService.getGoodsInfo(id);
		return Result.build(goods);
	}

	/**
	 * 热门商品
	 * 
	 * @param id
	 * @param isHot
	 * @return
	 */
	@PostMapping("setHot/{skuId}")
	public Result setHot(@PathVariable String skuId, @RequestParam(defaultValue = "false") boolean isHot) {
		goodsService.setHot(skuId, isHot);
		return Result.success();
	}

	/**
	 * 新的商品
	 * 
	 * @param id
	 * @param isNew
	 * @return
	 */
	@PostMapping("setNew/{skuId}")
	public Result setNew(@PathVariable String skuId, @RequestParam(defaultValue = "false") boolean isNew) {
		goodsService.setNew(skuId, isNew);
		return Result.success();
	}

	/**
	 * 新的商品
	 * 
	 * @param id
	 * @param isRecommend
	 * @return
	 */
	@PostMapping("setRecommend/{skuId}")
	public Result setRecommend(@PathVariable String skuId, @RequestParam(defaultValue = "false") boolean isRecommend) {
		goodsService.setRecommend(skuId, isRecommend);
		return Result.success();
	}
}

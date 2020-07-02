package com.xph.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.xph.shop.service.GoodsService;
import com.xph.shop.vo.Goods;
import com.xph.shop.vo.Result;
import com.xph.shop.vo.SkuVo;

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
	@PostMapping(value = "/findPage/{page}/{size}")
	public Result findPage(@RequestBody(required = false) SkuVo skuVo,
			@PathVariable int page, @PathVariable int size) {
		// 调用CategoryService实现分页条件查询Category
		PageInfo<SkuVo> pageInfo = goodsService.findPage(skuVo, page, size);
		return Result.build(pageInfo);
	}

	@PostMapping("create")
	public Result create(@RequestBody Goods goods) {
		goodsService.create(goods);
		return Result.success();
	}

	@PostMapping("updateStatus/{id}")
	public Result updateStatus(@PathVariable String id, String status) {
		goodsService.updateStatus(id, status);
		return Result.success();
	}

	@PostMapping("deleteGoods/{id}")
	public Result deleteGoods(@PathVariable String id) {
		goodsService.updateStatus(id, "3");
		return Result.success();
	}

	@PostMapping("deleteGoodsList")
	public Result deleteGoodsList(@RequestBody List<String> ids) {
		goodsService.updateStatus(ids, "3");
		return Result.success();
	}
}

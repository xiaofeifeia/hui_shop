package com.xph.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.xph.shop.entity.Banner;
import com.xph.shop.service.BannerService;
import com.xph.shop.vo.Result;

/**
 * @Author:xph
 * @Description:
 */

@RestController
@RequestMapping("/banner")
@CrossOrigin
public class BannerController {

	@Autowired
	private BannerService bannerService;

	/**
	 * Banner分页条件搜索实现
	 * 
	 * @param banner
	 * @param page
	 * @param size
	 * @return
	 */
	@PostMapping(value = "/findPage/{page}/{size}")
	public Result findPage(@RequestBody(required = false) Banner banner,
			@PathVariable int page, @PathVariable int size) {
		// 调用BannerService实现分页条件查询Banner
		PageInfo<Banner> pageInfo = bannerService.findPage(banner, page, size);
		return Result.build(pageInfo);
	}

	/**
	 * 根据ID删除品牌数据
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping(value = "delete/{id}")
	public Result delete(@PathVariable Integer id) {
		// 调用BannerService实现根据主键删除
		bannerService.delete(id);
		return Result.success();
	}

	/**
	 * 修改Banner数据
	 * 
	 * @param banner
	 * @param id
	 * @return
	 */
	@PostMapping(value = "update")
	public Result update(@RequestBody Banner banner) {
		// 调用BannerService实现修改Banner
		bannerService.update(banner);
		return Result.success();
	}

	/**
	 * 新增Banner数据
	 * 
	 * @param banner
	 * @return
	 */
	@PostMapping("add")
	public Result add(@RequestBody Banner banner) {
		// 调用BannerService实现添加Banner
		bannerService.add(banner);
		return Result.success();
	}

	/**
	 * 根据ID查询Banner数据
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("findById/{id}")
	public Result findById(@PathVariable Integer id) {
		// 调用BannerService实现根据主键查询Banner
		Banner banner = bannerService.findById(id);
		return Result.build(banner);
	}

	/**
	 * 查询Banner全部数据
	 * 
	 * @return
	 */
	@GetMapping("findAll")
	public Result findAll() {
		// 调用BannerService实现查询所有Banner
		List<Banner> list = bannerService.findAll();
		return Result.build(list);
	}
}

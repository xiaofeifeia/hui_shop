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
import com.xph.shop.entity.Brand;
import com.xph.shop.service.BrandService;
import com.xph.shop.vo.Result;

/**
 * @Author:xph
 * @Description:
 */

@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController {

	@Autowired
	private BrandService brandService;

	/**
	 * Brand分页条件搜索实现
	 * 
	 * @param brand
	 * @param page
	 * @param size
	 * @return
	 */
	@PostMapping(value = "/findPage/{page}/{size}")
	public Result findPage(@RequestBody(required = false) Brand brand,
			@PathVariable int page, @PathVariable int size) {
		// 调用BrandService实现分页条件查询Brand
		PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
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
		// 调用BrandService实现根据主键删除
		brandService.delete(id);
		return Result.success();
	}

	/**
	 * 修改Brand数据
	 * 
	 * @param brand
	 * @param id
	 * @return
	 */
	@PostMapping(value = "update")
	public Result update(@RequestBody Brand brand) {
		// 调用BrandService实现修改Brand
		brandService.update(brand);
		return Result.success();
	}

	/**
	 * 新增Brand数据
	 * 
	 * @param brand
	 * @return
	 */
	@PostMapping("add")
	public Result add(@RequestBody Brand brand) {
		// 调用BrandService实现添加Brand
		brandService.add(brand);
		return Result.success();
	}

	/**
	 * 根据ID查询Brand数据
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("findById/{id}")
	public Result findById(@PathVariable Integer id) {
		// 调用BrandService实现根据主键查询Brand
		Brand brand = brandService.findById(id);
		return Result.build(brand);
	}

	/**
	 * 查询Brand全部数据
	 * 
	 * @return
	 */
	@GetMapping("findAll")
	public Result findAll() {
		// 调用BrandService实现查询所有Brand
		List<Brand> list = brandService.findAll();
		return Result.build(list);
	}
	
	/**
	 * 根据ID删除品牌数据
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping(value = "deleteBrands")
	public Result deleteBrands(@RequestBody List<Long> brandIds) {
		// 调用BrandService实现根据主键删除
		brandService.deleteBrands(brandIds);
		return Result.success();
	}

}

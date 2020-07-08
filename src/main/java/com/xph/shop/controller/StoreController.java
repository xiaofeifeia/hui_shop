package com.xph.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.xph.shop.entity.Store;
import com.xph.shop.service.StoreService;
import com.xph.shop.vo.Result;

/**
 * @Author:xph
 * @Description:
 */

@RestController
@RequestMapping("/store")
@CrossOrigin
public class StoreController {

	@Autowired
	private StoreService storeService;

	/**
	 * Store分页条件搜索实现
	 * 
	 * @param store
	 * @param page
	 * @param size
	 * @return
	 */
	@PostMapping(value = "/findPage/{page}/{size}")
	public Result findPage(@RequestBody(required = false) Store store,
			@PathVariable int page, @PathVariable int size) {
		// 调用StoreService实现分页条件查询Store
		PageInfo<Store> pageInfo = storeService.findPage(store, page, size);
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
		// 调用StoreService实现根据主键删除
		storeService.delete(id);
		return Result.success();
	}
	
	/**
	 * 根据ID删除品牌数据
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping(value = "deleteStores")
	public Result deleteStores( List<Integer> ids) {
		// 调用StoreService实现根据主键删除
		storeService.deleteStores(ids);
		return Result.success();
	}

	/**
	 * 修改Store数据
	 * 
	 * @param store
	 * @param id
	 * @return
	 */
	@PostMapping(value = "update")
	public Result update(@RequestBody Store store) {
		// 调用StoreService实现修改Store
		storeService.update(store);
		return Result.success();
	}

	/**
	 * 新增Store数据
	 * 
	 * @param store
	 * @return
	 */
	@PostMapping("add")
	public Result add(@RequestBody Store store) {
		// 调用StoreService实现添加Store
		storeService.add(store);
		return Result.success();
	}

	/**
	 * 根据ID查询Store数据
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("findById/{id}")
	public Result findById(@PathVariable Integer id) {
		// 调用StoreService实现根据主键查询Store
		Store store = storeService.findById(id);
		return Result.build(store);
	}

	/**
	 * 查询Store全部数据
	 * 
	 * @return
	 */
	@GetMapping("findAll")
	public Result findAll() {
		// 调用StoreService实现查询所有Store
		List<Store> list = storeService.findAll();
		return Result.build(list);
	}
}

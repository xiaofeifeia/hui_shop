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
import com.xph.shop.entity.Dict;
import com.xph.shop.entity.DictItem;
import com.xph.shop.service.DictService;
import com.xph.shop.vo.Result;

@RestController
@RequestMapping("/dict")
@CrossOrigin
public class DictController {

	@Autowired
	private DictService dictService;

	/**
	 * Dict分页条件搜索实现
	 * 
	 * @param dict
	 * @param page
	 * @param size
	 * @return
	 */
	@PostMapping(value = "/findPage/{page}/{size}")
	public Result findPage(@RequestBody(required = false) Dict dict, @PathVariable int page, @PathVariable int size) {
		// 调用DictService实现分页条件查询Dict
		PageInfo<Dict> pageInfo = dictService.findPage(dict, page, size);
		return Result.build(pageInfo);
	}

	/**
	 * Dict分页条件搜索实现
	 * 
	 * @param dict
	 * @param page
	 * @param size
	 * @return
	 */
	@PostMapping(value = "/findDictItemPage/{page}/{size}")
	public Result findDictItemPage(@RequestBody(required = false) DictItem dictItem, @PathVariable int page, @PathVariable int size) {
		// 调用DictService实现分页条件查询Dict
		PageInfo<DictItem> pageInfo = dictService.findDictItemPage(dictItem, page, size);
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
		// 调用DictService实现根据主键删除
		dictService.delete(id);
		return Result.success();
	}

	/**
	 * 根据ID删除品牌数据
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping(value = "deleteDictItem/{dictItemId}")
	public Result deleteDictItem(@PathVariable Integer dictItemId) {
		// 调用DictService实现根据主键删除
		dictService.deleteDictItem(dictItemId);
		return Result.success();
	}

	/**
	 * 修改Dict数据
	 * 
	 * @param dict
	 * @param id
	 * @return
	 */
	@PostMapping(value = "update")
	public Result update(@RequestBody Dict dict) {
		// 调用DictService实现修改Dict
		dictService.update(dict);
		return Result.success();
	}

	/**
	 * 修改Dict数据
	 * 
	 * @param dict
	 * @param id
	 * @return
	 */
	@PostMapping(value = "updateDictItem")
	public Result updateDictItem(@RequestBody DictItem dictItem) {
		// 调用DictService实现修改Dict
		dictService.updateDictItem(dictItem);
		return Result.success();
	}

	/**
	 * 新增Dict数据
	 * 
	 * @param dict
	 * @return
	 */
	@PostMapping("add")
	public Result add(@RequestBody Dict dict) {
		// 调用DictService实现添加Dict
		dictService.add(dict);
		return Result.success();
	}

	/**
	 * 新增Dict数据
	 * 
	 * @param dict
	 * @return
	 */
	@PostMapping("addDictItem")
	public Result addDictItem(@RequestBody DictItem dictItem) {
		// 调用DictService实现添加Dict
		dictService.addDictItem(dictItem);
		return Result.success();
	}

	/**
	 * 根据ID查询Dict数据
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("findById/{id}")
	public Result findById(@PathVariable Integer id) {
		// 调用DictService实现根据主键查询Dict
		Dict dict = dictService.findById(id);
		return Result.build(dict);
	}

	/**
	 * 根据ID查询Dict数据
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("findDictItemById/{id}")
	public Result findDictItemById(@PathVariable Integer dictItemId) {
		// 调用DictService实现根据主键查询Dict
		DictItem dict = dictService.findDictItemById(dictItemId);
		return Result.build(dict);
	}

	/**
	 * 查询Dict全部数据
	 * 
	 * @return
	 */
	@GetMapping("findAll")
	public Result findAll() {
		// 调用DictService实现查询所有Dict
		List<Dict> list = dictService.findAll();
		return Result.build(list);
	}
}

package com.xph.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.xph.shop.entity.Spec;
import com.xph.shop.service.SpecService;
import com.xph.shop.vo.Result;
import com.xph.shop.vo.SpecVo;

/**
 * @Author:xph
 * @Description:
 */

@RestController
@RequestMapping("/spec")
@CrossOrigin
public class SpecController {

	@Autowired
	private SpecService specService;

	/**
	 * Spec分页条件搜索实现
	 * 
	 * @param spec
	 * @param page
	 * @param size
	 * @return
	 */
	@PostMapping(value = "/findPage/{page}/{size}")
	public Result findPage(@RequestBody(required = false) SpecVo spec,
			@PathVariable int page, @PathVariable int size) {
		// 调用SpecService实现分页条件查询Spec
		PageInfo<SpecVo> pageInfo = specService.findPage(spec, page, size);
		return Result.build(pageInfo);
	}

	/**
	 * 修改Spec数据
	 * 
	 * @param spec
	 * @param id
	 * @return
	 */
	@PostMapping(value = "update")
	public Result update(@RequestBody Spec spec) {
		// 调用SpecService实现修改Spec
		specService.update(spec);
		return Result.success();
	}
	/**
	 * 删除Spec数据
	 * 
	 * @param spec
	 * @return
	 */
	@PostMapping("delete/{id}")
	public Result add(@PathVariable Integer id) {
		specService.delete(id);
		return Result.success();
	}

	/**
	 * 新增Spec数据
	 * 
	 * @param spec
	 * @return
	 */
	@PostMapping("add")
	public Result add(@RequestBody Spec spec) {
		// 调用SpecService实现添加Spec
		specService.add(spec);
		return Result.success();
	}

	/**
	 * 根据ID查询Spec数据
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("findById/{id}")
	public Result findById(@PathVariable Integer id) {
		// 调用SpecService实现根据主键查询Spec
		Spec spec = specService.findById(id);
		return Result.build(spec);
	}

	/**
	 * 查询Spec全部数据
	 * 
	 * @return
	 */
	@GetMapping
	public Result findAll() {
		// 调用SpecService实现查询所有Spec
		List<Spec> list = specService.findAll();
		return Result.build(list);
	}
	
	
	/**
	 * 查询Spec全部数据
	 * 
	 * @return
	 */
	@PostMapping("listByTemplateId/{templateId}")
	public Result listByTemplateId(@PathVariable Integer templateId) {
		// 调用SpecService实现查询所有Spec
		List<Spec> list = specService.listByTemplateId(templateId);
		return Result.build(list);
	}
}

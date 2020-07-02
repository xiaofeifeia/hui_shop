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
import com.xph.shop.entity.Template;
import com.xph.shop.service.TemplateService;
import com.xph.shop.vo.Result;

@RestController
@RequestMapping("/template")
@CrossOrigin
public class TemplateController {

	@Autowired
	TemplateService templateService;

	/**
	 * Template分页条件搜索实现
	 * 
	 * @param template
	 * @param page
	 * @param size
	 * @return
	 */
	@PostMapping(value = "/findPage/{page}/{size}")
	public Result findPage(@RequestBody(required = false) Template template,
			@PathVariable int page, @PathVariable int size) {
		// 调用TemplateService实现分页条件查询Template
		PageInfo<Template> pageInfo = templateService.findPage(template, page,
				size);
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
		// 调用TemplateService实现根据主键删除
		templateService.delete(id);
		return Result.success();
	}

	/**
	 * 修改Template数据
	 * 
	 * @param template
	 * @param id
	 * @return
	 */
	@PostMapping(value = "update")
	public Result update(@RequestBody Template template) {
		// 调用TemplateService实现修改Template
		templateService.update(template);
		return Result.success();
	}

	/**
	 * 新增Template数据
	 * 
	 * @param template
	 * @return
	 */
	@PostMapping("add")
	public Result add(@RequestBody Template template) {
		// 调用TemplateService实现添加Template
		templateService.add(template);
		return Result.success();
	}

	/**
	 * 根据ID查询Template数据
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("findById/{id}")
	public Result findById(@PathVariable Integer id) {
		// 调用TemplateService实现根据主键查询Template
		Template template = templateService.findById(id);
		return Result.build(template);
	}

	@RequestMapping("findAll")
	public Result findAll() {
		List<Template> findAll = templateService.findAll();
		return Result.build(findAll);
	}
}

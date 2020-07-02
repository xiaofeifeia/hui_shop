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
import com.xph.shop.entity.Para;
import com.xph.shop.entity.Spec;
import com.xph.shop.service.ParaService;
import com.xph.shop.vo.Result;

/**
 * @Author:xph
 * @Description:
 */

@RestController
@RequestMapping("/para")
@CrossOrigin
public class ParaController {

	@Autowired
	private ParaService paraService;

	/**
	 * Para分页条件搜索实现
	 * 
	 * @param para
	 * @param page
	 * @param size
	 * @return
	 */
	@PostMapping(value = "/findPage/{page}/{size}")
	public Result findPage(@RequestBody(required = false) Para para,
			@PathVariable int page, @PathVariable int size) {
		// 调用ParaService实现分页条件查询Para
		PageInfo<Para> pageInfo = paraService.findPage(para, page, size);
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
		// 调用ParaService实现根据主键删除
		paraService.delete(id);
		return Result.success();
	}

	/**
	 * 修改Para数据
	 * 
	 * @param para
	 * @param id
	 * @return
	 */
	@PostMapping(value = "update")
	public Result update(@RequestBody Para para) {
		// 调用ParaService实现修改Para
		paraService.update(para);
		return Result.success();
	}

	/**
	 * 新增Para数据
	 * 
	 * @param para
	 * @return
	 */
	@PostMapping("add")
	public Result add(@RequestBody Para para) {
		// 调用ParaService实现添加Para
		paraService.add(para);
		return Result.success();
	}

	/**
	 * 根据ID查询Para数据
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/findById/{id}")
	public Result findById(@PathVariable Integer id) {
		// 调用ParaService实现根据主键查询Para
		Para para = paraService.findById(id);
		return Result.build(para);
	}

	/**
	 * 查询Para全部数据
	 * 
	 * @return
	 */
	@GetMapping("findAll")
	public Result findAll() {
		// 调用ParaService实现查询所有Para
		List<Para> list = paraService.findAll();
		return Result.build(list);
	}
	
	/**
	 * 根据模板查询
	 * 
	 * @return
	 */
	@PostMapping("listByTemplateId/{templateId}")
	public Result listByTemplateId(@PathVariable Integer templateId) {
		// 调用SpecService实现查询所有Spec
		List<Para> list = paraService.listByTemplateId(templateId);
		return Result.build(list);
	}
}

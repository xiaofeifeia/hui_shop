package com.xph.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xph.shop.entity.Category;
import com.xph.shop.service.CategoryService;
import com.xph.shop.vo.CategoryVo;
import com.xph.shop.vo.Page;
import com.xph.shop.vo.Result;

/**
 * @Author:xph
 * @Description:
 */

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	/**
	 * Category分页条件搜索实现
	 * 
	 * @param category
	 * @param page
	 * @param size
	 * @return
	 */
	@PostMapping(value = "/findPage/{page}/{size}")
	public Result findPage(@RequestBody(required = false) Category category,
			@PathVariable int page, @PathVariable int size) {
		// 调用CategoryService实现分页条件查询Category
		Page<CategoryVo> pageInfo = categoryService.findPage(category, page, size);
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
		// 调用CategoryService实现根据主键删除
		categoryService.delete(id);
		return Result.success();
	}

	/**
	 * 修改Category数据
	 * 
	 * @param category
	 * @param id
	 * @return
	 */
	@PostMapping(value = "update")
	public Result update(@RequestBody Category category) {
		// 调用CategoryService实现修改Category
		categoryService.update(category);
		return Result.success();
	}

	/**
	 * 新增Category数据
	 * 
	 * @param category
	 * @return
	 */
	@PostMapping("add")
	public Result add(@RequestBody Category category) {
		// 调用CategoryService实现添加Category
		categoryService.add(category);
		return Result.success();
	}

	/**
	 * 根据ID查询Category数据
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("findById/{id}")
	public Result findById(@PathVariable Integer id) {
		// 调用CategoryService实现根据主键查询Category
		Category category = categoryService.findById(id);
		return Result.build(category);
	}

	/**
	 * 查询Category全部数据
	 * 
	 * @return
	 */
	@GetMapping("findAll")
	public Result findAll() {
		// 调用CategoryService实现查询所有Category
		List<Category> list = categoryService.findAll();
		return Result.build(list);
	}
	
	@PostMapping("updateIsMenu/{id}")
	public Result updateIsMenu(@PathVariable Integer id,@RequestParam Boolean isMenu){
		categoryService.updateIsMenu(id,isMenu);
		return Result.success();
	}
	
	@PostMapping("updateIsShow/{id}")
	public Result updateIsShow(@PathVariable Integer id,@RequestParam Boolean isShow){
		categoryService.updateIsShow(id,isShow);
		return Result.success();
	}
	/**
	 * 根据父类获取分类
	 * @param parentId
	 * @return
	 */
	@PostMapping("listByParentId/{parentId}")
	public Result listByParentId(@PathVariable Integer parentId){
		List<Category> list =categoryService.listByParentId(parentId);
		return Result.build(list);
	}
}

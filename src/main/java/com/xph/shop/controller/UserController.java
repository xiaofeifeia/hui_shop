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
import com.xph.shop.entity.User;
import com.xph.shop.service.UserService;
import com.xph.shop.vo.Result;

/****
 * @Author:xph
 * @Description:
 *****/

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	/***
	 * User分页条件搜索实现
	 * 
	 * @param user
	 * @param page
	 * @param size
	 * @return
	 */
	@PostMapping(value = "/search/{page}/{size}")
	public Result findPage(@RequestBody(required = false) User user,
			@PathVariable int page, @PathVariable int size) {
		// 调用UserService实现分页条件查询User
		PageInfo<User> pageInfo = userService.findPage(user, page, size);
		return Result.build(pageInfo);
	}

	/***
	 * User分页搜索实现
	 * 
	 * @param page
	 *            :当前页
	 * @param size
	 *            :每页显示多少条
	 * @return
	 */
	@GetMapping(value = "/search/{page}/{size}")
	public Result findPage(@PathVariable int page, @PathVariable int size) {
		// 调用UserService实现分页查询User
		PageInfo<User> pageInfo = userService.findPage(page, size);
		return Result.build(pageInfo);
	}

	/***
	 * 多条件搜索品牌数据
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/search")
	public Result findList(@RequestBody(required = false) User user) {
		// 调用UserService实现条件查询User
		List<User> list = userService.findList(user);
		return Result.build(list);
	}

	/***
	 * 根据ID删除品牌数据
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/{id}")
	public Result delete(@PathVariable Integer id) {
		// 调用UserService实现根据主键删除
		userService.delete(id);
		return Result.success();
	}

	/***
	 * 修改User数据
	 * 
	 * @param user
	 * @param id
	 * @return
	 */
	@PutMapping(value = "/{id}")
	public Result update(@RequestBody User user, @PathVariable Integer id) {
		// 设置主键值
		user.setUserId(id);
		// 调用UserService实现修改User
		userService.update(user);
		return Result.success();
	}

	/***
	 * 新增User数据
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping
	public Result add(@RequestBody User user) {
		// 调用UserService实现添加User
		userService.add(user);
		return Result.success();
	}

	/***
	 * 根据ID查询User数据
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Result findById(@PathVariable Integer id) {
		// 调用UserService实现根据主键查询User
		User user = userService.findById(id);
		return Result.build(user);
	}

	/***
	 * 查询User全部数据
	 * 
	 * @return
	 */
	@GetMapping
	public Result findAll() {
		// 调用UserService实现查询所有User
		List<User> list = userService.findAll();
		return Result.build(list);
	}
}

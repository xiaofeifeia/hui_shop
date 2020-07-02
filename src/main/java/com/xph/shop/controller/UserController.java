package com.xph.shop.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.xph.shop.entity.User;
import com.xph.shop.service.UserService;
import com.xph.shop.utils.Constants;
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
	@PostMapping(value = "/findPage/{pageNum}/{pageSize}")
	public Result findPage(@RequestBody(required = false) String json,
			@PathVariable int pageNum, @PathVariable int pageSize) {
		// 调用UserService实现分页条件查询User
		User user = JSON.parseObject(json, User.class);
		String statusList=JSON.parseObject(json).getString("statusList");
		PageInfo<User> pageInfo = userService.findPage(user,statusList, pageNum, pageSize);
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
	@PostMapping(value = "delete/{id}")
	public Result delete(@PathVariable Long id) {
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
	@PostMapping(value = "update")
	public Result update(@RequestBody User user) {
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
	@PostMapping("/add")
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
	@GetMapping("/findById/{id}")
	public Result findById(@PathVariable Long id) {
		// 调用UserService实现根据主键查询User
		User user = userService.findById(id);
		return Result.build(user);
	}

	/***
	 * 查询User全部数据
	 * 
	 * @return
	 */
	@GetMapping("findAll")
	public Result findAll() {
		// 调用UserService实现查询所有User
		List<User> list = userService.findAll();
		return Result.build(list);
	}
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @param response
	 * @return
	 */
	@PostMapping("login")
	public Result login(@RequestBody User user,HttpServletResponse response){
		String token = userService.login(user.getUsername(),user.getPassword());
		if(StringUtils.isNotBlank(token)){
			//写入coolie
		    Cookie cookie=new Cookie(Constants.Authorization,token);
		    cookie.setDomain("localhost");
		    cookie.setPath("/");
		    response.addCookie(cookie);
		    return Result.build(token);
		}
		return Result.error("登录失败");
	}
	
	/***
	 * 查询User全部数据
	 * 
	 * @return
	 */
	@PostMapping("resetPwd/{userId}")
	public Result resetPwd(@PathVariable Long userId) {
		 userService.resetPwd(userId);
		return Result.success();
	}
	
	/***
	 *  删除多个用户
	 * 
	 * @return
	 */
	@PostMapping("deleteUsers")
	public Result deleteUsers(@RequestBody List<Long> userIds) {
		userService.deleleUsers(userIds);
		return Result.success();
	}
}

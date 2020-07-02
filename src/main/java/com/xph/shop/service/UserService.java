package com.xph.shop.service;

import com.xph.shop.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:User业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface UserService {

	/***
	 * User多条件分页查询
	 * 
	 * @param user
	 * @param statusList 状态，多个逗号隔开
	 * @param page
	 * @param size
	 * @return
	 */
	PageInfo<User> findPage(User user, String statusList, int page, int size);

	/***
	 * User分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	PageInfo<User> findPage(int page, int size);

	/***
	 * User多条件搜索方法
	 * 
	 * @param user
	 * @return
	 */
	List<User> findList(User user);

	/***
	 * 删除User
	 * 
	 * @param id
	 */
	void delete(Long id);

	/***
	 * 修改User数据
	 * 
	 * @param user
	 */
	void update(User user);

	/***
	 * 新增User
	 * 
	 * @param user
	 */
	void add(User user);

	/**
	 * 根据ID查询User
	 * 
	 * @param id
	 * @return
	 */
	User findById(Long id);

	/***
	 * 查询所有User
	 * 
	 * @return
	 */
	List<User> findAll();

	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 */
	String login(String username, String password);

	/**
	 * 重置密码
	 * @param userId
	 */
	void resetPwd(Long userId);
	/**
	 * 批量删除
	 * @param userIds
	 */
	void deleleUsers(List<Long> userIds);
}

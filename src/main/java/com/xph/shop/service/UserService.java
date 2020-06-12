package com.xph.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xph.shop.dao.UserMapper;
import com.xph.shop.entity.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public Page<User> getUserList(JSONObject jsobj) {
		Integer pageSize = jsobj.getInteger("pageSize");
		Integer pageNum = jsobj.getInteger("pageNum");
		if (pageSize == null) {
			pageSize = 20;
			jsobj.put("pageSize", pageSize);
		}
		if (pageNum == null) {
			pageNum = 1;
			jsobj.put("pageNum", pageNum);
		}
		PageHelper.startPage(pageNum, pageSize);
		return null;
	}
}

package com.xph.shop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xph.shop.entity.Template;

public interface TemplateService {

	/**
	 * Template多条件分页查询
	 * 
	 * @param template
	 * @param page
	 * @param size
	 * @return
	 */
	PageInfo<Template> findPage(Template template, int page, int size);

	/**
	 * 删除Template
	 * 
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * 修改Template数据
	 * 
	 * @param template
	 */
	void update(Template template);

	/**
	 * 新增Template
	 * 
	 * @param template
	 */
	void add(Template template);

	/**
	 * 根据ID查询Template
	 * 
	 * @param id
	 * @return
	 */
	Template findById(Integer id);

	/**
	 * 查询所有Template
	 * 
	 * @return
	 */
	List<Template> findAll();
}

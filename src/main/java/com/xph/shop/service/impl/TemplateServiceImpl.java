package com.xph.shop.service.impl;

import io.jsonwebtoken.lang.Collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xph.shop.dao.TemplateMapper;
import com.xph.shop.entity.Template;
import com.xph.shop.service.TemplateService;

@Service
public class TemplateServiceImpl implements TemplateService {

	@Autowired
	private TemplateMapper templateMapper;

	/**
	 * Template条件+分页查询
	 * 
	 * @param template
	 *            查询条件
	 * @param page
	 *            页码
	 * @param size
	 *            页大小
	 * @return 分页结果
	 */
	@Override
	public PageInfo<Template> findPage(Template template, int page, int size) {
		// 分页
		PageHelper.startPage(page, size);
		// 搜索条件构建
		Example example = createExample(template);
		// 执行搜索
		return new PageInfo<Template>(templateMapper.selectByExample(example));
	}

	/**
	 * Template构建查询对象
	 * 
	 * @param template
	 * @return
	 */
	public Example createExample(Template template) {
		Example example = new Example(Template.class);
		Example.Criteria criteria = example.createCriteria();
		if (template != null) {
			// ID
			if (!StringUtils.isEmpty(template.getId())) {
				criteria.andEqualTo("id", template.getId());
			}
			// 模板名称
			if (!StringUtils.isEmpty(template.getName())) {
				criteria.andLike("name", "%" + template.getName() + "%");
			}
			// 规格数量
			if (!StringUtils.isEmpty(template.getSpecNum())) {
				criteria.andEqualTo("specNum", template.getSpecNum());
			}
			// 参数数量
			if (!StringUtils.isEmpty(template.getParaNum())) {
				criteria.andEqualTo("paraNum", template.getParaNum());
			}
			// 创建时间
			if (!StringUtils.isEmpty(template.getCreatedate())) {
				criteria.andEqualTo("createdate", template.getCreatedate());
			}
			// 更新时间
			if (!StringUtils.isEmpty(template.getUpdatedate())) {
				criteria.andEqualTo("updatedate", template.getUpdatedate());
			}
		}
		return example;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@Override
	public void delete(Integer id) {
		templateMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 修改Template
	 * 
	 * @param template
	 */
	@Override
	public void update(Template template) {

		template.setUpdatedate(new Date());
		templateMapper.updateByPrimaryKeySelective(template);
	}

	/**
	 * 增加Template
	 * 
	 * @param template
	 */
	@Override
	public void add(Template template) {
		template.setCreatedate(new Date());
		template.setUpdatedate(new Date());

		templateMapper.insertSelective(template);
	}

	/**
	 * 根据ID查询Template
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Template findById(Integer id) {
		return templateMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Template> findAll() {
		List<Template> list = new ArrayList<Template>();
		Template t = new Template();
		t.setId(0);
		t.setName("根模板");
		list.add(t);
		List<Template> selectAll = templateMapper.selectAll();
		if (!Collections.isEmpty(selectAll)) {
			list.addAll(selectAll);
		}
		return list;
	}

}

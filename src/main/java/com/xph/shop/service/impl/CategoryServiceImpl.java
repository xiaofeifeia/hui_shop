package com.xph.shop.service.impl;

import io.jsonwebtoken.lang.Collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.xph.shop.dao.CategoryMapper;
import com.xph.shop.entity.Category;
import com.xph.shop.exception.MessageException;
import com.xph.shop.service.CategoryService;
import com.xph.shop.vo.CategoryVo;
import com.xph.shop.vo.Page;
import com.xph.shop.vo.StatusCode;
import com.xph.shop.vo.UserStatus;

/**
 * @Author:xph
 * @Description:Category业务层接口实现类
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	/**
	 * Category条件+分页查询
	 * 
	 * @param category
	 *            查询条件
	 * @param page
	 *            页码
	 * @param size
	 *            页大小
	 * @return 分页结果
	 */
	@Override
	public Page<CategoryVo> findPage(Category category, int page, int size) {
		// 分页
		PageHelper.startPage(page, size);
		// 搜索条件构建
		Example example = createExample(category);
		List<CategoryVo> data = new ArrayList<>();
		List<Category> selectByExample = categoryMapper
				.selectByExample(example);
		PageInfo<Category> pageInfo = new PageInfo<Category>(selectByExample);
		Page<CategoryVo> pager = new Page<CategoryVo>();
		pager.setTotal(pageInfo.getTotal());
		pager.setSize(pageInfo.getSize());
		if (selectByExample != null && selectByExample.size() > 0) {
			selectByExample.forEach(t -> {
				CategoryVo vo = new CategoryVo();
				BeanUtils.copyProperties(t, vo);
				if (t.getParentId() == 0) {
					vo.setLevel(1);
				}
				data.add(vo);
			});
		}
		pager.setList(data);
		// 执行搜索
		return pager;
	}

	/**
	 * Category构建查询对象
	 * 
	 * @param category
	 * @return
	 */
	public Example createExample(Category category) {
		Example example = new Example(Category.class);
		Example.Criteria criteria = example.createCriteria();
		if (category != null) {
			// 分类ID
			if (!StringUtils.isEmpty(category.getId())) {
				criteria.andEqualTo("id", category.getId());
			}
			// 分类名称
			if (!StringUtils.isEmpty(category.getName())) {
				criteria.andLike("name", "%" + category.getName() + "%");
			}
			// 商品数量
			if (!StringUtils.isEmpty(category.getGoodsNum())) {
				criteria.andEqualTo("goodsNum", category.getGoodsNum());
			}
			// 是否显示
			if (!StringUtils.isEmpty(category.getIsShow())) {
				criteria.andEqualTo("isShow", category.getIsShow());
			}
			// 是否导航
			if (!StringUtils.isEmpty(category.getIsMenu())) {
				criteria.andEqualTo("isMenu", category.getIsMenu());
			}
			// 排序
			if (!StringUtils.isEmpty(category.getSeq())) {
				criteria.andEqualTo("seq", category.getSeq());
			}
			// 上级ID
			if (!StringUtils.isEmpty(category.getParentId())) {
				criteria.andEqualTo("parentId", category.getParentId());
			}
			// 模板ID
			if (!StringUtils.isEmpty(category.getTemplateId())) {
				criteria.andEqualTo("templateId", category.getTemplateId());
			}
			// 创建时间
			if (!StringUtils.isEmpty(category.getCreatedate())) {
				criteria.andEqualTo("createdate", category.getCreatedate());
			}
			// 更新时间
			if (!StringUtils.isEmpty(category.getUpdatedate())) {
				criteria.andEqualTo("updatedate", category.getUpdatedate());
			}
		}
		criteria.andIn("status", Lists.newArrayList(
				UserStatus.ENABLE.getStatus(), UserStatus.DISABLE.getStatus()));
		return example;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@Override
	public void delete(Integer id) {
		Category findById = findById(id);
		if (findById == null) {
			throw new MessageException(StatusCode.CATEGORY_NOT_FOUND);
		}
		findById.setStatus(UserStatus.DELETE.getStatus());
		findById.setUpdatedate(new Date());
		categoryMapper.updateByPrimaryKeySelective(findById);
	}

	/**
	 * 修改Category
	 * 
	 * @param category
	 */
	@Override
	public void update(Category category) {
		category.setUpdatedate(new Date());
		categoryMapper.updateByPrimaryKeySelective(category);
	}

	/**
	 * 增加Category
	 * 
	 * @param category
	 */
	@Override
	public void add(Category category) {
		category.setCreatedate(new Date());
		category.setUpdatedate(new Date());
		categoryMapper.insertSelective(category);
	}

	/**
	 * 根据ID查询Category
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Category findById(Integer id) {
		return categoryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 查询Category全部数据,排除删除的
	 * 
	 * @return
	 */
	@Override
	public List<Category> findAll() {
		Example createExample = createExample(new Category());
		List<Category> list = new ArrayList<Category>();
		Category rootParent = new Category();
		rootParent.setId(0);
		rootParent.setName("根分类");
		list.add(rootParent);
		List<Category> selectByExample = categoryMapper
				.selectByExample(createExample);
		if (!Collections.isEmpty(selectByExample)) {
			list.addAll(selectByExample);
		}
		return list;
	}

	@Override
	public void updateIsMenu(Integer id, Boolean isMenu) {
		Category findById = findById(id);
		if (findById == null) {
			throw new MessageException(StatusCode.CATEGORY_NOT_FOUND);
		}
		findById.setIsMenu(isMenu);
		findById.setUpdatedate(new Date());
		categoryMapper.updateByPrimaryKeySelective(findById);
	}

	@Override
	public void updateIsShow(Integer id, Boolean isShow) {
		Category findById = findById(id);
		if (findById == null) {
			throw new MessageException(StatusCode.CATEGORY_NOT_FOUND);
		}
		findById.setIsShow(isShow);
		findById.setUpdatedate(new Date());
		categoryMapper.updateByPrimaryKeySelective(findById);
	}

	@Override
	public List<Category> listByParentId(Integer parentId) {
		Example example = new Example(Category.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("parentId",parentId).andEqualTo("status", UserStatus.ENABLE.getStatus());
		example.setOrderByClause("seq, createdate desc,updatedate desc");
		return categoryMapper.selectByExample(example);
	}

}

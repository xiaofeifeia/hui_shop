package com.xph.shop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xph.shop.dao.DictItemMapper;
import com.xph.shop.dao.DictMapper;
import com.xph.shop.entity.Dict;
import com.xph.shop.entity.DictItem;
import com.xph.shop.service.DictService;

/**
 * @Author:xph
 * @Description:Dict业务层接口实现类
 */
@Service
public class DictServiceImpl implements DictService {

	@Autowired
	private DictMapper dictMapper;
	@Autowired
	private DictItemMapper dictItemMapper;

	/**
	 * Dict条件+分页查询
	 * 
	 * @param dict
	 *            查询条件
	 * @param page
	 *            页码
	 * @param size
	 *            页大小
	 * @return 分页结果
	 */
	@Override
	public PageInfo<Dict> findPage(Dict dict, int page, int size) {
		// 分页
		PageHelper.startPage(page, size);
		// 搜索条件构建
		Example example = createExample(dict);
		// 执行搜索
		return new PageInfo<Dict>(dictMapper.selectByExample(example));
	}

	/**
	 * Dict构建查询对象
	 * 
	 * @param dict
	 * @return
	 */
	public Example createExample(Dict dict) {
		Example example = new Example(Dict.class);
		Example.Criteria criteria = example.createCriteria();
		if (dict != null) {
			//
			if (!StringUtils.isEmpty(dict.getId())) {
				criteria.andEqualTo("id", dict.getId());
			}
			//
			if (!StringUtils.isEmpty(dict.getDictCode())) {
				criteria.andEqualTo("dictCode", dict.getDictCode());
			}
			//
			if (!StringUtils.isEmpty(dict.getDictValue())) {
				criteria.andEqualTo("dictValue", dict.getDictValue());
			}
			//
			if (!StringUtils.isEmpty(dict.getCreatedate())) {
				criteria.andEqualTo("createdate", dict.getCreatedate());
			}
			//
			if (!StringUtils.isEmpty(dict.getUpdatedate())) {
				criteria.andEqualTo("updatedate", dict.getUpdatedate());
			}
		}
		return example;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@Transactional
	@Override
	public void delete(Integer id) {
		dictMapper.deleteByPrimaryKey(id);
		// 删除dict_item
		Example example = new Example(DictItem.class);
		example.createCriteria().andEqualTo("dictId", id);
		dictItemMapper.deleteByExample(example);
	}

	/**
	 * 修改Dict
	 * 
	 * @param dict
	 */
	@Override
	public void update(Dict dict) {
		dict.setUpdatedate(new Date());
		dictMapper.updateByPrimaryKey(dict);
	}

	/**
	 * 增加Dict
	 * 
	 * @param dict
	 */
	@Override
	public void add(Dict dict) {
		dict.setCreatedate(new Date());
		dict.setUpdatedate(new Date());
		dictMapper.insert(dict);
	}

	/**
	 * 根据ID查询Dict
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Dict findById(Integer id) {
		return dictMapper.selectByPrimaryKey(id);
	}

	/**
	 * 查询Dict全部数据
	 * 
	 * @return
	 */
	@Override
	public List<Dict> findAll() {
		return dictMapper.selectAll();
	}

	/**
	 * 删除DictItem
	 * 
	 * @param dictItem
	 */
	@Override
	public void deleteDictItem(Integer dictItemId) {
		dictItemMapper.deleteByPrimaryKey(dictItemId);
	}

	/**
	 * 修改DictItem
	 * 
	 * @param dictItem
	 */
	@Override
	public void updateDictItem(DictItem dictItem) {
		dictItem.setUpdatedate(new Date());
		dictItemMapper.updateByPrimaryKey(dictItem);
	}

	/**
	 * 增加DictItem
	 * 
	 * @param dictItem
	 */
	@Override
	public void addDictItem(DictItem dictItem) {
		dictItem.setCreatedate(new Date());
		dictItem.setUpdatedate(new Date());
		dictItemMapper.insert(dictItem);
	}

	@Override
	public List<DictItem> listByDictId(Integer dictId) {
		Example example = new Example(DictItem.class);
		example.createCriteria().andEqualTo("dictId", dictId);
		example.setOrderByClause("sort");
		return dictItemMapper.selectByExample(example);
	}

	@Override
	public DictItem findDictItemById(Integer dictItemId) {
		return dictItemMapper.selectByPrimaryKey(dictItemId);
	}

	@Override
	public PageInfo<DictItem> findDictItemPage(DictItem dictItem, int page, int size) {
		// 分页
		PageHelper.startPage(page, size);

		Example example = new Example(DictItem.class);
		Criteria createCriteria = example.createCriteria();
		if (dictItem.getDictId() != null) {
			createCriteria.andEqualTo("dictId", dictItem.getDictId());
		}
		if (org.apache.commons.lang3.StringUtils.isNotBlank(dictItem.getDictItemCode())) {
			createCriteria.andEqualTo("dictItemCode", dictItem.getDictItemCode());
		}

		if (org.apache.commons.lang3.StringUtils.isNotBlank(dictItem.getDictItemValue())) {
			createCriteria.andLike("dictItemValue", dictItem.getDictItemValue());
		}
		example.setOrderByClause("sort");
		// 执行搜索
		return new PageInfo<DictItem>(dictItemMapper.selectByExample(example));
	}

}

package com.xph.shop.service;

import com.xph.shop.entity.Dict;
import com.xph.shop.entity.DictItem;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author:xph
 * @Description:Dict业务层接口
 */
public interface DictService {

	/**
	 * Dict多条件分页查询
	 * 
	 * @param dict
	 * @param page
	 * @param size
	 * @return
	 */
	PageInfo<Dict> findPage(Dict dict, int page, int size);

	/**
	 * 删除Dict
	 * 
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * 修改Dict数据
	 * 
	 * @param dict
	 */
	void update(Dict dict);

	/**
	 * 新增Dict
	 * 
	 * @param dict
	 */
	void add(Dict dict);

	/**
	 * 根据ID查询Dict
	 * 
	 * @param id
	 * @return
	 */
	Dict findById(Integer id);

	/**
	 * 查询所有Dict
	 * 
	 * @return
	 */
	List<Dict> findAll();

	/**
	 * 根据ID查询Dict
	 * 
	 * @param id
	 * @return
	 */
	DictItem findDictItemById(Integer dictItemId);
	
	void updateDictItem(DictItem dictItem);

	void addDictItem(DictItem dictItem);

	void deleteDictItem(Integer dictItemId);

	List<DictItem> listByDictId(Integer dictId);

	PageInfo<DictItem> findDictItemPage(DictItem dictItem, int page, int size);
}

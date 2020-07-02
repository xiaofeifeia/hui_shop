package com.xph.shop.service;
import java.util.List;

import com.xph.shop.entity.Category;
import com.xph.shop.vo.CategoryVo;
import com.xph.shop.vo.Page;
/**
 * @Author:xph
 * @Description:Category业务层接口
 */
public interface CategoryService {

    /**
     * Category多条件分页查询
     * @param category
     * @param page
     * @param size
     * @return
     */
	Page<CategoryVo> findPage(Category category, int page, int size);

    /**
     * 删除Category
     * @param id
     */
    void delete(Integer id);

    /**
     * 修改Category数据
     * @param category
     */
    void update(Category category);

    /**
     * 新增Category
     * @param category
     */
    void add(Category category);

    /**
     * 根据ID查询Category
     * @param id
     * @return
     */
     Category findById(Integer id);

    /**
     * 查询所有Category
     * @return
     */
    List<Category> findAll();

	void updateIsMenu(Integer id, Boolean isMenu);
	
	void updateIsShow(Integer id, Boolean isShow);

	/**
	 * 根据父类获取分类
	 * @param parentId
	 * @return
	 */
	List<Category> listByParentId(Integer parentId);
}

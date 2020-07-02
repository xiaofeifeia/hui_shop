package com.xph.shop.service;
import com.xph.shop.entity.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * @Author:xph
 * @Description:Brand业务层接口
 */
public interface BrandService {

    /**
     * Brand多条件分页查询
     * @param brand
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(Brand brand, int page, int size);

    /**
     * Brand多条件搜索方法
     * @param brand
     * @return
     */
    List<Brand> findList(Brand brand);

    /**
     * 删除Brand
     * @param id
     */
    void delete(Integer id);

    /**
     * 修改Brand数据
     * @param brand
     */
    void update(Brand brand);

    /**
     * 新增Brand
     * @param brand
     */
    void add(Brand brand);

    /**
     * 根据ID查询Brand
     * @param id
     * @return
     */
     Brand findById(Integer id);

    /**
     * 查询所有Brand
     * @return
     */
    List<Brand> findAll();

    /**
     * 批量删除
     * @param brandIds
     */
	void deleteBrands(List<Long> brandIds);
}

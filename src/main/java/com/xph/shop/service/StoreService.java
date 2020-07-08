package com.xph.shop.service;
import com.xph.shop.entity.Store;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * @Author:xph
 * @Description:Store业务层接口
 */
public interface StoreService {

    /**
     * Store多条件分页查询
     * @param store
     * @param page
     * @param size
     * @return
     */
    PageInfo<Store> findPage(Store store, int page, int size);


    /**
     * 删除Store
     * @param id
     */
    void delete(Integer id);

    /**
     * 修改Store数据
     * @param store
     */
    void update(Store store);

    /**
     * 新增Store
     * @param store
     */
    void add(Store store);

    /**
     * 根据ID查询Store
     * @param id
     * @return
     */
     Store findById(Integer id);

    /**
     * 查询所有Store
     * @return
     */
    List<Store> findAll();


    /**
     * 批量删除
     * @param storeIds
     */
	void deleteStores(List<Integer> storeIds);
}

package com.xph.shop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xph.shop.entity.Banner;
import com.xph.shop.vo.BannerVo;

/**
 * @Author:xph
 * @Description:Banner业务层接口
 */
public interface BannerService {

	/**
	 * Banner多条件分页查询
	 * 
	 * @param banner
	 * @param page
	 * @param size
	 * @return
	 */
	PageInfo<Banner> findPage(BannerVo bannerVo, int page, int size);

	/**
	 * 删除Banner
	 * 
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * 修改Banner数据
	 * 
	 * @param banner
	 */
	void update(Banner banner);

	/**
	 * 新增Banner
	 * 
	 * @param banner
	 */
	void add(Banner banner);

	/**
	 * 根据ID查询Banner
	 * 
	 * @param id
	 * @return
	 */
	Banner findById(Integer id);

	/**
	 * 查询所有Banner
	 * 
	 * @return
	 */
	List<Banner> findAll();

	List<Banner> findAllWithSort();
}

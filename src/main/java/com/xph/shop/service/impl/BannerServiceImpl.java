package com.xph.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xph.shop.dao.BannerMapper;
import com.xph.shop.entity.Banner;
import com.xph.shop.service.BannerService;
import com.xph.shop.vo.BannerVo;

/**
 * @Author:xph
 * @Description:Banner业务层接口实现类
 */
@Service
public class BannerServiceImpl implements BannerService {

	@Autowired
	private BannerMapper bannerMapper;

	/**
	 * Banner条件+分页查询
	 * 
	 * @param banner
	 *            查询条件
	 * @param page
	 *            页码
	 * @param size
	 *            页大小
	 * @return 分页结果
	 */
	@Override
	public PageInfo<Banner> findPage(BannerVo banner, int page, int size) {
		// 分页
		PageHelper.startPage(page, size);
		// 搜索条件构建
		Example example = createExample(banner);
		// 执行搜索
		return new PageInfo<Banner>(bannerMapper.selectByExample(example));
	}

	/**
	 * Banner构建查询对象
	 * 
	 * @param banner
	 * @return
	 */
	public Example createExample(BannerVo banner) {
		Example example = new Example(Banner.class);
		Example.Criteria criteria = example.createCriteria();
		if (banner != null) {
			//
			if (!StringUtils.isEmpty(banner.getId())) {
				criteria.andEqualTo("id", banner.getId());
			}
			//
			if (!StringUtils.isEmpty(banner.getTitle())) {
				criteria.andLike("title", "%" + banner.getTitle() + "%");
			}
			//
			if (!StringUtils.isEmpty(banner.getUrl())) {
				criteria.andEqualTo("url", banner.getUrl());
			}
			//
			if (!StringUtils.isEmpty(banner.getImage())) {
				criteria.andEqualTo("image", banner.getImage());
			}
			//
			if (!StringUtils.isEmpty(banner.getSort())) {
				criteria.andEqualTo("sort", banner.getSort());
			}
			if (!StringUtils.isEmpty(banner.getType())) {
				criteria.andEqualTo("type", banner.getType());
			}
			if (banner.getNoType() != null) {
				criteria.andNotEqualTo("type", banner.getNoType());
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
		bannerMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 修改Banner
	 * 
	 * @param banner
	 */
	@Override
	public void update(Banner banner) {
		bannerMapper.updateByPrimaryKey(banner);
	}

	/**
	 * 增加Banner
	 * 
	 * @param banner
	 */
	@Override
	public void add(Banner banner) {
		bannerMapper.insert(banner);
	}

	/**
	 * 根据ID查询Banner
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Banner findById(Integer id) {
		return bannerMapper.selectByPrimaryKey(id);
	}

	/**
	 * 查询Banner全部数据
	 * 
	 * @return
	 */
	@Override
	public List<Banner> findAll() {
		return bannerMapper.selectAll();
	}

	@Override
	public List<Banner> findAllWithSort() {
		Example example = new Example(Banner.class);
		example.setOrderByClause("sort");
		return bannerMapper.selectByExample(example);
	}

}

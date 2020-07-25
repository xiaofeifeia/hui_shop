package com.xph.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xph.shop.entity.Banner;
import com.xph.shop.entity.Category;
import com.xph.shop.entity.Sku;
import com.xph.shop.service.BannerService;
import com.xph.shop.service.CategoryService;
import com.xph.shop.service.GoodsService;
import com.xph.shop.service.HomeApiService;
import com.xph.shop.vo.BannerType;
import com.xph.shop.vo.HomeVo;

@Service
public class HomeApiServiceImpl implements HomeApiService {

	@Autowired
	private BannerService bannerService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CategoryService categoryService;

	public HomeVo getHomeData() {
		HomeVo homeVo = new HomeVo();
		List<Banner> bannerList = new ArrayList<Banner>();
		List<Banner> data = bannerService.findAllWithSort();
		if (data != null && data.size() > 0) {
			data.forEach(t -> {
				if (t.getType() == BannerType.BANNER.getType()) {
					bannerList.add(t);
				} else if (t.getType() == BannerType.NEW.getType()) {
					homeVo.setNewBanner(t);
				} else if (t.getType() == BannerType.RECOMMEND.getType()) {
					homeVo.setRecommendBanner(t);
				} else if (t.getType() == BannerType.HOT.getType()) {
					homeVo.setHotBanner(t);
				}
			});
		}
		homeVo.setBannerList(bannerList);
		List<Category> findNavCategorys = categoryService.findNavCategorys();
		homeVo.setNavList(findNavCategorys);
		List<Category> findHotCategorys = categoryService.findHotCategorys();
		homeVo.setHotCategoryList(findHotCategorys);
		List<Sku> hotGoodsList = goodsService.findHotGoods();
		List<Sku> newGoodsList = goodsService.findNewGoods();
		List<Sku> recommendGoodsList = goodsService.findRecommendGoods();
		homeVo.setHotGoodsList(hotGoodsList);
		homeVo.setNewGoodsList(newGoodsList);
		homeVo.setRecommendGoodsList(recommendGoodsList);
		return homeVo;
	}
}

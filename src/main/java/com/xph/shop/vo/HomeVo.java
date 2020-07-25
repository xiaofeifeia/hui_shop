package com.xph.shop.vo;

import java.util.List;

import lombok.Data;

import com.alibaba.fastjson.JSONObject;
import com.xph.shop.entity.Banner;
import com.xph.shop.entity.Category;
import com.xph.shop.entity.Sku;

@Data
public class HomeVo {

	private List<Category> navList;// 导航栏
	private List<Category> hotCategoryList;// 热门分类
	private List<Sku> hotGoodsList;// 热门商品
	private List<Sku> recommendGoodsList;// 推荐商品
	private List<Sku> newGoodsList;// 新品商品
	private List<Banner> bannerList;// 首页轮播图
	private Banner hotBanner;// 首页热门图
	private Banner recommendBanner;// 首页推荐图
	private Banner newBanner;// 首页新品图
	private JSONObject search;// 搜索内容
}

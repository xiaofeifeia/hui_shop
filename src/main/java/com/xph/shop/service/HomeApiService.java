package com.xph.shop.service;

import com.xph.shop.vo.HomeVo;

public interface HomeApiService {

	/**
	 * 初始化小程序首页数据
	 * 
	 * @return
	 */
	public HomeVo getHomeData();
}

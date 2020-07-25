package com.xph.shop.uni.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xph.shop.service.HomeApiService;
import com.xph.shop.vo.HomeVo;
import com.xph.shop.vo.Result;

@CrossOrigin
@RestController
@RequestMapping("api/home")
public class HomeApiController {

	@Autowired
	private HomeApiService homeApiService;

	@RequestMapping("getHomeData")
	public Result getHomeData() {
		HomeVo homeData = homeApiService.getHomeData();
		return Result.build(homeData);
	}
}

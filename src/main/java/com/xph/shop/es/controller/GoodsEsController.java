package com.xph.shop.es.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xph.shop.es.service.GoodsEsService;
import com.xph.shop.vo.Result;

@RequestMapping("goodsEs")
@RestController
public class GoodsEsController {

	@Autowired
	GoodsEsService goodsEsService;

	@RequestMapping("importData")
	public Result importData() throws IOException {
		goodsEsService.importData();
		return Result.success();
	}
}

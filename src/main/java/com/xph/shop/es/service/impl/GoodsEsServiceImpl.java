package com.xph.shop.es.service.impl;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xph.shop.es.service.GoodsEsService;
import com.xph.shop.service.GoodsService;
import com.xph.shop.vo.GoodsEs;

@Service
public class GoodsEsServiceImpl implements GoodsEsService {

	@Autowired
	private RestHighLevelClient restHighLevelClient;

	@Autowired
	private GoodsService goodsService;

	@Override
	public void importData() throws IOException {
		List<GoodsEs> goodsList = goodsService.getGoodsList();
		for (GoodsEs goods : goodsList) {
			IndexRequest index = new IndexRequest("hui_shop", "goods", goods.getId());
			index.source(JSON.toJSONString(goods), XContentType.JSON);
			IndexResponse indexResponse = restHighLevelClient.index(index, RequestOptions.DEFAULT);
			System.err.println(JSON.toJSONString(indexResponse));

		}
	}

}

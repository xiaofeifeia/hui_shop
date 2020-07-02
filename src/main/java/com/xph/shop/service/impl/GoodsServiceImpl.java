package com.xph.shop.service.impl;

import io.jsonwebtoken.lang.Collections;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.entity.Example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.client.naming.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xph.shop.dao.GoodsMapper;
import com.xph.shop.dao.SkuMapper;
import com.xph.shop.dao.SpuMapper;
import com.xph.shop.entity.Sku;
import com.xph.shop.entity.Spu;
import com.xph.shop.exception.MessageException;
import com.xph.shop.service.GoodsService;
import com.xph.shop.vo.Goods;
import com.xph.shop.vo.IdWorker;
import com.xph.shop.vo.SkuVo;
import com.xph.shop.vo.StatusCode;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private SpuMapper spuMapper;
	@Autowired
	private SkuMapper skuMapper;
	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private IdWorker idWorker;

	@Override
	@Transactional
	public void create(Goods goods) {

		Spu spu = goods.getSpu();
		spu.setId(idWorker.nextId() + StringUtils.EMPTY);
		spu.setCreatedate(new Date());
		spu.setUpdatedate(new Date());
		spuMapper.insertSelective(spu);
		if (!Collections.isEmpty(goods.getSkus())) {
			goods.getSkus().forEach(sku -> {
				sku.setId(idWorker.nextId() + StringUtils.EMPTY);
				// 设置sku名
					StringBuilder skuName = new StringBuilder();
					skuName.append(spu.getName());
					JSONObject spec = JSON.parseObject(sku.getSpec());
					spec.forEach((key, value) -> {
						skuName.append(" " + value);
					});
					sku.setSpuId(spu.getId());
					sku.setName(skuName.toString());
					sku.setCreateTime(new Date());
					sku.setUpdateTime(new Date());
					skuMapper.insertSelective(sku);
				});
		}

	}

	@Override
	public PageInfo<SkuVo> findPage(SkuVo skuVo, int page, int size) {

		// 分页
		PageHelper.startPage(page, size);

		List<SkuVo> findPage = goodsMapper.findPage(skuVo);
		return new PageInfo<SkuVo>(findPage);
	}

	@Transactional
	@Override
	public void updateStatus(String id, String status) {
		Sku sku = skuMapper.selectByPrimaryKey(id);
		if (sku == null) {
			throw new MessageException(StatusCode.SKU_NOT_FOUND);
		}
		sku.setStatus(status);
		sku.setUpdateTime(new Date());
		skuMapper.updateByPrimaryKeySelective(sku);

	}

	@Transactional
	@Override
	public void updateStatus(List<String> ids, String status) {
		Sku sku = new Sku();
		sku.setStatus(status);
		sku.setUpdateTime(new Date());
		Example example = new Example(Sku.class);
		example.createCriteria().andIn("id", ids);
		skuMapper.updateByExampleSelective(sku, example);
	}

}

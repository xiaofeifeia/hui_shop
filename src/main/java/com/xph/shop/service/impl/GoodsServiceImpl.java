package com.xph.shop.service.impl;

import io.jsonwebtoken.lang.Collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
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
import com.xph.shop.entity.Brand;
import com.xph.shop.entity.Category;
import com.xph.shop.entity.Sku;
import com.xph.shop.entity.Spu;
import com.xph.shop.exception.MessageException;
import com.xph.shop.service.BrandService;
import com.xph.shop.service.CategoryService;
import com.xph.shop.service.GoodsService;
import com.xph.shop.utils.UserUtil;
import com.xph.shop.vo.Goods;
import com.xph.shop.vo.GoodsEs;
import com.xph.shop.vo.IdWorker;
import com.xph.shop.vo.SpuVo;
import com.xph.shop.vo.StatusCode;
import com.xph.shop.vo.UserStatus;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private SpuMapper spuMapper;
	@Autowired
	private SkuMapper skuMapper;
	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private BrandService brandService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private IdWorker idWorker;

	@Override
	@Transactional
	public void createOrUpdate(Goods goods) {

		Spu spu = goods.getSpu();

		if (spu.getId() == null) {
			spu.setId(idWorker.nextId() + StringUtils.EMPTY);
			spu.setCreatedate(new Date());
			spu.setUpdatedate(new Date());
			spuMapper.insertSelective(spu);
		} else {
			spu.setUpdatedate(new Date());
			spuMapper.updateByPrimaryKeySelective(spu);
		}

		Brand brand = brandService.findById(spu.getBrandId());

		if (!Collections.isEmpty(goods.getSkus())) {

			List<String> skuIds = new ArrayList<>();

			goods.getSkus().forEach(sku -> {

				// 设置sku名
					StringBuilder skuName = new StringBuilder();
					skuName.append(spu.getName());
					JSONObject spec = JSON.parseObject(sku.getSpec());
					spec.forEach((key, value) -> {
						skuName.append(" " + value);
					});
					sku.setSpuId(spu.getId());
					sku.setName(skuName.toString());
					sku.setBrandName(brand.getName());

					if (sku.getId() == null) {
						sku.setId(idWorker.nextId() + StringUtils.EMPTY);
						sku.setCreateTime(new Date());
						sku.setUpdateTime(new Date());
						skuMapper.insertSelective(sku);
					} else {
						sku.setUpdateTime(new Date());
						skuMapper.updateByPrimaryKeySelective(sku);
					}

					skuIds.add(sku.getId());
				});
			// 删除不在skuIds里的其他sku
			if (skuIds.size() > 0) {
				deleteSkusNotIn(skuIds);
			}
		}

	}

	@Override
	public PageInfo<SpuVo> findPage(SpuVo spuVo, int page, int size) {

		// 分页
		PageHelper.startPage(page, size);

		List<SpuVo> findPage = goodsMapper.findPage(spuVo);
		return new PageInfo<SpuVo>(findPage);
	}

	@Transactional
	@Override
	public void setMarketable(String id, String isMarketable) {
		Spu spu = spuMapper.selectByPrimaryKey(id);
		if (spu == null) {
			throw new MessageException(StatusCode.SPU_NOT_FOUND);
		}
		spu.setIsMarketable(isMarketable);
		spu.setUpdatedate(new Date());
		spuMapper.updateByPrimaryKeySelective(spu);

	}

	@Transactional
	@Override
	public void deleteGoods(String id) {
		Spu spu = spuMapper.selectByPrimaryKey(id);
		if (spu == null) {
			throw new MessageException(StatusCode.SPU_NOT_FOUND);
		}
		spu.setIsDelete(true);
		spu.setUpdatedate(new Date());
		spuMapper.updateByPrimaryKeySelective(spu);

	}

	@Transactional
	@Override
	public void deleteGoodsList(List<String> ids) {
		Spu spu = new Spu();
		spu.setIsDelete(true);
		spu.setUpdatedate(new Date());
		Example example = new Example(Spu.class);
		example.createCriteria().andIn("id", ids);
		spuMapper.updateByExampleSelective(spu, example);
	}

	private void deleteSkusNotIn(List<String> skuIds) {
		Sku sku = new Sku();
		sku.setStatus(UserStatus.DELETE.getStatus() + StringUtils.EMPTY);
		sku.setUpdateTime(new Date());
		Example example = new Example(Sku.class);
		example.createCriteria().andNotIn("id", skuIds);
		skuMapper.updateByExampleSelective(sku, example);
	}

	@Override
	public void audit(String id, Integer auditStatus, String auditInfo) {

		Spu spu = spuMapper.selectByPrimaryKey(id);
		if (spu == null) {
			throw new MessageException(StatusCode.SPU_NOT_FOUND);
		}
		spu=new Spu();
		spu.setId(id);
		spu.setAuditStatus(auditStatus);
		try {
			spu.setAuditUser(UserUtil.getLoginUser().getUserId());
		} catch (Exception e) {
			spu.setAuditUser(1L);
		}
		spu.setAuditInfo(auditInfo);
		spu.setAuditDate(new Date());
		spuMapper.updateByPrimaryKeySelective(spu);
	}

	@Override
	public Goods getGoodsInfo(String id) {
		Spu spu = spuMapper.selectByPrimaryKey(id);
		if (spu == null) {
			throw new MessageException(StatusCode.SPU_NOT_FOUND);
		}
		Example example = new Example(Sku.class);
		example.createCriteria().andEqualTo("spuId", id)
				.andNotEqualTo("status", UserStatus.DELETE.getStatus());
		List<Sku> skus = skuMapper.selectByExample(example);
		Goods goods = new Goods();
		goods.setSkus(skus);
		SpuVo spuVo = new SpuVo();
		BeanUtils.copyProperties(spu, spuVo);
		Category c1 = categoryService.findById(spu.getCategory1Id());
		Category c2 = categoryService.findById(spu.getCategory2Id());
		Category c3 = categoryService.findById(spu.getCategory3Id());
		if (c1 != null) {
			spuVo.setCategoryName1(c1.getName());
		}
		if (c2 != null) {
			spuVo.setCategoryName2(c2.getName());
		}
		if (c3 != null) {
			spuVo.setCategoryName3(c3.getName());
		}
		Brand brand = brandService.findById(spu.getBrandId());
        spuVo.setBrandName(brand.getName());
		goods.setSpu(spuVo);
		return goods;
	}

	@Override
	public List<GoodsEs> getGoodsList() {
		
		return goodsMapper.getGoodsList();
	}

	
}

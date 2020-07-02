package com.xph.shop.dao;

import java.util.List;

import tk.mybatis.mapper.common.Mapper;

import com.xph.shop.entity.Spec;
import com.xph.shop.vo.SpecVo;

/**
 * @Author:xph
 * @Description:Spec的Dao
 */
public interface SpecMapper extends Mapper<Spec> {

	public List<SpecVo> findPage(SpecVo specVo);
}

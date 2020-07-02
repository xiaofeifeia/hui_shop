package com.xph.shop.service;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xph.shop.entity.Spec;
import com.xph.shop.vo.SpecVo;
/**
 * @Author:xph
 * @Description:Spec业务层接口
 */
public interface SpecService {

    /**
     * Spec多条件分页查询
     * @param spec
     * @param page
     * @param size
     * @return
     */
    PageInfo<SpecVo> findPage(SpecVo spec, int page, int size);

    /**
     * 删除Spec
     * @param id
     */
    void delete(Integer id);

    /**
     * 修改Spec数据
     * @param spec
     */
    void update(Spec spec);

    /**
     * 新增Spec
     * @param spec
     */
    void add(Spec spec);

    /**
     * 根据ID查询Spec
     * @param id
     * @return
     */
     Spec findById(Integer id);

    /**
     * 查询所有Spec
     * @return
     */
    List<Spec> findAll();

    /**
     * 根据模板获取
     * @param templateId
     * @return
     */
	List<Spec> listByTemplateId(Integer templateId);
}

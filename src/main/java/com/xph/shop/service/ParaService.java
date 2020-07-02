package com.xph.shop.service;
import com.xph.shop.entity.Para;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * @Author:xph
 * @Description:Para业务层接口
 */
public interface ParaService {

    /**
     * Para多条件分页查询
     * @param para
     * @param page
     * @param size
     * @return
     */
    PageInfo<Para> findPage(Para para, int page, int size);

    /**
     * 删除Para
     * @param id
     */
    void delete(Integer id);

    /**
     * 修改Para数据
     * @param para
     */
    void update(Para para);

    /**
     * 新增Para
     * @param para
     */
    void add(Para para);

    /**
     * 根据ID查询Para
     * @param id
     * @return
     */
     Para findById(Integer id);

    /**
     * 查询所有Para
     * @return
     */
    List<Para> findAll();

    /**
     * 根据模板查询
     * @param templateId
     * @return
     */
	List<Para> listByTemplateId(Integer templateId);
}

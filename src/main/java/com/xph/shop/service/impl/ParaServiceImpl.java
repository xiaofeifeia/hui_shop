package com.xph.shop.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xph.shop.dao.ParaMapper;
import com.xph.shop.entity.Para;
import com.xph.shop.entity.Spec;
import com.xph.shop.service.ParaService;
/**
 * @Author:xph
 * @Description:Para业务层接口实现类
 */
@Service
public class ParaServiceImpl implements ParaService {

    @Autowired
    private ParaMapper paraMapper;


    /**
     * Para条件+分页查询
     * @param para 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Para> findPage(Para para, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(para);
        //执行搜索
        return new PageInfo<Para>(paraMapper.selectByExample(example));
    }

    /**
     * Para构建查询对象
     * @param para
     * @return
     */
    public Example createExample(Para para){
        Example example=new Example(Para.class);
        Example.Criteria criteria = example.createCriteria();
        if(para!=null){
            // id
            if(!StringUtils.isEmpty(para.getId())){
                    criteria.andEqualTo("id",para.getId());
            }
            // 名称
            if(!StringUtils.isEmpty(para.getName())){
                    criteria.andLike("name","%"+para.getName()+"%");
            }
            // 选项
            if(!StringUtils.isEmpty(para.getOptions())){
                    criteria.andEqualTo("options",para.getOptions());
            }
            // 排序
            if(!StringUtils.isEmpty(para.getSeq())){
                    criteria.andEqualTo("seq",para.getSeq());
            }
            // 模板ID
            if(!StringUtils.isEmpty(para.getTemplateId())){
                    criteria.andEqualTo("templateId",para.getTemplateId());
            }
            // 创建时间
            if(!StringUtils.isEmpty(para.getCreatedate())){
                    criteria.andEqualTo("createdate",para.getCreatedate());
            }
            // 更新时间
            if(!StringUtils.isEmpty(para.getUpdatedate())){
                    criteria.andEqualTo("updatedate",para.getUpdatedate());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        paraMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Para
     * @param para
     */
    @Override
    public void update(Para para){
    	para.setUpdatedate(new Date());
        paraMapper.updateByPrimaryKeySelective(para);
    }

    /**
     * 增加Para
     * @param para
     */
    @Override
    public void add(Para para){
    	para.setCreatedate(new Date());
    	para.setUpdatedate(new Date());
        paraMapper.insertSelective(para);
    }

    /**
     * 根据ID查询Para
     * @param id
     * @return
     */
    @Override
    public Para findById(Integer id){
        return  paraMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Para全部数据
     * @return
     */
    @Override
    public List<Para> findAll() {
        return paraMapper.selectAll();
    }

	@Override
	public List<Para> listByTemplateId(Integer templateId) {
		Para para=new Para();
		para.setTemplateId(templateId);
		Example example = createExample(para);
		example.setOrderByClause("seq,createdate desc,updatedate desc");
		return paraMapper.selectByExample(example);
	}
    
}

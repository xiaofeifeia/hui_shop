package com.xph.shop.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xph.shop.dao.SpecMapper;
import com.xph.shop.entity.Spec;
import com.xph.shop.service.SpecService;
import com.xph.shop.vo.SpecVo;
/**
 * @Author:xph
 * @Description:Spec业务层接口实现类
 */
@Service
public class SpecServiceImpl implements SpecService {

    @Autowired
    private SpecMapper specMapper;


    /**
     * Spec条件+分页查询
     * @param spec 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SpecVo> findPage(SpecVo spec, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //执行搜索
        return new PageInfo<SpecVo>(specMapper.findPage(spec));
    }


    /**
     * Spec构建查询对象
     * @param spec
     * @return
     */
    public Example createExample(Spec spec){
        Example example=new Example(Spec.class);
        Example.Criteria criteria = example.createCriteria();
        if(spec!=null){
            // ID
            if(!StringUtils.isEmpty(spec.getId())){
                    criteria.andEqualTo("id",spec.getId());
            }
            // 名称
            if(!StringUtils.isEmpty(spec.getName())){
                    criteria.andLike("name","%"+spec.getName()+"%");
            }
            // 规格选项
            if(!StringUtils.isEmpty(spec.getOptions())){
                    criteria.andEqualTo("options",spec.getOptions());
            }
            // 排序
            if(!StringUtils.isEmpty(spec.getSeq())){
                    criteria.andEqualTo("seq",spec.getSeq());
            }
            // 模板ID
            if(!StringUtils.isEmpty(spec.getTemplateId())){
                    criteria.andEqualTo("templateId",spec.getTemplateId());
            }
            // 创建时间
            if(!StringUtils.isEmpty(spec.getCreatedate())){
                    criteria.andEqualTo("createdate",spec.getCreatedate());
            }
            // 更新时间
            if(!StringUtils.isEmpty(spec.getUpdatedate())){
                    criteria.andEqualTo("updatedate",spec.getUpdatedate());
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
        specMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Spec
     * @param spec
     */
    @Override
    public void update(Spec spec){
    	spec.setUpdatedate(new Date());
        specMapper.updateByPrimaryKey(spec);
    }

    /**
     * 增加Spec
     * @param spec
     */
    @Override
    public void add(Spec spec){
    	spec.setCreatedate(new Date());
    	spec.setUpdatedate(new Date());
        specMapper.insert(spec);
    }

    /**
     * 根据ID查询Spec
     * @param id
     * @return
     */
    @Override
    public Spec findById(Integer id){
        return  specMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Spec全部数据
     * @return
     */
    @Override
    public List<Spec> findAll() {
        return specMapper.selectAll();
    }


	@Override
	public List<Spec> listByTemplateId(Integer templateId) {
		Spec spec=new Spec();
		spec.setTemplateId(templateId);
		Example example = createExample(spec);
		example.setOrderByClause("seq,createdate desc,updatedate desc");
		return specMapper.selectByExample(example);
	}
    
    
}

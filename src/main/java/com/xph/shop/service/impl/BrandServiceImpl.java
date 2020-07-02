package com.xph.shop.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xph.shop.dao.BrandMapper;
import com.xph.shop.entity.Brand;
import com.xph.shop.entity.User;
import com.xph.shop.exception.MessageException;
import com.xph.shop.service.BrandService;
import com.xph.shop.vo.StatusCode;
import com.xph.shop.vo.UserStatus;
/**
 * @Author:xph
 * @Description:Brand业务层接口实现类
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;


    /**
     * Brand条件+分页查询
     * @param brand 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Brand> findPage(Brand brand, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(brand);
        example.setOrderByClause("createdate desc,updatedate desc,seq desc");
        //执行搜索
        return new PageInfo<Brand>(brandMapper.selectByExample(example));
    }

    /**
     * Brand条件查询
     * @param brand
     * @return
     */
    @Override
    public List<Brand> findList(Brand brand){
        //构建查询条件
        Example example = createExample(brand);
        //根据构建的条件查询数据
        return brandMapper.selectByExample(example);
    }


    /**
     * Brand构建查询对象
     * @param brand
     * @return
     */
    public Example createExample(Brand brand){
        Example example=new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if(brand!=null){
            // 品牌id
            if(!StringUtils.isEmpty(brand.getId())){
                    criteria.andEqualTo("id",brand.getId());
            }
            // 品牌名称
            if(!StringUtils.isEmpty(brand.getName())){
                    criteria.andLike("name","%"+brand.getName()+"%");
            }
            // 品牌图片地址
            if(!StringUtils.isEmpty(brand.getImage())){
                    criteria.andEqualTo("image",brand.getImage());
            }
            // 品牌的首字母
            if(!StringUtils.isEmpty(brand.getLetter())){
                    criteria.andEqualTo("letter",brand.getLetter());
            }
            // 排序
            if(!StringUtils.isEmpty(brand.getSeq())){
                    criteria.andEqualTo("seq",brand.getSeq());
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
    	Brand findById = findById(id);
    	if(findById==null){
    		throw new MessageException(StatusCode.BRAND_NOT_FOUND);
    	}
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Brand
     * @param brand
     */
    @Override
    public void update(Brand brand){
    	if(org.apache.commons.lang3.StringUtils.isAnyBlank(brand.getName(),brand.getLetter())){
    		throw new MessageException(StatusCode.PARAM_ERROR);
    	}
    	Brand findById = findById(brand.getId());
    	if(findById==null){
    		throw new MessageException(StatusCode.BRAND_NOT_FOUND);
    	}
    	brand.setUpdateDate(new Date());
        brandMapper.updateByPrimaryKey(brand);
    }

    /**
     * 增加Brand
     * @param brand
     */
    @Override
    public void add(Brand brand){
    	if(org.apache.commons.lang3.StringUtils.isAnyBlank(brand.getName(),brand.getLetter())){
    		throw new MessageException(StatusCode.PARAM_ERROR);
    	}
    	brand.setCreateDate(new Date());
    	brand.setUpdateDate(new Date());
        brandMapper.insert(brand);
    }

    /**
     * 根据ID查询Brand
     * @param id
     * @return
     */
    @Override
    public Brand findById(Integer id){
        return  brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Brand全部数据
     * @return
     */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

	@Override
	public void deleteBrands(List<Long> brandIds) {
		Example example = new Example(Brand.class);
		example.createCriteria().andIn("id", brandIds);
		brandMapper.deleteByExample(example);
		
	}
    
    
}

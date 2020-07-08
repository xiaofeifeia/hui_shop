package com.xph.shop.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xph.shop.dao.StoreMapper;
import com.xph.shop.entity.Store;
import com.xph.shop.exception.MessageException;
import com.xph.shop.service.StoreService;
import com.xph.shop.utils.UserUtil;
import com.xph.shop.vo.StatusCode;
import com.xph.shop.vo.UserStatus;
/**
 * @Author:xph
 * @Description:Store业务层接口实现类
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;


    /**
     * Store条件+分页查询
     * @param store 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Store> findPage(Store store, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(store);
        //执行搜索
        return new PageInfo<Store>(storeMapper.selectByExample(example));
    }


    /**
     * Store构建查询对象
     * @param store
     * @return
     */
    public Example createExample(Store store){
        Example example=new Example(Store.class);
        Example.Criteria criteria = example.createCriteria();
        if(store!=null){
            // 
            if(!StringUtils.isEmpty(store.getId())){
                    criteria.andEqualTo("id",store.getId());
            }
            // 店铺名
            if(!StringUtils.isEmpty(store.getName())){
                    criteria.andLike("name","%"+store.getName()+"%");
            }
            // 门店联系电话
            if(!StringUtils.isEmpty(store.getPhone())){
                    criteria.andEqualTo("phone",store.getPhone());
            }
            // 
            if(!StringUtils.isEmpty(store.getLogo())){
                    criteria.andEqualTo("logo",store.getLogo());
            }
            // 地址
            if(!StringUtils.isEmpty(store.getAddress())){
                    criteria.andEqualTo("address",store.getAddress());
            }
            // 门店介绍
            if(!StringUtils.isEmpty(store.getIntroduction())){
                    criteria.andEqualTo("introduction",store.getIntroduction());
            }
            // 配送时间
            if(!StringUtils.isEmpty(store.getDeliveryTime())){
                    criteria.andEqualTo("deliveryTime",store.getDeliveryTime());
            }
            // 配送信息
            if(!StringUtils.isEmpty(store.getDeliveryInfo())){
                    criteria.andEqualTo("deliveryInfo",store.getDeliveryInfo());
            }
            // 创建人
            if(!StringUtils.isEmpty(store.getUserId())){
                    criteria.andEqualTo("userId",store.getUserId());
            }
            // 
            if(!StringUtils.isEmpty(store.getCreatedate())){
                    criteria.andEqualTo("createdate",store.getCreatedate());
            }
            // 
            if(!StringUtils.isEmpty(store.getUpdatedate())){
                    criteria.andEqualTo("updatedate",store.getUpdatedate());
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
    	Store store = findById( id);
    	if(store==null){
    		throw new MessageException(StatusCode.STORE_NOT_FOUND);
    	}
    	store.setUpdatedate(new Date());
    	store.setStatus(UserStatus.DELETE.getStatus());
        storeMapper.updateByPrimaryKeySelective(store);
    }
    
    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteStores(List<Integer> storeIds){
    	Example example=new Example(Store.class);
    	example.createCriteria().andIn("id", storeIds);
    	Store store =new Store();
    	store.setUpdatedate(new Date());
    	store.setStatus(UserStatus.DELETE.getStatus());
        storeMapper.updateByExampleSelective(store, example);
    }

    /**
     * 修改Store
     * @param store
     */
    @Override
    public void update(Store store){
    	if(findById(store.getId())==null){
    		throw new MessageException(StatusCode.STORE_NOT_FOUND);
    	}
    	store.setUpdatedate(new Date());
        storeMapper.updateByPrimaryKeySelective(store);
    }

    /**
     * 增加Store
     * @param store
     */
    @Override
    public void add(Store store){
    	store.setCreatedate(new Date());
    	store.setUpdatedate(new Date());
    	try {
			store.setUserId(UserUtil.getLoginUser().getUserId());
		} catch (Exception e) {
			store.setUserId(1l);
		}
        storeMapper.insertSelective(store);
    }

    /**
     * 根据ID查询Store
     * @param id
     * @return
     */
    @Override
    public Store findById(Integer id){
        return  storeMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Store全部数据
     * @return
     */
    @Override
    public List<Store> findAll() {
        return storeMapper.selectAll();
    }
}

package com.xph.shop.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import tk.mybatis.mapper.entity.Example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xph.shop.dao.UserMapper;
import com.xph.shop.entity.User;
import com.xph.shop.exception.MessageException;
import com.xph.shop.service.UserService;
import com.xph.shop.utils.BCrypt;
import com.xph.shop.utils.Constants;
import com.xph.shop.utils.JwtUtil;
import com.xph.shop.vo.StatusCode;
/****
 * @Author:shenkunlin
 * @Description:User业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * User条件+分页查询
     * @param user 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<User> findPage(User user, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(user);
        //执行搜索
        return new PageInfo<User>(userMapper.selectByExample(example));
    }

    /**
     * User分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<User> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<User>(userMapper.selectAll());
    }

    /**
     * User条件查询
     * @param user
     * @return
     */
    @Override
    public List<User> findList(User user){
        //构建查询条件
        Example example = createExample(user);
        //根据构建的条件查询数据
        return userMapper.selectByExample(example);
    }


    /**
     * User构建查询对象
     * @param user
     * @return
     */
    public Example createExample(User user){
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if(user!=null){
            // 用户id
            if(!StringUtils.isEmpty(user.getUserId())){
                    criteria.andEqualTo("userId",user.getUserId());
            }
            // 用户名
            if(!StringUtils.isEmpty(user.getUsername())){
                    criteria.andLike("username","%"+user.getUsername()+"%");
            }
            // 别名
            if(!StringUtils.isEmpty(user.getNickname())){
                    criteria.andLike("nickname","%"+user.getNickname()+"%");
            }
            // 密码
            if(!StringUtils.isEmpty(user.getPassword())){
                    criteria.andEqualTo("password",user.getPassword());
            }
            // 0后台创建 1:微信小程序，2:PC，3：H5，4：Android，5：IOS
            if(!StringUtils.isEmpty(user.getSourceType())){
                    criteria.andEqualTo("sourceType",user.getSourceType());
            }
            // 邮箱
            if(!StringUtils.isEmpty(user.getEmail())){
                    criteria.andEqualTo("email",user.getEmail());
            }
            // 头像
            if(!StringUtils.isEmpty(user.getHeadPic())){
                    criteria.andEqualTo("headPic",user.getHeadPic());
            }
            // 性别 0 默认0未知  1 男 2 女
            if(!StringUtils.isEmpty(user.getSex())){
                    criteria.andEqualTo("sex",user.getSex());
            }
            // 手机号码
            if(!StringUtils.isEmpty(user.getPhone())){
                    criteria.andEqualTo("phone",user.getPhone());
            }
            // 生日
            if(!StringUtils.isEmpty(user.getBirthday())){
                    criteria.andEqualTo("birthday",user.getBirthday());
            }
            // 0 正常  1 禁用  2删除
            if(!StringUtils.isEmpty(user.getStatus())){
                    criteria.andEqualTo("status",user.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(user.getCreateTime())){
                    criteria.andEqualTo("createTime",user.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(user.getUpdateTime())){
                    criteria.andEqualTo("updateTime",user.getUpdateTime());
            }
            // 最后登录时间
            if(!StringUtils.isEmpty(user.getLastLoginTime())){
                    criteria.andEqualTo("lastLoginTime",user.getLastLoginTime());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id){
    	User findById = findById(id);
    	if(findById==null){
    		throw new MessageException(StatusCode.USER_NOT_FOUND);
    	}
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改User
     * @param user
     */
    @Override
    public void update(User user){
    	if(org.apache.commons.lang3.StringUtils.isAnyBlank(user.getUsername(),user.getPassword())||user.getUserId()==null){
    		throw new MessageException(StatusCode.PARAM_ERROR);
    	}
    	User findById = findById(user.getUserId());
    	if(findById==null){
    		throw new MessageException(StatusCode.USER_NOT_FOUND);
    	}
    	BeanUtils.copyProperties(user, findById);
    	//对密码加密
    	String bcryptPwd = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
    	findById.setPassword(bcryptPwd);
    	findById.setUpdateTime(new Date());
        userMapper.updateByPrimaryKeySelective(findById);
    }

    /**
     * 增加User
     * @param user
     */
    @Override
    public void add(User user){
    	if(org.apache.commons.lang3.StringUtils.isAnyBlank(user.getUsername(),user.getPassword())){
    		throw new MessageException(StatusCode.PARAM_ERROR);
    	}
    	//对密码加密
    	String bcryptPwd = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
    	user.setPassword(bcryptPwd);
    	user.setCreateTime(new Date());
        userMapper.insertSelective(user);
    }

    /**
     * 根据ID查询User
     * @param id
     * @return
     */
    @Override
    public User findById(Long id){
        return  userMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询User全部数据
     * @return
     */
    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

	@Override
	public String login(String username, String password) {
		Example example=new Example(User.class);
		example.createCriteria().andCondition(" phone='"+username+"' or username='"+username+"'");
		List<User> list = userMapper.selectByExample(example);
		if(list==null || list.size()<=0){
		   throw new MessageException(StatusCode.USER_NOT_FOUND.getStatus(),username+","+StatusCode.USER_NOT_FOUND.getMessage());
		}
		User user = list.get(0);
		//密码错误
		if(!BCrypt.checkpw(password,user.getPassword())){
			 throw new MessageException(StatusCode.USER_PASSWORD_ERROR);
		}
	    User user2=new User();
	    user2.setUserId(user.getUserId());
	    user2.setLastLoginTime(new Date());
	    userMapper.updateByPrimaryKeySelective(user2);
	    JSONObject userData=new JSONObject();
	    userData.put("userId", user.getUserId());
	    userData.put("userName", user.getUsername());
	    userData.put("email", user.getEmail());
	    //创建jwt
	    String token = JwtUtil.createJWT(Constants.uuid, JSON.toJSONString(userData), null);
	    return token;
	}
    
    
}

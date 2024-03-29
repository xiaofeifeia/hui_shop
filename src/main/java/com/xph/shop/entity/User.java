package com.xph.shop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "tb_user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	private Long userId;// 用户id

	@Column(name = "username")
	private String username;// 用户名

	@Column(name = "nickname")
	private String nickname;// 别名

	@Column(name = "password")
	private String password;// 密码

	@Column(name = "source_type")
	private Byte sourceType;// 0后台创建 1:微信小程序，2:PC，3：H5，4：Android，5：IOS

	@Column(name = "email")
	private String email;// 邮箱

	@Column(name = "headPic")
	private String headPic;// 头像

	@Column(name = "sex")
	private Integer sex;// 性别 0 默认0未知 1 男 2 女

	@Column(name = "phone")
	private String phone;// 手机号码

	@Column(name = "birthday")
	private String birthday;// 生日

	@Column(name = "address")
	private String address;// 地址

	@Column(name = "status")
	private Integer status;// 0 正常 1 禁用 2删除

	@Column(name = "createdate")
	private Date createDate;// 创建时间

	@Column(name = "updatedate")
	private Date updateDate;// 更新时间

	@Column(name = "last_login_time")
	private Date lastLoginTime;// 最后登录时间

}

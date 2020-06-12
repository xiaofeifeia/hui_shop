package com.xph.shop.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="t_user")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
	private Long userId;
	private String userName;
	private String password;
	private String email;
	private String phone;
	private Byte age;
	private Byte sex;
	private String birthDay;
	/**
	 * 注册来源
	 */
	private Byte registFrom;
	private Date createTime;
	private Date updateTime;
}

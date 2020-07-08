package com.xph.shop.entity;
import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

import lombok.Data;
/**
 * @Author:xph
 * @Description:Store构建
 */
@Data
@Table(name="tb_store")
public class Store implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

    @Column(name = "name")
	private String name;//店铺名

    @Column(name = "phone")
	private String phone;//门店联系电话

    @Column(name = "logo")
	private String logo;//

    @Column(name = "address")
	private String address;//地址

    @Column(name = "introduction")
	private String introduction;//门店介绍

    @Column(name = "delivery_time")
	private String deliveryTime;//配送时间

    @Column(name = "delivery_info")
	private String deliveryInfo;//配送信息

    @Column(name = "user_id")
	private Long userId;//创建人

    @Column(name = "createdate")
	private Date createdate;//

    @Column(name = "updatedate")
	private Date updatedate;//
    
    @Column(name="status")
    private Integer status;

}

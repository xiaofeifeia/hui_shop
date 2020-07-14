package com.xph.shop.entity;
import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

import lombok.Data;
/**
 * @Author:xph
 * @Description:Sku构建
 */
@Data
@Table(name="tb_sku")
public class Sku implements Serializable{

	@Id
    @Column(name = "id")
	private String id;//商品id

    @Column(name = "sn")
	private String sn;//商品条码

    @Column(name = "name")
	private String name;//SKU名称

    @Column(name = "price")
	private Integer price;//价格（分）
    
    @Column(name = "old_price")
    private Integer oldPrice;//旧的价格

    @Column(name = "num")
	private Integer num;//库存数量

    @Column(name = "alert_num")
	private Integer alertNum;//库存预警数量

    @Column(name = "image")
	private String image;//商品图片

    @Column(name = "images")
	private String images;//商品图片列表

    @Column(name = "weight")
	private Integer weight;//重量（克）

    @Column(name = "create_time")
	private Date createTime;//创建时间

    @Column(name = "update_time")
	private Date updateTime;//更新时间

    @Column(name = "spu_id")
	private String spuId;//SPUID

    @Column(name = "category_id")
	private Integer categoryId;//类目ID

    @Column(name = "category_name")
	private String categoryName;//类目名称

    @Column(name = "brand_name")
	private String brandName;//品牌名称

    @Column(name = "spec")
	private String spec;//规格

    @Column(name = "sale_num")
	private Integer saleNum;//销量

    @Column(name = "comment_num")
	private Integer commentNum;//评论数

    @Column(name = "status")
	private String status;//商品状态 1-正常，2-下架，3-删除

    @Column(name = "version")
	private Integer version;//


}

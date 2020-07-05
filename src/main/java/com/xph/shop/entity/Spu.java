package com.xph.shop.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

import lombok.Data;

/**
 * @Author:xph
 * @Description:Spu构建
 */
@Data
@Table(name = "tb_spu")
public class Spu implements Serializable {

	@Id
	@Column(name = "id")
	private String id;// 主键

	@Column(name = "sn")
	private String sn;// 货号

	@Column(name = "name")
	private String name;// SPU名

	@Column(name = "caption")
	private String caption;// 副标题

	@Column(name = "brand_id")
	private Integer brandId;// 品牌ID

	@Column(name = "category1_id")
	private Integer category1Id;// 一级分类

	@Column(name = "category2_id")
	private Integer category2Id;// 二级分类

	@Column(name = "category3_id")
	private Integer category3Id;// 三级分类

	@Column(name = "template_id")
	private Integer templateId;// 模板ID

	@Column(name = "freight_id")
	private Integer freightId;// 运费模板id

	@Column(name = "image")
	private String image;// 图片

	@Column(name = "images")
	private String images;// 图片列表

	@Column(name = "sale_service")
	private String saleService;// 售后服务

	@Column(name = "introduction")
	private String introduction;// 介绍

	@Column(name = "spec_items")
	private String specItems;// 规格列表

	@Column(name = "para_items")
	private String paraItems;// 参数列表

	@Column(name = "sale_num")
	private Integer saleNum;// 销量

	@Column(name = "comment_num")
	private Integer commentNum;// 评论数

	@Column(name = "is_marketable")
	private String isMarketable;// 是否上架

	@Column(name = "is_enable_spec")
	private String isEnableSpec;// 是否启用规格

	@Column(name = "is_delete")
	private Boolean isDelete;// 是否删除

	@Column(name = "audit_status")
	private Integer auditStatus;// 审核状态

	@Column(name = "audit_user")
	private Long auditUser;// 审核人

	@Column(name = "audit_info")
	private String auditInfo;// 审核详情

	@Column(name = "auditdate")
	private Date auditDate; // 审核时间

	@Column(name = "createdate")
	private Date createdate;// 创建时间

	@Column(name = "updatedate")
	private Date updatedate;// 更新时间

}

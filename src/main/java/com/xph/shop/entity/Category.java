package com.xph.shop.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

import lombok.Data;

/**
 * @Author:xph
 * @Description:Category构建
 */
@Table(name = "tb_category")
@Data
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;// 分类ID

	@Column(name = "name")
	private String name;// 分类名称
	
	@Column(name = "caption")
	private String caption;// 副名称
	
	@Column(name = "image")
	private String image;// 图片

	@Column(name = "goods_num")
	private Integer goodsNum;// 商品数量

	@Column(name = "is_show")
	private Boolean isShow;// 是否显示

	@Column(name = "is_menu")
	private Boolean isMenu;// 是否导航

	@Column(name = "seq")
	private Integer seq;// 排序

	@Column(name = "parent_id")
	private Integer parentId;// 上级ID

	@Column(name = "template_id")
	private Integer templateId;// 模板ID

	@Column(name = "createdate")
	private Date createdate;// 创建时间

	@Column(name = "updatedate")
	private Date updatedate;// 更新时间
	
	@Column(name = "status")
	private Integer status;// 状态

}

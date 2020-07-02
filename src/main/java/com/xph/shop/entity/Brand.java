package com.xph.shop.entity;
import javax.persistence.*;

import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
import java.util.Date;

import lombok.Data;
/**
 * @Author:xph
 * @Description:Brand构建
 */
@Table(name="tb_brand")
@Data
public class Brand implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//品牌id

    @Column(name = "name")
	private String name;//品牌名称

    @Column(name = "image")
	private String image;//品牌图片地址

    @Column(name = "letter")
	private String letter;//品牌的首字母

    @Column(name = "seq")
	private Integer seq;//排序

	@Column(name = "createdate")
	private Date createDate;// 创建时间

	@Column(name = "updatedate")
	private Date updateDate;// 更新时间


}

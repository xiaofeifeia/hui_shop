package com.xph.shop.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class GoodsEs implements Serializable {

	private String id;

	private String sn;

	private String name;
	private Double price;

	private Double oldPrice;

	private Long num;

	private Long alertNum;

	private String image;

	private String images;

	private Double weight;

	private Date createTime;

	private Date updateTime;

	private Integer brandId;

	private Integer category1Id;

	private Integer category2Id;

	private Integer category3Id;

	private String spec;

	private Long saleNum;

	private Long commentNum;

	private String status;

	private Integer version;
	
	private String isMarketable;

	private String isEnableSpec;

	private Boolean isDelete;

	private Integer auditStatus;
}

package com.xph.shop.vo;

import lombok.Data;

import com.xph.shop.entity.Category;

@Data
public class CategoryVo extends Category{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer level;

}

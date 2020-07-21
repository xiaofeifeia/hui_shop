package com.xph.shop.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.xph.shop.entity.Category;

@Data
public class CategoryTree {

	private Integer id;
	private String name;
	private String image;
	private Integer level;
	private Integer pId;
	private List<CategoryTree> children;

	public CategoryTree() {
		super();
	}

	public CategoryTree(Category c) {
		this.id = c.getId();
		this.name = c.getName();
		this.image = c.getImage();
		this.pId = c.getParentId();
		this.children = new ArrayList<>();
	}

}

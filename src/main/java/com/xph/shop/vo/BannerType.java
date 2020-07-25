package com.xph.shop.vo;

public enum BannerType {
	BANNER(0, "轮播"), NEW(1, "新品"), RECOMMEND(2, "推荐"), HOT(3, "热门");

	BannerType(int type, String name) {
		this.type = type;
		this.name = name;
	}

	private int type;
	private String name;

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

}

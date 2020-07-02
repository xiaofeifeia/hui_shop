package com.xph.shop.vo;

public enum UserStatus {
	
	ENABLE(0, "可用"), DISABLE(1, "禁用"), DELETE(2, "删除");

	private int status;
	private String name;

	UserStatus(int status, String name) {
		this.status = status;
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public String getName() {
		return name;
	}

}

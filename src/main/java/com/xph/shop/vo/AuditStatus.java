package com.xph.shop.vo;

public enum AuditStatus {
	
	INIT(0, "未审核"),IN_AUDIT(1,"审核中"), SUCCUSS(2, "审核通过"), FAIL(3, "审核失败");

	private int status;
	private String name;

	AuditStatus(int status, String name) {
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

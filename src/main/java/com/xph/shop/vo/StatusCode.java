package com.xph.shop.vo;

/**
 * 返回码
 */
public enum StatusCode {
    
    // 0-99用于系统级
    SUCCESS(200, "操作成功"),
    ERROR(20001, "当前服务器出错"),
    PARAM_ERROR(20002, "请求参数错误"),
    CODE_TEXT_ERROR(20003, "短信验证码错误"),
    FAIL(20004, "当前操作失败"),
    UPLOAD_FILE_EMPTY(20005,"上传文件为空"),
    UPLOAD_FAIL(20006,"上传失败"),
    
    //用户
    USER_NOT_FOUND(20100,"用户不存在"),
    USER_PASSWORD_ERROR(20101,"密码错误"),
    USER_NOT_LOGIN(20103,"用户未登录"),
    USER_LOGIN_INFO_ERROR(20104,"获取登录用户信息失败"),

    
    BRAND_NOT_FOUND(20200,"品牌不存在"),
    
    CATEGORY_NOT_FOUND(20300,"分类不存在"),
    
    SPU_NOT_FOUND(20400,"SKU不存在"),
    
    SKU_NOT_FOUND(20401,"商品不存在"),
    
    STORE_NOT_FOUND(20500,"门店不存在"),

    ;
    
    private int status;
    private String message;

    StatusCode(int status, String message) {
        this.status = status;
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}

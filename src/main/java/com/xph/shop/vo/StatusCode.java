package com.xph.shop.vo;

/**
 * 返回码
 */
public enum StatusCode {
    
    // 0-99用于系统级
    SUCCESS(200, "操作成功"),
    ERROR(20001, "当前服务器出错"),
    PARAM_ERROR(20002, "请求参数错误"),
    CODE_TEXT_ERROR(4, "短信验证码错误"),
    FAIL(5, "当前操作失败"),
    CODE_IMAGE_ERROR(6, "图形验证码错误"),
    OTHER_LOGIN(9, "用户在别处登录"),
    DATA_NULL(11, "数据查询为空"),
    PORTION_FAIL(12, "部分数据失败"),
    SCHOOL_CODE_CREATE_ERROR(13, "学校编码生成失败，请联系管理员"),
    CREATE_LOGIN_KEY_ERROR(14, "创建登录密钥失败"),
    SCHOOLCODE_IS_NULL(15, "请输入学校编码"),
    ACCOUNT_IS_NULL(16, "请输入登录账号"),
    PASSWORD_IS_NULL(17, "请输入登录密码"),
    MOBILE_IS_REGISTER(18, "手机号码已被注册"),
    
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

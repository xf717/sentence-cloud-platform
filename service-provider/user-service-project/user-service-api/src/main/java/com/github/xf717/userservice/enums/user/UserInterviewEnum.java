package com.github.xf717.userservice.enums.user;

/**
 * @author momo
 * @date 2021-04-02 14:57
 */
public enum UserInterviewEnum {
    WAITING_ACCEPT_INTERVIEW(0, "待接受面试"),
    WAITING_INTERVIEW(1, "待面试"),
    REFUSE_INTERVIEW(2, "拒绝面试"),
    ACCEPT_INTERVIEW(3, "接受面试"),
    PASSED_INTERVIEW(4, "通过面试"),
    UN_PASSED_INTERVIEW(5, "面试失败"),
    WAITING_OFFER(6, "等待录用"),
    REFUSE_OFFER(7, "拒绝录用"),
    ACCEPT_OFFER(8, "接受录用"),
    COMPANY_USER_CANCEL_INTERVIEW(9, "企业已取消"),
    USER_CANCEL_INTERVIEW(10, "用户已取消"),
    ;

    /**
     * 角色编码
     */
    private final Integer code;
    private final String name;

    UserInterviewEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }
}

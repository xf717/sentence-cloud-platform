package com.db.chaomaxs.positionservice.enums.position;

/**
 * @author momo
 * @date 2021-04-21 11:46
 */
public enum PositionStatusEnum {
    WAIT_AUDIT_POSITION(0, "等待发布"),
    AUDIT_PASSED_POSITION(1, "招聘中"),
    AUDIT_REFUSE_POSITION(2, "审核失败"),
    CLOSE_POSITION(3, "已关闭");

    private Integer code;
    private String name;

    PositionStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getByCode(Integer code) {
        for (PositionStatusEnum statusEnum : values()) {
            if (statusEnum.getCode() == code) {
                return statusEnum.getName();
            }
        }
        return null;
    }
}

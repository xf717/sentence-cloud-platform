package com.github.xf717.userservice.enums.user;

/**
 * @author hlf
 * @version 1.0
 * @description: 用户绑定状态枚举
 * @date 2021/4/29 16:17
 */
public enum UserBindingStateEnum {

  UNBOUND(0, "未绑定"),
  BOUND(1, "已绑定"),
  UNBIND(2, "已解绑"),
  REFUSED(3, "已拒绝");

  private final Integer value;
  private final String name;

  UserBindingStateEnum(Integer value, String name) {
    this.value = value;
    this.name = name;
  }

  public Integer getValue() {
    return value;
  }

  public String getName() {
    return name;
  }
}

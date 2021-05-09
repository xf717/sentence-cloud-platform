package com.github.xf717.common.framework.jwt;

/**
 * jwt 属性接口
 *
 * @author xiaofeng
 */
public interface IJWTInfo {

  /**
   * 获取用户名
   *
   * @return
   */
  String getUniqueName();

  /**
   * 获取用户ID
   *
   * @return
   */
  String getId();

  /**
   * 获取名称
   *
   * @return
   */
  String getName();

  /**
   * tokenId
   *
   * @return
   */
  String getTokenId();
}

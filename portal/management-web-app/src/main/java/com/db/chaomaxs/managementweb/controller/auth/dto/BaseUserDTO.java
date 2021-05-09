package com.db.chaomaxs.managementweb.controller.auth.dto;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
public class BaseUserDTO {

  /**
   *
   */
  private Long id;

  /**
   *
   */
  private String username;

  /**
   *
   */
  private String password;

  /**
   *
   */
  private String name;

  /**
   *
   */
  private String birthday;

  /**
   *
   */
  private String address;

  /**
   *
   */
  private String mobilePhone;

  /**
   *
   */
  private String telPhone;

  /**
   *
   */
  private String email;

  /**
   *
   */
  private String sex;

  /**
   *
   */
  private String type;

  /**
   *
   */
  private String status;

  /**
   *
   */
  private String description;

  /**
   *
   */
  private String crtHost;

  /**
   * 是否删除:1 是  0 否  默认：0
   */
  private Integer isDeleted;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 创建人
   */
  private Long createBy;

  /**
   * 修改时间
   */
  private Date updateTime;

  /**
   * 修改人
   */
  private Long updateBy;


}

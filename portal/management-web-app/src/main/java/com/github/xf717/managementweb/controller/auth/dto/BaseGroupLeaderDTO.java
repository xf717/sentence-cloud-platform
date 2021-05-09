package com.github.xf717.managementweb.controller.auth.dto;

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
public class BaseGroupLeaderDTO {

  /**
   *
   */
  private Long id;

  /**
   *
   */
  private Long groupId;

  /**
   *
   */
  private Long userId;

  /**
   *
   */
  private String description;

  /**
   *
   */
  private String updHost;

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

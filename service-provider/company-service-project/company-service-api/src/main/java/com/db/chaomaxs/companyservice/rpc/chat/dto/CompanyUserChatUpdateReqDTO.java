package com.db.chaomaxs.companyservice.rpc.chat.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 企业我的沟通
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
public class CompanyUserChatUpdateReqDTO implements Serializable {


  /**
   * 主键id
   */
  @NotEmpty(message = "主键id")
  private Long id;

  /**
   * 企业用户id
   */
  private Long companyUserId;

  /**
   * 企业id
   */
  private Long companyId;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 职位id
   */
  private Long positionId;

  /**
   * 沟通状态:0-未沟通 1-已沟通  2-其它
   */
  private Integer status;

  /**
   * 排序
   */
  private Integer sort;

  /**
   * 是否删除 0 - 否 1- 是
   */
  private Integer isDeleted;

  /**
   * 创建人
   */
  private Long createBy;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 修改时间
   */
  private Long updateBy;

  /**
   * 修改时间
   */
  private Date updateTime;


}

package com.db.chaomaxs.companyweb.controller.interview.dto;

import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 企业面试表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
public class CompanyUserInterviewDTO {

  /**
   * 主键id
   */
  private Long id;

  /**
   * 企业用户id
   */
  private Long companyUserId;

  /**
   * 企业用户id
   */
  private Long companyId;

  /**
   * 职位id
   */
  private Long positionId;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 地址
   */
  private String interviewAddress;

  /**
   * 面试时间
   */
  private Date interviemTime;

  /**
   * 职位名
   */
  private String positionName;

  /**
   * 手机号
   */
  private String mobile;

  /**
   * 状态 0 -  待接受面试 1 -  待面试 2 -  拒绝面试 3 - 通过面试 4 - 拒绝录用 5-  接受录用 6 - 已取消
   */
  private Integer status;

  /**
   * 是否删除 0 -  否  1 - 是
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
   * 修改人
   */
  private Long updateBy;

  /**
   * 修改时间
   */
  private Date updateTime;


}

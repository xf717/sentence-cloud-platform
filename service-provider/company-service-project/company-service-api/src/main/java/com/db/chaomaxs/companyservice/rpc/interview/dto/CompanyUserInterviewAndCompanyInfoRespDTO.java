package com.db.chaomaxs.companyservice.rpc.interview.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @description: 求职端面试返回信息
 * @author wst
 * @date 2021/4/15 9:57
 */

@Data
@Accessors(chain = true)
public class CompanyUserInterviewAndCompanyInfoRespDTO implements Serializable {

  /**
   * 主键id
   */
  private Long id;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 用户id
   */
  private Long companyId;


  /**
   * 职位id
   */
  private Long positionId;

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
   * 公司规模字典id
   */
  private Long scopeDictionaryId;

  /**
   * 公司规模
   */
  private String scope;

  /**
   * 发展阶段字典id
   */
  private Long developmentStageDictionaryId;

  /**
   * 公司规模
   */
  private String developmentStage;

  /**
   * 所属行业名称
   */
  private String industryName;

  /**
   * 公司全称
   */
  private String fullName;


  /**
   * 最低薪资
   */
  private Integer startSalary;

  /**
   * 最高薪资
   */
  private Integer endSalary;


}

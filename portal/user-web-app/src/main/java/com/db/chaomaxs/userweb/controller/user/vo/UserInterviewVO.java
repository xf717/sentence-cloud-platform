package com.db.chaomaxs.userweb.controller.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户面试表
 *
 * @author momo
 * @date 2021-04-02 13:58:28
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserInterviewVO", description = "用户面试表")
public class UserInterviewVO {

  /**
   * 主键id
   */
  @ApiModelProperty(name = "id", value = "主键id")
  private Long id;

  /**
   * 用户id
   */
  @ApiModelProperty(name = "userId", value = "用户id")
  private Long userId;


  /**
   * 企业用户id
   */
  @ApiModelProperty(name = "companyUserId", value = "企业用户id")
  private Long companyUserId;

  /**
   * 企业用户面试表id
   */
  @ApiModelProperty(name = "companyUserInterviewId", value = "企业用户面试表id")
  private Long companyUserInterviewId;

  /**
   * 手机号
   */
  @ApiModelProperty(name = "mobile", value = "手机号")
  private String mobile;

  /**
   * 状态 0 -  待接受面试 1 -  待面试 2 -  拒绝面试 3 - 通过面试 4 - 拒绝录用 5-  接受录用 6 - 企业已取消 7 - 用户已取消
   */
  @ApiModelProperty(name = "status", value = "状态 0 -  待接受面试 1 -  待面试 2 -  拒绝面试 3 - 通过面试 4 - 拒绝录用 5-  接受录用 6 - 企业已取消 7 - 用户已取消")
  private Integer status;

  /**
   * 职位名
   */
  @ApiModelProperty(name = "positionName", value = "职位名")
  private String positionName;

  /**
   * 面试时间
   */
  @ApiModelProperty(name = "interviemTime", value = "面试时间")
  private String interviemTime;

  /**
   * 地址
   */
  @ApiModelProperty(name = "interviemTime", value = "地址")
  private String interviewAddress;

  /**
   * 薪资范围
   */
  @ApiModelProperty(name = "interviemTime", value = "地址")
  private String salaryRange;

  /**
   * 公司规模
   */
  @ApiModelProperty(name = "scope", value = "公司规模")
  private String scope;

  /**
   * 发展阶段
   */
  @ApiModelProperty(name = "developmentStage", value = "发展阶段")
  private String developmentStage;

  /**
   * 所属行业名称
   */
  @ApiModelProperty(name = "industryName", value = "所属行业名称")
  private String industryName;

  /**
   * 公司id
   */
  @ApiModelProperty(name = "companyId", value = "公司id")
  private Long companyId;


  /**
   * 公司全称
   */
  @ApiModelProperty(name = "fullName", value = "公司全称")
  private String fullName;

  /**
   * 最低薪资
   */
  @ApiModelProperty(name = "startSalary", value = "最低薪资")
  private Integer startSalary;

  /**
   * 最高薪资
   */
  @ApiModelProperty(name = "endSalary", value = "最高薪资")
  private Integer endSalary;


}

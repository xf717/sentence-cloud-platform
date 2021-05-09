package com.github.xf717.userweb.controller.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 企业投递表
 *
 * @author momo
 * @date 2021-04-08 14:18:28
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserDeliveryVO", description = "企业投递表")
public class UserDeliveryVO {

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
   * 企业id
   */
  @ApiModelProperty(name = "companyId", value = "企业id")
  private Long companyId;

  /**
   * 职位id
   */
  @ApiModelProperty(name = "positionId", value = "职位id")
  private Long positionId;

  /**
   * 状态
   */
  @ApiModelProperty(name = "status", value = "状态")
  private Integer status;

  /**
   * 创建时间
   */
  @ApiModelProperty(name = "createTime", value = "创建时间")
  private Date createTime;

  /**
   * 公司全称
   */
  @ApiModelProperty(name = "fullName", value = "公司全称")
  private String fullName;

  /**
   * 发展阶段
   */
  @ApiModelProperty(name = "developmentStage", value = "发展阶段")
  private String developmentStage;

  /**
   * 公司规模
   */
  @ApiModelProperty(name = "scope", value = "公司规模")
  private String scope;

  /**
   * 招聘者姓名
   */
  @ApiModelProperty(name = "realName", value = "招聘者姓名")
  private String realName;

  /**
   * 职位名称
   */
  @ApiModelProperty(name = "positionName", value = "职位名称")
  private String positionName;

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

  /**
   * 经验要求
   */
  @ApiModelProperty(name = "experience", value = "经验要求")
  private String experience;

  /**
   * 学历
   */
  @ApiModelProperty(name = "education", value = "学历")
  private String education;

  /**
   * 商圈
   */
  @ApiModelProperty(name = "businessDistrict", value = "商圈")
  private String businessDistrict;

  /**
   * 职位关键字
   */
  @ApiModelProperty(name = "keywordList", value = "职位关键字")
  private List<CompanyPositionKeywordVO> keywordList;

}

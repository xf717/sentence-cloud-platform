package com.github.xf717.userweb.controller.user.vo;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 记录用户签到记录信息
 *
 * @author wst
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserIntegralRecordVO", description = "记录用户签到记录信息")
public class UserIntegralRecordVO {

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 用户id
   */
  @ApiModelProperty(name = "userId", value = "用户id")
  private Long userId;

  /**
   * 手机号码
   */
  @ApiModelProperty(name = "mobile", value = "手机号码")
  private String mobile;

  /**
   * 连续签到天数
   */
  @ApiModelProperty(name = "checkDay", value = "连续签到天数")
  private Integer checkDay;

  /**
   * 签到时间
   */
  @ApiModelProperty(name = "signInTime", value = "签到时间")
  private Date signInTime;

  /**
   * 积分说明,字典表id
   */
  @ApiModelProperty(name = "integralExplanationDictionaryId", value = "积分说明,字典表id")
  private Long integralExplanationDictionaryId;

  /**
   * 积分类型:关联字典表id
   */
  @ApiModelProperty(name = "integralTypeDictionaryId", value = "积分类型:关联字典表id")
  private Long integralTypeDictionaryId;

  /**
   * 积分值
   */
  @ApiModelProperty(name = "integralValue", value = "积分值")
  private Integer integralValue;


}

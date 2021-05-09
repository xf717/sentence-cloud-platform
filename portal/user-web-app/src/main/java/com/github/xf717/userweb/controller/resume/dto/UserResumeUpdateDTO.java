package com.github.xf717.userweb.controller.resume.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 用户_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserResumeUpdateDTO", description = "更新用户_简历")
public class UserResumeUpdateDTO {

  /**
   * 主键Id
   */
  @ApiModelProperty(name = "id", value = "主键Id")
  private Long id;

  /**
   * 用户id
   */
  @ApiModelProperty(name = "userId", value = "用户id")
  private Long userId;

  /**
   * 出生年
   */
  @ApiModelProperty(name = "birthdayYear", value = "出生年")
  private Integer birthdayYear;

  /**
   * 出身月
   */
  @ApiModelProperty(name = "birthdayMonth", value = "出身月")
  private Integer birthdayMonth;

  /**
   * 出生日
   */
  @ApiModelProperty(name = "birthdayDay", value = "出生日")
  private Integer birthdayDay;

  /**
   * 参加工作时间
   */
  @ApiModelProperty(name = "participateJob", value = "参加工作时间")
  private Integer participateJob;

  /**
   * 工作年限
   */
  @ApiModelProperty(name = "workYearTotal", value = "工作年限")
  private Integer workYearTotal;

  /**
   * 自我评价
   */
  @ApiModelProperty(name = "evaluate", value = "自我评价")
  private String evaluate;

  /**
   * 求职状态:关键字典表id
   */
  @ApiModelProperty(name = "positionWantedDictionaryId", value = "求职状态:关键字典表id")
  private Long positionWantedDictionaryId;

  /**
   * 求职状态名称，冗余字段
   */
  @ApiModelProperty(name = "positionWantedStatusName", value = "求职状态名称，冗余字段")
  private String positionWantedStatusName;


}

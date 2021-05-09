package com.github.xf717.userweb.controller.resume.vo;


import io.swagger.annotations.ApiModel;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @description: 用户_期望职位和求职状态
 * @author wst
 * @date 2021/4/7 16:04
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "UserExpectedAndStatusVO",description = "用户_期望职位和求职状态")
public class UserExpectedAndStatusVO {

  /**
   * 用户简历id
   */
  private Long userResumeId;

  /**
   * 求职状态:关键字典表id
   */
  private Long positionWantedDictionaryId;

  /**
   * 求职状态名称，冗余字段
   */
  private String positionWantedStatusName;

  /**
   * 用户求职期望职位
   */
  private List<UserExpectedPositionVO> userExpectedPositionVOList;
}

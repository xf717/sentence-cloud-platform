package com.db.chaomaxs.userweb.controller.user.dto;

import java.util.Date;

import com.db.chaomaxs.common.framework.vo.PageParam;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 记录用户签到记录信息
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "UserIntegralRecordPageDTO", description = "分页:记录用户签到记录信息")
public class UserIntegralRecordPageDTO extends PageParam {

	private static final long serialVersionUID = 1L;

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

  /**
   * 是否删除 1:是 0否  默认：0
   */
  @ApiModelProperty(name = "isDeleted", value = "是否删除 1:是 0否  默认：0")
  private Integer isDeleted;

  /**
   * 创建时间
   */
  @ApiModelProperty(name = "createTime", value = "创建时间")
  private Date createTime;

  /**
   * 创建人
   */
  @ApiModelProperty(name = "createBy", value = "创建人")
  private Long createBy;

  /**
   * 修改时间
   */
  @ApiModelProperty(name = "updateTime", value = "修改时间")
  private Date updateTime;

  /**
   * 修改人
   */
  @ApiModelProperty(name = "updateBy", value = "修改人")
  private Long updateBy;


}

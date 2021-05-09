package com.db.chaomaxs.userweb.controller.resume.dto;

import java.util.Date;

import com.db.chaomaxs.common.framework.vo.PageParam;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 用户_专业技能表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "UserProfessionalSkillPageDTO", description = "分页:用户_专业技能表")
public class UserProfessionalSkillPageDTO extends PageParam {

	private static final long serialVersionUID = 1L;

  /**
   * 用户消息id
   */
  @ApiModelProperty(name = "id", value = "用户消息id")
  private Long id;

  /**
   * 用户id
   */
  @ApiModelProperty(name = "userResumeId", value = "用户id")
  private Long userResumeId;

  /**
   * 阅读时长
   */
  @ApiModelProperty(name = "skillName", value = "阅读时长")
  private String skillName;

  /**
   * 读完多少本
   */
  @ApiModelProperty(name = "durationNum", value = "读完多少本")
  private Integer durationNum;

  /**
   * 掌握程度，关联字典表id
   */
  @ApiModelProperty(name = "masteryDictionaryId", value = "掌握程度，关联字典表id")
  private Long masteryDictionaryId;

  /**
   * 公司id,做为数据隔离
   */
  @ApiModelProperty(name = "companyId", value = "公司id,做为数据隔离")
  private Long companyId;

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

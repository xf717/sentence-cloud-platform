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
 * 就可以去掉 用户_工作经历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "UserWorkExperiencePageDTO", description = "分页:用户_工作经历")
public class UserWorkExperiencePageDTO extends PageParam {

	private static final long serialVersionUID = 1L;

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 用户简历id,关联user_resume 主键id
   */
  @ApiModelProperty(name = "userResumeId", value = "用户简历id,关联user_resume 主键id")
  private Long userResumeId;

  /**
   * 公司名称
   */
  @ApiModelProperty(name = "companyName", value = "公司名称")
  private String companyName;

  /**
   * 公司id,做为数据隔离
   */
  @ApiModelProperty(name = "companyId", value = "公司id,做为数据隔离")
  private Long companyId;

  /**
   * 职位分类id：关键职位字典表id
   */
  @ApiModelProperty(name = "positionTypeId", value = "职位分类id：关键职位字典表id")
  private Long positionTypeId;

  /**
   * 职位分类名称
   */
  @ApiModelProperty(name = "positionTypeName", value = "职位分类名称")
  private String positionTypeName;

  /**
   * 职位名称,冗余字段
   */
  @ApiModelProperty(name = "positionName", value = "职位名称,冗余字段")
  private String positionName;

  /**
   * 所属行业id,关联行业字典表id
   */
  @ApiModelProperty(name = "industryId", value = "所属行业id,关联行业字典表id")
  private Long industryId;

  /**
   * 所属行业名称,冗余字段
   */
  @ApiModelProperty(name = "industryName", value = "所属行业名称,冗余字段")
  private String industryName;

  /**
   * 工作内容
   */
  @ApiModelProperty(name = "content", value = "工作内容")
  private String content;

  /**
   * 入职时间
   */
  @ApiModelProperty(name = "startJobTime", value = "入职时间")
  private Integer startJobTime;

  /**
   * 离职时间：-1值代表至今
   */
  @ApiModelProperty(name = "quitJobTime", value = "离职时间：-1值代表至今")
  private Integer quitJobTime;

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

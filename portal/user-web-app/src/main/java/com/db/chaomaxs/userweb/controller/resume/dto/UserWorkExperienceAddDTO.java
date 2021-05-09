package com.db.chaomaxs.userweb.controller.resume.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_工作经历
 *
 * @author wst
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserWorkExperienceCreateDTO", description = "添加用户_工作经历")
public class UserWorkExperienceAddDTO {


  /**
   * 公司名称
   */
  @ApiModelProperty(name = "companyName", value = "公司名称")
  private String companyName;

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
   * 技能标签
   */
  @ApiModelProperty(name = "workSkillTagList", value = "技能标签")
  private List<String> workSkillTagList;


}

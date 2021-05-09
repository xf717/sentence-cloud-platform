package com.db.chaomaxs.userweb.controller.resume.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 *用户_工作经历_技能标签信息表
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserWorkSkillTagVO",description = "用户_工作经历_技能标签信息表")
public class UserWorkSkillTagVO{

    	/**
	 * 系统id
	 */
	@ApiModelProperty(name ="id", value = "系统id")
	private Long id;
    
    	/**
	 * 工作经历ID
	 */
	@ApiModelProperty(name ="workExperienceId" ,value = "工作经历ID")
	private Long workExperienceId;
    
    	/**
	 * 技能标签
	 */
	@ApiModelProperty(name ="skillTag" ,value = "技能标签")
	private String skillTag;

}

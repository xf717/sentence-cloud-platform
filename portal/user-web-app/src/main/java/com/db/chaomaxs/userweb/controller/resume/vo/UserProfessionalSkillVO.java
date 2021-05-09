package com.db.chaomaxs.userweb.controller.resume.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 *用户_专业技能表
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserProfessionalSkillVO",description = "用户_专业技能表")
public class UserProfessionalSkillVO{

    	/**
	 * 用户消息id
	 */
	@ApiModelProperty(name ="id", value = "用户消息id")
	private Long id;
    
    	/**
	 * 用户id
	 */
	@ApiModelProperty(name ="userResumeId" ,value = "用户id")
	private Long userResumeId;
    
    	/**
	 * 技能名称
	 */
	@ApiModelProperty(name ="skillName" ,value = "技能名称")
	private String skillName;
    
    	/**
	 * 持续时间
	 */
	@ApiModelProperty(name ="durationNum" ,value = "持续时间")
	private Integer durationNum;
    
    	/**
	 * 掌握程度，关联字典表id
	 */
	@ApiModelProperty(name ="masteryDictionaryId" ,value = "掌握程度，关联字典表id")
	private Long masteryDictionaryId;

}

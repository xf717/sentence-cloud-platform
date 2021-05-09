package com.github.xf717.userweb.controller.resume.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 用户_专业技能表
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserProfessionalSkillUpdateDTO",description = "更新用户_专业技能表")
public class UserProfessionalSkillUpdateDTO {

    	/**
	 * 用户消息id
	 */
	@ApiModelProperty(name ="id",value = "用户消息id")
	private Long id;
    
    	/**
	 * 用户id
	 */
	@ApiModelProperty(name ="userResumeId", value = "用户id")
	private Long userResumeId;
    
    	/**
	 * 技能名称
	 */
	@ApiModelProperty(name ="skillName", value = "阅读时长")
	private String skillName;
    
    	/**
	 * 使用时长
	 */
	@ApiModelProperty(name ="durationNum", value = "读完多少本")
	private Integer durationNum;
    
    	/**
	 * 掌握程度，关联字典表id
	 */
	@ApiModelProperty(name ="masteryDictionaryId", value = "掌握程度，关联字典表id")
	private Long masteryDictionaryId;
}

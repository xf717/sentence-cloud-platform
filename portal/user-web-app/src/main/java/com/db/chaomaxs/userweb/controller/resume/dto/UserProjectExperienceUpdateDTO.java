package com.db.chaomaxs.userweb.controller.resume.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 用户_项目经历
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserProjectExperienceUpdateDTO",description = "更新用户_项目经历")
public class UserProjectExperienceUpdateDTO {

    	/**
	 * 系统id
	 */
	@ApiModelProperty(name ="id",value = "系统id")
	private Long id;
    
    	/**
	 * 用户简历id,关联user_resume表id
	 */
	@ApiModelProperty(name ="userResumeId", value = "用户简历id,关联user_resume表id")
	private Long userResumeId;
    
    	/**
	 * 项目名称
	 */
	@ApiModelProperty(name ="projectName", value = "项目名称")
	private String projectName;
    
    	/**
	 * 项目开始时间
	 */
	@ApiModelProperty(name ="startTime", value = "项目开始时间")
	private Date startTime;
    
    	/**
	 * 项目结束时间
	 */
	@ApiModelProperty(name ="endTime", value = "项目结束时间")
	private Date endTime;
    
    	/**
	 * 项目描述
	 */
	@ApiModelProperty(name ="description", value = "项目描述")
	private String description;
}

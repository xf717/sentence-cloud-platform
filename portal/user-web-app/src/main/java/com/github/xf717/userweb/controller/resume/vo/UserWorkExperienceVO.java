package com.github.xf717.userweb.controller.resume.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 *用户_工作经历
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserWorkExperienceVO",description = "用户_工作经历")
public class UserWorkExperienceVO{

    	/**
	 * 系统id
	 */
	@ApiModelProperty(name ="id", value = "系统id")
	private Long id;
    
    	/**
	 * 用户简历id,关联user_resume 主键id
	 */
	@ApiModelProperty(name ="userResumeId" ,value = "用户简历id,关联user_resume 主键id")
	private Long userResumeId;
    
    	/**
	 * 公司名称
	 */
	@ApiModelProperty(name ="companyName" ,value = "公司名称")
	private String companyName;
    
    	/**
	 * 职位名称,冗余字段
	 */
	@ApiModelProperty(name ="positionName" ,value = "职位名称,冗余字段")
	private String positionName;
    
    	/**
	 * 入职时间
	 */
	@ApiModelProperty(name ="startJobTime" ,value = "入职时间")
	private Integer startJobTime;
    
    	/**
	 * 离职时间：-1值代表至今
	 */
	@ApiModelProperty(name ="quitJobTime" ,value = "离职时间：-1值代表至今")
	private Integer quitJobTime;

	/**
	 * 工作内容
	 */
	@ApiModelProperty(name ="content", value = "工作内容")
	private String content;
	/**
	 * 技能标签
	 */
	private List<UserWorkSkillTagVO> workSkillTagList;


}

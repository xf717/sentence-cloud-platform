package com.github.xf717.userweb.controller.resume.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 *用户_附件_简历
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserEnclosureResumeVO",description = "用户_附件_简历")
public class UserEnclosureResumeVO{

    	/**
	 * 主键Id
	 */
	@ApiModelProperty(name ="id", value = "主键Id")
	private Long id;
    
    	/**
	 * 用户id
	 */
	@ApiModelProperty(name ="userId" ,value = "用户id")
	private Long userId;
    
    	/**
	 * 附件资源ID
	 */
	@ApiModelProperty(name ="resourceId" ,value = "附件资源ID")
	private Long resourceId;

	/**
	 * 简历名称
	 */
	@ApiModelProperty(name ="fileName" ,value = "简历名称")
	private String resumeName;


	/**
	 * 创建时间
	 */
	@ApiModelProperty(name ="createTime" ,value = "创建时间")
	private Date createTime;


}

package com.github.xf717.userweb.controller.resume.vo;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 *用户_资格证书表
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserCredentialVO",description = "用户_资格证书表")
public class UserCredentialVO{

    	/**
	 * 系统id
	 */
	@ApiModelProperty(name ="id", value = "系统id")
	private Long id;
    
    	/**
	 * 用户id
	 */
	@ApiModelProperty(name ="userResumeId" ,value = "用户id")
	private Long userResumeId;
    
    	/**
	 * 证书名称
	 */
	@ApiModelProperty(name ="name" ,value = "证书名称")
	private String name;
    
    	/**
	 * 获得开始时间
	 */
	@ApiModelProperty(name ="startTime" ,value = "获得开始时间")
	private Date startTime;
    
    	/**
	 * 获得证书结束时间
	 */
	@ApiModelProperty(name ="endTime" ,value = "获得证书结束时间")
	private Date endTime;

}

package com.db.chaomaxs.managementweb.controller.feedback.vo;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 *内容管理_意见反馈_扩展信息表
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "OpinionFeedbackExtendVO",description = "内容管理_意见反馈_扩展信息表")
public class OpinionFeedbackExtendVO{

    	/**
	 * 系统id
	 */
	@ApiModelProperty(name ="id", value = "系统id")
	private Long id;
    
    	/**
	 * 反馈内容
	 */
	@ApiModelProperty(name ="feedbackContent" ,value = "反馈内容")
	private String feedbackContent;
    
    	/**
	 * 内容
	 */
	@ApiModelProperty(name ="content" ,value = "内容")
	private String content;
    
    	/**
	 * 意见反馈ID
	 */
	@ApiModelProperty(name ="opinionFeedbackId" ,value = "意见反馈ID")
	private Long opinionFeedbackId;
    
    	/**
	 * 是否删除 1:是 0否  默认：0
	 */
	@ApiModelProperty(name ="isDeleted" ,value = "是否删除 1:是 0否  默认：0")
	private Integer isDeleted;
    
    	/**
	 * 创建时间
	 */
	@ApiModelProperty(name ="createTime" ,value = "创建时间")
	private Date createTime;
    
    	/**
	 * 创建人
	 */
	@ApiModelProperty(name ="createBy" ,value = "创建人")
	private Long createBy;
    
    	/**
	 * 修改时间
	 */
	@ApiModelProperty(name ="updateTime" ,value = "修改时间")
	private Date updateTime;
    
    	/**
	 * 修改人
	 */
	@ApiModelProperty(name ="updateBy" ,value = "修改人")
	private Long updateBy;
    

}

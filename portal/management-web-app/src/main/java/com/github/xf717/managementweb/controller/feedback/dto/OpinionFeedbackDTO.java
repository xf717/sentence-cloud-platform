package com.github.xf717.managementweb.controller.feedback.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 意见反馈信息表
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Data
@Accessors(chain = true)
public class OpinionFeedbackDTO {

    	/**
	 * 系统id
	 */
	private Long id;
    
    	/**
	 * 反馈人
	 */
	private Long feedbackBy;
    
    	/**
	 * 反馈手机号码
	 */
	private String mobile;
    
    	/**
	 * 反馈平台类型(1求职端小程序,2企业端小程序,3企业端PC,4微信)
	 */
	private Integer releasePlatformType;
    
    	/**
	 * 反馈时间
	 */
	private Date releaseTime;
    
    	/**
	 * 处理状态(0待处理,1处理中,3已处理)
	 */
	private Integer handleStatus;
    
    	/**
	 * 是否删除 1:是 0否  默认：0
	 */
	private Integer isDeleted;
    
    	/**
	 * 创建时间
	 */
	private Date createTime;
    
    	/**
	 * 创建人
	 */
	private Long createBy;
    
    	/**
	 * 修改时间
	 */
	private Date updateTime;
    
    	/**
	 * 修改人
	 */
	private Long updateBy;
    

}

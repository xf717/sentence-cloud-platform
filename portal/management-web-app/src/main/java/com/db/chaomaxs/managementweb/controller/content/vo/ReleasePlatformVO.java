package com.db.chaomaxs.managementweb.controller.content.vo;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 *发布平台
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ReleasePlatformVO",description = "发布平台")
public class ReleasePlatformVO{

    	/**
	 * 系统id
	 */
	@ApiModelProperty(name ="id", value = "系统id")
	private Long id;
    
    	/**
	 * 发布平台类型:1.发布平台模块  2.消息通知模块
	 */
	@ApiModelProperty(name ="releasePlatformType" ,value = "发布平台类型:1.发布平台模块  2.消息通知模块")
	private Integer releasePlatformType;
    
    	/**
	 * 信息ID
	 */
	@ApiModelProperty(name ="infoId" ,value = "信息ID")
	private Long infoId;
    
    	/**
	 * 类型(1-消息,2-通知)
	 */
	@ApiModelProperty(name ="type" ,value = "类型(1-消息,2-通知)")
	private Integer type;
    
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

package com.github.xf717.managementweb.controller.content.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 发布平台
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ReleasePlatformUpdateDTO",description = "更新发布平台")
public class ReleasePlatformUpdateDTO {

    	/**
	 * 系统id
	 */
	@ApiModelProperty(name ="id",value = "系统id")
	private Long id;
    
    	/**
	 * 发布平台类型:1.发布平台模块  2.消息通知模块
	 */
	@ApiModelProperty(name ="releasePlatformType", value = "发布平台类型:1.发布平台模块  2.消息通知模块")
	private Integer releasePlatformType;
    
    	/**
	 * 信息ID
	 */
	@ApiModelProperty(name ="infoId", value = "信息ID")
	private Long infoId;
    
    	/**
	 * 类型(1-消息,2-通知)
	 */
	@ApiModelProperty(name ="type", value = "类型(1-消息,2-通知)")
	private Integer type;
    
    	/**
	 * 是否删除 1:是 0否  默认：0
	 */
	@ApiModelProperty(name ="isDeleted", value = "是否删除 1:是 0否  默认：0")
	private Integer isDeleted;
    
    	/**
	 * 创建时间
	 */
	@ApiModelProperty(name ="createTime", value = "创建时间")
	private Date createTime;
    
    	/**
	 * 创建人
	 */
	@ApiModelProperty(name ="createBy", value = "创建人")
	private Long createBy;
    
    	/**
	 * 修改时间
	 */
	@ApiModelProperty(name ="updateTime", value = "修改时间")
	private Date updateTime;
    
    	/**
	 * 修改人
	 */
	@ApiModelProperty(name ="updateBy", value = "修改人")
	private Long updateBy;
    

}

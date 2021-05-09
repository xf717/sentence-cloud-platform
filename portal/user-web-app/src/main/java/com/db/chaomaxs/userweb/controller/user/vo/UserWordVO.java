package com.db.chaomaxs.userweb.controller.user.vo;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 *用户_常用语
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserWordVO",description = "用户_常用语")
public class UserWordVO{

    	/**
	 * 
	 */
	@ApiModelProperty(name ="id", value = "")
	private Long id;
    
    	/**
	 * 内容
	 */
	@ApiModelProperty(name ="content" ,value = "内容")
	private String content;
    
    	/**
	 * 用户id
	 */
	@ApiModelProperty(name ="userId" ,value = "用户id")
	private Long userId;
    
    	/**
	 * 排序
	 */
	@ApiModelProperty(name ="sort" ,value = "排序")
	private Integer sort;
    
    	/**
	 * 是否删除  0 - 否 1 - 是 
	 */
	@ApiModelProperty(name ="isDeleted" ,value = "是否删除  0 - 否 1 - 是 ")
	private Integer isDeleted;
    
    	/**
	 * 创建人
	 */
	@ApiModelProperty(name ="createBy" ,value = "创建人")
	private Long createBy;
    
    	/**
	 * 创建时间
	 */
	@ApiModelProperty(name ="createTime" ,value = "创建时间")
	private Date createTime;
    
    	/**
	 * 修改人
	 */
	@ApiModelProperty(name ="updateBy" ,value = "修改人")
	private Long updateBy;
    
    	/**
	 * 修改时间
	 */
	@ApiModelProperty(name ="updateTime" ,value = "修改时间")
	private Date updateTime;
    

}

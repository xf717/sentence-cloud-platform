package com.github.xf717.userweb.controller.user.vo;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 *用户_沟通
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserChatVO",description = "用户_沟通")
public class UserChatVO{

    	/**
	 * 主键id
	 */
	@ApiModelProperty(name ="id", value = "主键id")
	private Long id;
    
    	/**
	 * 企业发布的职位id
	 */
	@ApiModelProperty(name ="positionId" ,value = "企业发布的职位id")
	private Long positionId;
    
    	/**
	 * 用户id
	 */
	@ApiModelProperty(name ="userId" ,value = "用户id")
	private Long userId;
    
    	/**
	 * 企业用户id
	 */
	@ApiModelProperty(name ="companyUserId" ,value = "企业用户id")
	private Long companyUserId;
    
    	/**
	 * 状态
	 */
	@ApiModelProperty(name ="status" ,value = "状态")
	private Integer status;
    
    	/**
	 * 排序
	 */
	@ApiModelProperty(name ="sort" ,value = "排序")
	private Integer sort;
    
    	/**
	 * 是否删除 0 - 否 1-是
	 */
	@ApiModelProperty(name ="isDeleted" ,value = "是否删除 0 - 否 1-是")
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

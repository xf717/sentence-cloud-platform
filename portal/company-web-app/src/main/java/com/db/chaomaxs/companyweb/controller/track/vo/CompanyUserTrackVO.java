package com.db.chaomaxs.companyweb.controller.track.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 *企业我的足迹
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyUserTrackVO",description = "企业我的足迹")
public class CompanyUserTrackVO implements Serializable {

    private static final long serialVersionUID = 1L;

    	/**
	 * 主键id
	 */
	@ApiModelProperty(name ="id", value = "主键id")
	private Long id;
    
    	/**
	 * 企业用户id
	 */
	@ApiModelProperty(name ="companyUserId" ,value = "企业用户id")
	private Long companyUserId;
    
    	/**
	 * 职位id
	 */
	@ApiModelProperty(name ="positionId" ,value = "职位id")
	private Long positionId;
    
    	/**
	 * 用户id
	 */
	@ApiModelProperty(name ="userId" ,value = "用户id")
	private Long userId;
    
    	/**
	 * 是否删除 0-否 1-是
	 */
	@ApiModelProperty(name ="isDeleted" ,value = "是否删除 0-否 1-是")
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

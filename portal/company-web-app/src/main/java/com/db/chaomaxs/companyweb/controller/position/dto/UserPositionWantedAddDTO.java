package com.db.chaomaxs.companyweb.controller.position.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 用户求职
 * @author xiaofeng
 * @date 2021-03-29 16:36:57
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserPositionWantedCreateDTO",description = "添加用户求职")
public class UserPositionWantedAddDTO {

    	/**
	 * 系统id
	 */
	@ApiModelProperty(name ="id",value = "系统id")
	private Long id;
    
    	/**
	 * 企业ID
	 */
	@ApiModelProperty(name ="companyId", value = "企业ID")
	private Long companyId;
    
    	/**
	 * 职位id,关键企业发布职位表
	 */
	@ApiModelProperty(name ="positionId", value = "职位id,关键企业发布职位表")
	private Long positionId;
    
    	/**
	 * 职位名称：冗余字段
	 */
	@ApiModelProperty(name ="positionName", value = "职位名称：冗余字段")
	private String positionName;
    
    	/**
	 * 经验要求：关联经验要求表主键id
	 */
	@ApiModelProperty(name ="userResumeId", value = "经验要求：关联经验要求表主键id")
	private Long userResumeId;
    
    	/**
	 * 是否删除:1 是  0 否  默认：0
	 */
	@ApiModelProperty(name ="isDeleted", value = "是否删除:1 是  0 否  默认：0")
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

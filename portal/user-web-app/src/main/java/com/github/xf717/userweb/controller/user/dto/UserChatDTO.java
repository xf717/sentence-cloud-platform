package com.github.xf717.userweb.controller.user.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 用户_沟通
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@Accessors(chain = true)
public class UserChatDTO {

    	/**
	 * 主键id
	 */
	private Long id;
    
    	/**
	 * 企业发布的职位id
	 */
	private Long positionId;
    
    	/**
	 * 用户id
	 */
	private Long userId;
    
    	/**
	 * 企业用户id
	 */
	private Long companyUserId;
    
    	/**
	 * 状态
	 */
	private Integer status;
    
    	/**
	 * 排序
	 */
	private Integer sort;
    
    	/**
	 * 是否删除 0 - 否 1-是
	 */
	private Integer isDeleted;
    
    	/**
	 * 创建人
	 */
	private Long createBy;
    
    	/**
	 * 创建时间
	 */
	private Date createTime;
    
    	/**
	 * 修改人
	 */
	private Long updateBy;
    
    	/**
	 * 修改时间
	 */
	private Date updateTime;
    

}

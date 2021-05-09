package com.db.chaomaxs.userweb.controller.user.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 企业投递表
 * @author momo
 * @date 2021-04-08 14:18:28
 */
@Data
@Accessors(chain = true)
public class UserDeliveryDTO {

    	/**
	 * 主键id
	 */
	private Long id;
    
    	/**
	 * 用户id
	 */
	private Long userId;
    
    	/**
	 * 企业用户id
	 */
	private Long companyUserId;
    
    	/**
	 * 企业id
	 */
	private Long companyId;
    
    	/**
	 * 职位id
	 */
	private Long positionId;
    
    	/**
	 * 状态
	 */
	private Integer status;
    
    	/**
	 * 是否删除
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

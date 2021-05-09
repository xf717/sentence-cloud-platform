package com.github.xf717.userweb.controller.user.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 用户_设置
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@Accessors(chain = true)
public class UserSetDTO {

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
	 * 是否拉入黑名单
            0 - 否
            1 - 是
	 */
	private Integer blackSwitch;
    
    	/**
	 * 是否拉黑职位
            0 - 否
            1 - 是
	 */
	private Integer blackCompanyUserSwitch;
    
    	/**
	 * 消息是否置顶
            0 - 否
            1 - 是
	 */
	private Integer topSwitch;
    
    	/**
	 * 是否删除  0 - 否 1 - 是
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

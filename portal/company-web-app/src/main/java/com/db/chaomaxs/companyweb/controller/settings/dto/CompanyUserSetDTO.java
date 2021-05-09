package com.db.chaomaxs.companyweb.controller.settings.dto;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;



/**
 * 企业我的设置
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
public class CompanyUserSetDTO {

    	/**
	 * 主键id
	 */
	private Long id;
    
    	/**
	 * 企业用户id
	 */
	private Long companyUserId;
    
    	/**
	 * 企业id
	 */
	private Long companyId;
    
    	/**
	 * 用户id
	 */
	private Long userId;
    
    	/**
	 * 是否拉入黑名单
            0 - 否
            1 - 是
	 */
	private Integer blackSwitch;
    
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

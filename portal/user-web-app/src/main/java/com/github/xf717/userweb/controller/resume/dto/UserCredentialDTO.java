package com.github.xf717.userweb.controller.resume.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 用户_资格证书表
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
public class UserCredentialDTO {

    	/**
	 * 系统id
	 */
	private Long id;
    
    	/**
	 * 用户id
	 */
	private Long userResumeId;
    
    	/**
	 * 权益id
	 */
	private String name;
    
    	/**
	 * 获得开始时间
	 */
	private Date startTime;
    
    	/**
	 * 获得证书结束时间
	 */
	private Date endTime;
    
    	/**
	 * 公司id,做为数据隔离
	 */
	private Long companyId;
    
    	/**
	 * 是否删除 1:是 0否  默认：0
	 */
	private Integer isDeleted;
    
    	/**
	 * 创建时间
	 */
	private Date createTime;
    
    	/**
	 * 创建人
	 */
	private Long createBy;
    
    	/**
	 * 修改时间
	 */
	private Date updateTime;
    
    	/**
	 * 修改人
	 */
	private Long updateBy;
    

}

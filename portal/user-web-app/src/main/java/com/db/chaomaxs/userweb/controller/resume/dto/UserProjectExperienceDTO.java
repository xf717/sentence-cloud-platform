package com.db.chaomaxs.userweb.controller.resume.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 用户_项目经历
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Data
@Accessors(chain = true)
public class UserProjectExperienceDTO {

    	/**
	 * 系统id
	 */
	private Long id;
    
    	/**
	 * 用户简历id,关联user_resume表id
	 */
	private Long userResumeId;
    
    	/**
	 * 项目名称
	 */
	private String projectName;
    
    	/**
	 * 项目开始时间
	 */
	private Date startTime;
    
    	/**
	 * 项目结束时间
	 */
	private Date endTime;
    
    	/**
	 * 项目描述
	 */
	private String description;
    
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

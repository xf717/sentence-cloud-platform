package com.db.chaomaxs.companyweb.controller.recommend.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 推荐人才简历
 * @author xiaofeng
 * @date 2021-03-29 17:09:31
 */
@Data
@Accessors(chain = true)
public class RecommendResumeDTO {

    	/**
	 * 系统id
	 */
	private Long id;
    
    	/**
	 * 用户简历id
	 */
	private Long userResumeId;
    
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

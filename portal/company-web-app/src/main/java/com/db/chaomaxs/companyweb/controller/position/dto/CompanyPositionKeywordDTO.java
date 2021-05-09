package com.db.chaomaxs.companyweb.controller.position.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 企业_职位
 * @author momo
 * @date 2021-04-14 17:16:58
 */
@Data
@Accessors(chain = true)
public class CompanyPositionKeywordDTO {

    	/**
	 * 系统id
	 */
	private Long id;
    
    	/**
	 * 职位关键字id
	 */
	private Long positionKeywordId;
    
    	/**
	 * 企业职位表id
	 */
	private Long companyPositionId;
    
    	/**
	 * 是否删除:1 是  0 否  默认：0
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

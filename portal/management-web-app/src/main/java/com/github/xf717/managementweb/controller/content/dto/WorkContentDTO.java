package com.github.xf717.managementweb.controller.content.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 内容管理-工作内容息表
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@Accessors(chain = true)
public class WorkContentDTO {

    	/**
	 * 系统id
	 */
	private Long id;
    
    	/**
	 * 职位分类一级ID冗余字段
	 */
	private Long onePositionTypeId;
    
    	/**
	 * 职位分类二级ID--冗余字段
	 */
	private Long twoPositionTypeId;
    
    	/**
	 * 职位分类三级ID  冗余字段
	 */
	private Long threePositionTypeId;
    
    	/**
	 * 发布状态  (1 发布 0未发布)
	 */
	private Integer releaseStatus;
    
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

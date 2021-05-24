package com.github.xf717.managementweb.controller.content.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 内容管理-问题信息表
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@Accessors(chain = true)
public class ProblemInformationDTO {

    	/**
	 * 系统id
	 */
	private Long id;
    
    	/**
	 * 问题标题
	 */
	private String title;
    
    	/**
	 * 问题类型,关联字典表id
	 */
	private Long typeDictionaryId;
    
    	/**
	 * 发布状态  是否发布  1:是 0否  
	 */
	private Integer releaseStatus;
    
    	/**
	 * 排序
	 */
	private Integer sort;
    
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
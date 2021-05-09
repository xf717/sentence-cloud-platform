package com.db.chaomaxs.managementweb.controller.dict.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 字典分类信息表
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Data
@Accessors(chain = true)
public class DataDictionaryTypeDTO {

    	/**
	 * 系统id
	 */
	private Long id;
    
    	/**
	 * 字典类型名称
	 */
	private String dictName;
    
    	/**
	 * 字典类型编号
	 */
	private String dictCode;
    
    	/**
	 * 排序
	 */
	private Integer sort;
    
    	/**
	 * 启用状态(1 启用 0不启用)
	 */
	private Integer enabled;
    
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

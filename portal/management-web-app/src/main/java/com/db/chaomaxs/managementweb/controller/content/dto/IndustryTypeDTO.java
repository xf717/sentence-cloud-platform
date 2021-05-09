package com.db.chaomaxs.managementweb.controller.content.dto;

import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 行业分类信息表
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@Accessors(chain = true)
public class IndustryTypeDTO {

    
    	/**
	 * 分类名称
	 */
	private String typeName;

    

}

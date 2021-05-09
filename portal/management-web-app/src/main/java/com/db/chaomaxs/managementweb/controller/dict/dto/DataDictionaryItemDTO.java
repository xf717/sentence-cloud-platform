package com.db.chaomaxs.managementweb.controller.dict.dto;

import com.db.chaomaxs.common.framework.util.base.annotation.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 数据字典项信息表
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Data
@Accessors(chain = true)
public class DataDictionaryItemDTO {


    
    	/**
	 * 字典分类ID
	 */
   @NotNull
	private Long dictionaryTypeId;

    	/**
	 * 启用状态
	 */
	private Integer enabled;
	/**
	 * 搜索关键字
	 */
	private String key;
    

    

}

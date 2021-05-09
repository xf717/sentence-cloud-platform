package com.db.chaomaxs.managementweb.controller.positiontype.dto;

import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 职务职位分类信息表
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Data
@Accessors(chain = true)
public class PositionTypeDTO {

    	/**
	 * 分类名称
	 */
	private String typeName;

}

package com.db.chaomaxs.managementweb.controller.content.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 行业分类信息表
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "IndustryTypeUpdateDTO",description = "更新行业分类信息表")
public class IndustryTypeUpdateDTO {

    	/**
	 * 系统id
	 */
	@ApiModelProperty(name ="id",value = "系统id")
	private Long id;
    
    	/**
	 * 分类名称
	 */
	@ApiModelProperty(name ="typeName", value = "分类名称",required = true, example = "教育培训")
	private String typeName;

    
    	/**
	 * 上级分类ID
	 */
	@ApiModelProperty(name ="parentId", value = "上级分类ID", required = true ,example = "1")
	private Long parentId;
    
    	/**
	 * 显示状态(1显示 0不显示)
	 */
	@ApiModelProperty(name ="displayStatus", value = "显示状态(1显示 0不显示)",required = true,example = "1")
	private Integer displayStatus;
    
    	/**
	 * 排序
	 */
	@ApiModelProperty(name ="sort", value = "排序",required = true, example = "1")
	private Integer sort;
    

    

}

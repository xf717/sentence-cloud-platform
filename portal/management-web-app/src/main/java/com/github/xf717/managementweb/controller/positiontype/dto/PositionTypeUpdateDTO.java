package com.github.xf717.managementweb.controller.positiontype.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 职务职位分类信息表
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "PositionTypeUpdateDTO",description = "更新职务职位分类信息表")
public class PositionTypeUpdateDTO {

    	/**
	 * 系统id
	 */
	@ApiModelProperty(name ="id",value = "系统id")
	private Long id;
    
    	/**
	 * 分类名称
	 */
	@ApiModelProperty(name ="typeName", value = "分类名称")
	private String typeName;
    
    	/**
	 * 编号  1-2-3
	 */
	@ApiModelProperty(name ="code", value = "编号  1-2-3")
	private String code;
    
    	/**
	 * 级别
	 */
	@ApiModelProperty(name ="level", value = "级别")
	private Integer level;
    
    	/**
	 * 上级分类ID
	 */
	@ApiModelProperty(name ="parentId", value = "上级分类ID")
	private Long parentId;
    
    	/**
	 * 显示状态（1显示 0不显示）
	 */
	@ApiModelProperty(name ="displayStatus", value = "显示状态（1显示 0不显示）")
	private Integer displayStatus;
    
    	/**
	 * 排序
	 */
	@ApiModelProperty(name ="sortOrder", value = "排序")
	private Integer sortOrder;
    
    	/**
	 * 是否删除 1:是 0否  默认：0
	 */
	@ApiModelProperty(name ="isDeleted", value = "是否删除 1:是 0否  默认：0")
	private Integer isDeleted;
    
    	/**
	 * 创建时间
	 */
	@ApiModelProperty(name ="createTime", value = "创建时间")
	private Date createTime;
    
    	/**
	 * 创建人
	 */
	@ApiModelProperty(name ="createBy", value = "创建人")
	private Long createBy;
    
    	/**
	 * 修改时间
	 */
	@ApiModelProperty(name ="updateTime", value = "修改时间")
	private Date updateTime;
    
    	/**
	 * 修改人
	 */
	@ApiModelProperty(name ="updateBy", value = "修改人")
	private Long updateBy;
    

}

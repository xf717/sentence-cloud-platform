package com.db.chaomaxs.managementweb.controller.content.dto;

import java.util.Date;

import com.db.chaomaxs.common.framework.vo.PageParam;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 内容管理-问题信息表
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "ProblemInformationPageDTO",description = "分页:内容管理-问题信息表")
public class ProblemInformationPageDTO extends PageParam {


	private static final long serialVersionUID = -6565690056518828187L;
	/**
	 * 问题标题
	 */
	@ApiModelProperty(name ="title", value = "问题标题")
	private String title;
    
    	/**
	 * 问题类型,关联字典表id
	 */
	@ApiModelProperty(name ="typeDictionaryId", value = "问题类型,关联字典表id")
	private Long typeDictionaryId;
    
    	/**
	 * 发布状态  是否发布  1:是 0否  
	 */
	@ApiModelProperty(name ="releaseStatus", value = "发布状态  是否发布  1:是 0否  ")
	private Integer releaseStatus;
    

    
    	/**
	 * 开始时间
	 */
	@ApiModelProperty(name ="startTime", value = "创建时间")
	private Date startTime;

	/**
	 * 结束时间
	 */
	@ApiModelProperty(name ="endTime", value = "结束时间")
	private Date	endTime;
    
    	/**
	 * 创建人
	 */
	@ApiModelProperty(name ="createBy", value = "创建人")
	private Long createBy;

	/**
	 * 平台
	 */
	@ApiModelProperty(name ="platform", value = "平台 1:PC 2:求职端　3:企业端")
	private Integer platform;

    

}

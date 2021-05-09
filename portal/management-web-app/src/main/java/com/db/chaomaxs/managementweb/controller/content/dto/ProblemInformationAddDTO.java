package com.db.chaomaxs.managementweb.controller.content.dto;

import com.db.chaomaxs.common.framework.util.base.annotation.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 添加了swagger API 配置
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 内容管理-问题信息表
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ProblemInformationCreateDTO",description = "添加内容管理-问题信息表")
public class ProblemInformationAddDTO {

    	/**
	 * 问题标题
	 */
	@ApiModelProperty(name ="title", value = "问题标题")
	@NotNull
	@Size(max = 25,message = "问题标题内容超长")
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
	@NotNull
	private Integer releaseStatus;
    
    	/**
	 * 排序
	 */
	@ApiModelProperty(name ="sort", value = "排序")
	private Integer sort;
	/**
	 * 平台
	 */
	@ApiModelProperty(name ="platform", value = "平台  1:求职端　2:企业端")
	@NotNull
	private Integer platform;


	/**
	 * 问题标题
	 */
	@ApiModelProperty(name ="content", value = "问题内容")
	@NotNull
	private String content;

}

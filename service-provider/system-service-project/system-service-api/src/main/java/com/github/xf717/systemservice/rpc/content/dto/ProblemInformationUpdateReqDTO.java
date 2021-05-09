package com.github.xf717.systemservice.rpc.content.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 内容管理-问题信息表
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@Accessors(chain = true)
public class ProblemInformationUpdateReqDTO implements Serializable {


    	/**
	 * 系统id
	 */
		@NotEmpty(message = "系统id")
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
	 * 平台
	 */
	private Integer platform;

	/**
	 * 问题内容扩展表id
	 */
	private Long informationExtendId;

	/**
	 * 内容
	 */
	private String content;
    

}

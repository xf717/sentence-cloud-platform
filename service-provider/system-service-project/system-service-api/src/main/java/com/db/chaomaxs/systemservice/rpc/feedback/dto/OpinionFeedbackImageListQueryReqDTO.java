package com.db.chaomaxs.systemservice.rpc.feedback.dto;

import java.util.Date;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 意见反馈_图片
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Data
@Accessors(chain = true)
public class OpinionFeedbackImageListQueryReqDTO implements Serializable {


    	/**
	 * 系统id
	 */
		@NotEmpty(message = "系统id")
	private Long id;
    
    	/**
	 * 意见反馈ID
	 */
	private Long opinionFeedbackId;
    
    	/**
	 * 图片资源ID
	 */
	private Long imageResourseId;
    
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

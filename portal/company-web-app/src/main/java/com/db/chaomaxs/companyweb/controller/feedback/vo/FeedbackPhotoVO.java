package com.db.chaomaxs.companyweb.controller.feedback.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 *帮助与反馈_图片说明
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "FeedbackPhotoVO",description = "帮助与反馈_图片说明")
public class FeedbackPhotoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    	/**
	 * 系统id
	 */
	@ApiModelProperty(name ="id", value = "系统id")
	private Long id;
    
    	/**
	 * 帮助与反馈id
	 */
	@ApiModelProperty(name ="feedbackId" ,value = "帮助与反馈id")
	private Long feedbackId;
    
    	/**
	 * 相片资源id 关联资源库表id
	 */
	@ApiModelProperty(name ="imageResourceId" ,value = "相片资源id 关联资源库表id")
	private Long imageResourceId;
    
    	/**
	 * 是否删除:1 是  0 否  默认：0
	 */
	@ApiModelProperty(name ="isDeleted" ,value = "是否删除:1 是  0 否  默认：0")
	private Integer isDeleted;
    
    	/**
	 * 创建时间
	 */
	@ApiModelProperty(name ="createTime" ,value = "创建时间")
	private Date createTime;
    
    	/**
	 * 创建人
	 */
	@ApiModelProperty(name ="createBy" ,value = "创建人")
	private Long createBy;
    
    	/**
	 * 修改时间
	 */
	@ApiModelProperty(name ="updateTime" ,value = "修改时间")
	private Date updateTime;
    
    	/**
	 * 修改人
	 */
	@ApiModelProperty(name ="updateBy" ,value = "修改人")
	private Long updateBy;
    

}

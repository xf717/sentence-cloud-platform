package com.db.chaomaxs.systemservice.rpc.notice.dto;

import java.util.Date;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 通知信息表
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@Data
@Accessors(chain = true)
public class NoticeInformationUpdateReqDTO implements Serializable {


    	/**
	 * 系统id
	 */
		@NotEmpty(message = "系统id")
	private Long id;
    
    	/**
	 * 标题
	 */
	private String title;
    
    	/**
	 * 定时发布时间
	 */
	private Date intervaLtime;
    
    	/**
	 * 发布时间
	 */
	private Date releaseTime;
    
    	/**
	 * 发布类型:关联字典表id
	 */
	private Long releaseTypeDictionaryId;
    
    	/**
	 * 消息URL
	 */
	private String url;
    
    	/**
	 * 弹框结束时间
	 */
	private Date popupEndTime;
    
    	/**
	 * 弹框开始时间
	 */
	private Date popupStartTime;
    
    	/**
	 * 弹框图片ID
	 */
	private Long popupResourseId;
    
    	/**
	 * 显示方式 关联字典表id
	 */
	private Long displayModeDictionaryId;
    
    	/**
	 * 发布状态（0待发布,1 立即发布,2定时发布）
	 */
	private Integer status;
    
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

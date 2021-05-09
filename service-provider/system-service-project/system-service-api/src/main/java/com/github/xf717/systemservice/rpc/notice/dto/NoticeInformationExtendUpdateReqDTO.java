package com.github.xf717.systemservice.rpc.notice.dto;

import java.util.Date;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 内容管理通知信息_扩展信息表
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@Data
@Accessors(chain = true)
public class NoticeInformationExtendUpdateReqDTO implements Serializable {


    	/**
	 * 系统id
	 */
		@NotEmpty(message = "系统id")
	private Long id;
    
    	/**
	 * 内容
	 */
	private String content;
    
    	/**
	 * 通知信息ID
	 */
	private Long noticeInformationId;
    
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

package com.github.xf717.userservice.rpc.user.dto;

import java.util.Date;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 用户消息表
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserMessageUpdateReqDTO implements Serializable {


    	/**
	 * 
	 */
		@NotEmpty(message = "")
	private Long id;
    
    	/**
	 * 消息id
	 */
	private Long messageId;
    
    	/**
	 * 用户ID
	 */
	private Long userId;
    
    	/**
	 * 修改时间
	 */
	private Date readTime;
    
    	/**
	 * 0 - 未读
            1 - 已读
	 */
	private Integer readStatus;
    
    	/**
	 * 是否删除
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

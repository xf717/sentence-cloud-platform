package com.db.chaomaxs.userservice.dal.mysql.dataobject.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;



/**
 * 用户消息表
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_message")
public class UserMessageDO extends DeletableDO{

    	/**
	 * 
	 */
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

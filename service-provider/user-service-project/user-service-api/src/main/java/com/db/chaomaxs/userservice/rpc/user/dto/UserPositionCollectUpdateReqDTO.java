package com.db.chaomaxs.userservice.rpc.user.dto;

import java.util.Date;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 用户_职位_收藏
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@Accessors(chain = true)
public class UserPositionCollectUpdateReqDTO implements Serializable {


    	/**
	 * 系统id
	 */
		@NotEmpty(message = "系统id")
	private Long id;
    
    	/**
	 * 用户id
	 */
	private Long userId;
    
    	/**
	 * 企业用户
	 */
	private Long companyUserId;
    
    	/**
	 * 企业发布的职位id
	 */
	private Long positionId;
    
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
	private Integer updateBy;
    

}

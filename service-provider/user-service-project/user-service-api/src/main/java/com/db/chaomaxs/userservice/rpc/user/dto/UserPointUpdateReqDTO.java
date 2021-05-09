package com.db.chaomaxs.userservice.rpc.user.dto;

import java.util.Date;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 用户_积分表
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@Accessors(chain = true)
public class UserPointUpdateReqDTO implements Serializable {


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
	 * 总积分
	 */
	private Integer totalPoint;
    
    	/**
	 * 积分
	 */
	private Integer point;
    
    	/**
	 * 公司id,做为数据隔离
	 */
	private Long companyId;
    
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

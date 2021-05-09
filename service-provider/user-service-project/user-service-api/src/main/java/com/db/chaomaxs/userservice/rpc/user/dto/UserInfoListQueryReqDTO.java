package com.db.chaomaxs.userservice.rpc.user.dto;

import java.util.Date;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 用户_帐号信息
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserInfoListQueryReqDTO implements Serializable {


    	/**
	 * 系统id
	 */
		@NotEmpty(message = "系统id")
	private Long userId;
    
    	/**
	 * 昵称
	 */
	private String nickname;
    
    	/**
	 * 密码
	 */
	private String password;
    
    	/**
	 * 绑定手机
	 */
	private String mobile;
    
    	/**
	 * 个性签名
	 */
	private String signature;
    
    	/**
	 * 用户头像
	 */
	private String avatarUrl;
    
    	/**
	 * 用户状态(1正常、2冻结,默认为1)
	 */
	private Integer userStatus;
    
    	/**
	 * 用户类型(1普通用户,2企业用户,3,运营用户  默认为1)
	 */
	private Integer userType;
    
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

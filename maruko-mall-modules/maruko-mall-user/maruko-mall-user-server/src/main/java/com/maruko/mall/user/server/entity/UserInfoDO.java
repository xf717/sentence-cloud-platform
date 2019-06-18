package com.maruko.mall.user.server.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_帐号信息
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Table(name = "user_info")
@Data
@Accessors(chain = true)
public class UserInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;

	    /**
     * 用户id
     */
    @Id
    private Integer userId;
	
	    /**
     * 昵称
     */
    @Column(name = "nickname")
    private String nickname;
	
	    /**
     * 密码
     */
    @Column(name = "user_pwd")
    private String userPwd;
	
	    /**
     * 加盐
     */
    @Column(name = "salt")
    private String salt;
	
	    /**
     * 绑定手机
     */
    @Column(name = "mobile")
    private String mobile;
	
	    /**
     * 个性签名
     */
    @Column(name = "signature")
    private String signature;
	
	    /**
     * 用户头像
     */
    @Column(name = "photo")
    private String photo;
	
	    /**
     * 用户状态(1正常、2冻结,默认为1),关联字典项：item_no
     */
    @Column(name = "user_status")
    private Integer userStatus;
	
	    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;
	
	    /**
     * 创建人
     */
    @Column(name = "create_by")
    private Integer createBy;
	
	    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Long modifyTime;
	
	    /**
     * 修改人
     */
    @Column(name = "modify_by")
    private Integer modifyBy;
	

}

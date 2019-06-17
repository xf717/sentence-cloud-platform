package com.maruko.mall.user.server.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_第三方表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Table(name = "user_third")
@Data
@Accessors(chain = true)
public class UserThirdDO implements Serializable {
	private static final long serialVersionUID = 1L;

	    /**
     * 系统id
     */
    @Id
    private Integer userThirdId;
	
	    /**
     * 账号id
     */
    @Column(name = "user_id")
    private Integer userId;
	
	    /**
     * 第三方类型
     */
    @Column(name = "third_type")
    private Integer thirdType;
	
	    /**
     * access_token
     */
    @Column(name = "access_token")
    private String accessToken;
	
	    /**
     * 昵称,冗余字段
     */
    @Column(name = "nickname")
    private String nickname;
	
	    /**
     * 头像,冗余字段
     */
    @Column(name = "photo")
    private String photo;
	
	    /**
     * 性别(1男、2女、0未知),冗余字段
     */
    @Column(name = "gender")
    private Integer gender;
	
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

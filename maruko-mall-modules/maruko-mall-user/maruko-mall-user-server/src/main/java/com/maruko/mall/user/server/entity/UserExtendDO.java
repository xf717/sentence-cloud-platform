package com.maruko.mall.user.server.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_扩展表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Table(name = "user_extend")
@Data
@Accessors(chain = true)
public class UserExtendDO implements Serializable {
	private static final long serialVersionUID = 1L;

	    /**
     * 主键id
     */
    @Id
    private Integer userExtendId;
	
	    /**
     * 用户信息id
     */
    @Column(name = "user_id")
    private Integer userId;
	
	    /**
     * email
     */
    @Column(name = "email")
    private String email;
	
	    /**
     * 字典:性别(1男、2女、0未知)
     */
    @Column(name = "gender")
    private Integer gender;
	
	    /**
     * 出生年
     */
    @Column(name = "birthday_year")
    private Integer birthdayYear;
	
	    /**
     * 出身月
     */
    @Column(name = "birthday_month")
    private Integer birthdayMonth;
	
	    /**
     * 出生日
     */
    @Column(name = "birthday_day")
    private Integer birthdayDay;
	
	    /**
     * 注册时间
     */
    @Column(name = "reg_time")
    private Long regTime;
	
	    /**
     * 注册ip
     */
    @Column(name = "reg_ip")
    private Integer regIp;
	
	    /**
     * 用户注册类型(1.手机 2.第三方3.邮箱)
     */
    @Column(name = "reg_type")
    private Integer regType;
	
	    /**
     * 注册来源：1平台（默认1）,2其它
     */
    @Column(name = "reg_source")
    private Integer regSource;
	
	    /**
     * 帐号冻结时间
     */
    @Column(name = "expire_freeze")
    private Long expireFreeze;
	
	    /**
     * 帐号冻结原因
     */
    @Column(name = "reason")
    private String reason;
	
	    /**
     * 终端类型(字典:1android手机、2android平板、3pc、4ios手机、5ios平板、6小程序)
     */
    @Column(name = "terminal_type")
    private Integer terminalType;
	
	    /**
     * 终端唯一
     */
    @Column(name = "terminal_sn")
    private String terminalSn;
	
	    /**
     * 终端名称
     */
    @Column(name = "terminal_name")
    private String terminalName;
	
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

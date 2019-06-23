package com.maruko.mall.user.server.client.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户_扩展表
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Data
@Accessors(chain = true)
public class UserExtendBO implements Serializable {

//	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private Integer userExtendId;

	/**
	 * 用户信息id
	 */
	private Integer userId;

	/**
	 * email
	 */
	private String email;

	/**
	 * 字典:性别(1男、2女、0未知)
	 */
	private Integer gender;

	/**
	 * 出生年
	 */
	private Integer birthdayYear;

	/**
	 * 出身月
	 */
	private Integer birthdayMonth;

	/**
	 * 出生日
	 */
	private Integer birthdayDay;

	/**
	 * 注册时间
	 */
	private Long regTime;

	/**
	 * 注册ip
	 */
	private Integer regIp;

	/**
	 * 用户注册类型(1.手机 2.第三方3.邮箱)
	 */
	private Integer regType;

	/**
	 * 注册来源：1平台（默认1）,2其它
	 */
	private Integer regSource;

	/**
	 * 帐号冻结时间
	 */
	private Long expireFreeze;

	/**
	 * 帐号冻结原因
	 */
	private String reason;

	/**
	 * 终端类型(字典:1android手机、2android平板、3pc、4ios手机、5ios平板、6小程序)
	 */
	private Integer terminalType;

	/**
	 * 终端唯一
	 */
	private String terminalSn;

	/**
	 * 终端名称
	 */
	private String terminalName;

	/**
	 * 创建时间
	 */
	private Long createTime;

	/**
	 * 创建人
	 */
	private Integer createBy;

	/**
	 * 修改时间
	 */
	private Long modifyTime;

	/**
	 * 修改人
	 */
	private Integer modifyBy;


}

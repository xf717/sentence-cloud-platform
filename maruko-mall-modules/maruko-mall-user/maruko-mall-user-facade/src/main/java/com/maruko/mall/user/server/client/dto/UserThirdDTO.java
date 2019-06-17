package com.maruko.mall.user.server.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 用户_第三方表
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserThirdDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 系统id
	 */
	private Integer userThirdId;

	/**
	 * 账号id
	 */
	private Integer userId;

	/**
	 * 第三方类型
	 */
	private Integer thirdType;

	/**
	 * access_token
	 */
	private String accessToken;

	/**
	 * 昵称,冗余字段
	 */
	private String nickname;

	/**
	 * 头像,冗余字段
	 */
	private String photo;

	/**
	 * 性别(1男、2女、0未知),冗余字段
	 */
	private Integer gender;

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

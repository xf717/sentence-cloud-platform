package com.maruko.mall.user.server.client.dto;

import lombok.Data;

import java.io.Serializable;


/**
 * 用户_类型表
 * @author xiaofeng
 * @date 2019-06-04 22:35:12
 */
@Data
public class UserTypeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id(不能做成自增长)
	 */
	private Integer userTypeId;

	/**
	 * 用户类型名称
	 */
	private String userTypeName;

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

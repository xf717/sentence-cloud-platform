package com.maruko.mall.user.server.client.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户_类型表
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Data
@Accessors(chain = true)
public class UserTypeBO implements Serializable {

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

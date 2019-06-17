package com.maruko.mall.user.server.client.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户_积分表
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Data
@Accessors(chain = true)
public class UserIntegralBO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 系统id
	 */
	private Integer userIntegralId;

	/**
	 * 用户id
	 */
	private Integer userId;

	/**
	 * 总积分
	 */
	private Integer totalIntegral;

	/**
	 * 积分
	 */
	private Integer integral;

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

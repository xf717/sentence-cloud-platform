package com.maruko.mall.user.server.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 用户收货地址
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private Integer addressId;

	/**
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * 省分id
	 */
	private Integer provinceId;

	/**
	 * 市ID
	 */
	private Integer cityId;

	/**
	 * 县区id
	 */
	private Integer countyId;

	/**
	 * 手机号码
	 */
	private String mobile;

	/**
	 * 详细地址
	 */
	private String address;

	/**
	 * 联系人
	 */
	private String contact;

	/**
	 * 是否默认
	 */
	private Integer isDefault;

	/**
	 * 别名
	 */
	private String alias;

	/**
	 * 备注
	 */
	private String notes;

	/**
	 * 创建时间
	 */
	private Long createTime;

	/**
	 * 创建者
	 */
	private Integer createBy;

	/**
	 * 修改时间
	 */
	private Long modifyTime;

	/**
	 * 修改者
	 */
	private Integer modifyBy;


}

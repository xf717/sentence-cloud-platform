package com.maruko.mall.user.server.client.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户_帐号信息
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Data
@Accessors(chain = true)
public class UserInfoBO implements Serializable {

//	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	private Integer userId;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 密码
	 */
	private String userPwd;

	/**
	 * 加盐
	 */
	private String salt;

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
	private String photo;

	/**
	 * 用户状态(1正常、2冻结,默认为1),关联字典项：item_no
	 */
	private Integer userStatus;

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

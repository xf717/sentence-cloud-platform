package com.maruko.mall.user.server.service;

import com.maruko.mall.user.server.client.dto.UserInfoDTO;
import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.Page;

/**
 * 用户_帐号信息
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface IUserInfoService {

	/**
	 * 添加数据
	 * @param userInfoDTO
	 * @return
	 */
	BaseResponse add(UserInfoDTO userInfoDTO);

	/**
	 * 添加数据,并返回添加成功后的实体数据，可以获取到主键ID
	 * @param userInfoDTO
	 * @return
	 */
	ObjectRestResponse<UserInfoDTO> addUserInfo(UserInfoDTO userInfoDTO);

	/**
	 * 更新数据
	 * @param userInfoDTO
	 * @return
	 */
	BaseResponse update(UserInfoDTO userInfoDTO);

	/**
	 * 根据ID删除数据
	 * @param id
	 * @return
	 */
	BaseResponse remove(Integer id);

	/**
	 * 查找数据显示分页
	 * @param page
	 * @return
	 */
	TableResultResponse<UserInfoDTO> page(UserInfoDTO userInfoDTO, Page<UserInfoDTO> page);

	/**
	 * 根据条件查找数据
	 * @param userInfoDTO
	 * @return
	 */
	ListRestResponse<UserInfoDTO> query(UserInfoDTO userInfoDTO);

	/**
	 * 根据Id查找
	 * @param id
	 * @return
	 */
	ObjectRestResponse<UserInfoDTO> findById(Integer id);


	/**
	 * 根据条件查找数据
	 * @param userInfoDTO
	 * @return
	 */
	ObjectRestResponse<UserInfoDTO> findByCondition(UserInfoDTO userInfoDTO);
}

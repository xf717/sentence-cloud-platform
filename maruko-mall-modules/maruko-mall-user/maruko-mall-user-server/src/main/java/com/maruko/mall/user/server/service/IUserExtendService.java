package com.maruko.mall.user.server.service;

import com.maruko.mall.user.server.client.dto.UserExtendDTO;
import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.Page;

/**
 * 用户_扩展表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface IUserExtendService {

	/**
	 * 添加数据
	 * @param userExtendDTO
	 * @return
	 */
	BaseResponse add(UserExtendDTO userExtendDTO);

	/**
	 * 添加数据,并返回添加成功后的实体数据，可以获取到主键ID
	 * @param userExtendDTO
	 * @return
	 */
	ObjectRestResponse<UserExtendDTO> addUserExtend(UserExtendDTO userExtendDTO);

	/**
	 * 更新数据
	 * @param userExtendDTO
	 * @return
	 */
	BaseResponse update(UserExtendDTO userExtendDTO);

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
	TableResultResponse<UserExtendDTO> page(UserExtendDTO userExtendDTO, Page<UserExtendDTO> page);

	/**
	 * 根据条件查找数据
	 * @param userExtendDTO
	 * @return
	 */
	ListRestResponse<UserExtendDTO> query(UserExtendDTO userExtendDTO);

	/**
	 * 根据Id查找
	 * @param id
	 * @return
	 */
	ObjectRestResponse<UserExtendDTO> findById(Integer id);


	/**
	 * 根据条件查找数据
	 * @param userExtendDTO
	 * @return
	 */
	ObjectRestResponse<UserExtendDTO> findByCondition(UserExtendDTO userExtendDTO);
}

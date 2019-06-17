package com.maruko.mall.user.server.service;

import com.maruko.mall.user.server.client.dto.UserTypeDTO;
import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.Page;

/**
 * 用户_类型表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface IUserTypeService {

	/**
	 * 添加数据
	 * @param userTypeDTO
	 * @return
	 */
	BaseResponse add(UserTypeDTO userTypeDTO);

	/**
	 * 添加数据,并返回添加成功后的实体数据，可以获取到主键ID
	 * @param userTypeDTO
	 * @return
	 */
	ObjectRestResponse<UserTypeDTO> addUserType(UserTypeDTO userTypeDTO);

	/**
	 * 更新数据
	 * @param userTypeDTO
	 * @return
	 */
	BaseResponse update(UserTypeDTO userTypeDTO);

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
	TableResultResponse<UserTypeDTO> page(UserTypeDTO userTypeDTO, Page<UserTypeDTO> page);

	/**
	 * 根据条件查找数据
	 * @param userTypeDTO
	 * @return
	 */
	ListRestResponse<UserTypeDTO> query(UserTypeDTO userTypeDTO);

	/**
	 * 根据Id查找
	 * @param id
	 * @return
	 */
	ObjectRestResponse<UserTypeDTO> findById(Integer id);


	/**
	 * 根据条件查找数据
	 * @param userTypeDTO
	 * @return
	 */
	ObjectRestResponse<UserTypeDTO> findByCondition(UserTypeDTO userTypeDTO);
}

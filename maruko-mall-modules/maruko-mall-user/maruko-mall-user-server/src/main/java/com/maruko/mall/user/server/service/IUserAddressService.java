package com.maruko.mall.user.server.service;

import com.maruko.mall.user.server.client.dto.UserAddressDTO;
import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.Page;

/**
 * 用户收货地址
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface IUserAddressService {

	/**
	 * 添加数据
	 * @param userAddressDTO
	 * @return
	 */
	BaseResponse add(UserAddressDTO userAddressDTO);

	/**
	 * 添加数据,并返回添加成功后的实体数据，可以获取到主键ID
	 * @param userAddressDTO
	 * @return
	 */
	ObjectRestResponse<UserAddressDTO> addUserAddress(UserAddressDTO userAddressDTO);

	/**
	 * 更新数据
	 * @param userAddressDTO
	 * @return
	 */
	BaseResponse update(UserAddressDTO userAddressDTO);

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
	TableResultResponse<UserAddressDTO> page(UserAddressDTO userAddressDTO, Page<UserAddressDTO> page);

	/**
	 * 根据条件查找数据
	 * @param userAddressDTO
	 * @return
	 */
	ListRestResponse<UserAddressDTO> query(UserAddressDTO userAddressDTO);

	/**
	 * 根据Id查找
	 * @param id
	 * @return
	 */
	ObjectRestResponse<UserAddressDTO> findById(Integer id);


	/**
	 * 根据条件查找数据
	 * @param userAddressDTO
	 * @return
	 */
	ObjectRestResponse<UserAddressDTO> findByCondition(UserAddressDTO userAddressDTO);
}

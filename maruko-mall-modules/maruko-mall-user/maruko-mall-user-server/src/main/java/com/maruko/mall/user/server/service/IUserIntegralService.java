package com.maruko.mall.user.server.service;

import com.maruko.mall.user.server.client.dto.UserIntegralDTO;
import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.Page;

/**
 * 用户_积分表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface IUserIntegralService {

	/**
	 * 添加数据
	 * @param userIntegralDTO
	 * @return
	 */
	BaseResponse add(UserIntegralDTO userIntegralDTO);

	/**
	 * 添加数据,并返回添加成功后的实体数据，可以获取到主键ID
	 * @param userIntegralDTO
	 * @return
	 */
	ObjectRestResponse<UserIntegralDTO> addUserIntegral(UserIntegralDTO userIntegralDTO);

	/**
	 * 更新数据
	 * @param userIntegralDTO
	 * @return
	 */
	BaseResponse update(UserIntegralDTO userIntegralDTO);

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
	TableResultResponse<UserIntegralDTO> page(UserIntegralDTO userIntegralDTO, Page<UserIntegralDTO> page);

	/**
	 * 根据条件查找数据
	 * @param userIntegralDTO
	 * @return
	 */
	ListRestResponse<UserIntegralDTO> query(UserIntegralDTO userIntegralDTO);

	/**
	 * 根据Id查找
	 * @param id
	 * @return
	 */
	ObjectRestResponse<UserIntegralDTO> findById(Integer id);


	/**
	 * 根据条件查找数据
	 * @param userIntegralDTO
	 * @return
	 */
	ObjectRestResponse<UserIntegralDTO> findByCondition(UserIntegralDTO userIntegralDTO);
}

package com.maruko.mall.user.server.service;

import com.maruko.mall.user.server.client.dto.UserThirdDTO;
import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.Page;

/**
 * 用户_第三方表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface IUserThirdService {

	/**
	 * 添加数据
	 * @param userThirdDTO
	 * @return
	 */
	BaseResponse add(UserThirdDTO userThirdDTO);

	/**
	 * 添加数据,并返回添加成功后的实体数据，可以获取到主键ID
	 * @param userThirdDTO
	 * @return
	 */
	ObjectRestResponse<UserThirdDTO> addUserThird(UserThirdDTO userThirdDTO);

	/**
	 * 更新数据
	 * @param userThirdDTO
	 * @return
	 */
	BaseResponse update(UserThirdDTO userThirdDTO);

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
	TableResultResponse<UserThirdDTO> page(UserThirdDTO userThirdDTO, Page<UserThirdDTO> page);

	/**
	 * 根据条件查找数据
	 * @param userThirdDTO
	 * @return
	 */
	ListRestResponse<UserThirdDTO> query(UserThirdDTO userThirdDTO);

	/**
	 * 根据Id查找
	 * @param id
	 * @return
	 */
	ObjectRestResponse<UserThirdDTO> findById(Integer id);


	/**
	 * 根据条件查找数据
	 * @param userThirdDTO
	 * @return
	 */
	ObjectRestResponse<UserThirdDTO> findByCondition(UserThirdDTO userThirdDTO);
}

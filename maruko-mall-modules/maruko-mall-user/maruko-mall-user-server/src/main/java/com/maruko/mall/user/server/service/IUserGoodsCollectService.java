package com.maruko.mall.user.server.service;

import com.maruko.mall.user.server.client.dto.UserGoodsCollectDTO;
import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.Page;

/**
 * 用户_商品收藏表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface IUserGoodsCollectService {

	/**
	 * 添加数据
	 * @param userGoodsCollectDTO
	 * @return
	 */
	BaseResponse add(UserGoodsCollectDTO userGoodsCollectDTO);

	/**
	 * 添加数据,并返回添加成功后的实体数据，可以获取到主键ID
	 * @param userGoodsCollectDTO
	 * @return
	 */
	ObjectRestResponse<UserGoodsCollectDTO> addUserGoodsCollect(UserGoodsCollectDTO userGoodsCollectDTO);

	/**
	 * 更新数据
	 * @param userGoodsCollectDTO
	 * @return
	 */
	BaseResponse update(UserGoodsCollectDTO userGoodsCollectDTO);

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
	TableResultResponse<UserGoodsCollectDTO> page(UserGoodsCollectDTO userGoodsCollectDTO, Page<UserGoodsCollectDTO> page);

	/**
	 * 根据条件查找数据
	 * @param userGoodsCollectDTO
	 * @return
	 */
	ListRestResponse<UserGoodsCollectDTO> query(UserGoodsCollectDTO userGoodsCollectDTO);

	/**
	 * 根据Id查找
	 * @param id
	 * @return
	 */
	ObjectRestResponse<UserGoodsCollectDTO> findById(Integer id);


	/**
	 * 根据条件查找数据
	 * @param userGoodsCollectDTO
	 * @return
	 */
	ObjectRestResponse<UserGoodsCollectDTO> findByCondition(UserGoodsCollectDTO userGoodsCollectDTO);
}

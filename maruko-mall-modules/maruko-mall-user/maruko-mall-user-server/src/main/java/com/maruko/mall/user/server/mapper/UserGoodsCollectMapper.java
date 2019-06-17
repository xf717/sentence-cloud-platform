package com.maruko.mall.user.server.mapper;

import com.maruko.mall.user.server.client.dto.UserGoodsCollectDTO;
import com.maruko.mall.user.server.entity.UserGoodsCollectDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 用户_商品收藏表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface UserGoodsCollectMapper extends BaseMapper<UserGoodsCollectDO> {

	/**
	 * 查找数据
	 * @param dto
	 * @return
	 */
	List<UserGoodsCollectDTO> query(UserGoodsCollectDTO dto);

	/**
	 * 插入数据，并返回主键ID
	 * @param dto
	 * @return
	 */
	int insertSelectiveUserGoodsCollect(UserGoodsCollectDTO dto);

}

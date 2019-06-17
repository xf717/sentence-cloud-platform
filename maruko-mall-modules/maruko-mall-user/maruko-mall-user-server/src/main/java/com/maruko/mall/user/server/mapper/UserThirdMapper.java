package com.maruko.mall.user.server.mapper;

import com.maruko.mall.user.server.client.dto.UserThirdDTO;
import com.maruko.mall.user.server.entity.UserThirdDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 用户_第三方表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface UserThirdMapper extends BaseMapper<UserThirdDO> {

	/**
	 * 查找数据
	 * @param dto
	 * @return
	 */
	List<UserThirdDTO> query(UserThirdDTO dto);

	/**
	 * 插入数据，并返回主键ID
	 * @param dto
	 * @return
	 */
	int insertSelectiveUserThird(UserThirdDTO dto);

}

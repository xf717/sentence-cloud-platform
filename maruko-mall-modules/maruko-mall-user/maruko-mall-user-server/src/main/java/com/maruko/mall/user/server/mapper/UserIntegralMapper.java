package com.maruko.mall.user.server.mapper;

import com.maruko.mall.user.server.client.dto.UserIntegralDTO;
import com.maruko.mall.user.server.entity.UserIntegralDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 用户_积分表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface UserIntegralMapper extends BaseMapper<UserIntegralDO> {

	/**
	 * 查找数据
	 * @param dto
	 * @return
	 */
	List<UserIntegralDTO> query(UserIntegralDTO dto);

	/**
	 * 插入数据，并返回主键ID
	 * @param dto
	 * @return
	 */
	int insertSelectiveUserIntegral(UserIntegralDTO dto);

}

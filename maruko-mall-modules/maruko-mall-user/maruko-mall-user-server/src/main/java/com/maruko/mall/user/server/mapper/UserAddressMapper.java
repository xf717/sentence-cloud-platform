package com.maruko.mall.user.server.mapper;

import com.maruko.mall.user.server.client.dto.UserAddressDTO;
import com.maruko.mall.user.server.entity.UserAddressDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 用户收货地址
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface UserAddressMapper extends BaseMapper<UserAddressDO> {

	/**
	 * 查找数据
	 * @param dto
	 * @return
	 */
	List<UserAddressDTO> query(UserAddressDTO dto);

	/**
	 * 插入数据，并返回主键ID
	 * @param dto
	 * @return
	 */
	int insertSelectiveUserAddress(UserAddressDTO dto);

}

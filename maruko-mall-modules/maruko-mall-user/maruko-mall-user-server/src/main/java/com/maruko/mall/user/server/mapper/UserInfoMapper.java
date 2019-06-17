package com.maruko.mall.user.server.mapper;

import com.maruko.mall.user.server.client.dto.UserInfoDTO;
import com.maruko.mall.user.server.entity.UserInfoDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 用户_帐号信息
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface UserInfoMapper extends BaseMapper<UserInfoDO> {

	/**
	 * 查找数据
	 * @param dto
	 * @return
	 */
	List<UserInfoDTO> query(UserInfoDTO dto);

	/**
	 * 插入数据，并返回主键ID
	 * @param dto
	 * @return
	 */
	int insertSelectiveUserInfo(UserInfoDTO dto);

}

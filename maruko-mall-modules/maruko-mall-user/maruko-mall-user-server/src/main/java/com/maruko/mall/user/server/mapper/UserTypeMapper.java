package com.maruko.mall.user.server.mapper;

import com.maruko.mall.user.server.client.dto.UserTypeDTO;
import com.maruko.mall.user.server.entity.UserTypeDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 用户_类型表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface UserTypeMapper extends BaseMapper<UserTypeDO> {

	/**
	 * 查找数据
	 * @param dto
	 * @return
	 */
	List<UserTypeDTO> query(UserTypeDTO dto);

	/**
	 * 插入数据，并返回主键ID
	 * @param dto
	 * @return
	 */
	int insertSelectiveUserType(UserTypeDTO dto);

}

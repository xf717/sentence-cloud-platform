package com.maruko.mall.user.server.mapper;

import com.maruko.mall.user.server.client.dto.UserExtendDTO;
import com.maruko.mall.user.server.entity.UserExtendDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 用户_扩展表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface UserExtendMapper extends BaseMapper<UserExtendDO> {

	/**
	 * 查找数据
	 * @param dto
	 * @return
	 */
	List<UserExtendDTO> query(UserExtendDTO dto);

	/**
	 * 插入数据，并返回主键ID
	 * @param dto
	 * @return
	 */
	int insertSelectiveUserExtend(UserExtendDTO dto);

}

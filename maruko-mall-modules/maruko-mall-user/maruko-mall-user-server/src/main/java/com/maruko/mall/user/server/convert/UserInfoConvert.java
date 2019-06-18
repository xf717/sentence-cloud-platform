package com.maruko.mall.user.server.convert;

import com.maruko.mall.user.server.client.bo.UserInfoBO;
import com.maruko.mall.user.server.entity.UserInfoDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 用户_帐号信息
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Mapper
public interface UserInfoConvert {

	UserInfoConvert INSTANCE = Mappers.getMapper(UserInfoConvert.class);


	@Mappings({})
	UserInfoBO convert(UserInfoDO userInfoDO);


}

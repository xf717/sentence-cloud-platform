package com.maruko.mall.user.server.convert;

import com.maruko.mall.user.server.client.bo.User;
import com.maruko.mall.user.server.entity.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * UserConvert
 * @author xiaofeng
 * @date 2019/06/23 21:45
 * @version 1.0
 */
@Mapper
public interface UserConvert {

	UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

	User convert(UserDO userDO);

}

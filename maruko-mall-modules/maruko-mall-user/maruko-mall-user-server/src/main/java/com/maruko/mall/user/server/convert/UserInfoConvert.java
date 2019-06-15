package com.maruko.mall.user.server.convert;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * UserInfoConvert
 * @author xiaofeng
 * @date 2019/06/15 13:21
 * @version 1.0
 */
@Mapper
public interface UserInfoConvert {

	UserInfoConvert INSTANCE = Mappers.getMapper(UserInfoConvert.class);





}

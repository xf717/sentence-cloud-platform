package com.maruko.mall.user.server.convert;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户_帐号信息
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Mapper
public interface UserInfoConvert {

	UserInfoConvert} INSTANCE = Mappers.getMapper(UserInfoConvert.class);


    @Mappings({})
    UserInfoDO convert(UserInfoDTO dto);





}

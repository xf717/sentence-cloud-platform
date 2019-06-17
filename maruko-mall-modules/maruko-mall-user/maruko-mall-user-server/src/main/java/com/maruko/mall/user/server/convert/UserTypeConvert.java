package com.maruko.mall.user.server.convert;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户_类型表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Mapper
public interface UserTypeConvert {

	UserTypeConvert} INSTANCE = Mappers.getMapper(UserTypeConvert.class);


    @Mappings({})
    UserTypeDO convert(UserTypeDTO dto);





}

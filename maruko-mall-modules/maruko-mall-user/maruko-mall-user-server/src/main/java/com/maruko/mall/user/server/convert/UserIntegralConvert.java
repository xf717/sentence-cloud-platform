package com.maruko.mall.user.server.convert;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户_积分表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Mapper
public interface UserIntegralConvert {

	UserIntegralConvert} INSTANCE = Mappers.getMapper(UserIntegralConvert.class);


    @Mappings({})
    UserIntegralDO convert(UserIntegralDTO dto);





}

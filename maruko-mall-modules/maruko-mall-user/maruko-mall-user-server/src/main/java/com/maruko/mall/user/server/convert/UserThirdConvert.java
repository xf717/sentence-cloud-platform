package com.maruko.mall.user.server.convert;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户_第三方表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Mapper
public interface UserThirdConvert {

	UserThirdConvert} INSTANCE = Mappers.getMapper(UserThirdConvert.class);


    @Mappings({})
    UserThirdDO convert(UserThirdDTO dto);





}

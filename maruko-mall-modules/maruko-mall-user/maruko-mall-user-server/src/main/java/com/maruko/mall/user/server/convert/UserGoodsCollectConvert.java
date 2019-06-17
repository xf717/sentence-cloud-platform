package com.maruko.mall.user.server.convert;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户_商品收藏表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Mapper
public interface UserGoodsCollectConvert {

	UserGoodsCollectConvert} INSTANCE = Mappers.getMapper(UserGoodsCollectConvert.class);


    @Mappings({})
    UserGoodsCollectDO convert(UserGoodsCollectDTO dto);





}

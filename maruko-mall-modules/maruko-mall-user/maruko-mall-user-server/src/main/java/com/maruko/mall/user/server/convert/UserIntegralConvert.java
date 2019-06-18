package com.maruko.mall.user.server.convert;


import com.maruko.mall.user.server.client.bo.UserIntegralBO;
import com.maruko.mall.user.server.entity.UserIntegralDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 用户_积分表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Mapper
public interface UserIntegralConvert {

	UserIntegralConvert INSTANCE = Mappers.getMapper(UserIntegralConvert.class);


	@Mappings({})
	UserIntegralBO convert(UserIntegralDO userIntegralDO);


}

package com.maruko.mall.user.server.convert;

import com.maruko.mall.user.server.client.bo.UserAddressBO;
import com.maruko.mall.user.server.entity.UserAddressDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户收货地址
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Mapper
public interface UserAddressConvert {

	UserAddressConvert INSTANCE = Mappers.getMapper(UserAddressConvert.class);

	@Mappings({})
	UserAddressBO convert(UserAddressDO userAddressDO);

	@Mappings({})
	List<UserAddressBO> convert(List<UserAddressDO> userAddressDOS);


}

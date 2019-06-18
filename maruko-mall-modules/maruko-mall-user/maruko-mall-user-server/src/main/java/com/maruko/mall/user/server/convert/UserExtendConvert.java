package com.maruko.mall.user.server.convert;
import com.maruko.mall.user.server.client.bo.UserExtendBO;
import com.maruko.mall.user.server.entity.UserExtendDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 用户_扩展表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Mapper
public interface UserExtendConvert {

	UserExtendConvert INSTANCE = Mappers.getMapper(UserExtendConvert.class);


	@Mappings({})
	UserExtendBO convert(UserExtendDO userExtendDO);


}

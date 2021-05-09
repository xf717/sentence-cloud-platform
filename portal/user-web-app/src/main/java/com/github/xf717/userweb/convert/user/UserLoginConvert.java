package com.github.xf717.userweb.convert.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换用户信息表
 *
 * @author wst
 * @date 2021/4/6 11:41
 */

@Mapper
public interface UserLoginConvert {

  UserLoginConvert INSTANCE = Mappers.getMapper(UserLoginConvert.class);
}

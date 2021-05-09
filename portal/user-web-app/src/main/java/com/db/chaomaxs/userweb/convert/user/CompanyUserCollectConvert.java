package com.db.chaomaxs.userweb.convert.user;

import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.UserCollectPageReqDTO;
import com.db.chaomaxs.userweb.controller.user.dto.CompanyUserCollectPageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换企业_用户_收藏
 *
 * @author momo
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyUserCollectConvert {

  CompanyUserCollectConvert INSTANCE = Mappers.getMapper(CompanyUserCollectConvert.class);

  @Mappings({})
  UserCollectPageReqDTO convert(CompanyUserCollectPageDTO companyUserCollectPageDTO);

}

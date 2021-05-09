package com.db.chaomaxs.userweb.convert.position;

import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoDetailRespDTO;
import com.db.chaomaxs.userweb.controller.position.vo.CompanyInfoDetailVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


/**
 * 公司转换
 *
 * @author xiaofeng
 * @date 2021-04-06 17:45:09
 */
@Mapper
public interface CompanyConvert {

  CompanyConvert INSTANCE = Mappers.getMapper(CompanyConvert.class);

  /**
   * 公司信息转换
   *
   * @param companyInfo
   * @return
   */
  @Mapping(source = "userId", target = "companyUserId")
  CompanyInfoDetailVO convert(CompanyInfoDetailRespDTO companyInfo);
}

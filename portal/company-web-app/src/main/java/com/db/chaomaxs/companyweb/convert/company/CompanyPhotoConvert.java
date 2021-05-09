package com.db.chaomaxs.companyweb.convert.company;

import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoRespDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyPhotoAddDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyPhotoVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换公司_相册
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyPhotoConvert {

  CompanyPhotoConvert INSTANCE = Mappers.getMapper(CompanyPhotoConvert.class);


  /**
   * CompanyPhotoRespDTOs to CompanyPhotoVOs
   * @param listResp
   * @return
   */
  List<CompanyPhotoVO> convertList(List<CompanyPhotoRespDTO> listResp);

  /**
   * companyPhotoAddDTOs convert companyPhotoCreateReqDTOs
   * @param companyPhotoAddDTOs 转换对象
   * @return
   */
  List<CompanyPhotoReqDTO> convert(List<CompanyPhotoAddDTO> companyPhotoAddDTOs);

}

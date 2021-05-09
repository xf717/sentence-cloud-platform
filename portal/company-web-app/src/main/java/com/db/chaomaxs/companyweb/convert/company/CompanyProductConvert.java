package com.db.chaomaxs.companyweb.convert.company;

import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductRespDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyProductAddDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyProductVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换公司_产品
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyProductConvert {

  CompanyProductConvert INSTANCE = Mappers.getMapper(CompanyProductConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  CompanyProductCreateReqDTO convert(CompanyProductAddDTO addDTO);

  /**
   * addDtos convert CreateReqDTOs
   * @param addDTOs
   * @return
   */
  List<CompanyProductCreateReqDTO> convertToCreateReqDTO(List<CompanyProductAddDTO> addDTOs);

  /**
   * BO convert VO
   *
   * @param companyProductRespDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyProductVO convert(CompanyProductRespDTO companyProductRespDTO);

  @Mappings({})
  List<CompanyProductVO> convertList(List<CompanyProductRespDTO> listResp);

}

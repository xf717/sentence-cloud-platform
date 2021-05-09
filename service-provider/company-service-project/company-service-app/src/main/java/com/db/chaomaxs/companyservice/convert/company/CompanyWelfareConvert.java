package com.db.chaomaxs.companyservice.convert.company;

import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.CompanyWelfareDO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareSaveReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * CompanyWelfareConvert
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyWelfareConvert {

  CompanyWelfareConvert INSTANCE = Mappers.getMapper(CompanyWelfareConvert.class);

  /**
   * 将 CompanyWelfareDTO 转成 CompanyWelfareVO
   *
   * @param createReqDTO
   * @return
   */
  CompanyWelfareDO convert(CompanyWelfareCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  CompanyWelfareDO convert(CompanyWelfareUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<CompanyWelfareRespDTO> convertList(List<CompanyWelfareDO> list);

  /**
   * 对象转换
   *
   * @param companyWelfareDO
   * @return
   */
  CompanyWelfareRespDTO convert(CompanyWelfareDO companyWelfareDO);

  /**
   * 转换对象
   * @param companyWelfareSaveReqDTO
   * @return
   */
  CompanyWelfareDO convertToCompanyWelfareDO(CompanyWelfareSaveReqDTO companyWelfareSaveReqDTO);

  /**
   * 转换对象
   * @param companyWelfareSaveReqDTOs
   * @return
   */
  List<CompanyWelfareDO> convertToCompanyWelfareDOs(List<CompanyWelfareSaveReqDTO> companyWelfareSaveReqDTOs);

  /**
   * 转换对象
   * @param companyWelfareRespDTO
   * @return
   */
  CompanyWelfareSaveReqDTO convertToCompanyWelfareSaveReqDTO(CompanyWelfareRespDTO companyWelfareRespDTO);

  /**
   * 转换对象
   * @param companyWelfareRespDTOs
   * @return
   */
  List<CompanyWelfareSaveReqDTO> convertToCompanyWelfareSaveReqDTOs(List<CompanyWelfareRespDTO> companyWelfareRespDTOs);

}

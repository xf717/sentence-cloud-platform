package com.db.chaomaxs.companyweb.convert.company;

import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareSaveReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareUpdateReqDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyWelfareAddDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyWelfareUpdateDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyWelfareVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换公司福利
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyWelfareConvert {

  CompanyWelfareConvert INSTANCE = Mappers.getMapper(CompanyWelfareConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  CompanyWelfareCreateReqDTO convert(CompanyWelfareAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  CompanyWelfareUpdateReqDTO convert(CompanyWelfareUpdateDTO updateDTO);

  /**
   * BO convert VO
   *
   * @param companyWelfareRespDTO 转换对象
   * @return
   */
  CompanyWelfareVO convert(CompanyWelfareRespDTO companyWelfareRespDTO);

  /**
   * CompanyWelfareRespDTOs convert CompanyWelfareVOs
   *
   * @param listResp
   * @return
   */
  List<CompanyWelfareVO> convertList(List<CompanyWelfareRespDTO> listResp);

  /**
   * 转换对象
   *
   * @param companyWelfareAddDTOs 转换对象
   * @return
   */
  List<CompanyWelfareSaveReqDTO> convertToCompanyWelfareSaveReqDTOs(
      List<CompanyWelfareAddDTO> companyWelfareAddDTOs);
}

package com.db.chaomaxs.companyweb.convert.company;

import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoUpdateReqDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyInfoAddDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyInfoUpdateDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyRegisterReqDto;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyBaseInfoVO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyInfoVO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换企业_基础信息
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyInfoConvert {

  CompanyInfoConvert INSTANCE = Mappers.getMapper(CompanyInfoConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyInfoCreateReqDTO convert(CompanyInfoAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyInfoUpdateReqDTO convert(CompanyInfoUpdateDTO updateDTO);

  /**
   * BO convert VO
   *
   * @param companyInfoRespDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyInfoVO convert(CompanyInfoRespDTO companyInfoRespDTO);

  @Mappings({})
  List<CompanyInfoVO> convertList(List<CompanyInfoRespDTO> listResp);

  /**
   * CompanyRegisterReqDto convert CompanyInfoCreateReqDTO
   * @param companyRegisterReqDto 转换对象
   * @return
   */
  @Mappings({})
  CompanyInfoCreateReqDTO convert(CompanyRegisterReqDto companyRegisterReqDto);

  /**
   * CompanyRegisterReqDto convert UserRecruitUpdateReqDTO
   * @param companyRegisterReqDto 转换对象
   * @return
   */
  @Mappings({})
  UserRecruitUpdateReqDTO convertToUserRecruitUpdateReqDTO(CompanyRegisterReqDto companyRegisterReqDto);

  @Mappings({})
  CompanyBaseInfoVO convertToCompanyBaseInfoVO(CompanyInfoRespDTO companyInfoRespDTO);
}

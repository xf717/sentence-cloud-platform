package com.db.chaomaxs.companyweb.convert.settings;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetRespDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetUpdateReqDTO;
import com.db.chaomaxs.companyweb.controller.settings.dto.CompanyUserSetAddDTO;
import com.db.chaomaxs.companyweb.controller.settings.dto.CompanyUserSetDTO;
import com.db.chaomaxs.companyweb.controller.settings.dto.CompanyUserSetPageDTO;
import com.db.chaomaxs.companyweb.controller.settings.dto.CompanyUserSetUpdateDTO;
import com.db.chaomaxs.companyweb.controller.settings.vo.CompanyUserSetVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换企业我的设置
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@Mapper
public interface CompanyUserSetConvert {

  CompanyUserSetConvert INSTANCE = Mappers.getMapper(CompanyUserSetConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyUserSetCreateReqDTO convert(CompanyUserSetAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyUserSetUpdateReqDTO convert(CompanyUserSetUpdateDTO updateDTO);

  @Mappings({})
  CompanyUserSetListQueryReqDTO convert(CompanyUserSetDTO companyUserSetDTO);

  /**
   * BO convert VO
   *
   * @param companyUserSetRespDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyUserSetVO convert(CompanyUserSetRespDTO companyUserSetRespDTO);

  @Mappings({})
  List<CompanyUserSetVO> convertList(List<CompanyUserSetRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<CompanyUserSetVO> convert(
      TableResultResponse<CompanyUserSetRespDTO> tableResultResponse);

  @Mappings({})
  CompanyUserSetPageReqDTO convert(CompanyUserSetPageDTO companyUserSetPageDTO);

}

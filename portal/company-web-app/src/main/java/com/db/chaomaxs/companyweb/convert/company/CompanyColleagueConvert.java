package com.db.chaomaxs.companyweb.convert.company;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyColleagueInfoDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyColleagueTransferReqDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyColleagueVO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingExtendRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingInfoRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingTransferReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author hlf
 * @date 2021/4/29 18:17
 */
@Mapper
public interface CompanyColleagueConvert {

  CompanyColleagueConvert INSTANCE = Mappers.getMapper(CompanyColleagueConvert.class);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  TableResultResponse<CompanyColleagueVO> convertTableResult(
      TableResultResponse<UserBindingInfoRespDTO> tableResultResponse);

  /**
   * list转换
   * @param bindingExtendsRestResponse
   * @return
   */
  ObjectRestResponse<List<CompanyColleagueInfoDTO>> convertList(
      ObjectRestResponse<List<UserBindingExtendRespDTO>> bindingExtendsRestResponse);

  /**
   * companyColleagueTransferReqDTO convert userBindingTransferReqDTO
   * @param companyColleagueTransferReqDTO
   * @return
   */
  UserBindingTransferReqDTO convert(CompanyColleagueTransferReqDTO companyColleagueTransferReqDTO);
}

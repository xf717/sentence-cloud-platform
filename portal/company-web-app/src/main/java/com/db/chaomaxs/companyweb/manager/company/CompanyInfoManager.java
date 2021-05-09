package com.db.chaomaxs.companyweb.manager.company;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.CompanyInfoRpcFacade;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyInfoUpdateDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyRegisterReqDto;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyBaseInfoVO;
import com.db.chaomaxs.companyweb.convert.company.CompanyInfoConvert;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryTypeListIdsReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.facade.DataDictionaryItemRpcFacade;
import com.db.chaomaxs.userservice.enums.user.UserBindingStateEnum;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingCompanyCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserBindingCompanyRpcFacade;
import com.db.chaomaxs.userservice.rpc.user.facade.UserExtendRpcFacade;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyInfoManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyInfoManager {

  @Autowired
  private CompanyInfoRpcFacade companyInfoRpcFacade;

  @Autowired
  private UserExtendRpcFacade userExtendRpcFacade;

  @Autowired
  private UserBindingCompanyRpcFacade userBindingCompanyRpcFacade;

  @Autowired
  private DataDictionaryItemRpcFacade dataDictionaryItemRpcFacade;

  /**
   * 更新数据
   *
   * @param companyInfoUpdateDTO 更新参数
   * @return
   */
  public int update(CompanyInfoUpdateDTO companyInfoUpdateDTO) {
    companyInfoUpdateDTO.setId(BaseContextHandler.getCompanyId());
    BaseResponse baseResponse = companyInfoRpcFacade
        .update(CompanyInfoConvert.INSTANCE.convert(companyInfoUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public CompanyBaseInfoVO getCompanyInfoById(Long id) {
    ObjectRestResponse<CompanyInfoRespDTO> objectRestResponse = companyInfoRpcFacade
        .getCompanyInfoById(id);
    CompanyInfoRespDTO companyInfoRespDTO = objectRestResponse.getData();
    objectRestResponse.checkError();

    // 根据字典ids 批量查询字典名称
    DataDictionaryTypeListIdsReqDTO dataDictionaryTypeListIdsReqDTO = new DataDictionaryTypeListIdsReqDTO();
    dataDictionaryTypeListIdsReqDTO.setIds(Lists.newArrayList(
        companyInfoRespDTO.getDevelopmentStageDictionaryId(), companyInfoRespDTO.getScopeDictionaryId()));
    companyInfoRespDTO.getDevelopmentStageDictionaryId();
    ObjectRestResponse<List<DataDictionaryItemRespDTO>> listObjectRestResponse = dataDictionaryItemRpcFacade
        .listDataDictionaryItemByIds(dataDictionaryTypeListIdsReqDTO);
    Map<Long, DataDictionaryItemRespDTO> dictionaryItemRespDtoMap = listObjectRestResponse.getData().stream()
        .collect(Collectors.toMap(DataDictionaryItemRespDTO::getId, a -> a, (k1, k2) -> k2));

    CompanyBaseInfoVO vo = CompanyInfoConvert.INSTANCE
        .convertToCompanyBaseInfoVO(companyInfoRespDTO);
    vo.setDevelopmentStageDictionaryName(null == dictionaryItemRespDtoMap.get(companyInfoRespDTO.getDevelopmentStageDictionaryId()) ?
        null : dictionaryItemRespDtoMap.get(companyInfoRespDTO.getDevelopmentStageDictionaryId()).getDictText());
    vo.setScopeDictionaryName(null == dictionaryItemRespDtoMap.get(companyInfoRespDTO.getScopeDictionaryId()) ?
        null : dictionaryItemRespDtoMap.get(companyInfoRespDTO.getScopeDictionaryId()).getDictText());
    return vo;
  }

  /**
   * 公司注册
   *
   * @param companyRegisterReqDto 注册请求参数
   * @return
   */
  public int register(CompanyRegisterReqDto companyRegisterReqDto) {
    Long userId = BaseContextHandler.getUserId();
    // 根据公司全称查询，判断公司是否已添加
    ObjectRestResponse companyInfoResponse = companyInfoRpcFacade
        .getCompanyInfoByCompanyName(companyRegisterReqDto.getFullName());

    Long companyId = null;
    UserBindingCompanyCreateReqDTO userBindingCompanyCreateReqDTO = new UserBindingCompanyCreateReqDTO();
    // 公司信息不存在时添加
    if (companyInfoResponse.getData() == null) {
      companyRegisterReqDto.setUserId(userId);
      // 添加公司基本信息
      companyId = companyInfoRpcFacade
          .save(CompanyInfoConvert.INSTANCE.convert(companyRegisterReqDto));
      userBindingCompanyCreateReqDTO.setCompanyId(companyId)
          .setBindingState(UserBindingStateEnum.BOUND.getValue())
          .setManager(1)
          .setUserId(userId);
    } else {
      CompanyInfoRespDTO companyInfoRespDTO = (CompanyInfoRespDTO) companyInfoResponse.getData();
      userBindingCompanyCreateReqDTO.setCompanyId(companyInfoRespDTO.getId())
          .setBindingState(UserBindingStateEnum.UNBOUND.getValue())
          .setManager(0)
          .setUserId(userId);
      companyId = companyInfoRespDTO.getId();
    }
    // 用户绑定表添加
    userBindingCompanyRpcFacade.save(userBindingCompanyCreateReqDTO);

    // 修改用户拓展及用户招聘拓展信息
    UserRecruitUpdateReqDTO userRecruitUpdateReqDTO = CompanyInfoConvert
        .INSTANCE.convertToUserRecruitUpdateReqDTO(companyRegisterReqDto);
    userRecruitUpdateReqDTO.setCompanyId(companyId);
    userRecruitUpdateReqDTO.setUserId(userId);
    userRecruitUpdateReqDTO.setCompanyName(companyRegisterReqDto.getFullName());
    BaseResponse baseResponse = userExtendRpcFacade.updateUserRecruitInfo(userRecruitUpdateReqDTO);

    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }


}

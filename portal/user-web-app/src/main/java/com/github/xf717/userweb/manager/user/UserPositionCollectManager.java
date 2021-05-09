package com.github.xf717.userweb.manager.user;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.companyservice.rpc.company.dto.CompanyInfoListReqDTO;
import com.github.xf717.companyservice.rpc.company.dto.CompanyInfoListRespDTO;
import com.github.xf717.companyservice.rpc.company.facade.CompanyInfoRpcFacade;
import com.github.xf717.positionservice.rpc.position.dto.CompanyPositionRespDTO;
import com.github.xf717.positionservice.rpc.position.dto.IdsReqDTO;
import com.github.xf717.positionservice.rpc.position.facade.CompanyPositionRpcFacade;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryTypeListIdsReqDTO;
import com.github.xf717.systemservice.rpc.dict.facade.DataDictionaryItemRpcFacade;
import com.github.xf717.userservice.rpc.user.dto.UserExtendDetailRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendDetailReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPositionCollectCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPositionCollectPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPositionCollectRespDTO;
import com.github.xf717.userservice.rpc.user.facade.UserExtendRpcFacade;
import com.github.xf717.userservice.rpc.user.facade.UserPositionCollectRpcFacade;
import com.github.xf717.userweb.controller.user.dto.UserPositionCollectAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserPositionCollectPageDTO;
import com.github.xf717.userweb.controller.user.vo.CompanyPositionConvertVO;
import com.github.xf717.userweb.controller.user.vo.UserPositionCollectVO;
import com.github.xf717.userweb.convert.user.UserPositionCollectConvert;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserPositionCollectManager
 *
 * @author wst
 * @date 2021-03-29 12:47:47
 */
@Service
@Validated
public class UserPositionCollectManager {

  @Autowired
  private UserPositionCollectRpcFacade userPositionCollectRpcFacade;

  @Autowired
  private CompanyPositionRpcFacade companyPositionRpcFacade;

  @Autowired
  private DataDictionaryItemRpcFacade dataDictionaryItemRpcFacade;

  @Autowired
  private UserExtendRpcFacade userExtendRpcFacade;

  @Autowired
  private CompanyInfoRpcFacade companyInfoRpcFacade;

  /**
   * 添加数据
   *
   * @param userPositionCollectAddDTO 添加参数
   * @return
   */
  public int save(UserPositionCollectAddDTO userPositionCollectAddDTO) {
    UserPositionCollectCreateReqDTO userPositionCollectCreateReqDTO = UserPositionCollectConvert.INSTANCE
        .convert(userPositionCollectAddDTO);
    userPositionCollectCreateReqDTO.setUserId(BaseContextHandler.getUserId());
    BaseResponse baseResponse = userPositionCollectRpcFacade.save(userPositionCollectCreateReqDTO);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }


  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = userPositionCollectRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public UserPositionCollectVO getUserPositionCollectById(Long id) {
    ObjectRestResponse<UserPositionCollectRespDTO> objectRestResponse = userPositionCollectRpcFacade
        .getUserPositionCollectById(id);
    objectRestResponse.checkError();
    return UserPositionCollectConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 查找数据显示分页
   *
   * @param pageDTO 分页参数
   * @return
   */
  public TableResultResponse<UserPositionCollectVO> pageUserPositionCollect(
      UserPositionCollectPageDTO pageDTO) {
    UserPositionCollectPageReqDTO userPositionCollectPageReqDTO = UserPositionCollectConvert.INSTANCE
        .convert(pageDTO);
    userPositionCollectPageReqDTO.setUserId(Long.parseLong(BaseContextHandler.getUserID()));
    TableResultResponse<UserPositionCollectRespDTO> tableResultResponse = userPositionCollectRpcFacade
        .page(userPositionCollectPageReqDTO);
    tableResultResponse.checkError();
    TableResultResponse<UserPositionCollectVO> positionCollectPage = UserPositionCollectConvert.INSTANCE
        .convert(tableResultResponse);

    return positionInfo(positionCollectPage);
  }

  /**
   *
   * @param positionCollectPage
   * @return
   */
  public TableResultResponse<UserPositionCollectVO> positionInfo(TableResultResponse<UserPositionCollectVO>
      positionCollectPage){
    Set<Long> positionIdList = new HashSet<>();
    Set<Long> companyUserIdList = new HashSet<>();
    for (UserPositionCollectVO userPositionCollectVO : positionCollectPage.getData().getRows()) {
      positionIdList.add(userPositionCollectVO.getPositionId());
      companyUserIdList.add(userPositionCollectVO.getCompanyUserId());
    }
    //查询个人拓展信息
    List<UserExtendDetailRespDTO> userExtendList = userExtend(companyUserIdList);
    Map<Long, UserExtendDetailRespDTO> userExtendMap = new HashMap<>();
    if (!CollectionUtils.isEmpty(userExtendList)) {
      userExtendMap = userExtendList.stream()
          .collect(Collectors.toMap(UserExtendDetailRespDTO::getUserId, a -> a, (k1, k2) -> k1));
    }

    //查询职位信息
    Map<Long, CompanyPositionConvertVO> companyPositionMap = companyPositionRespMap(positionIdList);

    Set<Long> companyIdList = new HashSet<>();

    for (UserExtendDetailRespDTO dto : userExtendList) {
      companyIdList.add(dto.getCompanyId());
    }
    //查询公司信息
    Map<Long, CompanyInfoListRespDTO> companyInfoMap = companyInfo(companyIdList);
    achieveUserPosition(companyInfoMap, companyPositionMap, userExtendMap, positionCollectPage);
    return positionCollectPage;
  }

  /**
   * 职位信息查询
   * @param positionIdList
   * @return
   */

  public Map<Long, CompanyPositionConvertVO> companyPositionRespMap(Set<Long> positionIdList) {
    Map<Long, CompanyPositionConvertVO> companyPositionMap = new HashMap<>();
    List<Long> dataDictionaryIds = new ArrayList<>();
    IdsReqDTO idsReqDTO = new IdsReqDTO();
    idsReqDTO.setIds(positionIdList);
    ObjectRestResponse<List<CompanyPositionRespDTO>> companyPositionsResponse = companyPositionRpcFacade
        .getCompanyPositionsByIds(idsReqDTO);
    if (CollectionUtils.isEmpty(companyPositionsResponse.getData())) {
      return companyPositionMap;
    }
    for (CompanyPositionRespDTO dto : companyPositionsResponse.getData()) {
      dataDictionaryIds.add(dto.getEducationId());
      dataDictionaryIds.add(dto.getExperienceId());
    }
    DataDictionaryTypeListIdsReqDTO dataDictionaryDTO = new DataDictionaryTypeListIdsReqDTO();
    dataDictionaryDTO.setIds(dataDictionaryIds);
    ObjectRestResponse<List<DataDictionaryItemRespDTO>> scopeDictionary = dataDictionaryItemRpcFacade
        .listDataDictionaryItemByIds(dataDictionaryDTO);

    Map<Long, String> dataDictionaryMap = scopeDictionary.getData().stream()
        .collect(Collectors
            .toMap(DataDictionaryItemRespDTO::getId, DataDictionaryItemRespDTO::getDictText,
                (k1, k2) -> k1));
    List<CompanyPositionConvertVO> companyPositionVOList = UserPositionCollectConvert.INSTANCE
        .convertPosition(companyPositionsResponse.getData());
    for (CompanyPositionConvertVO vo : companyPositionVOList) {
      vo.setEducation(dataDictionaryMap.get(vo.getExperienceId()));
      vo.setExperience(dataDictionaryMap.get(vo.getExperienceId()));
    }
    companyPositionMap = companyPositionVOList.stream()
        .collect(Collectors.toMap(CompanyPositionConvertVO::getId, a -> a, (k1, k2) -> k1));
    return companyPositionMap;
  }


  /**
   * 查公司用户信息
   *
   * @param companyUserIdList
   * @return
   */
  public List<UserExtendDetailRespDTO> userExtend(Set<Long> companyUserIdList) {
    UserExtendDetailReqDTO userExtendDetailReqDTO = new UserExtendDetailReqDTO();
    userExtendDetailReqDTO.setUserIds(companyUserIdList);
    //根据公司用户ids 查询
    ObjectRestResponse<List<UserExtendDetailRespDTO>> userExtendResponse = userExtendRpcFacade
        .listUserExtendByUserIds(userExtendDetailReqDTO);
    return userExtendResponse.getData();
  }

  /**
   * 查公司信息
   *
   * @param companyIdList
   * @return
   */
  public Map<Long, CompanyInfoListRespDTO> companyInfo(Set<Long> companyIdList) {
    CompanyInfoListReqDTO companyInfoListReqDTO = new CompanyInfoListReqDTO();
    companyInfoListReqDTO.setIdsList(companyIdList);
    //根据公司ids 查询
    Map<Long, CompanyInfoListRespDTO> companyInfoMap = new HashMap<>();
    ObjectRestResponse<List<CompanyInfoListRespDTO>> companyInfoResponse = companyInfoRpcFacade
        .listCompanyInfoByIds(companyInfoListReqDTO);
    if (CollectionUtils.isEmpty(companyInfoResponse.getData())) {
      return companyInfoMap;
    }
    List<Long> dataDictionaryIds = new ArrayList<>();
    for (CompanyInfoListRespDTO dto : companyInfoResponse.getData()) {
      dataDictionaryIds.add(dto.getScopeDictionaryId());
      dataDictionaryIds.add(dto.getDevelopmentStageDictionaryId());
    }

    DataDictionaryTypeListIdsReqDTO queryDTO = new DataDictionaryTypeListIdsReqDTO().setIds(dataDictionaryIds);
    ObjectRestResponse<List<DataDictionaryItemRespDTO>> scopeDictionary = dataDictionaryItemRpcFacade
        .listDataDictionaryItemByIds(queryDTO);
    Map<Long, String> dataDictionaryMap = scopeDictionary.getData().stream()
        .collect(Collectors.toMap(DataDictionaryItemRespDTO::getId,DataDictionaryItemRespDTO::getDictText,(k1, k2) -> k1));
    for (CompanyInfoListRespDTO respDTO : companyInfoResponse.getData()) {
      respDTO.setScope(dataDictionaryMap.get(respDTO.getScopeDictionaryId()));
      respDTO.setDevelopmentStage(dataDictionaryMap.get(respDTO.getDevelopmentStageDictionaryId()));
    }
   companyInfoMap = companyInfoResponse.getData().stream()
        .collect(Collectors.toMap(CompanyInfoListRespDTO::getId, a -> a, (k1, k2) -> k1));
    return companyInfoMap;
  }

  /**
   * 数据组装
   * @param companyInfoMap
   * @param companyPositionMap
   * @param userExtendMap
   * @param positionCollectPage
   */
  public void achieveUserPosition(Map<Long, CompanyInfoListRespDTO> companyInfoMap,
      Map<Long, CompanyPositionConvertVO> companyPositionMap,
      Map<Long, UserExtendDetailRespDTO> userExtendMap,
      TableResultResponse<UserPositionCollectVO> positionCollectPage) {

    for (UserPositionCollectVO userPositionCollectVO : positionCollectPage.getData().getRows()) {
      //用户信息
      userPositionCollectVO
          .setRealName(null == userExtendMap.get(userPositionCollectVO.getUserId()) ? null
              : userExtendMap.get(userPositionCollectVO.getUserId()).getRealName());
      userPositionCollectVO
          .setCompanyId(null == userExtendMap.get(userPositionCollectVO.getUserId()) ? null
              : userExtendMap.get(userPositionCollectVO.getUserId()).getCompanyId());
      userPositionCollectVO.setCompanyId(null == userExtendMap.get(userPositionCollectVO.getCompanyUserId()) ? null
          : userExtendMap.get(userPositionCollectVO.getCompanyUserId()).getCompanyId());
      //公司全称
      userPositionCollectVO
          .setFullName(null == companyInfoMap.get(userPositionCollectVO.getCompanyId()) ? null
              : companyInfoMap.get(userPositionCollectVO.getCompanyId()).getFullName());
      //公司规模
      userPositionCollectVO
          .setScope(null == companyInfoMap.get(userPositionCollectVO.getCompanyId()) ? null
              : companyInfoMap.get(userPositionCollectVO.getCompanyId()).getScope());
      //融资情况
      userPositionCollectVO.setDevelopmentStage(
          null == companyInfoMap.get(userPositionCollectVO.getCompanyId()) ? null
              : companyInfoMap.get(userPositionCollectVO.getCompanyId()).getDevelopmentStage());
      //职位信息
      userPositionCollectVO
          .setPositionName(null == companyPositionMap.get(userPositionCollectVO.getPositionId()) ?
              null : companyPositionMap.get(userPositionCollectVO.getPositionId()).getPositionName());
      //学历
      userPositionCollectVO
          .setEducation(null == companyPositionMap.get(userPositionCollectVO.getPositionId()) ?
              null : companyPositionMap.get(userPositionCollectVO.getPositionId()).getEducation());
      //经验
      userPositionCollectVO
          .setExperience(null == companyPositionMap.get(userPositionCollectVO.getPositionId()) ?
              null : companyPositionMap.get(userPositionCollectVO.getPositionId()).getExperience());
      //最低薪资
      userPositionCollectVO
          .setStartSalary(null == companyPositionMap.get(userPositionCollectVO.getPositionId()) ?
              null : companyPositionMap.get(userPositionCollectVO.getPositionId()).getStartSalary());
      //最高薪资
      userPositionCollectVO
          .setEndSalary(null == companyPositionMap.get(userPositionCollectVO.getPositionId()) ?
              null : companyPositionMap.get(userPositionCollectVO.getPositionId()).getEndSalary());
      //状态
      userPositionCollectVO.setStatus(null == companyPositionMap.get(userPositionCollectVO.getPositionId()) ?
          null : companyPositionMap.get(userPositionCollectVO.getPositionId()).getStatus());

      //商圈
      userPositionCollectVO.setBusinessDistrict(null == companyPositionMap.
          get(userPositionCollectVO.getPositionId()) ? null :
          companyPositionMap.get(userPositionCollectVO.getPositionId()).getBusinessDistrict());

      //街道
      userPositionCollectVO.setAreaCode(null == companyPositionMap.
          get(userPositionCollectVO.getPositionId()) ? null :
          companyPositionMap.get(userPositionCollectVO.getPositionId()).getAreaCode());

      //关键字
      userPositionCollectVO
          .setKeywordList(null == companyPositionMap.get(userPositionCollectVO.getPositionId())
              ? null
              : companyPositionMap.get(userPositionCollectVO.getPositionId()).getKeywordList());
    }

  }

}

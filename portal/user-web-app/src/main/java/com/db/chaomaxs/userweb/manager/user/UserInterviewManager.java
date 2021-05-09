package com.db.chaomaxs.userweb.manager.user;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoListRespDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewIdReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewRespDTO;
import com.db.chaomaxs.companyservice.rpc.interview.facade.CompanyUserInterviewRpcFacade;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.IdsReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.facade.CompanyPositionRpcFacade;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendDetailRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserInterviewRpcFacade;
import com.db.chaomaxs.userweb.controller.user.dto.UserInterviewPageDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserInterviewUpdateDTO;
import com.db.chaomaxs.userweb.controller.user.vo.UserInterviewVO;
import com.db.chaomaxs.userweb.convert.user.UserInterviewConvert;
import com.db.chaomaxs.userweb.manager.user.interview.UserInterviewStateFactory;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserInterviewManager
 *
 * @author momo
 * @date 2021-04-02 13:58:28
 */
@Service
@Validated
public class UserInterviewManager {

  @Autowired
  private UserInterviewRpcFacade userInterviewRpcFacade;

  @Autowired
  private UserInterviewStateFactory updateUserInterviewStateFactory;

  @Autowired
  private CompanyPositionRpcFacade companyPositionRpcFacade;

  @Autowired
  private CompanyUserInterviewRpcFacade companyUserInterviewRpcFacade;

  @Autowired
  private UserPositionCollectManager userPositionCollectManager;


  /**
   * 更新数据
   *
   * @param userInterviewUpdateDTO 更新参数
   * @return
   */
  public int update(UserInterviewUpdateDTO userInterviewUpdateDTO) {
    //更新用户面试状态
    BaseResponse baseResponse = updateUserInterviewStateFactory.updateUserInterviewState(UserInterviewConvert.INSTANCE.convert(userInterviewUpdateDTO));
    baseResponse.checkError();
    // 更新企业面试状态
    BaseResponse response = updateUserInterviewStateFactory.updateCompanyUserInterviewState(UserInterviewConvert.INSTANCE
        .convertToCompanyInterview(userInterviewUpdateDTO));
    response.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }


  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public UserInterviewVO getUserInterviewById(Long id) {
    ObjectRestResponse<UserInterviewRespDTO> objectRestResponse = userInterviewRpcFacade
        .getUserInterviewById(id);
    objectRestResponse.checkError();
    return UserInterviewConvert.INSTANCE.convert(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<UserInterviewVO> pageUserInterview(UserInterviewPageDTO pageReqDTO) {
    UserInterviewPageReqDTO userInterviewPageReqDTO = UserInterviewConvert.INSTANCE
        .convert(pageReqDTO);
    userInterviewPageReqDTO.setUserId(Long.parseLong(BaseContextHandler.getUserID()));
    TableResultResponse<UserInterviewRespDTO> tableResultResponse = userInterviewRpcFacade
        .page(userInterviewPageReqDTO);
    tableResultResponse.checkError();
    TableResultResponse<UserInterviewVO> userInterviewPage = UserInterviewConvert.INSTANCE
        .convert(tableResultResponse);
    List<UserInterviewVO> userInterview;
    if (!CollectionUtils.isEmpty(userInterviewPage.getData().getRows())) {
      Set<Long> interviewIds = userInterviewPage.getData().getRows().stream()
          .map(UserInterviewVO::getCompanyUserInterviewId).collect(Collectors.toSet());
       userInterview = companyUserInterviewAndCompanyInfo(interviewIds);
      // 按照面试时间排序
       userInterview = userInterview.stream()
          .sorted(Comparator.comparing(UserInterviewVO::getInterviemTime)).collect(
              Collectors.toList());
      userInterviewPage.getData().setRows(userInterview);
    }
    return userInterviewPage;
  }

  /**
   * 查询面试相关信息
   * @param interviewIds
   * @return
   */
  private List<UserInterviewVO> companyUserInterviewAndCompanyInfo(Set<Long> interviewIds) {
    //查询企业面试表
    CompanyUserInterviewIdReqDTO companyUserInterviewIdReqDTO = new CompanyUserInterviewIdReqDTO();
    companyUserInterviewIdReqDTO.setIds(interviewIds);
    ObjectRestResponse<List<CompanyUserInterviewRespDTO>> listObjectRestResponse = companyUserInterviewRpcFacade
        .getCompanyUserInterviewByIds(companyUserInterviewIdReqDTO);

    Set<Long> companyUserIds = new HashSet<>();
    Set<Long> positionIds = new HashSet<>();
    for (CompanyUserInterviewRespDTO dto : listObjectRestResponse.getData()) {
      companyUserIds.add(dto.getCompanyUserId());
      positionIds.add(dto.getPositionId());
    }
    //查询职位信息
    IdsReqDTO dto = new IdsReqDTO();
    dto.setIds(positionIds);
    ObjectRestResponse<List<CompanyPositionRespDTO>> companyPositionsResp = companyPositionRpcFacade
        .getCompanyPositionsByIds(dto);
    Map<Long, CompanyPositionRespDTO> companyPositionsMap = companyPositionsResp.getData().stream()
        .collect(Collectors.toMap(CompanyPositionRespDTO::getId, a -> a, (k1, k2) -> k1));

    for (CompanyUserInterviewRespDTO respDTO : listObjectRestResponse.getData()) {
      respDTO.setPositionName(null == companyPositionsMap.get(respDTO.getPositionId()) ? null
          : companyPositionsMap.get(respDTO.getPositionId()).getPositionName());
      respDTO.setStartSalary(null == companyPositionsMap.get(respDTO.getPositionId()) ? null
          : companyPositionsMap.get(respDTO.getPositionId()).getStartSalary());
      respDTO.setEndSalary(null == companyPositionsMap.get(respDTO.getPositionId()) ? null
          : companyPositionsMap.get(respDTO.getPositionId()).getEndSalary());
    }
    return setUserInterviewInfo(companyUserIds,listObjectRestResponse);
  }

  /**
   * 查询公司信息
   * @param companyUserIds 公司用户ids
   * @param listObjectRestResponse
   * @return
   */
  private List<UserInterviewVO> setUserInterviewInfo(Set<Long> companyUserIds,
      ObjectRestResponse<List<CompanyUserInterviewRespDTO>> listObjectRestResponse) {

    // 查询用户拓展信息中公司id
    List<UserExtendDetailRespDTO> userExtendList = userPositionCollectManager
        .userExtend(companyUserIds);
    Map<Long, Long> userExtendMap = userExtendList.stream().collect(Collectors.toMap(
        UserExtendDetailRespDTO::getUserId, UserExtendDetailRespDTO::getCompanyId, (k1, k2) -> k1));

    //查询公司信息
    Set<Long> companyIds = userExtendList.stream().map(UserExtendDetailRespDTO::getCompanyId).collect(Collectors.toSet());
    Map<Long, CompanyInfoListRespDTO> companyInfoMap = userPositionCollectManager
        .companyInfo(companyIds);

    List<UserInterviewVO> userInterviewList = UserInterviewConvert.INSTANCE
        .convertToList(listObjectRestResponse.getData());

    for(UserInterviewVO vo : userInterviewList){
      vo.setCompanyId(userExtendMap.get(vo.getCompanyUserId()));
      vo.setScope(null == companyInfoMap.get(vo.getCompanyId()) ? null
          : companyInfoMap.get(vo.getCompanyId()).getScope());
      vo.setDevelopmentStage(null == companyInfoMap.get(vo.getCompanyId()) ? null
          : companyInfoMap.get(vo.getCompanyId()).getDevelopmentStage());
      vo.setFullName(null == companyInfoMap.get(vo.getCompanyId()) ? null
          : companyInfoMap.get(vo.getCompanyId()).getFullName());
    }
    return userInterviewList;
  }

}

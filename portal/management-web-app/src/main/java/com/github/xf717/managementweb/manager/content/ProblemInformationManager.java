package com.github.xf717.managementweb.manager.content;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.managementweb.controller.content.dto.ProblemInformationAddDTO;
import com.github.xf717.managementweb.controller.content.dto.ProblemInformationDTO;
import com.github.xf717.managementweb.controller.content.dto.ProblemInformationPageDTO;
import com.github.xf717.managementweb.controller.content.dto.ProblemInformationUpdateDTO;
import com.github.xf717.managementweb.controller.content.vo.ProblemInformationDetailsVO;
import com.github.xf717.managementweb.controller.content.vo.ProblemInformationVO;
import com.github.xf717.managementweb.convert.content.ProblemInformationConvert;
import com.github.xf717.managementweb.convert.content.ProblemInformationDetailsConvert;
import com.github.xf717.systemservice.enums.ProblemInformation.ProblemInformationPlatformEnum;
import com.github.xf717.systemservice.enums.ProblemInformation.ProblemInformationStatusEnum;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationRespDTO;
import com.github.xf717.systemservice.rpc.content.facade.ProblemInformationRpcFacade;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryTypeListIdsReqDTO;
import com.github.xf717.systemservice.rpc.dict.facade.DataDictionaryItemRpcFacade;
import com.github.xf717.userservice.rpc.user.dto.UserExtendDetailRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendDetailReqDTO;
import com.github.xf717.userservice.rpc.user.facade.UserExtendRpcFacade;
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
 * ProblemInformationManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Service
@Validated
public class ProblemInformationManager {

  @Autowired
  private ProblemInformationRpcFacade problemInformationRpcFacade;
  @Autowired
  private UserExtendRpcFacade userExtendRpcFacade;
  @Autowired
  private DataDictionaryItemRpcFacade dataDictionaryItemRpcFacade;

  /**
   * 添加数据
   *
   * @param problemInformationAddDTO 添加参数
   * @return
   */
  public int save(ProblemInformationAddDTO problemInformationAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = problemInformationRpcFacade
        .save(ProblemInformationConvert.INSTANCE.convert(problemInformationAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param problemInformationUpdateDTO 更新参数
   * @return
   */
  public int update(ProblemInformationUpdateDTO problemInformationUpdateDTO) {
    BaseResponse baseResponse = problemInformationRpcFacade
        .update(ProblemInformationConvert.INSTANCE.convert(problemInformationUpdateDTO));
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
    BaseResponse baseResponse = problemInformationRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public ProblemInformationDetailsVO getProblemInformationById(Long id) {
    ObjectRestResponse<ProblemInformationRespDTO> objectRestResponse = problemInformationRpcFacade
        .getProblemInformationById(
            id);
    objectRestResponse.checkError();
//    ProblemInformationVO problemInformationVO = ProblemInformationConvert.INSTANCE
//        .convert(objectRestResponse.getData());
    ProblemInformationDetailsVO problemInformationDetailsVO = ProblemInformationDetailsConvert.INSTANCE
        .convert(objectRestResponse.getData());

    return problemInformationDetailsVO;
  }


  /**
   * 根据条件查找数据
   *
   * @param problemInformationDTO 查询参数
   * @return
   */
  public List<ProblemInformationVO> listProblemInformations(
      ProblemInformationDTO problemInformationDTO) {
    ObjectRestResponse<List<ProblemInformationRespDTO>> objectRestResponse = problemInformationRpcFacade
        .listProblemInformations(
            ProblemInformationConvert.INSTANCE.convert(problemInformationDTO));
    objectRestResponse.checkError();
    List<ProblemInformationVO> problemInformationVOS = ProblemInformationConvert.INSTANCE
        .convertList(objectRestResponse.getData());
    convertProblemInformationVO(problemInformationVOS);
    return problemInformationVOS;
  }

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<ProblemInformationVO> pageProblemInformation(
      ProblemInformationPageDTO pageReqDTO) {
    TableResultResponse<ProblemInformationRespDTO> tableResultResponse = problemInformationRpcFacade
        .page(ProblemInformationConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();

    TableResultResponse<ProblemInformationVO> result = ProblemInformationConvert.INSTANCE
        .convert(tableResultResponse);
    //组装数据
    convertProblemInformationVO(result.getData().getRows());
    return result;
  }

  /**
   * 组装数据
   *
   * @param vos
   */
  public void convertProblemInformationVO(List<ProblemInformationVO> vos) {
    if (CollectionUtils.isEmpty(vos)) {
      return;
    }
    Set<Long> userIds = new HashSet<>();
    Set<Long> dictionaryIds = new HashSet<>();
    for (ProblemInformationVO vo : vos) {
      userIds.add(vo.getCreateBy());
      dictionaryIds.add(vo.getTypeDictionaryId());
    }
    //查询人员扩展信息集合
    Map<Long, String> userNameMap = toUserNameMap(userIds);
    //查询字典项集合
    Map<Long, String> dictionaryTextMap = toDictionaryTextMap(dictionaryIds);
    //赋值
    for (ProblemInformationVO vo : vos) {
      vo.setCreateName(userNameMap.get(vo.getCreateBy()));
      vo.setTypeDictionary(dictionaryTextMap.get(vo.getTypeDictionaryId()));
      vo.setReleaseStatusStr(ProblemInformationStatusEnum.getValue(vo.getReleaseStatus()));
      vo.setPlatformStr(ProblemInformationPlatformEnum.getValue(vo.getPlatform()));
    }

  }

  /**
   * 用户名字map
   *
   * @param ids
   * @return
   */
  public Map<Long, String> toUserNameMap(Set<Long> ids) {
    if (ids.isEmpty()) {
      return new HashMap<>();
    }
    //查询人员扩展信息集合
    UserExtendDetailReqDTO userExtendDetailReq = new UserExtendDetailReqDTO();
    userExtendDetailReq.setUserIds(ids);
    ObjectRestResponse<List<UserExtendDetailRespDTO>> userResponse = userExtendRpcFacade
        .listUserExtendByUserIds(userExtendDetailReq);
    Map<Long, String> userNameMap = new HashMap<>();
    if (null != userResponse.getData()) {
      userNameMap = userResponse.getData().stream()
          .collect(Collectors
              .toMap(UserExtendDetailRespDTO::getUserId, d -> d.getRealName(), (k1, k2) -> k2));
    }
    return userNameMap;
  }

  /**
   * 字典类型编号map
   *
   * @param ids
   * @return
   */
  public Map<Long, String> toDictionaryTextMap(Set<Long> ids) {
    if (ids.isEmpty()) {
      return new HashMap<>();
    }
    //查询字典类型编号集合
    DataDictionaryTypeListIdsReqDTO queryDTO = new DataDictionaryTypeListIdsReqDTO();
    queryDTO.setIds(new ArrayList<>(ids));
    ObjectRestResponse<List<DataDictionaryItemRespDTO>> listObjectRestResponse = dataDictionaryItemRpcFacade
        .listDataDictionaryItemByIds(queryDTO);
    Map<Long, String> dictionaryTextMap = new HashMap<>();
    if (null != listObjectRestResponse.getData()) {
      dictionaryTextMap = listObjectRestResponse.getData().stream()
          .collect(Collectors
              .toMap(DataDictionaryItemRespDTO::getId, d -> d.getDictText(), (k1, k2) -> k2));
    }
    return dictionaryTextMap;
  }


}

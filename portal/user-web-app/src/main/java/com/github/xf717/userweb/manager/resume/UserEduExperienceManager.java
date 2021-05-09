package com.github.xf717.userweb.manager.resume;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemListQueryReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.github.xf717.systemservice.rpc.dict.facade.DataDictionaryItemRpcFacade;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.facade.UserEduExperienceRpcFacade;
import com.github.xf717.userweb.controller.resume.dto.UserEduExperienceAddDTO;
import com.github.xf717.userweb.controller.resume.dto.UserEduExperienceUpdateDTO;
import com.github.xf717.userweb.controller.resume.vo.UniversityVO;
import com.github.xf717.userweb.controller.resume.vo.UserEduExperienceVO;
import com.github.xf717.userweb.convert.resume.UserEduExperienceConvert;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserEduExperienceManager
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Service
@Validated
public class UserEduExperienceManager {

  @Autowired
  private UserEduExperienceRpcFacade userEduExperienceRpcFacade;

  @Autowired
  private DataDictionaryItemRpcFacade dataDictionaryItemRpcFacade;

  /**
   * 添加数据
   *
   * @param userEduExperienceAddDTO 添加参数
   * @return
   */
  public int save(UserEduExperienceAddDTO userEduExperienceAddDTO) {
    UserEduExperienceCreateReqDTO reqDTO = UserEduExperienceConvert.INSTANCE
        .convert(userEduExperienceAddDTO);
    reqDTO.setUserId(Long.parseLong(BaseContextHandler.getUserID()));
    BaseResponse baseResponse = userEduExperienceRpcFacade.save(reqDTO);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param userEduExperienceUpdateDTO 更新参数
   * @return
   */
  public int update(UserEduExperienceUpdateDTO userEduExperienceUpdateDTO) {
    BaseResponse baseResponse = userEduExperienceRpcFacade
        .update(UserEduExperienceConvert.INSTANCE.convert(userEduExperienceUpdateDTO));
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
    BaseResponse baseResponse = userEduExperienceRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public UserEduExperienceVO getUserEduExperienceById(Long id) {
    ObjectRestResponse<UserEduExperienceRespDTO> objectRestResponse = userEduExperienceRpcFacade
        .getUserEduExperienceById(id);
    objectRestResponse.checkError();
    return UserEduExperienceConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 个人资料获取学历信息
   *
   * @return
   */
  public UserEduExperienceVO getLastStepByUserId() {
    Long userId =Long.parseLong(BaseContextHandler.getUserID());
    ObjectRestResponse<UserEduExperienceRespDTO> objectRestResponse = userEduExperienceRpcFacade
        .getLastStepByUserId(userId);
    objectRestResponse.checkError();
    UserEduExperienceVO userEduExperienceVO = UserEduExperienceConvert.INSTANCE
        .convert(objectRestResponse.getData());
    return userEduExperienceVO;
  }

  /**
   * 模糊查询高校名称
   *
   * @param universityName
   * @return
   */
  public List<UniversityVO> queryUniversityName(String universityName) {
    DataDictionaryItemListQueryReqDTO dataDictionaryItemListQueryReqDTO = new DataDictionaryItemListQueryReqDTO();
    dataDictionaryItemListQueryReqDTO.setDictionaryTypeId(21L);
    dataDictionaryItemListQueryReqDTO.setEnabled(1);
    dataDictionaryItemListQueryReqDTO.setKey(universityName);
    ObjectRestResponse<List<DataDictionaryItemRespDTO>> listObjectRestResponse = dataDictionaryItemRpcFacade
        .listDataDictionaryItems(dataDictionaryItemListQueryReqDTO);
    List<UniversityVO> universityVO = UserEduExperienceConvert.INSTANCE
        .convertToUniversity(listObjectRestResponse.getData());
    System.out.println(universityVO);
    return universityVO;
  }

}

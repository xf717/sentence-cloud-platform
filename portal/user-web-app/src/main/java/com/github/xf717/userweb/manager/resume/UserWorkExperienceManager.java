package com.github.xf717.userweb.manager.resume;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.companyservice.rpc.company.dto.CompanyFullNameRespDTO;
import com.github.xf717.companyservice.rpc.company.facade.CompanyInfoRpcFacade;
import com.github.xf717.positionservice.rpc.positiontype.dto.PositionTypeRespDTO;
import com.github.xf717.positionservice.rpc.positiontype.facade.PositionTypeRpcFacade;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentDetailRespDTO;
import com.github.xf717.systemservice.rpc.content.facade.WorkContentRpcFacade;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.facade.UserWorkExperienceRpcFacade;
import com.github.xf717.userweb.controller.resume.dto.UserWorkExperienceAddDTO;
import com.github.xf717.userweb.controller.resume.dto.UserWorkExperienceUpdateDTO;
import com.github.xf717.userweb.controller.resume.vo.CompanyVO;
import com.github.xf717.userweb.controller.resume.vo.UserReferenceVO;
import com.github.xf717.userweb.controller.resume.vo.UserWorkExperienceVO;
import com.github.xf717.userweb.convert.resume.UserWorkExperienceConvert;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserWorkExperienceManager
 *
 * @author wst
 * @date 2021-03-29 13:08:14
 */
@Service
@Validated
public class UserWorkExperienceManager {

  @Autowired
  private UserWorkExperienceRpcFacade userWorkExperienceRpcFacade;

  @Autowired
  private CompanyInfoRpcFacade companyInfoRpcFacade;

  @Autowired
  private WorkContentRpcFacade workContentRpcFacade;

  @Autowired
  private PositionTypeRpcFacade positionTypeRpcFacade;

  /**
   * 添加数据
   *
   * @param userWorkExperienceAddDTO 添加参数
   * @return
   */
  public int save(UserWorkExperienceAddDTO userWorkExperienceAddDTO) {
    UserWorkExperienceCreateReqDTO reqDTO = UserWorkExperienceConvert.INSTANCE
        .convert(userWorkExperienceAddDTO);
    reqDTO.setUserId(Long.parseLong(BaseContextHandler.getUserID()));
    BaseResponse baseResponse = userWorkExperienceRpcFacade.save(reqDTO);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param userWorkExperienceUpdateDTO 更新参数
   * @return
   */
  public int update(UserWorkExperienceUpdateDTO userWorkExperienceUpdateDTO) {
    BaseResponse baseResponse = userWorkExperienceRpcFacade
        .update(UserWorkExperienceConvert.INSTANCE.convert(userWorkExperienceUpdateDTO));
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
    BaseResponse baseResponse = userWorkExperienceRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public UserWorkExperienceVO getUserWorkExperienceById(Long id) {
    ObjectRestResponse<UserWorkExperienceRespDTO> objectRestResponse = userWorkExperienceRpcFacade
        .getUserWorkExperienceById(id);
    objectRestResponse.checkError();
    return UserWorkExperienceConvert.INSTANCE.convert(objectRestResponse.getData());
  }

  /**
   * 填写个人资料查询数据
   *
   * @return
   */
  public UserWorkExperienceVO getLastStepByUserId() {
    Long userId = Long.parseLong(BaseContextHandler.getUserID());
    ObjectRestResponse<UserWorkExperienceRespDTO> objectRestResponse = userWorkExperienceRpcFacade
        .getLastStepByUserId(userId);
    objectRestResponse.checkError();
    UserWorkExperienceVO userWorkExperienceVO = UserWorkExperienceConvert.INSTANCE
        .convert(objectRestResponse.getData());
    userWorkExperienceVO.setWorkSkillTagList(UserWorkExperienceConvert.INSTANCE
        .convertTagList(objectRestResponse.getData().getWorkSkillTagList()));
    return userWorkExperienceVO;
  }

  /**
   * 根据公司名称模糊查询
   *
   * @param fullName 公司名称
   * @return
   */
  public List<CompanyVO> queryByCompanyName(String fullName) {
    ObjectRestResponse<List<CompanyFullNameRespDTO>> listObjectRestResponse = companyInfoRpcFacade
        .listCompanyName(fullName);
    listObjectRestResponse.checkError();
    return UserWorkExperienceConvert.INSTANCE.convertToList(listObjectRestResponse.getData());
  }

  public UserReferenceVO workExperienceReference() {
    ObjectRestResponse<WorkContentDetailRespDTO> objectRestResponse = workContentRpcFacade
        .workContentDetail();
    UserReferenceVO userReferenceVO = UserWorkExperienceConvert.INSTANCE
        .convert(objectRestResponse.getData());
    ObjectRestResponse<PositionTypeRespDTO> positionType = positionTypeRpcFacade
        .getPositionTypeById(objectRestResponse.getData().getThreePositionTypeId());
    userReferenceVO.setPositionName(positionType.getData().getTypeName());
    return userReferenceVO;
  }
}

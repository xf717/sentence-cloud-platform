package com.github.xf717.userweb.manager.user;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.exception.auth.UserInvalidException;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userservice.rpc.user.dto.UserExtendUpdateEnableHideReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyBatchInsertReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyRespDTO;
import com.github.xf717.userservice.rpc.user.facade.UserExtendRpcFacade;
import com.github.xf717.userservice.rpc.user.facade.UserHideCompanyRpcFacade;
import com.github.xf717.userweb.controller.user.dto.UserHideCompanyBatchInsertDTO;
import com.github.xf717.userweb.controller.user.vo.UserHideCompanyVO;
import com.github.xf717.userweb.convert.user.UserHideCompanyConvert;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserHideCompanyManager
 *
 * @author wst
 * @date 2021-03-29 12:47:48
 */
@Service
@Validated
public class UserHideSetManager {

  @Autowired
  private UserHideCompanyRpcFacade userHideCompanyRpcFacade;

  @Autowired
  private UserExtendRpcFacade userExtendRpcFacade;

  /**
   * 添加数据
   *
   * @param userHideCompanyBatchInsertDTO 添加参数
   * @return
   */
  public int save(UserHideCompanyBatchInsertDTO userHideCompanyBatchInsertDTO) {
    UserHideCompanyBatchInsertReqDTO reqDTO = UserHideCompanyConvert.INSTANCE
        .convert(userHideCompanyBatchInsertDTO);
    for (UserHideCompanyCreateReqDTO userHideCompanyCreateReqDTO : reqDTO.getHideCompanyList()) {
      userHideCompanyCreateReqDTO.setUserId(Long.parseLong(BaseContextHandler.getUserID()));
    }
    BaseResponse baseResponse = userHideCompanyRpcFacade.save(reqDTO);
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
    BaseResponse baseResponse = userHideCompanyRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }


  /**
   * 查找隐弊的数据
   *
   * @return
   */
  public List<UserHideCompanyVO> listUserHideCompanys() {
    ObjectRestResponse<List<UserHideCompanyRespDTO>> objectRestResponse = userHideCompanyRpcFacade
        .listUserHideCompanys(new UserHideCompanyListQueryReqDTO());
    objectRestResponse.checkError();
    return UserHideCompanyConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 更新是否隐藏简历
   *
   * @param enabledHide
   * @return
   */
  public int updateEnableHideResume(Integer enabledHide) {
    final Long userId = BaseContextHandler.getUserId();
    if (userId == null || userId.equals(0)) {
      throw new UserInvalidException("用户未登录,请登录");
    }
    UserExtendUpdateEnableHideReqDTO updateEnableHideReqDTO = new UserExtendUpdateEnableHideReqDTO()
        .setUserId(userId)
        .setEnabledHide(enabledHide);
    BaseResponse baseResponse = userExtendRpcFacade.updateEnableHideDTO(updateEnableHideReqDTO);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }


}

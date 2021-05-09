package com.db.chaomaxs.userweb.manager.user;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendUpdateEnableHideReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserSetRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserExtendRpcFacade;
import com.db.chaomaxs.userservice.rpc.user.facade.UserSetRpcFacade;
import com.db.chaomaxs.userweb.controller.user.dto.UserExtendUpdateEnableHideDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserSetAddDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserSetUpdateDTO;
import com.db.chaomaxs.userweb.controller.user.vo.UserSetVO;
import com.db.chaomaxs.userweb.convert.user.UserHideCompanyConvert;
import com.db.chaomaxs.userweb.convert.user.UserSetConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserSetManager
 *
 * @author wst
 * @date 2021-03-29 12:47:47
 */
@Service
@Validated
public class UserSetManager {

  @Autowired
  private UserSetRpcFacade userSetRpcFacade;

  @Autowired
  private UserExtendRpcFacade userExtendRpcFacade;

  /**
   * 添加数据
   *
   * @param userSetAddDTO 添加参数
   * @return
   */
  public int save(UserSetAddDTO userSetAddDTO) {
    BaseResponse baseResponse = userSetRpcFacade
        .save(UserSetConvert.INSTANCE.convert(userSetAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param userSetUpdateDTO 更新参数
   * @return
   */
  public int update(UserSetUpdateDTO userSetUpdateDTO) {
    BaseResponse baseResponse = userSetRpcFacade
        .update(UserSetConvert.INSTANCE.convert(userSetUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }


  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public UserSetVO getUserSetById(Long id) {
    ObjectRestResponse<UserSetRespDTO> objectRestResponse = userSetRpcFacade.getUserSetById(id);
    objectRestResponse.checkError();
    return UserSetConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 更新是否隐藏简历
   *
   * @param updateEnableHideDTO
   * @return
   */
  public int updateEnableHide(UserExtendUpdateEnableHideDTO updateEnableHideDTO) {
    UserExtendUpdateEnableHideReqDTO reqDTO = UserHideCompanyConvert.INSTANCE
        .convert(updateEnableHideDTO);
    reqDTO.setUserId(Long.parseLong(BaseContextHandler.getUserID()));
    BaseResponse baseResponse = userExtendRpcFacade.updateEnableHideDTO(reqDTO);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

}

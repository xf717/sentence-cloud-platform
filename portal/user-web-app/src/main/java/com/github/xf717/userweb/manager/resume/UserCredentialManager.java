package com.github.xf717.userweb.manager.resume;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userweb.controller.resume.dto.UserCredentialAddDTO;
import com.github.xf717.userweb.controller.resume.dto.UserCredentialUpdateDTO;
import com.github.xf717.userweb.controller.resume.vo.UserCredentialVO;
import com.github.xf717.userweb.convert.resume.UserCredentialConvert;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialRespDTO;
import com.github.xf717.userservice.rpc.resume.facade.UserCredentialRpcFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserCredentialManager
 *
 * @author wst
 * @date 2021-03-29 13:08:14
 */
@Service
@Validated
public class UserCredentialManager {

  @Autowired
  private UserCredentialRpcFacade userCredentialRpcFacade;

  /**
   * 添加数据
   * @param userCredentialAddDTO 添加参数
   * @return
   */
  public int save(UserCredentialAddDTO userCredentialAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = userCredentialRpcFacade
        .save(UserCredentialConvert.INSTANCE.convert(userCredentialAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   * @param userCredentialUpdateDTO  更新参数
   * @return
   */
  public int update(UserCredentialUpdateDTO userCredentialUpdateDTO) {
    BaseResponse baseResponse = userCredentialRpcFacade
        .update(UserCredentialConvert.INSTANCE.convert(userCredentialUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   * @param id  id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = userCredentialRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   * @param id id
   * @return
   */
  public UserCredentialVO getUserCredentialById(Long id) {
    ObjectRestResponse<UserCredentialRespDTO> objectRestResponse = userCredentialRpcFacade.getUserCredentialById(
        id);
    objectRestResponse.checkError();
    return UserCredentialConvert.INSTANCE.convert(objectRestResponse.getData());
  }

}

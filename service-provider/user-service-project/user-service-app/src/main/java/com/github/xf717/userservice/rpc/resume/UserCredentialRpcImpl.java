package com.github.xf717.userservice.rpc.resume;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.manager.resume.UserCredentialManager;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialPageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.facade.UserCredentialRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Slf4j
@Service
public class UserCredentialRpcImpl implements UserCredentialRpcFacade {

  @Autowired
  private UserCredentialManager userCredentialManager;

  @Override
  public BaseResponse save(UserCredentialCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userCredentialManager.saveUserCredential(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserCredentialUpdateReqDTO updateReqDTO) {
    userCredentialManager.updateUserCredential(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      userCredentialManager.deleteUserCredential(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserCredentialRespDTO> getUserCredentialById(Long id) {
      UserCredentialRespDTO userCredential = userCredentialManager.getUserCredentialById(id);
    return new ObjectRestResponse<>().data(userCredential);
  }

  @Override
  public ObjectRestResponse<List<UserCredentialRespDTO>> listUserCredentials(UserCredentialListQueryReqDTO listQuery) {
    List<UserCredentialRespDTO> list = userCredentialManager.listUserCredentials(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserCredentialRespDTO> page(UserCredentialPageReqDTO pageReqDTO) {
    PageResult<UserCredentialRespDTO> pageResult = userCredentialManager.pageUserCredential(pageReqDTO);
    TableResultResponse<UserCredentialRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}

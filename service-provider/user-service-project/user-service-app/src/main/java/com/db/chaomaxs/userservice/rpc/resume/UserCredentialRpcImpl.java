package com.db.chaomaxs.userservice.rpc.resume;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.manager.resume.UserCredentialManager;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialPageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.facade.UserCredentialRpcFacade;
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

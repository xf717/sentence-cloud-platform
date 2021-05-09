package com.github.xf717.userservice.rpc.user;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.manager.user.UserBindingCompanyManager;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingExtendRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingInfoRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingStateUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingTransferReqDTO;
import com.github.xf717.userservice.rpc.user.facade.UserBindingCompanyRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Slf4j
@Service
public class UserBindingCompanyRpcImpl implements UserBindingCompanyRpcFacade {

  @Autowired
  private UserBindingCompanyManager userBindingCompanyManager;

  @Override
  public BaseResponse save(UserBindingCompanyCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userBindingCompanyManager.saveUserBindingCompany(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserBindingCompanyUpdateReqDTO updateReqDTO) {
    userBindingCompanyManager.updateUserBindingCompany(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    userBindingCompanyManager.deleteUserBindingCompany(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserBindingCompanyRespDTO> getUserBindingCompanyById(Long id) {
    UserBindingCompanyRespDTO userBindingCompany = userBindingCompanyManager
        .getUserBindingCompanyById(id);
    return new ObjectRestResponse<>().data(userBindingCompany);
  }

  @Override
  public ObjectRestResponse<List<UserBindingCompanyRespDTO>> listUserBindingCompanys(
      UserBindingCompanyListQueryReqDTO listQuery) {
    List<UserBindingCompanyRespDTO> list = userBindingCompanyManager
        .listUserBindingCompanys(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserBindingInfoRespDTO> page(
      UserBindingCompanyPageReqDTO pageReqDTO) {
    PageResult<UserBindingInfoRespDTO> pageResult = userBindingCompanyManager
        .pageUserBindingCompany(pageReqDTO);
    TableResultResponse<UserBindingInfoRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

  @Override
  public BaseResponse updateBindingState(UserBindingStateUpdateReqDTO bindingStateUpdateReqDTO) {
    return userBindingCompanyManager.updateBindingState(bindingStateUpdateReqDTO);
  }

  @Override
  public ObjectRestResponse<List<UserBindingExtendRespDTO>> getAllBindingUser(Long companyId) {
    return ObjectRestResponse.success(userBindingCompanyManager.getAllBindingUser(companyId));
  }

  @Override
  public BaseResponse managerTransfer(UserBindingTransferReqDTO userBindingTransferReqDTO) {
    userBindingCompanyManager.managerTransfer(userBindingTransferReqDTO);
    return BaseResponse.success("转移成功");
  }

  @Override
  public BaseResponse handover(UserBindingTransferReqDTO userBindingTransferReqDTO) {
    userBindingCompanyManager.handover(userBindingTransferReqDTO);
    return BaseResponse.success("交接成功");
  }

}

package com.github.xf717.userservice.rpc.user;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.manager.user.UserHideCompanyManager;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyBatchInsertReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyRespDTO;
import com.github.xf717.userservice.rpc.user.facade.UserHideCompanyRpcFacade;
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
public class UserHideCompanyRpcImpl implements UserHideCompanyRpcFacade {

  @Autowired
  private UserHideCompanyManager userHideCompanyManager;

  @Override
  public BaseResponse save(UserHideCompanyBatchInsertReqDTO batchInsertReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userHideCompanyManager.saveUserHideCompany(batchInsertReqDTO);
    return BaseResponse.success("保存成功");
  }


  @Override
  public BaseResponse remove(Long id) {
      userHideCompanyManager.deleteUserHideCompany(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserHideCompanyRespDTO> getUserHideCompanyById(Long id) {
      UserHideCompanyRespDTO userHideCompany = userHideCompanyManager.getUserHideCompanyById(id);
    return new ObjectRestResponse<>().data(userHideCompany);
  }

  @Override
  public ObjectRestResponse<List<UserHideCompanyRespDTO>> listUserHideCompanys(UserHideCompanyListQueryReqDTO listQuery) {
    List<UserHideCompanyRespDTO> list = userHideCompanyManager.listUserHideCompanys(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserHideCompanyRespDTO> page(UserHideCompanyPageReqDTO pageReqDTO) {
    PageResult<UserHideCompanyRespDTO> pageResult = userHideCompanyManager.pageUserHideCompany(pageReqDTO);
    TableResultResponse<UserHideCompanyRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}

package com.db.chaomaxs.logservice.rpc.sms;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.logservice.manager.sms.UserSmsCodeManager;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeCreateReqDTO;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeListQueryReqDTO;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodePageReqDTO;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeRespDTO;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeUpdateReqDTO;
import com.db.chaomaxs.logservice.rpc.sms.facade.UserSmsCodeRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:02
 */
@Slf4j
@Service
public class UserSmsCodeRpcImpl implements UserSmsCodeRpcFacade {

  @Autowired
  private UserSmsCodeManager userSmsCodeManager;

  @Override
  public BaseResponse save(UserSmsCodeCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userSmsCodeManager.saveUserSmsCode(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserSmsCodeUpdateReqDTO updateReqDTO) {
    userSmsCodeManager.updateUserSmsCode(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    userSmsCodeManager.deleteUserSmsCode(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserSmsCodeRespDTO> getUserSmsCodeById(Long id) {
    UserSmsCodeRespDTO userSmsCode = userSmsCodeManager.getUserSmsCodeById(id);
    return new ObjectRestResponse<>().data(userSmsCode);
  }

  @Override
  public ObjectRestResponse<List<UserSmsCodeRespDTO>> listUserSmsCodes(
      UserSmsCodeListQueryReqDTO listQuery) {
    List<UserSmsCodeRespDTO> list = userSmsCodeManager.listUserSmsCodes(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserSmsCodeRespDTO> page(UserSmsCodePageReqDTO pageReqDTO) {
    PageResult<UserSmsCodeRespDTO> pageResult = userSmsCodeManager.pageUserSmsCode(pageReqDTO);
    TableResultResponse<UserSmsCodeRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

  @Override
  public ObjectRestResponse<UserSmsCodeRespDTO> getLastCodeByMobile(String mobile, Integer scene) {
    return new ObjectRestResponse<>().data(userSmsCodeManager.getLastCodeByMobile(mobile, scene));
  }

}

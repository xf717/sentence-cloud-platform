package com.db.chaomaxs.userservice.rpc.user;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.manager.user.UserInfoManager;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPersonalInfoRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserInfoRpcFacade;
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
public class UserInfoRpcImpl implements UserInfoRpcFacade {

  @Autowired
  private UserInfoManager userInfoManager;

  @Override
  public BaseResponse save(UserInfoCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userInfoManager.saveUserInfo(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public ObjectRestResponse<UserInfoRespDTO> createUserIfAbsent(UserInfoCreateReqDTO createReqDTO) {
    return ObjectRestResponse.success(userInfoManager.createUserIfAbsent(createReqDTO));
  }

  @Override
  public BaseResponse update(UserInfoUpdateReqDTO updateReqDTO) {
    userInfoManager.updateUserInfo(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    userInfoManager.deleteUserInfo(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<List<UserInfoRespDTO>> listUserInfos(
      UserInfoListQueryReqDTO listQuery) {
    List<UserInfoRespDTO> list = userInfoManager.listUserInfos(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserInfoRespDTO> page(UserInfoPageReqDTO pageReqDTO) {
    PageResult<UserInfoRespDTO> pageResult = userInfoManager.pageUserInfo(pageReqDTO);
    TableResultResponse<UserInfoRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

  @Override
  public ObjectRestResponse<UserInfoRespDTO> verifyPassword(String username, String password) {
    return ObjectRestResponse.success(userInfoManager.verifyPassword(username, password));
  }

  @Override
  public ObjectRestResponse<Boolean> setPassword(String username, String password) {
    return ObjectRestResponse.success(userInfoManager.setPassword(username, password));
  }


  @Override
  public ObjectRestResponse<Boolean> updateMobile(String username, String mobile) {
    return ObjectRestResponse.success(userInfoManager.updateMobile(username, mobile));
  }

  @Override
  public ObjectRestResponse<Boolean> updatePassword(String username, String oldPassword,
      String password) {
    return ObjectRestResponse
        .success(userInfoManager.updatePassword(username, oldPassword, password));
  }

  @Override
  public ObjectRestResponse<UserPersonalInfoRespDTO> getUserInfoById(Long userId) {
    UserPersonalInfoRespDTO userPersonalInfoRespDTO = userInfoManager.getUserInfoById(userId);
    return new ObjectRestResponse<>().data(userPersonalInfoRespDTO);
  }

}

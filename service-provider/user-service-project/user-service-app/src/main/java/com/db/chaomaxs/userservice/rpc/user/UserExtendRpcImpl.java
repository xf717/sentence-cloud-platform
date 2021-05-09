package com.db.chaomaxs.userservice.rpc.user;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.manager.user.UserExtendManager;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendDetailRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendDetailReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendUpdateEnableHideReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserExtendRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Slf4j
@Service
public class UserExtendRpcImpl implements UserExtendRpcFacade {

  @Autowired
  private UserExtendManager userExtendManager;

  @Override
  public BaseResponse save(UserExtendCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userExtendManager.saveUserExtend(createReqDTO);
    return BaseResponse.success("保存成功");
  }


  @Override
  public BaseResponse remove(Long id) {
    userExtendManager.deleteUserExtend(id);
    return BaseResponse.success("删除成功");
  }


  @Override
  public ObjectRestResponse<UserExtendRespDTO> getUserExtendByUserId(Long userId) {
    UserExtendRespDTO userExtendRespDTO = userExtendManager.getUserExtendByUserId(userId);
    return new ObjectRestResponse<>().data(userExtendRespDTO);
  }


  @Override
  public ObjectRestResponse<List<UserExtendRespDTO>> listUserExtends(
      UserExtendListQueryReqDTO listQuery) {
    List<UserExtendRespDTO> list = userExtendManager.listUserExtends(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserExtendRespDTO> page(UserExtendPageReqDTO pageReqDTO) {
    PageResult<UserExtendRespDTO> pageResult = userExtendManager.pageUserExtend(pageReqDTO);
    TableResultResponse<UserExtendRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

  @Override
  public ObjectRestResponse<List<UserExtendDetailRespDTO>> listUserExtendByUserIds(
      @RequestBody UserExtendDetailReqDTO userExtendDetailReqDTO) {
    List<UserExtendDetailRespDTO> list = userExtendManager
        .listUserExtendByUserIds(userExtendDetailReqDTO);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public BaseResponse updateEnableHideDTO(UserExtendUpdateEnableHideReqDTO updateEnableHideReqDTO) {
    userExtendManager.updateEnableHideDTO(updateEnableHideReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse updateUserRecruitInfo(UserRecruitUpdateReqDTO userRecruitUpdateReqDTO) {
    userExtendManager.updateUserRecruitInfo(userRecruitUpdateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public ObjectRestResponse<UserExtendDetailRespDTO> getUserExtendInfo(Long userId) {
    UserExtendDetailRespDTO userExtendInfo = userExtendManager.getUserExtendInfo(userId);
    return new ObjectRestResponse<>().data(userExtendInfo);
  }
}

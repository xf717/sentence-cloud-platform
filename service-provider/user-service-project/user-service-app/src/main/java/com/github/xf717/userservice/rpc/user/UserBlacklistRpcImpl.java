package com.github.xf717.userservice.rpc.user;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.manager.user.UserBlacklistManager;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.facade.UserBlacklistRpcFacade;
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
public class UserBlacklistRpcImpl implements UserBlacklistRpcFacade {

  @Autowired
  private UserBlacklistManager userBlacklistManager;

  @Override
  public BaseResponse save(UserBlacklistCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userBlacklistManager.saveUserBlacklist(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserBlacklistUpdateReqDTO updateReqDTO) {
    userBlacklistManager.updateUserBlacklist(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      userBlacklistManager.deleteUserBlacklist(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserBlacklistRespDTO> getUserBlacklistById(Long id) {
      UserBlacklistRespDTO userBlacklist = userBlacklistManager.getUserBlacklistById(id);
    return new ObjectRestResponse<>().data(userBlacklist);
  }

  @Override
  public ObjectRestResponse<List<UserBlacklistRespDTO>> listUserBlacklists(UserBlacklistListQueryReqDTO listQuery) {
    List<UserBlacklistRespDTO> list = userBlacklistManager.listUserBlacklists(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserBlacklistRespDTO> page(UserBlacklistPageReqDTO pageReqDTO) {
    PageResult<UserBlacklistRespDTO> pageResult = userBlacklistManager.pageUserBlacklist(pageReqDTO);
    TableResultResponse<UserBlacklistRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}

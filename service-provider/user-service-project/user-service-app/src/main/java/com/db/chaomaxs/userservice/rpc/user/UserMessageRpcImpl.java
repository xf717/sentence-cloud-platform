package com.db.chaomaxs.userservice.rpc.user;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.manager.user.UserMessageManager;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessagePageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserMessageRpcFacade;
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
public class UserMessageRpcImpl implements UserMessageRpcFacade {

  @Autowired
  private UserMessageManager userMessageManager;

  @Override
  public BaseResponse save(UserMessageCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userMessageManager.saveUserMessage(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserMessageUpdateReqDTO updateReqDTO) {
    userMessageManager.updateUserMessage(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      userMessageManager.deleteUserMessage(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserMessageRespDTO> getUserMessageById(Long id) {
      UserMessageRespDTO userMessage = userMessageManager.getUserMessageById(id);
    return new ObjectRestResponse<>().data(userMessage);
  }

  @Override
  public ObjectRestResponse<List<UserMessageRespDTO>> listUserMessages(UserMessageListQueryReqDTO listQuery) {
    List<UserMessageRespDTO> list = userMessageManager.listUserMessages(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserMessageRespDTO> page(UserMessagePageReqDTO pageReqDTO) {
    PageResult<UserMessageRespDTO> pageResult = userMessageManager.pageUserMessage(pageReqDTO);
    TableResultResponse<UserMessageRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}

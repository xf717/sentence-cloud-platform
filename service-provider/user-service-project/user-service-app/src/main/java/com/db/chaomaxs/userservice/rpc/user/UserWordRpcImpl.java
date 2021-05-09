package com.db.chaomaxs.userservice.rpc.user;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.manager.user.UserWordManager;
import com.db.chaomaxs.userservice.rpc.user.dto.UserWordCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserWordPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserWordRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserWordUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserWordRpcFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Slf4j
@Service
public class UserWordRpcImpl implements UserWordRpcFacade {

  @Autowired
  private UserWordManager userWordManager;

  @Override
  public BaseResponse save(UserWordCreateReqDTO createReqDTO) {
    userWordManager.saveUserWord(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserWordUpdateReqDTO updateReqDTO) {
    userWordManager.updateUserWord(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    userWordManager.deleteUserWord(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserWordRespDTO> getUserWordById(Long id) {
    UserWordRespDTO userWord = userWordManager.getUserWordById(id);
    return new ObjectRestResponse<>().data(userWord);
  }

  @Override
  public TableResultResponse<UserWordRespDTO> page(UserWordPageReqDTO pageReqDTO) {
    PageResult<UserWordRespDTO> pageResult = userWordManager.pageUserWord(pageReqDTO);
    TableResultResponse<UserWordRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

  @Override
  public BaseResponse userWordTopByUserId(Long id, Long userId) {
    userWordManager.userWordTopByUserId(id, userId);
    return BaseResponse.success("删除成功");
  }

}

package com.db.chaomaxs.userservice.rpc.user;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.manager.user.UserThirdManager;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserThirdRpcFacade;
import java.util.List;
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
public class UserThirdRpcImpl implements UserThirdRpcFacade {

  @Autowired
  private UserThirdManager userThirdManager;

  @Override
  public BaseResponse save(UserThirdCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userThirdManager.saveUserThird(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public ObjectRestResponse<UserThirdRespDTO> createUserThirdIfAbsent(
      UserThirdCreateReqDTO createReqDTO) {
    return ObjectRestResponse.success(userThirdManager.createUserThirdIfAbsent(createReqDTO));
  }

  @Override
  public BaseResponse update(UserThirdUpdateReqDTO updateReqDTO) {
    userThirdManager.updateUserThird(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    userThirdManager.deleteUserThird(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserThirdRespDTO> getUserThirdById(Long id) {
    UserThirdRespDTO userThird = userThirdManager.getUserThirdById(id);
    return new ObjectRestResponse<>().data(userThird);
  }

  @Override
  public ObjectRestResponse<List<UserThirdRespDTO>> listUserThirds(
      UserThirdListQueryReqDTO listQuery) {
    List<UserThirdRespDTO> list = userThirdManager.listUserThirds(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserThirdRespDTO> page(UserThirdPageReqDTO pageReqDTO) {
    PageResult<UserThirdRespDTO> pageResult = userThirdManager.pageUserThird(pageReqDTO);
    TableResultResponse<UserThirdRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

}

package com.github.xf717.userservice.rpc.user;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.manager.user.UserRecruitExtendManager;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitExtendCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitExtendListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitExtendPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitExtendRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitExtendUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.facade.UserRecruitExtendRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 12:54:37
 */
@Slf4j
@Service
public class UserRecruitExtendRpcImpl implements UserRecruitExtendRpcFacade {

  @Autowired
  private UserRecruitExtendManager userRecruitExtendManager;

  @Override
  public BaseResponse save(UserRecruitExtendCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userRecruitExtendManager.saveUserRecruitExtend(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserRecruitExtendUpdateReqDTO updateReqDTO) {
    userRecruitExtendManager.updateUserRecruitExtend(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      userRecruitExtendManager.deleteUserRecruitExtend(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserRecruitExtendRespDTO> getUserRecruitExtendById(Long id) {
      UserRecruitExtendRespDTO userRecruitExtend = userRecruitExtendManager.getUserRecruitExtendById(id);
    return new ObjectRestResponse<>().data(userRecruitExtend);
  }

  @Override
  public ObjectRestResponse<List<UserRecruitExtendRespDTO>> listUserRecruitExtends(UserRecruitExtendListQueryReqDTO listQuery) {
    List<UserRecruitExtendRespDTO> list = userRecruitExtendManager.listUserRecruitExtends(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserRecruitExtendRespDTO> page(UserRecruitExtendPageReqDTO pageReqDTO) {
    PageResult<UserRecruitExtendRespDTO> pageResult = userRecruitExtendManager.pageUserRecruitExtend(pageReqDTO);
    TableResultResponse<UserRecruitExtendRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}

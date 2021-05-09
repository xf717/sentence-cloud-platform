package com.db.chaomaxs.userservice.rpc.resume;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.userservice.manager.resume.UserResumeManager;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserIdsReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserResumeDetailRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserResumeCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserResumeRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserResumeUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.facade.UserResumeRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Slf4j
@Service
public class UserResumeRpcImpl implements UserResumeRpcFacade {

  @Autowired
  private UserResumeManager userResumeManager;

  @Override
  public BaseResponse save(UserResumeCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userResumeManager.saveUserResume(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserResumeUpdateReqDTO updateReqDTO) {
    userResumeManager.updateUserResume(updateReqDTO);
    return BaseResponse.success("更新成功");
  }


  @Override
  public ObjectRestResponse<UserResumeRespDTO> getUserResumeById(Long userId) {
    UserResumeRespDTO userResume = userResumeManager.getUserResumeById(userId);
    return new ObjectRestResponse<>().data(userResume);
  }

  @Override
  public ObjectRestResponse<List<UserResumeDetailRespDTO>> getResumeDetailByUserIds(
      UserIdsReqDTO userIdsReqDTO) {
    List<UserResumeDetailRespDTO> userDeliveryResumeRespDTOList = userResumeManager
        .getResumeDetailByUserIds(userIdsReqDTO);
    return new ObjectRestResponse<>().data(userDeliveryResumeRespDTOList);
  }

}

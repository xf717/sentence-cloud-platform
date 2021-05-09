package com.github.xf717.userservice.rpc.user;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userservice.manager.user.UserSetManager;
import com.github.xf717.userservice.rpc.user.dto.UserSetCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserSetRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserSetUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.facade.UserSetRpcFacade;
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
public class UserSetRpcImpl implements UserSetRpcFacade {

    @Autowired
    private UserSetManager userSetManager;

  @Override
  public BaseResponse save(UserSetCreateReqDTO createReqDTO) {
    userSetManager.saveUserSet(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserSetUpdateReqDTO updateReqDTO) {
    userSetManager.updateUserSet(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

    @Override
    public ObjectRestResponse<UserSetRespDTO> getUserSetById(Long id) {
        UserSetRespDTO userSet = userSetManager.getUserSetById(id);
        return new ObjectRestResponse<>().data(userSet);
    }

    @Override
    public ObjectRestResponse<UserSetRespDTO> getUserSetByUserIdAndCompanyUserId(Long userId, Long companyUserId) {
        UserSetRespDTO userSet = userSetManager.getUserSetByUserIdAndCompanyUserId(userId,companyUserId);
        return new ObjectRestResponse<>().data(userSet);
    }
}

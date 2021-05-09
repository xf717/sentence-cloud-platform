package com.github.xf717.userservice.rpc.user.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.UserChatRpcImpl;
import com.github.xf717.userservice.rpc.user.facade.api.UserChatApi;
import com.github.xf717.userservice.rpc.user.dto.UserChatCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserChatRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserChatPageReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_沟通
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@RestController
public class UserChatRpcController implements UserChatApi {

    @Autowired
    private UserChatRpcImpl userChatRpc;

    @Override
    public BaseResponse save(@RequestBody UserChatCreateReqDTO createReqDTO) {
        return userChatRpc.save(createReqDTO);
    }

    @Override
    public TableResultResponse<UserChatRespDTO> page(@RequestBody UserChatPageReqDTO pageReqDTO) {
        return userChatRpc.page(pageReqDTO);
    }
}

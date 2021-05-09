package com.github.xf717.userservice.rpc.user;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.manager.user.UserChatManager;
import com.github.xf717.userservice.rpc.user.dto.UserChatCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserChatPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserChatRespDTO;
import com.github.xf717.userservice.rpc.user.facade.UserChatRpcFacade;
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
public class UserChatRpcImpl implements UserChatRpcFacade {

    @Autowired
    private UserChatManager userChatManager;

    @Override
    public BaseResponse save(UserChatCreateReqDTO createReqDTO) {
        userChatManager.saveUserChat(createReqDTO);
        return BaseResponse.success("保存成功");
    }


    @Override
    public TableResultResponse<UserChatRespDTO> page(UserChatPageReqDTO pageReqDTO) {
        PageResult<UserChatRespDTO> pageResult = userChatManager.pageUserChat(pageReqDTO);
        TableResultResponse<UserChatRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(), pageResult.getList());
        return tableResultResponse;
    }

}

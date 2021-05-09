package com.github.xf717.userweb.manager.user;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.userservice.rpc.user.dto.UserChatCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserChatPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserChatRespDTO;
import com.github.xf717.userweb.controller.user.dto.UserChatAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserChatPageDTO;
import com.github.xf717.userweb.controller.user.vo.UserChatVO;
import com.github.xf717.userweb.convert.user.UserChatConvert;
import com.github.xf717.userservice.rpc.user.facade.UserChatRpcFacade;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserChatManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Service
@Validated
public class UserChatManager {

    @Autowired
    private UserChatRpcFacade userChatRpcFacade;

    /**
     * 添加数据
     *
     * @param userChatAddDTO 添加参数
     * @return
     */
    public int save(UserChatAddDTO userChatAddDTO) {
        UserChatCreateReqDTO userChatCreateReqDTO = UserChatConvert.INSTANCE.convert(userChatAddDTO);
        userChatCreateReqDTO.setUserId(BaseContextHandler.getUserId());
        BaseResponse baseResponse = userChatRpcFacade.save(userChatCreateReqDTO);
        baseResponse.checkError();
        return baseResponse.isSuccess() ? 1 : 0;
    }


    /**
     * 查找数据显示分页
     *
     * @param pageDTO 分页参数
     * @return
     */
    public TableResultResponse<UserChatVO> pageUserChat(UserChatPageDTO pageDTO) {
        UserChatPageReqDTO userChatPageReqDTO = UserChatConvert.INSTANCE.convert(pageDTO);
        userChatPageReqDTO.setUserId(BaseContextHandler.getUserId());
        TableResultResponse<UserChatRespDTO> tableResultResponse = userChatRpcFacade.page(userChatPageReqDTO);
        tableResultResponse.checkError();
        return UserChatConvert.INSTANCE.convert(tableResultResponse);
    }


}

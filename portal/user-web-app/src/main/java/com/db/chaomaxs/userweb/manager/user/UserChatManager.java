package com.db.chaomaxs.userweb.manager.user;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.userservice.rpc.user.dto.UserChatCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserChatPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserChatRespDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserChatAddDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserChatPageDTO;
import com.db.chaomaxs.userweb.controller.user.vo.UserChatVO;
import com.db.chaomaxs.userweb.convert.user.UserChatConvert;
import com.db.chaomaxs.userservice.rpc.user.facade.UserChatRpcFacade;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
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

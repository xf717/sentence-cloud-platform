package com.github.xf717.userservice.manager.user;

import com.github.xf717.userservice.rpc.user.dto.UserChatCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserChatPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserChatRespDTO;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.service.user.UserChatService;
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
    private UserChatService userChatService;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveUserChat(UserChatCreateReqDTO createReqDTO) {
        return userChatService.saveUserChat(createReqDTO);
    }

    /**
     * 分类
     *
     * @param page
     * @return
     */
    public PageResult<UserChatRespDTO> pageUserChat(UserChatPageReqDTO page) {
        return userChatService.pageUserChat(page);
    }


}

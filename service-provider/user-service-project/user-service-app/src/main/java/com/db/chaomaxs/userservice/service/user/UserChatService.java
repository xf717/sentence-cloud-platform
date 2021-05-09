package com.db.chaomaxs.userservice.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.user.UserChatConvert;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserChatDO;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserChatMapper;
import com.db.chaomaxs.userservice.rpc.user.dto.UserChatCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserChatPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserChatRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserChatService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserChatService {

    @Autowired
    private UserChatMapper userChatMapper;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveUserChat(UserChatCreateReqDTO createReqDTO) {
        UserChatDO userChatDO = UserChatConvert.INSTANCE.convert(createReqDTO);
        UserChatDO getUserChatDO = userChatMapper.getByUserIdAndCompanyUserId(userChatDO);
        if (getUserChatDO != null) {
            return 1;
        }
        return userChatMapper.insert(userChatDO);
    }


    /**
     * 分类
     *
     * @param page
     * @return
     */
    public PageResult<UserChatRespDTO> pageUserChat(UserChatPageReqDTO page) {
        IPage<UserChatDO> userChatPage = userChatMapper.selectPage(page);
        return UserChatConvert.INSTANCE.convertPage(userChatPage);
    }


}

package com.db.chaomaxs.companyweb.service.user;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserExtendRpcFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author momo
 * @date 2021-04-27 14:24
 */
@Service
public class UserService {
    @Autowired
    private UserExtendRpcFacade userExtendRpcFacade;

    public UserExtendRespDTO getById(Long id) {
        ObjectRestResponse<UserExtendRespDTO> response = userExtendRpcFacade.getUserExtendByUserId(id);
        return response.getData();
    }
}

package com.db.chaomaxs.userservice.rpc.user.rest;

import com.db.chaomaxs.userservice.rpc.user.dto.UserChatCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserChatPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserChatUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserChatRpcFacade;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author momo
 * @date 2021-04-07 15:55
 */
@Ignore
public class UserChatRpcControllerTest extends MySpringBootTest {

    @Autowired
    private UserChatRpcFacade userChatRpcFacade;
    @Test
    public void testSave() {
        UserChatCreateReqDTO dto=new UserChatCreateReqDTO();
        dto.setUserId(1L);
        dto.setCompanyUserId(3L);
        dto.setPositionId(3L);
        userChatRpcFacade.save(dto);
    }
    @Test
    public void testRemove() {
        UserChatUpdateReqDTO dto=new UserChatUpdateReqDTO();
        dto.setUserId(1L);
        dto.setCompanyUserId(2L);
//        userChatRpcFacade.remove(dto);
    }

    @Test
    public void testPage() {
        UserChatPageReqDTO dto=new UserChatPageReqDTO();
        dto.setUserId(1L);
        dto.setPageNo(1);
        dto.setPageSize(10);
        userChatRpcFacade.page(dto);
    }
}

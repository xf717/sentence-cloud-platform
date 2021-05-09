package com.github.xf717.userservice.rpc.user.rest;
import com.github.xf717.userservice.rpc.user.dto.UserSetCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserSetUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.facade.UserSetRpcFacade;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author momo
 * @date 2021-03-31 11:55
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class UserSetRpcControllerTest extends TestCase {
    @Autowired
    private UserSetRpcFacade userSetRpcFacade;
    @Test
    public void testSave() {
        UserSetCreateReqDTO userSetCreateReqDTO=new UserSetCreateReqDTO();
        userSetCreateReqDTO.setUserId(1L);
        userSetCreateReqDTO.setCompanyUserId(2L);
        userSetCreateReqDTO.setBlackCompanyUserSwitch(0);
        userSetCreateReqDTO.setBlackSwitch(1);
        userSetCreateReqDTO.setTopSwitch(1);
        userSetCreateReqDTO.setUserId(1L);
        userSetRpcFacade.save(userSetCreateReqDTO);
    }

    @Test
    public void testUpdate() {
        UserSetUpdateReqDTO userSetUpdateReqDTO=new UserSetUpdateReqDTO();
        userSetUpdateReqDTO.setId(1L);
        userSetUpdateReqDTO.setBlackCompanyUserSwitch(0);
        userSetUpdateReqDTO.setBlackSwitch(0);
        userSetUpdateReqDTO.setTopSwitch(0);
        userSetUpdateReqDTO.setUserId(1L);
        userSetRpcFacade.update(userSetUpdateReqDTO);
    }
    @Test
    public void testGetUserSetById() {
        userSetRpcFacade.getUserSetByUserIdAndCompanyUserId(1L,2L);
    }
}

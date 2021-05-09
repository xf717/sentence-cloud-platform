package com.db.chaomaxs.userservice.rpc.user.rest;


import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserDeliveryRpcFacade;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author momo
 * @date 2021-04-08 15:12
 */
@Ignore
public class UserDeliveryRpcControllerTest extends MySpringBootTest {

    @Autowired
    private UserDeliveryRpcFacade userDeliveryRpcFacade;

    @Test
    public void testSave() {
        UserDeliveryCreateReqDTO reqDTO = new UserDeliveryCreateReqDTO();
        reqDTO.setCompanyId(2L);
        reqDTO.setCompanyUserId(3L);
        reqDTO.setUserId(2L);
        reqDTO.setPositionId(1L);
        userDeliveryRpcFacade.save(reqDTO);
    }

    @Test
    public void testPage() {
        UserDeliveryPageReqDTO reqDTO=new UserDeliveryPageReqDTO();
        reqDTO.setUserId(1L);
        reqDTO.setPageNo(1);
        reqDTO.setPageSize(10);
        userDeliveryRpcFacade.page(reqDTO);
    }
}
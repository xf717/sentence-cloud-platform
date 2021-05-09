package com.github.xf717.userservice.rpc.user.rest;

import com.github.xf717.userservice.rpc.user.dto.UserStatisticReqDTO;
import com.github.xf717.userservice.rpc.user.facade.UserStatisticRpcFacade;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author momo
 * @date 2021-04-13 19:08
 */
@Ignore
public class UserStatisticRpcControllerTest extends MySpringBootTest {

    @Autowired
    private UserStatisticRpcFacade userStatisticRpcFacade;

    @Test
    public void testGetStatistic() {
        UserStatisticReqDTO userStatisticReqDTO = new UserStatisticReqDTO();
        userStatisticReqDTO.setUserId(1L);
        userStatisticRpcFacade.getStatistic(userStatisticReqDTO);
    }
}

package com.db.chaomaxs.userservice.rpc.user.rest;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserTrackRpcFacade;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author momo
 * @date 2021-03-31 19:20
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class UserTrackRpcControllerTest extends TestCase {
    @Autowired
    private UserTrackRpcFacade userTrackRpcFacade;

    @Test
    public void testSave() {
        UserTrackCreateReqDTO userTrackCreateReqDTO=new UserTrackCreateReqDTO();
        userTrackCreateReqDTO.setUserId(1L);
        userTrackCreateReqDTO.setCompanyUserId(3L);
        userTrackCreateReqDTO.setPositionId(2L);
        userTrackRpcFacade.save(userTrackCreateReqDTO);
    }


    @Test
    public void testPage() {
        UserTrackPageReqDTO userTrackPageReqDTO=new UserTrackPageReqDTO();
        userTrackPageReqDTO.setUserId(1L);
        userTrackPageReqDTO.setPageNo(0);
        userTrackPageReqDTO.setPageSize(10);
        userTrackRpcFacade.page(userTrackPageReqDTO);
    }
}
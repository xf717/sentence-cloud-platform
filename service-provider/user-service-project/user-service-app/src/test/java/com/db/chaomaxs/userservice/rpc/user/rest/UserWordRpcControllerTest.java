package com.db.chaomaxs.userservice.rpc.user.rest;
import com.db.chaomaxs.userservice.rpc.user.dto.UserWordCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserWordPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserWordUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserWordRpcFacade;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author momo
 * @date 2021-03-29 17:49
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class UserWordRpcControllerTest  extends TestCase {

    @Autowired
    private UserWordRpcFacade userWordRpcFacade;

    @Test
    public void testSave() {
        UserWordCreateReqDTO reqDTO=new UserWordCreateReqDTO();
        reqDTO.setContent("aaa");
        reqDTO.setUserId(1L);
        userWordRpcFacade.save(reqDTO);
    }

    @Test
    public void testUpdate() {
        UserWordUpdateReqDTO reqDTO=new UserWordUpdateReqDTO();
        reqDTO.setContent("ddddd");
        reqDTO.setId(2L);
        reqDTO.setUpdateBy(4L);
        userWordRpcFacade.update(reqDTO);
    }

    @Test
    public void testRemove() {
        userWordRpcFacade.remove(2L);
    }

    @Test
    public void testGetUserWordById() {
        userWordRpcFacade.getUserWordById(2L);
    }

    public void testListUserWords() {
    }

    @Test
    public void testPage() {
        UserWordPageReqDTO userWordPageReqDTO=new UserWordPageReqDTO();
        userWordPageReqDTO.setPageNo(0);
        userWordPageReqDTO.setPageSize(10);
        userWordPageReqDTO.setUserId(1L);
        userWordRpcFacade.page(userWordPageReqDTO);
    }
}
package com.github.xf717.userservice.rpc.user.rest;

import com.github.xf717.userservice.enums.user.UserInterviewEnum;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.facade.UserInterviewRpcFacade;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author momo
 * @date 2021-04-02 14:36
 */
public class UserInterviewRpcControllerTest extends MySpringBootTest {
    @Autowired
    private UserInterviewRpcFacade userInterviewRpcFacade;

    @Test
    public void testSave() {
        UserInterviewCreateReqDTO userInterviewCreateReqDTO=new UserInterviewCreateReqDTO();
        userInterviewCreateReqDTO.setCompanyUserInterviewId(1L);
        userInterviewCreateReqDTO.setUserId(1L);
        userInterviewCreateReqDTO.setStatus(UserInterviewEnum.WAITING_ACCEPT_INTERVIEW.getCode());
        userInterviewRpcFacade.save(userInterviewCreateReqDTO);
    }

    @Test
    public void testUpdate() {
        UserInterviewUpdateReqDTO userInterviewUpdateReqDTO=new UserInterviewUpdateReqDTO();
        userInterviewUpdateReqDTO.setId(1L);
        userInterviewUpdateReqDTO.setStatus(UserInterviewEnum.ACCEPT_INTERVIEW.getCode());
        userInterviewRpcFacade.update(userInterviewUpdateReqDTO);
    }

    @Test
    public void testGetUserInterviewById() {
        userInterviewRpcFacade.getUserInterviewById(1L);
    }

    @Test
    public void testPage() {
        UserInterviewPageReqDTO userInterviewPageReqDTO=new UserInterviewPageReqDTO();
        userInterviewPageReqDTO.setUserId(1L);
        userInterviewPageReqDTO.setPageNo(0);
        userInterviewPageReqDTO.setPageSize(10);
        userInterviewRpcFacade.page(userInterviewPageReqDTO);
    }
}

package com.db.chaomaxs.companyservice.rpc.collect.rest;

import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.UserCollectPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.facade.CompanyUserCollectRpcFacade;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author momo
 * @date 2021-03-30 15:07
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class CompanyUserCollectRpcControllerTest extends TestCase {

    @Autowired
    private CompanyUserCollectRpcFacade companyUserCollectRpcFacade;

    @Test
    public void testSave() {
        CompanyUserCollectCreateReqDTO createReqDTO = new CompanyUserCollectCreateReqDTO();
        createReqDTO.setPositionId(1L);
        createReqDTO.setCompanyUserId(1L);
        createReqDTO.setUserId(4L);
        companyUserCollectRpcFacade.save(createReqDTO);
    }

    @Test
    public void testRemove() {
        companyUserCollectRpcFacade.remove(1L);
    }

    @Test
    public void testPage() {
        CompanyUserCollectPageReqDTO companyUserCollectPageReqDTO = new CompanyUserCollectPageReqDTO();
        companyUserCollectPageReqDTO.setCompanyUserId(1L);
        companyUserCollectPageReqDTO.setPageNo(0);
        companyUserCollectPageReqDTO.setPageSize(10);
        companyUserCollectRpcFacade.page(companyUserCollectPageReqDTO);
    }

    @Test
    public void testUserPage() {
        UserCollectPageReqDTO userCollectPageReqDTO = new UserCollectPageReqDTO();
        userCollectPageReqDTO.setUserId(3L);
        userCollectPageReqDTO.setPageNo(0);
        userCollectPageReqDTO.setPageSize(10);
        companyUserCollectRpcFacade.userPage(userCollectPageReqDTO);
    }
}
package com.db.chaomaxs.companyservice.rpc.company.rest;

import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatRespDTO;
import com.db.chaomaxs.companyservice.rpc.chat.facade.CompanyUserChatRpcFacade;
import junit.framework.TestCase;
import org.checkerframework.checker.units.qual.C;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author momo
 * @date 2021-04-01 11:33
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class CompanyUserChatRpcControllerTest extends TestCase {

    @Autowired
    private CompanyUserChatRpcFacade companyUserChatRpcFacade;

    @Test
    public void testSave() {
        CompanyUserChatCreateReqDTO companyUserChatCreateReqDTO = new CompanyUserChatCreateReqDTO();
        companyUserChatCreateReqDTO.setUserId(3L);
        companyUserChatCreateReqDTO.setCompanyUserId(1L);
        companyUserChatCreateReqDTO.setCompanyId(2L);
        companyUserChatRpcFacade.save(companyUserChatCreateReqDTO);
    }

    public void testGetCompanyUserChatById() {
        companyUserChatRpcFacade.getCompanyUserChatById(1L);
    }

    public void testPage() {
        CompanyUserChatPageReqDTO companyUserChatRespDTO = new CompanyUserChatPageReqDTO();
        companyUserChatRpcFacade.page(companyUserChatRespDTO);
    }
}
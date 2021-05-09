package com.db.chaomaxs.companyservice.rpc.settings.rest;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.facade.CompanyUserSetRpcFacade;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author momo
 * @date 2021-03-31 15:17
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class CompanyUserSetRpcControllerTest extends TestCase {

    @Autowired
    private CompanyUserSetRpcFacade companyUserSetRpcFacade;

    @Test
    public void testSave() {
        CompanyUserSetCreateReqDTO companyUserSetCreateReqDTO=new CompanyUserSetCreateReqDTO();
        companyUserSetCreateReqDTO.setUserId(1L);
        companyUserSetCreateReqDTO.setCompanyUserId(2L);
        companyUserSetCreateReqDTO.setCompanyId(1L);
        companyUserSetCreateReqDTO.setBlackSwitch(1);
        companyUserSetCreateReqDTO.setTopSwitch(1);
        companyUserSetCreateReqDTO.setUserId(1L);
        companyUserSetRpcFacade.save(companyUserSetCreateReqDTO);
    }

    @Test
    public void testUpdate() {
        CompanyUserSetUpdateReqDTO companyUserSetUpdateReqDTO=new CompanyUserSetUpdateReqDTO();
        companyUserSetUpdateReqDTO.setId(1L);
        companyUserSetUpdateReqDTO.setBlackSwitch(0);
        companyUserSetUpdateReqDTO.setTopSwitch(0);
        companyUserSetUpdateReqDTO.setUserId(1L);
        companyUserSetRpcFacade.update(companyUserSetUpdateReqDTO);
    }
    @Test
    public void testGetUserSetByUserIdAndCompanyUserId() {
        CompanyUserSetQueryReqDTO companyUserSetQueryReqDTO=new CompanyUserSetQueryReqDTO();
        companyUserSetQueryReqDTO.setCompanyId(1L);
        companyUserSetQueryReqDTO.setUserId(1L);
        companyUserSetQueryReqDTO.setCompanyUserId(1L);
        companyUserSetRpcFacade.getUserSetByCompanyUserIdAndUserId(companyUserSetQueryReqDTO);
    }
}
package com.db.chaomaxs.companyservice.rpc.delivery.rest;

import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.facade.CompanyDeliveryRpcFacade;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author momo
 * @date 2021-03-30 18:50
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class CompanyDeliveryRpcControllerTest extends TestCase {

    @Autowired
    private CompanyDeliveryRpcFacade companyDeliveryRpcFacade;


    @Test
    public void testSave() {
        CompanyDeliveryCreateReqDTO companyDeliveryCreateReqDTO=new CompanyDeliveryCreateReqDTO();
        companyDeliveryCreateReqDTO.setCompanyId(1L);
        companyDeliveryCreateReqDTO.setUserId(7L);
        companyDeliveryCreateReqDTO.setCompanyUserId(1L);
        companyDeliveryCreateReqDTO.setPositionId(1L);
        companyDeliveryRpcFacade.save(companyDeliveryCreateReqDTO);
    }
    @Test
    public void testUpdate() {
    }
    @Test
    public void testRemove() {
//        companyDeliveryRpcFacade.remove(1L);
    }
    @Test
    public void testGetCompanyDeliveryById() {
        companyDeliveryRpcFacade.getCompanyDeliveryById(2L);
    }
    @Test
    public void testPage() {
        CompanyDeliveryPageReqDTO companyDeliveryPageReqDTO=new CompanyDeliveryPageReqDTO();
        companyDeliveryPageReqDTO.setCompanyUserId(1L);
        companyDeliveryPageReqDTO.setPageNo(0);
        companyDeliveryPageReqDTO.setPageSize(10);
        companyDeliveryRpcFacade.page(companyDeliveryPageReqDTO);
    }
}

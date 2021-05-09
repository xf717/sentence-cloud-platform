package com.db.chaomaxs.companyservice.rpc.track.rest;

import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.track.facade.CompanyUserTrackRpcFacade;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author momo
 * @date 2021-03-31 17:53
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CompanyUserTrackRpcControllerTest extends TestCase {

    @Autowired
    private CompanyUserTrackRpcFacade companyUserTrackRpcFacade;


    @Test
    public void testSave() {
        CompanyUserTrackCreateReqDTO companyUserTrackCreateReqDTO=new CompanyUserTrackCreateReqDTO();
        companyUserTrackCreateReqDTO.setPositionId(1L);
        companyUserTrackCreateReqDTO.setCompanyUserId(1L);
        companyUserTrackCreateReqDTO.setUserId(5L);
        companyUserTrackRpcFacade.save(companyUserTrackCreateReqDTO);
    }


    @Test
    public void testPage() {
        CompanyUserTrackPageReqDTO companyUserTrackPageReqDTO=new CompanyUserTrackPageReqDTO();
        companyUserTrackPageReqDTO.setUserId(1L);
        companyUserTrackPageReqDTO.setPageNo(0);
        companyUserTrackPageReqDTO.setPageSize(10);
        companyUserTrackRpcFacade.page(companyUserTrackPageReqDTO);
    }
}
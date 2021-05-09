package com.db.chaomaxs.companyservice.rpc.interview.rest;

import com.db.chaomaxs.companyservice.rpc.MySpringBootTest;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewHandoverReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewIdReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateStateReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.facade.CompanyUserInterviewRpcFacade;
import com.google.common.collect.Sets;
import java.util.Date;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author momo
 * @date 2021-04-01 15:02
 */
@Ignore
public class CompanyUserInterviewRpcControllerTest extends MySpringBootTest {

    @Autowired
    private CompanyUserInterviewRpcFacade companyUserInterviewRpcFacade;


    @Test
    public void testSave() {
        CompanyUserInterviewCreateReqDTO companyUserInterviewCreateReqDTO = new CompanyUserInterviewCreateReqDTO();
        companyUserInterviewCreateReqDTO.setCompanyId(1L);
        companyUserInterviewCreateReqDTO.setCompanyUserId(2L);
        companyUserInterviewCreateReqDTO.setInterviemTime(new Date());
        companyUserInterviewCreateReqDTO.setUserId(2L);
        companyUserInterviewCreateReqDTO.setMobile("139****1111");
        companyUserInterviewCreateReqDTO.setInterviewAddress("软件园二期观日路34号楼之一");
        companyUserInterviewCreateReqDTO.setPositionId(1L);
        companyUserInterviewCreateReqDTO.setPositionName("JAVA");
        companyUserInterviewRpcFacade.save(companyUserInterviewCreateReqDTO);
    }

    @Test
    public void testUpdate() {
        CompanyUserInterviewUpdateReqDTO userInterviewUpdateReqDTO = new CompanyUserInterviewUpdateReqDTO();
        userInterviewUpdateReqDTO.setId(1L);
        userInterviewUpdateReqDTO.setCompanyId(1L);
        userInterviewUpdateReqDTO.setCompanyUserId(2L);
        userInterviewUpdateReqDTO.setInterviemTime(new Date());
        userInterviewUpdateReqDTO.setMobile("139****1112");
        userInterviewUpdateReqDTO.setInterviewAddress("软件园二期观日路35号楼之一");
        userInterviewUpdateReqDTO.setPositionId(1L);
        userInterviewUpdateReqDTO.setPositionName("PHP");
        companyUserInterviewRpcFacade.update(userInterviewUpdateReqDTO);
    }

    @Test
    public void testUpdateState() {
        CompanyUserInterviewUpdateStateReqDTO companyUserInterviewUpdateStateReqDTO = new CompanyUserInterviewUpdateStateReqDTO();
        companyUserInterviewUpdateStateReqDTO.setId(1L);
        companyUserInterviewUpdateStateReqDTO.setStatus(2);
        companyUserInterviewRpcFacade.updateState(companyUserInterviewUpdateStateReqDTO);
    }


    @Test
    public void testGetCompanyUserInterviewById() {
        companyUserInterviewRpcFacade.getCompanyUserInterviewById(1L);
    }

    @Test
    public void testGetCompanyUserInterviewByIds() {
        CompanyUserInterviewIdReqDTO companyUserInterviewIdReqDTO = new CompanyUserInterviewIdReqDTO();
        companyUserInterviewIdReqDTO.setIds(Sets.newHashSet(1L, 2L));
        companyUserInterviewRpcFacade.getCompanyUserInterviewByIds(companyUserInterviewIdReqDTO);
    }

    @Test
    public void testGetByCompanyUserIdAndUserId() {
        CompanyUserInterviewReqDTO companyUserInterviewReqDTO = new CompanyUserInterviewReqDTO();
        companyUserInterviewReqDTO.setCompanyId(1L);
        companyUserInterviewReqDTO.setCompanyUserId(2L);
        companyUserInterviewReqDTO.setUserId(1L);
        companyUserInterviewRpcFacade.getByCompanyUserIdAndUserId(companyUserInterviewReqDTO);
    }

    @Test
    public void testPage() {
        CompanyUserInterviewPageReqDTO companyUserInterviewPageReqDTO = new CompanyUserInterviewPageReqDTO();
        companyUserInterviewPageReqDTO.setCompanyId(1L);
        companyUserInterviewPageReqDTO.setCompanyUserId(2L);
        companyUserInterviewPageReqDTO.setStatus(0);
        companyUserInterviewPageReqDTO.setPageNo(0);
        companyUserInterviewPageReqDTO.setPageSize(10);
        companyUserInterviewRpcFacade.page(companyUserInterviewPageReqDTO);
    }

    @Test
    public void testList() {
        CompanyUserInterviewListQueryReqDTO queryReqDTO = new CompanyUserInterviewListQueryReqDTO();
        queryReqDTO.setCompanyUserId(1L);
        queryReqDTO.setCompanyId(1L);
        companyUserInterviewRpcFacade.interviewList(queryReqDTO);
    }

    @Test
    public void handover() {
        CompanyUserInterviewHandoverReqDTO companyUserInterviewHandoverReqDTO = new CompanyUserInterviewHandoverReqDTO();
        companyUserInterviewHandoverReqDTO.setUserId(1L);
        companyUserInterviewHandoverReqDTO.setHandoverUserId(2L);

        companyUserInterviewRpcFacade.handover(companyUserInterviewHandoverReqDTO);
    }


}
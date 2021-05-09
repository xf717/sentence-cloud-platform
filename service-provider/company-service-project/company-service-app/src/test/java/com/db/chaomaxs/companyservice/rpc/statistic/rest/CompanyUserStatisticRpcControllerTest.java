package com.db.chaomaxs.companyservice.rpc.statistic.rest;

import com.db.chaomaxs.companyservice.rpc.MySpringBootTest;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticReqDTO;
import com.db.chaomaxs.companyservice.rpc.statistic.facade.CompanyUserStatisticRpcFacade;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author momo
 * @date 2021-04-12 19:54
 */
public class CompanyUserStatisticRpcControllerTest extends MySpringBootTest {
    @Autowired
    private CompanyUserStatisticRpcFacade companyUserStatisticRpcFacade;


    @Test
    public void testGetStatistic() {
        CompanyUserStatisticReqDTO companyUserStatisticReqDTO=new CompanyUserStatisticReqDTO();
        companyUserStatisticReqDTO.setCompanyId(1L);
        companyUserStatisticReqDTO.setCompanyUserId(1L);
        companyUserStatisticRpcFacade.getStatistic(companyUserStatisticReqDTO);
    }
}
package com.db.chaomaxs.companyweb.manager.interview.interview;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateStateReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.facade.CompanyUserInterviewRpcFacade;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author momo
 * @date 2021-04-08 10:45
 */
public class CompanyUserCancelInterview implements CompanyUserInterview {
    @Autowired
    private CompanyUserInterviewRpcFacade companyUserInterviewRpcFacade;

    @Override
    public BaseResponse updateCompanyUserInterviewState(CompanyUserInterviewUpdateStateReqDTO companyUserInterviewUpdateStateReqDTO) {
        return companyUserInterviewRpcFacade.updateState(companyUserInterviewUpdateStateReqDTO);
    }
}

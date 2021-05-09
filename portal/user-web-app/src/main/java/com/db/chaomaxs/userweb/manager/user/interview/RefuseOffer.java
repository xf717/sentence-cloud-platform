package com.db.chaomaxs.userweb.manager.user.interview;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateStateReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.facade.CompanyUserInterviewRpcFacade;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserInterviewRpcFacade;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author momo
 * @date 2021-04-08 10:43
 */
public class RefuseOffer implements UserInterview {
    @Autowired
    private UserInterviewRpcFacade userInterviewRpcFacade;

    @Autowired
    private CompanyUserInterviewRpcFacade companyUserInterviewRpcFacade;

    @Override
    public BaseResponse updateUserInterviewState(UserInterviewUpdateReqDTO userInterviewUpdateReqDTO) {
        return userInterviewRpcFacade.update(userInterviewUpdateReqDTO);
    }

    @Override
    public BaseResponse updateCompanyUserInterviewState(
        CompanyUserInterviewUpdateStateReqDTO companyUserInterviewUpdateStateReqDTO){
        return companyUserInterviewRpcFacade.updateState(companyUserInterviewUpdateStateReqDTO);
    }
}

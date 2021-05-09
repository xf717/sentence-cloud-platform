package com.github.xf717.userweb.manager.user.interview;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateStateReqDTO;
import com.github.xf717.companyservice.rpc.interview.facade.CompanyUserInterviewRpcFacade;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.facade.UserInterviewRpcFacade;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author momo
 * @date 2021-04-08 09:39
 */
public class RefuseInterview implements UserInterview {

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

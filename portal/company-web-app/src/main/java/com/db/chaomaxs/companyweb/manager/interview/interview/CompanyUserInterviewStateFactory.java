package com.db.chaomaxs.companyweb.manager.interview.interview;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.companyservice.enums.interview.CompanyUserInterviewEnum;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateStateReqDTO;
import com.google.common.collect.Maps;

import java.util.Map;
import org.springframework.stereotype.Service;


/**
 * @author momo
 * @date 2021-04-08 10:06
 */
@Service
public class CompanyUserInterviewStateFactory {

    private static Map<Integer, CompanyUserInterview> companyUserInterviewStateMap = Maps.newHashMap();

    private static void initCompanyUserInterviewState() {
        if (companyUserInterviewStateMap.isEmpty()) {
            companyUserInterviewStateMap.put(CompanyUserInterviewEnum.ACCEPT_INTERVIEW.getCode(), new PassedInterview());
            companyUserInterviewStateMap.put(CompanyUserInterviewEnum.REFUSE_INTERVIEW.getCode(), new UnPassedInterview());
            companyUserInterviewStateMap.put(CompanyUserInterviewEnum.ACCEPT_OFFER.getCode(), new CompanyUserCancelInterview());
        }
    }


    public BaseResponse updateUserInterviewState(CompanyUserInterviewUpdateStateReqDTO companyUserInterviewUpdateStateReqDTO) {
        initCompanyUserInterviewState();
        CompanyUserInterview companyUserInterview = companyUserInterviewStateMap.get(companyUserInterviewUpdateStateReqDTO.getStatus());
        return companyUserInterview.updateCompanyUserInterviewState(companyUserInterviewUpdateStateReqDTO);
    }
}

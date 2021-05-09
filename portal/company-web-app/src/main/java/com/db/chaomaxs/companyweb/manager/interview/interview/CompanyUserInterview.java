package com.db.chaomaxs.companyweb.manager.interview.interview;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateStateReqDTO;

/**
 * @author momo
 * @date 2021-04-08 09:35
 */
public interface CompanyUserInterview {

     BaseResponse updateCompanyUserInterviewState(CompanyUserInterviewUpdateStateReqDTO companyUserInterviewUpdateStateReqDTO);

}

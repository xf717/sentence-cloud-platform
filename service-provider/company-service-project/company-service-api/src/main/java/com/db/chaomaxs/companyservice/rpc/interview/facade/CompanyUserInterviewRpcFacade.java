package com.db.chaomaxs.companyservice.rpc.interview.facade;

import com.db.chaomaxs.companyservice.rpc.interview.facade.api.CompanyUserInterviewApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 企业面试表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@FeignClient(value = "${chaomax.company.serviceId}", configuration = {})
public interface CompanyUserInterviewRpcFacade extends CompanyUserInterviewApi {

}

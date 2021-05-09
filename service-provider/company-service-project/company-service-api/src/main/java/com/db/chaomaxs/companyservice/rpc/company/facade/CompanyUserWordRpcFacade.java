package com.db.chaomaxs.companyservice.rpc.company.facade;

import com.db.chaomaxs.companyservice.rpc.company.facade.api.CompanyUserWordApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 企业常用语表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@FeignClient(value = "${chaomax.company.serviceId}", configuration = {})
public interface CompanyUserWordRpcFacade extends CompanyUserWordApi {

}

package com.db.chaomaxs.companyservice.rpc.collect.facade;

import com.db.chaomaxs.companyservice.rpc.collect.facade.api.CompanyUserCollectApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 企业_用户_收藏
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@FeignClient(value = "${chaomax.company.serviceId}", configuration = {})
public interface CompanyUserCollectRpcFacade extends CompanyUserCollectApi {

}

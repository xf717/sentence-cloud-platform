package com.db.chaomaxs.companyservice.rpc.settings.facade;

import com.db.chaomaxs.companyservice.rpc.settings.facade.api.CompanyUserSetApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 企业我的设置
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@FeignClient(value = "${chaomax.company.serviceId}", configuration = {})
public interface CompanyUserSetRpcFacade extends CompanyUserSetApi {

}

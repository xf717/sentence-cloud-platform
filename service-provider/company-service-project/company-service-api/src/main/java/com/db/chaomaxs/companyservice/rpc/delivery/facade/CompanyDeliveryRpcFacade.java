package com.db.chaomaxs.companyservice.rpc.delivery.facade;

import com.db.chaomaxs.companyservice.rpc.delivery.facade.api.CompanyDeliveryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 企业投递表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@FeignClient(value = "${chaomax.company.serviceId}", configuration = {})
public interface CompanyDeliveryRpcFacade extends CompanyDeliveryApi {

}

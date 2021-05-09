package com.db.chaomaxs.positionservice.rpc.position.facade;

import com.db.chaomaxs.positionservice.rpc.position.facade.api.CompanyPositionApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 企业_职位
 *
 * @author xiaofeng
 * @date 2021-03-29 16:36:57
 */
@FeignClient(value = "${chaomax.position.serviceId}",configuration = {})
public interface CompanyPositionRpcFacade extends CompanyPositionApi {
}

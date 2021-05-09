package com.db.chaomaxs.systemservice.rpc.auth.facade;

import com.db.chaomaxs.systemservice.rpc.auth.facade.api.BaseGroupApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@FeignClient(value = "${chaomax.system.serviceId}", configuration = {})
public interface BaseGroupRpcFacade extends BaseGroupApi {

}

package com.github.xf717.systemservice.rpc.auth.facade;

import com.github.xf717.systemservice.rpc.auth.facade.api.BaseGroupLeaderApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@FeignClient(value = "${chaomax.system.serviceId}", configuration = {})
public interface BaseGroupLeaderRpcFacade extends BaseGroupLeaderApi {

}

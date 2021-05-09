package com.github.xf717.systemservice.rpc.auth.facade;

import com.github.xf717.systemservice.rpc.auth.facade.api.BaseGroupMemberApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@FeignClient(value = "${chaomax.system.serviceId}", configuration = {})
public interface BaseGroupMemberRpcFacade extends BaseGroupMemberApi {

}

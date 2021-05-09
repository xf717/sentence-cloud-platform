package com.github.xf717.systemservice.rpc.auth.facade;

import com.github.xf717.systemservice.rpc.auth.facade.api.PermissionApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * PermissionRpcFacade
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/30 19:52
 */
@FeignClient(value = "${chaomax.system.serviceId}", configuration = {})
public interface PermissionRpcFacade extends PermissionApi {

}

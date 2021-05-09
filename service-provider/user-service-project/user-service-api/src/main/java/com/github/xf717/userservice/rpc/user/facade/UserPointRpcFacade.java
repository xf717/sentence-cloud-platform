package com.github.xf717.userservice.rpc.user.facade;

import com.github.xf717.userservice.rpc.user.facade.api.UserPointApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_积分表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserPointRpcFacade extends UserPointApi {
}

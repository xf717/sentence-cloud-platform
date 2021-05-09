package com.github.xf717.userservice.rpc.user.facade;

import com.github.xf717.userservice.rpc.user.facade.api.UserThirdApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_第三方表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserThirdRpcFacade extends UserThirdApi {
}

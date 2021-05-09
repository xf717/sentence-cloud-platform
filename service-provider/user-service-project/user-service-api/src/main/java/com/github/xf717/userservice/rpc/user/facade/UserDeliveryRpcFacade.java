package com.github.xf717.userservice.rpc.user.facade;

import com.github.xf717.userservice.rpc.user.facade.api.UserDeliveryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 企业投递表
 *
 * @author momo
 * @date 2021-04-08 14:18:28
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserDeliveryRpcFacade extends UserDeliveryApi {
}

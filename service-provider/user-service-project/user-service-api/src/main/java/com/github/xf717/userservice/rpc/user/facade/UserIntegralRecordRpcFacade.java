package com.github.xf717.userservice.rpc.user.facade;

import com.github.xf717.userservice.rpc.user.facade.api.UserIntegralRecordApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 记录用户签到记录信息
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserIntegralRecordRpcFacade extends UserIntegralRecordApi {
}

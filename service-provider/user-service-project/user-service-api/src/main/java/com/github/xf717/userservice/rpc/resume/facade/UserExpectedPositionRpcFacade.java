package com.github.xf717.userservice.rpc.resume.facade;

import com.github.xf717.userservice.rpc.resume.facade.api.UserExpectedPositionApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_期望职位
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserExpectedPositionRpcFacade extends UserExpectedPositionApi {
}

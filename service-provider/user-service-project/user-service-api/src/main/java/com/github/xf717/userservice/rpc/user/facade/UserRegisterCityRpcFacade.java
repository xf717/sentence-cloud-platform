package com.github.xf717.userservice.rpc.user.facade;

import com.github.xf717.userservice.rpc.user.facade.api.UserRegisterCityApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户注册城市表，注册时保存
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserRegisterCityRpcFacade extends UserRegisterCityApi {
}

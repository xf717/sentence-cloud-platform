package com.github.xf717.userservice.rpc.user.facade;

import com.github.xf717.userservice.rpc.user.facade.api.UserHideCompanyApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_屏蔽公司
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserHideCompanyRpcFacade extends UserHideCompanyApi {
}

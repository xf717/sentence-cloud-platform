package com.db.chaomaxs.userservice.rpc.user.facade;

import com.db.chaomaxs.userservice.rpc.user.facade.api.UserBindingCompanyApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_企业绑定
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserBindingCompanyRpcFacade extends UserBindingCompanyApi {
}

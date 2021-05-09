package com.db.chaomaxs.logservice.rpc.login.facade;

import com.db.chaomaxs.logservice.rpc.login.facade.api.UserLoginLogApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_登录日志
 *
 * @author xiaofeng
 * @date 2021-03-29 16:03:34
 */
@FeignClient(value = "${chaomax.log.serviceId}",configuration = {})
public interface UserLoginLogRpcFacade extends UserLoginLogApi {
}

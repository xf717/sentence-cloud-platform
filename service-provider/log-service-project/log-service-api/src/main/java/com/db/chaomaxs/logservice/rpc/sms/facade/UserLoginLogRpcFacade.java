package com.db.chaomaxs.logservice.rpc.sms.facade;

import com.db.chaomaxs.logservice.rpc.sms.facade.api.UserLoginLogApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_登录日志
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:03
 */
@FeignClient(value = "${chaomax.log.serviceId}", configuration = {})
public interface UserLoginLogRpcFacade extends UserLoginLogApi {

}

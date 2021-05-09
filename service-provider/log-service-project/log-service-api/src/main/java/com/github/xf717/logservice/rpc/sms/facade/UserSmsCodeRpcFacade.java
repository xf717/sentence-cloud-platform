package com.github.xf717.logservice.rpc.sms.facade;

import com.github.xf717.logservice.rpc.sms.facade.api.UserSmsCodeApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户短信验证码表
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:02
 */
@FeignClient(value = "${chaomax.log.serviceId}", configuration = {})
public interface UserSmsCodeRpcFacade extends UserSmsCodeApi {

}

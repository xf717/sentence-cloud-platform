package com.db.chaomaxs.userservice.rpc.sms.facade;

import com.db.chaomaxs.hystrix.config.FeignConfiguration;
import com.db.chaomaxs.userservice.rpc.sms.facade.api.SmsCodeApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 短信发送
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@FeignClient(value = "${chaomax.user.serviceId}", configuration = {FeignConfiguration.class})
public interface SmsCodeRpcFacade extends SmsCodeApi {

}

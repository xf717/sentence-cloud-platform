package com.db.chaomaxs.userservice.rpc.user.facade;

import com.db.chaomaxs.userservice.rpc.user.facade.api.UserSetApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_设置
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserSetRpcFacade extends UserSetApi {
}

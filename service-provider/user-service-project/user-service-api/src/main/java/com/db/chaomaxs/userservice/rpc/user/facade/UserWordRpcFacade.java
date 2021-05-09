package com.db.chaomaxs.userservice.rpc.user.facade;

import com.db.chaomaxs.userservice.rpc.user.facade.api.UserWordApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_常用语
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserWordRpcFacade extends UserWordApi {
}

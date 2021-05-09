package com.db.chaomaxs.userservice.rpc.user.facade;

import com.db.chaomaxs.userservice.rpc.user.facade.api.UserExtendApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_基础信息扩展表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserExtendRpcFacade extends UserExtendApi {
}

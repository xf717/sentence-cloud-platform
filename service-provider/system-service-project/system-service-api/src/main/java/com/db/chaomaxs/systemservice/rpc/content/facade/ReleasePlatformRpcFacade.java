package com.db.chaomaxs.systemservice.rpc.content.facade;

import com.db.chaomaxs.systemservice.rpc.content.facade.api.ReleasePlatformApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 发布平台
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@FeignClient(value = "${chaomax.system.serviceId}",configuration = {})
public interface ReleasePlatformRpcFacade extends ReleasePlatformApi {
}

package com.db.chaomaxs.resourceservice.rpc.resource.facade;

import com.db.chaomaxs.resourceservice.rpc.resource.facade.api.ResourceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 文件资源表
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
@FeignClient(value = "${chaomax.resource.serviceId}", configuration = {})
public interface ResourceRpcFacade extends ResourceApi {

}

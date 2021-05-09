package com.github.xf717.systemservice.rpc.content.facade;

import com.github.xf717.systemservice.rpc.content.facade.api.IndustryTypeApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 行业分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@FeignClient(value = "${chaomax.system.serviceId}",configuration = {})
public interface IndustryTypeRpcFacade extends IndustryTypeApi {
}

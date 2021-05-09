package com.github.xf717.systemservice.rpc.dict.facade;

import com.github.xf717.systemservice.rpc.dict.facade.api.DataDictionaryItemApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 数据字典项信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@FeignClient(value = "${chaomax.system.serviceId}",configuration = {})
public interface DataDictionaryItemRpcFacade extends DataDictionaryItemApi {
}

package com.db.chaomaxs.systemservice.rpc.content.facade;

import com.db.chaomaxs.systemservice.rpc.content.facade.api.WorkContentApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 内容管理-工作内容息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@FeignClient(value = "${chaomax.system.serviceId}",configuration = {})
public interface WorkContentRpcFacade extends WorkContentApi {
}

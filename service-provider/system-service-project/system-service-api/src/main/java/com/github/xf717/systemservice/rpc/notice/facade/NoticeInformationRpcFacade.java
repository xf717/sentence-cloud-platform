package com.github.xf717.systemservice.rpc.notice.facade;

import com.github.xf717.systemservice.rpc.notice.facade.api.NoticeInformationApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 通知信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@FeignClient(value = "${chaomax.system.serviceId}",configuration = {})
public interface NoticeInformationRpcFacade extends NoticeInformationApi {
}

package com.github.xf717.systemservice.rpc.notice.facade;

import com.github.xf717.systemservice.rpc.notice.facade.api.NoticeInformationExtendApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 内容管理通知信息_扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@FeignClient(value = "${chaomax.system.serviceId}",configuration = {})
public interface NoticeInformationExtendRpcFacade extends NoticeInformationExtendApi {
}

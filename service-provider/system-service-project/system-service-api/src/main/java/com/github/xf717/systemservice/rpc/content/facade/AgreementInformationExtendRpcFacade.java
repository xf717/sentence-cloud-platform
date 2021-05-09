package com.github.xf717.systemservice.rpc.content.facade;

import com.github.xf717.systemservice.rpc.content.facade.api.AgreementInformationExtendApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 内容管理-协议信息_扩展息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@FeignClient(value = "${chaomax.system.serviceId}",configuration = {})
public interface AgreementInformationExtendRpcFacade extends AgreementInformationExtendApi {
}

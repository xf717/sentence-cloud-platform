package com.db.chaomaxs.systemservice.rpc.content.facade;

import com.db.chaomaxs.systemservice.rpc.content.facade.api.ProblemInformationExtendApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 内容管理-问题扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@FeignClient(value = "${chaomax.system.serviceId}",configuration = {})
public interface ProblemInformationExtendRpcFacade extends ProblemInformationExtendApi {
}

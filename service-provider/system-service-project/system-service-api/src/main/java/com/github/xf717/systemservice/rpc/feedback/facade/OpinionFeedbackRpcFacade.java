package com.github.xf717.systemservice.rpc.feedback.facade;

import com.github.xf717.systemservice.rpc.feedback.facade.api.OpinionFeedbackApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 意见反馈信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@FeignClient(value = "${chaomax.system.serviceId}",configuration = {})
public interface OpinionFeedbackRpcFacade extends OpinionFeedbackApi {
}

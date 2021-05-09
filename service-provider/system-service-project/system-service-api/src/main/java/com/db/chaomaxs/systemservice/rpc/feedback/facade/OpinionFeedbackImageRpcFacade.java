package com.db.chaomaxs.systemservice.rpc.feedback.facade;

import com.db.chaomaxs.systemservice.rpc.feedback.facade.api.OpinionFeedbackImageApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 意见反馈_图片
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@FeignClient(value = "${chaomax.system.serviceId}",configuration = {})
public interface OpinionFeedbackImageRpcFacade extends OpinionFeedbackImageApi {
}

package com.db.chaomaxs.companyservice.rpc.feedback.facade;

import com.db.chaomaxs.companyservice.rpc.feedback.facade.api.FeedbackApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 帮助与反馈
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@FeignClient(value = "${chaomax.company.serviceId}", configuration = {})
public interface FeedbackRpcFacade extends FeedbackApi {

}

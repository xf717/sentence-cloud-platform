package com.db.chaomaxs.companyservice.rpc.feedback.facade;

import com.db.chaomaxs.companyservice.rpc.feedback.facade.api.FeedbackPhotoApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 帮助与反馈_图片说明
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@FeignClient(value = "${chaomax.company.serviceId}", configuration = {})
public interface FeedbackPhotoRpcFacade extends FeedbackPhotoApi {

}

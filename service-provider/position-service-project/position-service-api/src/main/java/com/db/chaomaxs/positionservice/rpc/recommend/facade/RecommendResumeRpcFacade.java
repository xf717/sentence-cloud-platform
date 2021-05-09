package com.db.chaomaxs.positionservice.rpc.recommend.facade;

import com.db.chaomaxs.positionservice.rpc.recommend.facade.api.RecommendResumeApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 推荐人才简历
 *
 * @author xiaofeng
 * @date 2021-03-29 17:09:31
 */
@FeignClient(value = "${chaomax.position.serviceId}",configuration = {})
public interface RecommendResumeRpcFacade extends RecommendResumeApi {
}

package com.db.chaomaxs.userservice.rpc.resume.facade;

import com.db.chaomaxs.userservice.rpc.resume.facade.api.UserExpectedPositionIndustryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_期望_职位_行业
 *
 * @author wst
 * @date 2021-04-12 13:47:08
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserExpectedPositionIndustryRpcFacade extends UserExpectedPositionIndustryApi {
}

package com.db.chaomaxs.userservice.rpc.resume.facade;

import com.db.chaomaxs.userservice.rpc.resume.facade.api.UserEduExperienceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_教育经历表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserEduExperienceRpcFacade extends UserEduExperienceApi {
}

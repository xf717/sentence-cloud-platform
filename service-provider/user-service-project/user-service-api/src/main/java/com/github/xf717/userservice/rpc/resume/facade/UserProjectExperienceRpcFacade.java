package com.github.xf717.userservice.rpc.resume.facade;

import com.github.xf717.userservice.rpc.resume.facade.api.UserProjectExperienceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_项目经历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserProjectExperienceRpcFacade extends UserProjectExperienceApi {
}

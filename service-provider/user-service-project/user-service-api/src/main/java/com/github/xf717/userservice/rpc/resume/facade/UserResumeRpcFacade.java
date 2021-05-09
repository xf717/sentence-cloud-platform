package com.github.xf717.userservice.rpc.resume.facade;

import com.github.xf717.userservice.rpc.resume.facade.api.UserResumeApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserResumeRpcFacade extends UserResumeApi {
}

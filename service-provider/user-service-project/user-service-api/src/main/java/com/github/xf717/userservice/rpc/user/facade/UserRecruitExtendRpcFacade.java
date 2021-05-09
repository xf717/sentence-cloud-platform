package com.github.xf717.userservice.rpc.user.facade;

import com.github.xf717.userservice.rpc.user.facade.api.UserRecruitExtendApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_招聘_扩展表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:54:37
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserRecruitExtendRpcFacade extends UserRecruitExtendApi {
}

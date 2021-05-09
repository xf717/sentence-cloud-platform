package com.db.chaomaxs.userservice.rpc.user.facade;

import com.db.chaomaxs.userservice.rpc.user.facade.api.UserInterviewApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户面试表
 *
 * @author momo
 * @date 2021-04-02 13:58:28
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserInterviewRpcFacade extends UserInterviewApi {
}

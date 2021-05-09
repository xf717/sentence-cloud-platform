package com.db.chaomaxs.userservice.rpc.resume.facade;

import com.db.chaomaxs.userservice.rpc.resume.facade.api.UserEnclosureResumeApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_附件_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserEnclosureResumeRpcFacade extends UserEnclosureResumeApi {
}

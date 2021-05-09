package com.db.chaomaxs.userservice.rpc.resume.facade;

import com.db.chaomaxs.userservice.rpc.resume.facade.api.UserProfessionalSkillApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_专业技能表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserProfessionalSkillRpcFacade extends UserProfessionalSkillApi {
}

package com.db.chaomaxs.userservice.rpc.resume.facade;

import com.db.chaomaxs.userservice.rpc.resume.facade.api.UserWorkSkillTagApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_工作经历_技能标签信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@FeignClient(value = "${chaomax.user.serviceId}",configuration = {})
public interface UserWorkSkillTagRpcFacade extends UserWorkSkillTagApi {
}

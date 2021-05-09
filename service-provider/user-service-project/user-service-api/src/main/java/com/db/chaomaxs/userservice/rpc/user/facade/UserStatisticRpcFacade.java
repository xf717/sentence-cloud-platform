package com.db.chaomaxs.userservice.rpc.user.facade;

import com.db.chaomaxs.userservice.rpc.user.facade.api.UserStatisticApi;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.Map;
import java.util.Set;

/**
 * 企业我的足迹
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@FeignClient(value = "${chaomax.user.serviceId}", configuration = {})
public interface UserStatisticRpcFacade extends UserStatisticApi {


}

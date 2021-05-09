package com.db.chaomaxs.security.auth.client.rpc.oauth.facade;

import com.db.chaomaxs.security.auth.client.rpc.oauth.facade.api.OAuth2Api;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * UserAuthRpcFacade
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/26 9:12
 */
@FeignClient(value = "${auth.serviceId}", configuration = {})
public interface OAuth2RpcFacade extends OAuth2Api {

}

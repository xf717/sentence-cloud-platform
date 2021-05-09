package com.db.chaomaxs.security.auth.client.rpc.auth.facade;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 服务鉴权远程调用
 *
 * @author xiaofeng
 * @date 2017/9/15
 */
@FeignClient(value = "${auth.serviceId}", configuration = {})
public interface ServiceAuthRpcFacade {

  @RequestMapping(value = "/client/userPubKey", method = RequestMethod.POST)
  public ObjectRestResponse<byte[]> getUserPublicKey(@RequestParam("clientId") String clientId,
      @RequestParam("secret") String secret);

}

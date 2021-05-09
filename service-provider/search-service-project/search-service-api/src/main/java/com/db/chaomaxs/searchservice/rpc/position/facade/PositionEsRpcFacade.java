package com.db.chaomaxs.searchservice.rpc.position.facade;

import com.db.chaomaxs.hystrix.config.FeignConfiguration;
import com.db.chaomaxs.searchservice.rpc.position.facade.api.PositionEsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author momo
 * @date 2021-04-22 14:03
 */
@FeignClient(value = "${chaomax.search.serviceId}", configuration = {FeignConfiguration.class})
public interface PositionEsRpcFacade extends PositionEsApi {

}

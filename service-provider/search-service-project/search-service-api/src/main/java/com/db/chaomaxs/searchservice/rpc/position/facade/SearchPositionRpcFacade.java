package com.db.chaomaxs.searchservice.rpc.position.facade;

import com.db.chaomaxs.hystrix.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.db.chaomaxs.searchservice.rpc.position.facade.api.SearchPositionApi;

/**
 * SearchPositionRpcFacade
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/28 16:36
 */
@FeignClient(value = "${chaomax.search.serviceId}", configuration = {FeignConfiguration.class})
public interface SearchPositionRpcFacade extends SearchPositionApi {

}

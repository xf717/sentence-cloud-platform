package com.db.chaomaxs.positionservice.rpc.positiontype.facade;

import com.db.chaomaxs.positionservice.rpc.positiontype.facade.api.PositionKeywordExtendApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 职务关键词-扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@FeignClient(value = "${chaomax.position.serviceId}",configuration = {})
public interface PositionKeywordExtendRpcFacade extends PositionKeywordExtendApi {
}

package com.db.chaomaxs.positionservice.rpc.positiontype.facade;

import com.db.chaomaxs.positionservice.rpc.positiontype.facade.api.PositionKeywordApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 内容管理-职位关键词信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@FeignClient(value = "${chaomax.position.serviceId}",configuration = {})
public interface PositionKeywordRpcFacade extends PositionKeywordApi {
}

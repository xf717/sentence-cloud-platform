package com.db.chaomaxs.positionservice.rpc.positiontype.facade;

import com.db.chaomaxs.positionservice.rpc.positiontype.facade.api.PositionTypeApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 职务职位分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@FeignClient(value = "${chaomax.position.serviceId}",configuration = {})
public interface PositionTypeRpcFacade extends PositionTypeApi {
}

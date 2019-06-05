package com.maruko.mall.user.server.client.facade;

import com.maruko.mall.user.server.client.facade.api.IUserIntegralFacade;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_积分表
 *
 * @author xiaofeng
 * @date 2019-06-04 22:35:12
 */
@FeignClient(value = "${maruko-mall-user-server}")
public interface IUserIntegralFeignClientFacade extends IUserIntegralFacade {
}

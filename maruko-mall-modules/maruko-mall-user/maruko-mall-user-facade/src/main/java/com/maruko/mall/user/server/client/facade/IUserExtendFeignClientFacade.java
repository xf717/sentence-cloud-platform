package com.maruko.mall.user.server.client.facade;

import com.maruko.mall.user.server.client.facade.api.IUserExtendFacade;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户_扩展表
 *
 * @author xiaofeng
 * @date 2019-06-04 22:35:12
 */
@FeignClient(value = "${maruko-mall-user-server}")
public interface IUserExtendFeignClientFacade extends IUserExtendFacade {
}

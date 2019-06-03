package com.maruko.mall.security.gate.feign;

import com.maruko.mall.security.gate.fallback.UserServiceFallback;
import com.maruko.mall.security.api.vo.authority.PermissionInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-21 8:11
 */
@FeignClient(value = "maruko-mall-admin", fallback = UserServiceFallback.class)
public interface IUserService {
	@RequestMapping(value = "/api/user/un/{username}/permissions", method = RequestMethod.GET)
	public List<PermissionInfo> getPermissionByUsername(@PathVariable("username") String username);

	@RequestMapping(value = "/api/permissions", method = RequestMethod.GET)
	List<PermissionInfo> getAllPermissionInfo();
}

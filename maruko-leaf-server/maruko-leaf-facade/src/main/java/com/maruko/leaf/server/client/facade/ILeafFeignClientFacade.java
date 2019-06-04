package com.maruko.leaf.server.client.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 声明式调用接口
 * @author xiaofeng
 */
@FeignClient(value = "${maruko-leaf-server}")
public interface ILeafFeignClientFacade {


	/**
	 * 号段模式
	 * @param key
	 * @return
	 */
	@GetMapping(value = "/api/segment/get/{key}")
	String getSegmentID(@PathVariable("key") String key);

	/**
	 * Snowflake模式
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/api/snowflake/get/{key}")
	String getSnowflakeID(@PathVariable("key") String key);

}

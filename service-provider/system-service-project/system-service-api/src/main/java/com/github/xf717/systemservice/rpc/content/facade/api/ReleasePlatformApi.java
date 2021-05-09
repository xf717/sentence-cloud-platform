package com.github.xf717.systemservice.rpc.content.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformUpdateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 发布平台
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
public interface ReleasePlatformApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/releasePlatform/save")
	BaseResponse save(@RequestBody ReleasePlatformCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/releasePlatform/update")
	BaseResponse update(@RequestBody ReleasePlatformUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/releasePlatform/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/releasePlatform/get/{id}")
	ObjectRestResponse<ReleasePlatformRespDTO> getReleasePlatformById(@PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/releasePlatform/list")
	ObjectRestResponse<List<ReleasePlatformRespDTO>> listReleasePlatforms(
      @RequestBody ReleasePlatformListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/releasePlatform/page")
	TableResultResponse<ReleasePlatformRespDTO> page(
      @RequestBody ReleasePlatformPageReqDTO pageReqDTO);

}

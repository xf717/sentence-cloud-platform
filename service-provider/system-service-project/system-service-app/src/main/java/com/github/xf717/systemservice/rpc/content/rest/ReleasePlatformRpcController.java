package com.github.xf717.systemservice.rpc.content.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.content.ReleasePlatformRpcImpl;
import com.github.xf717.systemservice.rpc.content.facade.api.ReleasePlatformApi;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformUpdateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发布平台
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@RestController
public class ReleasePlatformRpcController implements ReleasePlatformApi {

	@Autowired
	private ReleasePlatformRpcImpl releasePlatformRpc;

	@Override
	public BaseResponse save(@RequestBody ReleasePlatformCreateReqDTO createReqDTO) {
		return releasePlatformRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody ReleasePlatformUpdateReqDTO updateReqDTO) {
		return releasePlatformRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return releasePlatformRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<ReleasePlatformRespDTO> getReleasePlatformById(@PathVariable("id") Long id) {
		return releasePlatformRpc.getReleasePlatformById(id);
	}

	@Override
	public ObjectRestResponse<List<ReleasePlatformRespDTO>> listReleasePlatforms(@RequestBody ReleasePlatformListQueryReqDTO listQuery) {
		return releasePlatformRpc.listReleasePlatforms(listQuery);
	}

	@Override
	public TableResultResponse<ReleasePlatformRespDTO> page(@RequestBody ReleasePlatformPageReqDTO pageReqDTO) {
		return releasePlatformRpc.page(pageReqDTO);
	}
}

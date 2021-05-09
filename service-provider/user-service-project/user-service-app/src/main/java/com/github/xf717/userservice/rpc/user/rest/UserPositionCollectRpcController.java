package com.github.xf717.userservice.rpc.user.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.UserPositionCollectRpcImpl;
import com.github.xf717.userservice.rpc.user.facade.api.UserPositionCollectApi;
import com.github.xf717.userservice.rpc.user.dto.UserPositionCollectCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPositionCollectRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPositionCollectPageReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_职位_收藏
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@RestController
public class UserPositionCollectRpcController implements UserPositionCollectApi {

	@Autowired
	private UserPositionCollectRpcImpl userPositionCollectRpc;

	@Override
	public BaseResponse save(@RequestBody UserPositionCollectCreateReqDTO createReqDTO) {
		return userPositionCollectRpc.save(createReqDTO);
	}


	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userPositionCollectRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserPositionCollectRespDTO> getUserPositionCollectById(@PathVariable("id") Long id) {
		return userPositionCollectRpc.getUserPositionCollectById(id);
	}


	@Override
	public TableResultResponse<UserPositionCollectRespDTO> page(@RequestBody UserPositionCollectPageReqDTO pageReqDTO) {
		return userPositionCollectRpc.page(pageReqDTO);
	}
}

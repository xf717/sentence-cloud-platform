package com.github.xf717.userservice.rpc.user.rest;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.UserTrackRpcImpl;
import com.github.xf717.userservice.rpc.user.dto.UserPositionRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackRespDTO;
import com.github.xf717.userservice.rpc.user.facade.api.UserTrackApi;
import com.github.xf717.userservice.rpc.user.dto.UserTrackCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackPageReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 我的足迹
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@RestController
public class UserTrackRpcController implements UserTrackApi {

	@Autowired
	private UserTrackRpcImpl userTrackRpc;

	@Override
	public BaseResponse save(@RequestBody UserTrackCreateReqDTO createReqDTO) {
		return userTrackRpc.save(createReqDTO);
	}


	@Override
	public TableResultResponse<UserTrackRespDTO> page(@RequestBody UserTrackPageReqDTO pageReqDTO) {
		return userTrackRpc.page(pageReqDTO);
	}
}

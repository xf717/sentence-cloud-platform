package com.github.xf717.userservice.rpc.user.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.rpc.user.UserPointRpcImpl;
import com.github.xf717.userservice.rpc.user.facade.api.UserPointApi;
import com.github.xf717.userservice.rpc.user.dto.UserPointCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPointRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPointUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPointListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPointPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_积分表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@RestController
public class UserPointRpcController implements UserPointApi {

	@Autowired
	private UserPointRpcImpl userPointRpc;

	@Override
	public BaseResponse save(@RequestBody UserPointCreateReqDTO createReqDTO) {
		return userPointRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserPointUpdateReqDTO updateReqDTO) {
		return userPointRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userPointRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserPointRespDTO> getUserPointById(@PathVariable("id") Long id) {
		return userPointRpc.getUserPointById(id);
	}

	@Override
	public ObjectRestResponse<List<UserPointRespDTO>> listUserPoints(@RequestBody UserPointListQueryReqDTO listQuery) {
		return userPointRpc.listUserPoints(listQuery);
	}

	@Override
	public TableResultResponse<UserPointRespDTO> page(@RequestBody UserPointPageReqDTO pageReqDTO) {
		return userPointRpc.page(pageReqDTO);
	}
}

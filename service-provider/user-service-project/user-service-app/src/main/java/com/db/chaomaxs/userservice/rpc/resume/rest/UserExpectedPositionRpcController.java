package com.db.chaomaxs.userservice.rpc.resume.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.userservice.rpc.resume.UserExpectedPositionRpcImpl;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedAndStatusRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.facade.api.UserExpectedPositionApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_期望职位
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@RestController
public class UserExpectedPositionRpcController implements UserExpectedPositionApi {

	@Autowired
	private UserExpectedPositionRpcImpl userExpectedPositionRpc;

	@Override
	public BaseResponse save(@RequestBody UserExpectedPositionCreateReqDTO createReqDTO) {
		return userExpectedPositionRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserExpectedPositionUpdateReqDTO updateReqDTO) {
		return userExpectedPositionRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userExpectedPositionRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserExpectedPositionRespDTO> getUserExpectedPositionById(@PathVariable("id") Long id) {
		return userExpectedPositionRpc.getUserExpectedPositionById(id);
	}

	@Override
	public ObjectRestResponse<UserExpectedAndStatusRespDTO> getUserExpectedAndStatusByUserId(@PathVariable("userId") Long userId){
		return userExpectedPositionRpc.getUserExpectedAndStatusByUserId(userId);
	}
}

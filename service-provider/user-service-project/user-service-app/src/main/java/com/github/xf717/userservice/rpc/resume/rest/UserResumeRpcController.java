package com.github.xf717.userservice.rpc.resume.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userservice.rpc.resume.UserResumeRpcImpl;
import com.github.xf717.userservice.rpc.resume.dto.UserIdsReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeDetailRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.facade.api.UserResumeApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@RestController
public class UserResumeRpcController implements UserResumeApi {

	@Autowired
	private UserResumeRpcImpl userResumeRpc;

	@Override
	public BaseResponse save(@RequestBody UserResumeCreateReqDTO createReqDTO) {
		return userResumeRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserResumeUpdateReqDTO updateReqDTO) {
		return userResumeRpc.update(updateReqDTO);
	}


	@Override
	public ObjectRestResponse<UserResumeRespDTO> getUserResumeById(@PathVariable("userId") Long userId) {
		return userResumeRpc.getUserResumeById(userId);
	}

	@Override
	public ObjectRestResponse<List<UserResumeDetailRespDTO>> getResumeDetailByUserIds(
			@RequestBody UserIdsReqDTO userIdsReqDTO) {
		return userResumeRpc.getResumeDetailByUserIds(userIdsReqDTO);
	}

}

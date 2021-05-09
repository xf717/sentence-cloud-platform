package com.github.xf717.userservice.rpc.resume.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.resume.UserEduExperienceRpcImpl;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperiencePageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.facade.api.UserEduExperienceApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_教育经历表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@RestController
public class UserEduExperienceRpcController implements UserEduExperienceApi {

	@Autowired
	private UserEduExperienceRpcImpl userEduExperienceRpc;

	@Override
	public BaseResponse save(@RequestBody UserEduExperienceCreateReqDTO createReqDTO) {
		return userEduExperienceRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserEduExperienceUpdateReqDTO updateReqDTO) {
		return userEduExperienceRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userEduExperienceRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserEduExperienceRespDTO> getUserEduExperienceById(@PathVariable("id") Long id) {
		return userEduExperienceRpc.getUserEduExperienceById(id);
	}

	@Override
	public ObjectRestResponse<List<UserEduExperienceRespDTO>> listUserEduExperiences(@RequestBody UserEduExperienceListQueryReqDTO listQuery) {
		return userEduExperienceRpc.listUserEduExperiences(listQuery);
	}

	@Override
	public TableResultResponse<UserEduExperienceRespDTO> page(@RequestBody UserEduExperiencePageReqDTO pageReqDTO) {
		return userEduExperienceRpc.page(pageReqDTO);
	}

	@Override
	public ObjectRestResponse<UserEduExperienceRespDTO> getLastStepByUserId(@PathVariable("userId") Long userId) {
		return userEduExperienceRpc.getLastStepByUserId(userId);
	}
}

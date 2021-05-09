package com.github.xf717.userservice.rpc.resume.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.resume.UserWorkExperienceRpcImpl;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperiencePageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.facade.api.UserWorkExperienceApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_工作经历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@RestController
public class UserWorkExperienceRpcController implements UserWorkExperienceApi {

	@Autowired
	private UserWorkExperienceRpcImpl userWorkExperienceRpc;

	@Override
	public BaseResponse save(@RequestBody UserWorkExperienceCreateReqDTO createReqDTO) {
		return userWorkExperienceRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserWorkExperienceUpdateReqDTO updateReqDTO) {
		return userWorkExperienceRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userWorkExperienceRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserWorkExperienceRespDTO> getUserWorkExperienceById(@PathVariable("id") Long id) {
		return userWorkExperienceRpc.getUserWorkExperienceById(id);
	}

	@Override
	public ObjectRestResponse<List<UserWorkExperienceRespDTO>> listUserWorkExperiences(@RequestBody UserWorkExperienceListQueryReqDTO listQuery) {
		return userWorkExperienceRpc.listUserWorkExperiences(listQuery);
	}

	@Override
	public TableResultResponse<UserWorkExperienceRespDTO> page(@RequestBody UserWorkExperiencePageReqDTO pageReqDTO) {
		return userWorkExperienceRpc.page(pageReqDTO);
	}

	@Override
	public ObjectRestResponse<UserWorkExperienceRespDTO> getLastStepByUserId(@PathVariable("userId") Long userId) {
		return userWorkExperienceRpc.getUserWorkExperienceById(userId);
	}
}

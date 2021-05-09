package com.github.xf717.userservice.rpc.resume.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.resume.UserEnclosureResumeRpcImpl;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumeCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumePageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumeRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumeUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.facade.api.UserEnclosureResumeApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_附件_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@RestController
public class UserEnclosureResumeRpcController implements UserEnclosureResumeApi {

	@Autowired
	private UserEnclosureResumeRpcImpl userEnclosureResumeRpc;

	@Override
	public BaseResponse save(@RequestBody UserEnclosureResumeCreateReqDTO createReqDTO) {
		return userEnclosureResumeRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserEnclosureResumeUpdateReqDTO updateReqDTO) {
		return userEnclosureResumeRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userEnclosureResumeRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserEnclosureResumeRespDTO> getUserEnclosureResumeById(@PathVariable("id") Long id) {
		return userEnclosureResumeRpc.getUserEnclosureResumeById(id);
	}

	@Override
	public ObjectRestResponse<List<UserEnclosureResumeRespDTO>> listUserEnclosureResumes(@PathVariable("userId") Long userId) {
		return userEnclosureResumeRpc.listUserEnclosureResumes(userId);
	}

	@Override
	public TableResultResponse<UserEnclosureResumeRespDTO> page(@RequestBody UserEnclosureResumePageReqDTO pageReqDTO) {
		return userEnclosureResumeRpc.page(pageReqDTO);
	}
}

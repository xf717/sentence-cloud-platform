package com.db.chaomaxs.userservice.rpc.resume.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.rpc.resume.UserProjectExperienceRpcImpl;
import com.db.chaomaxs.userservice.rpc.resume.facade.api.UserProjectExperienceApi;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperiencePageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_项目经历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@RestController
public class UserProjectExperienceRpcController implements UserProjectExperienceApi {

	@Autowired
	private UserProjectExperienceRpcImpl userProjectExperienceRpc;

	@Override
	public BaseResponse save(@RequestBody UserProjectExperienceCreateReqDTO createReqDTO) {
		return userProjectExperienceRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserProjectExperienceUpdateReqDTO updateReqDTO) {
		return userProjectExperienceRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userProjectExperienceRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserProjectExperienceRespDTO> getUserProjectExperienceById(@PathVariable("id") Long id) {
		return userProjectExperienceRpc.getUserProjectExperienceById(id);
	}

	@Override
	public ObjectRestResponse<List<UserProjectExperienceRespDTO>> listUserProjectExperiences(@RequestBody UserProjectExperienceListQueryReqDTO listQuery) {
		return userProjectExperienceRpc.listUserProjectExperiences(listQuery);
	}

	@Override
	public TableResultResponse<UserProjectExperienceRespDTO> page(@RequestBody UserProjectExperiencePageReqDTO pageReqDTO) {
		return userProjectExperienceRpc.page(pageReqDTO);
	}
}

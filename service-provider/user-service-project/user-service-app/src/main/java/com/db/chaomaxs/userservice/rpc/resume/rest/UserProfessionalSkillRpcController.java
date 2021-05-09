package com.db.chaomaxs.userservice.rpc.resume.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.rpc.resume.UserProfessionalSkillRpcImpl;
import com.db.chaomaxs.userservice.rpc.resume.facade.api.UserProfessionalSkillApi;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProfessionalSkillCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProfessionalSkillRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProfessionalSkillUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProfessionalSkillListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProfessionalSkillPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_专业技能表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@RestController
public class UserProfessionalSkillRpcController implements UserProfessionalSkillApi {

	@Autowired
	private UserProfessionalSkillRpcImpl userProfessionalSkillRpc;

	@Override
	public BaseResponse save(@RequestBody UserProfessionalSkillCreateReqDTO createReqDTO) {
		return userProfessionalSkillRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserProfessionalSkillUpdateReqDTO updateReqDTO) {
		return userProfessionalSkillRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userProfessionalSkillRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserProfessionalSkillRespDTO> getUserProfessionalSkillById(@PathVariable("id") Long id) {
		return userProfessionalSkillRpc.getUserProfessionalSkillById(id);
	}

	@Override
	public ObjectRestResponse<List<UserProfessionalSkillRespDTO>> listUserProfessionalSkills(@RequestBody UserProfessionalSkillListQueryReqDTO listQuery) {
		return userProfessionalSkillRpc.listUserProfessionalSkills(listQuery);
	}

	@Override
	public TableResultResponse<UserProfessionalSkillRespDTO> page(@RequestBody UserProfessionalSkillPageReqDTO pageReqDTO) {
		return userProfessionalSkillRpc.page(pageReqDTO);
	}
}

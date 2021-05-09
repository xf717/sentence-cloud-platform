package com.github.xf717.userservice.rpc.user.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.rpc.user.UserRecruitExtendRpcImpl;
import com.github.xf717.userservice.rpc.user.facade.api.UserRecruitExtendApi;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitExtendCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitExtendRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitExtendUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitExtendListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitExtendPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_招聘_扩展表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:54:37
 */
@RestController
public class UserRecruitExtendRpcController implements UserRecruitExtendApi {

	@Autowired
	private UserRecruitExtendRpcImpl userRecruitExtendRpc;

	@Override
	public BaseResponse save(@RequestBody UserRecruitExtendCreateReqDTO createReqDTO) {
		return userRecruitExtendRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserRecruitExtendUpdateReqDTO updateReqDTO) {
		return userRecruitExtendRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userRecruitExtendRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserRecruitExtendRespDTO> getUserRecruitExtendById(@PathVariable("id") Long id) {
		return userRecruitExtendRpc.getUserRecruitExtendById(id);
	}

	@Override
	public ObjectRestResponse<List<UserRecruitExtendRespDTO>> listUserRecruitExtends(@RequestBody UserRecruitExtendListQueryReqDTO listQuery) {
		return userRecruitExtendRpc.listUserRecruitExtends(listQuery);
	}

	@Override
	public TableResultResponse<UserRecruitExtendRespDTO> page(@RequestBody UserRecruitExtendPageReqDTO pageReqDTO) {
		return userRecruitExtendRpc.page(pageReqDTO);
	}
}

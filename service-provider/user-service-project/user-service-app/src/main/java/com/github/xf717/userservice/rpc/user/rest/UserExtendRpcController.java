package com.github.xf717.userservice.rpc.user.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.UserExtendRpcImpl;
import com.github.xf717.userservice.rpc.user.dto.UserExtendCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendDetailRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendDetailReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendUpdateEnableHideReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.facade.api.UserExtendApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_基础信息扩展表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@RestController
public class UserExtendRpcController implements UserExtendApi {

	@Autowired
	private UserExtendRpcImpl userExtendRpc;

	@Override
	public BaseResponse save(@RequestBody UserExtendCreateReqDTO createReqDTO) {
		return userExtendRpc.save(createReqDTO);
	}


	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userExtendRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserExtendRespDTO> getUserExtendByUserId(@PathVariable("userId") Long userId){
		return userExtendRpc.getUserExtendByUserId(userId);
	}


	@Override
	public ObjectRestResponse<List<UserExtendRespDTO>> listUserExtends(@RequestBody UserExtendListQueryReqDTO listQuery) {
		return userExtendRpc.listUserExtends(listQuery);
	}

	@Override
	public TableResultResponse<UserExtendRespDTO> page(@RequestBody UserExtendPageReqDTO pageReqDTO) {
		return userExtendRpc.page(pageReqDTO);
	}

	@Override
	public ObjectRestResponse<List<UserExtendDetailRespDTO>> listUserExtendByUserIds(
			@RequestBody UserExtendDetailReqDTO userExtendDetailReqDTO){
		return userExtendRpc.listUserExtendByUserIds(userExtendDetailReqDTO);
	}

	@Override
	public BaseResponse updateEnableHideDTO(@RequestBody UserExtendUpdateEnableHideReqDTO updateEnableHideReqDTO) {
		return userExtendRpc.updateEnableHideDTO(updateEnableHideReqDTO);
	}

	@Override
	public BaseResponse updateUserRecruitInfo(@RequestBody UserRecruitUpdateReqDTO userRecruitUpdateReqDTO) {
		return userExtendRpc.updateUserRecruitInfo(userRecruitUpdateReqDTO);
	}

	@Override
	public ObjectRestResponse<UserExtendDetailRespDTO> getUserExtendInfo(
			@PathVariable("userId") Long userId){
		return userExtendRpc.getUserExtendInfo(userId);
	}
}

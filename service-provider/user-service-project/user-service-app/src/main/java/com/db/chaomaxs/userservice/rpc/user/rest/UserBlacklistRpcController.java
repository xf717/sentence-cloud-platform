package com.db.chaomaxs.userservice.rpc.user.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.rpc.user.UserBlacklistRpcImpl;
import com.db.chaomaxs.userservice.rpc.user.facade.api.UserBlacklistApi;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_黑名单
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@RestController
public class UserBlacklistRpcController implements UserBlacklistApi {

	@Autowired
	private UserBlacklistRpcImpl userBlacklistRpc;

	@Override
	public BaseResponse save(@RequestBody UserBlacklistCreateReqDTO createReqDTO) {
		return userBlacklistRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserBlacklistUpdateReqDTO updateReqDTO) {
		return userBlacklistRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userBlacklistRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserBlacklistRespDTO> getUserBlacklistById(@PathVariable("id") Long id) {
		return userBlacklistRpc.getUserBlacklistById(id);
	}

	@Override
	public ObjectRestResponse<List<UserBlacklistRespDTO>> listUserBlacklists(@RequestBody UserBlacklistListQueryReqDTO listQuery) {
		return userBlacklistRpc.listUserBlacklists(listQuery);
	}

	@Override
	public TableResultResponse<UserBlacklistRespDTO> page(@RequestBody UserBlacklistPageReqDTO pageReqDTO) {
		return userBlacklistRpc.page(pageReqDTO);
	}
}

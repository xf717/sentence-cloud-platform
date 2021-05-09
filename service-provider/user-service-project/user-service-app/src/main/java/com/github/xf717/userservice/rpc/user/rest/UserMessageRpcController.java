package com.github.xf717.userservice.rpc.user.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.rpc.user.UserMessageRpcImpl;
import com.github.xf717.userservice.rpc.user.facade.api.UserMessageApi;
import com.github.xf717.userservice.rpc.user.dto.UserMessageCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserMessageRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserMessageUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserMessageListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserMessagePageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户消息表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@RestController
public class UserMessageRpcController implements UserMessageApi {

	@Autowired
	private UserMessageRpcImpl userMessageRpc;

	@Override
	public BaseResponse save(@RequestBody UserMessageCreateReqDTO createReqDTO) {
		return userMessageRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserMessageUpdateReqDTO updateReqDTO) {
		return userMessageRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userMessageRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserMessageRespDTO> getUserMessageById(@PathVariable("id") Long id) {
		return userMessageRpc.getUserMessageById(id);
	}

	@Override
	public ObjectRestResponse<List<UserMessageRespDTO>> listUserMessages(@RequestBody UserMessageListQueryReqDTO listQuery) {
		return userMessageRpc.listUserMessages(listQuery);
	}

	@Override
	public TableResultResponse<UserMessageRespDTO> page(@RequestBody UserMessagePageReqDTO pageReqDTO) {
		return userMessageRpc.page(pageReqDTO);
	}
}

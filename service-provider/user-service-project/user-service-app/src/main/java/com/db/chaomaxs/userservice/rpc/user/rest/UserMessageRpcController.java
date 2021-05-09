package com.db.chaomaxs.userservice.rpc.user.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.rpc.user.UserMessageRpcImpl;
import com.db.chaomaxs.userservice.rpc.user.facade.api.UserMessageApi;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessagePageReqDTO;
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

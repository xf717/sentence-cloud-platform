package com.db.chaomaxs.userservice.rpc.user.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.user.UserInterviewRpcImpl;
import com.db.chaomaxs.userservice.rpc.user.facade.api.UserInterviewApi;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户面试表
 *
 * @author momo
 * @date 2021-04-02 13:58:28
 */
@RestController
public class UserInterviewRpcController implements UserInterviewApi {

	@Autowired
	private UserInterviewRpcImpl userInterviewRpc;

	@Override
	public BaseResponse save(@RequestBody UserInterviewCreateReqDTO createReqDTO) {
		return userInterviewRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserInterviewUpdateReqDTO updateReqDTO) {
		return userInterviewRpc.update(updateReqDTO);
	}

	@Override
	public ObjectRestResponse<UserInterviewRespDTO> getUserInterviewById(@PathVariable("id") Long id) {
		return userInterviewRpc.getUserInterviewById(id);
	}

	@Override
	public TableResultResponse<UserInterviewRespDTO> page(@RequestBody UserInterviewPageReqDTO pageReqDTO) {
		return userInterviewRpc.page(pageReqDTO);
	}
}

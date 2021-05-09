package com.github.xf717.userservice.rpc.resume.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.resume.UserCredentialRpcImpl;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialPageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.facade.api.UserCredentialApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_资格证书表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@RestController
public class UserCredentialRpcController implements UserCredentialApi {

	@Autowired
	private UserCredentialRpcImpl userCredentialRpc;

	@Override
	public BaseResponse save(@RequestBody UserCredentialCreateReqDTO createReqDTO) {
		return userCredentialRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserCredentialUpdateReqDTO updateReqDTO) {
		return userCredentialRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userCredentialRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserCredentialRespDTO> getUserCredentialById(@PathVariable("id") Long id) {
		return userCredentialRpc.getUserCredentialById(id);
	}

	@Override
	public ObjectRestResponse<List<UserCredentialRespDTO>> listUserCredentials(@RequestBody UserCredentialListQueryReqDTO listQuery) {
		return userCredentialRpc.listUserCredentials(listQuery);
	}

	@Override
	public TableResultResponse<UserCredentialRespDTO> page(@RequestBody UserCredentialPageReqDTO pageReqDTO) {
		return userCredentialRpc.page(pageReqDTO);
	}
}

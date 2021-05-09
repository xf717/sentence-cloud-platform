package com.github.xf717.userservice.rpc.user.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.UserBindingCompanyRpcImpl;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingExtendRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingInfoRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingStateUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingTransferReqDTO;
import com.github.xf717.userservice.rpc.user.facade.api.UserBindingCompanyApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_企业绑定
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@RestController
public class UserBindingCompanyRpcController implements UserBindingCompanyApi {

	@Autowired
	private UserBindingCompanyRpcImpl userBindingCompanyRpc;

	@Override
	public BaseResponse save(@RequestBody UserBindingCompanyCreateReqDTO createReqDTO) {
		return userBindingCompanyRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserBindingCompanyUpdateReqDTO updateReqDTO) {
		return userBindingCompanyRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userBindingCompanyRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserBindingCompanyRespDTO> getUserBindingCompanyById(@PathVariable("id") Long id) {
		return userBindingCompanyRpc.getUserBindingCompanyById(id);
	}

	@Override
	public ObjectRestResponse<List<UserBindingCompanyRespDTO>> listUserBindingCompanys(@RequestBody UserBindingCompanyListQueryReqDTO listQuery) {
		return userBindingCompanyRpc.listUserBindingCompanys(listQuery);
	}

	@Override
	public TableResultResponse<UserBindingInfoRespDTO> page(@RequestBody UserBindingCompanyPageReqDTO pageReqDTO) {
		return userBindingCompanyRpc.page(pageReqDTO);
	}

	@Override
	public BaseResponse updateBindingState(@RequestBody UserBindingStateUpdateReqDTO bindingStateUpdateReqDTO) {
		return userBindingCompanyRpc.updateBindingState(bindingStateUpdateReqDTO);
	}

	@Override
	public ObjectRestResponse<List<UserBindingExtendRespDTO>> getAllBindingUser(@RequestParam("companyId") Long companyId) {
		return userBindingCompanyRpc.getAllBindingUser(companyId);
	}

	@Override
	public BaseResponse managerTransfer(@RequestBody UserBindingTransferReqDTO userBindingTransferReqDTO) {
		return userBindingCompanyRpc.managerTransfer(userBindingTransferReqDTO);
	}

	@Override
	public BaseResponse handover(@RequestBody UserBindingTransferReqDTO userBindingTransferReqDTO) {
		return userBindingCompanyRpc.handover(userBindingTransferReqDTO);
	}


}

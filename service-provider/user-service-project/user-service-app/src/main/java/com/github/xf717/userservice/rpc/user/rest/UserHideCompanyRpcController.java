package com.github.xf717.userservice.rpc.user.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.UserHideCompanyRpcImpl;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyBatchInsertReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyRespDTO;
import com.github.xf717.userservice.rpc.user.facade.api.UserHideCompanyApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_屏蔽公司
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@RestController
public class UserHideCompanyRpcController implements UserHideCompanyApi {

	@Autowired
	private UserHideCompanyRpcImpl userHideCompanyRpc;

	@Override
	public BaseResponse save(@RequestBody UserHideCompanyBatchInsertReqDTO batchInsertReqDTO) {
		return userHideCompanyRpc.save(batchInsertReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userHideCompanyRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserHideCompanyRespDTO> getUserHideCompanyById(@PathVariable("id") Long id) {
		return userHideCompanyRpc.getUserHideCompanyById(id);
	}

	@Override
	public ObjectRestResponse<List<UserHideCompanyRespDTO>> listUserHideCompanys(@RequestBody UserHideCompanyListQueryReqDTO listQuery) {
		return userHideCompanyRpc.listUserHideCompanys(listQuery);
	}

	@Override
	public TableResultResponse<UserHideCompanyRespDTO> page(@RequestBody UserHideCompanyPageReqDTO pageReqDTO) {
		return userHideCompanyRpc.page(pageReqDTO);
	}
}

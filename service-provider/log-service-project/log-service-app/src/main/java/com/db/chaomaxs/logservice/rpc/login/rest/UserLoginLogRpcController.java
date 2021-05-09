package com.db.chaomaxs.logservice.rpc.login.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.logservice.rpc.login.UserLoginLogRpcImpl;
import com.db.chaomaxs.logservice.rpc.sms.facade.api.UserLoginLogApi;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogCreateReqDTO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogRespDTO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogUpdateReqDTO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogListQueryReqDTO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_登录日志
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:03
 */
@RestController
public class UserLoginLogRpcController implements UserLoginLogApi {

	@Autowired
	private UserLoginLogRpcImpl userLoginLogRpc;

	@Override
	public BaseResponse save(@RequestBody UserLoginLogCreateReqDTO createReqDTO) {
		return userLoginLogRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserLoginLogUpdateReqDTO updateReqDTO) {
		return userLoginLogRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userLoginLogRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserLoginLogRespDTO> getUserLoginLogById(@PathVariable("id") Long id) {
		return userLoginLogRpc.getUserLoginLogById(id);
	}

	@Override
	public ObjectRestResponse<List<UserLoginLogRespDTO>> listUserLoginLogs(@RequestBody UserLoginLogListQueryReqDTO listQuery) {
		return userLoginLogRpc.listUserLoginLogs(listQuery);
	}

	@Override
	public TableResultResponse<UserLoginLogRespDTO> page(@RequestBody UserLoginLogPageReqDTO pageReqDTO) {
		return userLoginLogRpc.page(pageReqDTO);
	}
}

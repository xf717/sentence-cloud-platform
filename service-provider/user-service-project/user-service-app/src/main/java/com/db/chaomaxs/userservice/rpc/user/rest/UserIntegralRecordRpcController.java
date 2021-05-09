package com.db.chaomaxs.userservice.rpc.user.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.user.UserIntegralRecordRpcImpl;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.api.UserIntegralRecordApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 记录用户签到记录信息
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@RestController
public class UserIntegralRecordRpcController implements UserIntegralRecordApi {

	@Autowired
	private UserIntegralRecordRpcImpl userIntegralRecordRpc;

	@Override
	public BaseResponse save(@RequestBody UserIntegralRecordCreateReqDTO createReqDTO) {
		return userIntegralRecordRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserIntegralRecordUpdateReqDTO updateReqDTO) {
		return userIntegralRecordRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userIntegralRecordRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserIntegralRecordRespDTO> getUserIntegralRecordById(@PathVariable("id") Long id) {
		return userIntegralRecordRpc.getUserIntegralRecordById(id);
	}

	@Override
	public ObjectRestResponse<List<UserIntegralRecordRespDTO>> listUserIntegralRecords(@RequestBody UserIntegralRecordListQueryReqDTO listQuery) {
		return userIntegralRecordRpc.listUserIntegralRecords(listQuery);
	}

	@Override
	public TableResultResponse<UserIntegralRecordRespDTO> page(@RequestBody UserIntegralRecordPageReqDTO pageReqDTO) {
		return userIntegralRecordRpc.page(pageReqDTO);
	}

	@Override
	public BaseResponse sign(@PathVariable("userId") Long userId){
		return userIntegralRecordRpc.sign(userId);
	}
}

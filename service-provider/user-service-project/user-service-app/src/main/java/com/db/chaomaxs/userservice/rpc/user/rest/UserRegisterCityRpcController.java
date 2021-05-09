package com.db.chaomaxs.userservice.rpc.user.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.rpc.user.UserRegisterCityRpcImpl;
import com.db.chaomaxs.userservice.rpc.user.facade.api.UserRegisterCityApi;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册城市表，注册时保存
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@RestController
public class UserRegisterCityRpcController implements UserRegisterCityApi {

	@Autowired
	private UserRegisterCityRpcImpl userRegisterCityRpc;

	@Override
	public BaseResponse save(@RequestBody UserRegisterCityCreateReqDTO createReqDTO) {
		return userRegisterCityRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserRegisterCityUpdateReqDTO updateReqDTO) {
		return userRegisterCityRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userRegisterCityRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserRegisterCityRespDTO> getUserRegisterCityById(@PathVariable("id") Long id) {
		return userRegisterCityRpc.getUserRegisterCityById(id);
	}

	@Override
	public ObjectRestResponse<List<UserRegisterCityRespDTO>> listUserRegisterCitys(@RequestBody UserRegisterCityListQueryReqDTO listQuery) {
		return userRegisterCityRpc.listUserRegisterCitys(listQuery);
	}

	@Override
	public TableResultResponse<UserRegisterCityRespDTO> page(@RequestBody UserRegisterCityPageReqDTO pageReqDTO) {
		return userRegisterCityRpc.page(pageReqDTO);
	}
}

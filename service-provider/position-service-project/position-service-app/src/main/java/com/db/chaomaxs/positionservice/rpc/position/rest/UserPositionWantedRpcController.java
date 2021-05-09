package com.db.chaomaxs.positionservice.rpc.position.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.positionservice.rpc.position.UserPositionWantedRpcImpl;
import com.db.chaomaxs.positionservice.rpc.position.facade.api.UserPositionWantedApi;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户求职
 *
 * @author xiaofeng
 * @date 2021-03-29 16:36:57
 */
@RestController
public class UserPositionWantedRpcController implements UserPositionWantedApi {

	@Autowired
	private UserPositionWantedRpcImpl userPositionWantedRpc;

	@Override
	public BaseResponse save(@RequestBody UserPositionWantedCreateReqDTO createReqDTO) {
		return userPositionWantedRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserPositionWantedUpdateReqDTO updateReqDTO) {
		return userPositionWantedRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return userPositionWantedRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<UserPositionWantedRespDTO> getUserPositionWantedById(@PathVariable("id") Long id) {
		return userPositionWantedRpc.getUserPositionWantedById(id);
	}

	@Override
	public ObjectRestResponse<List<UserPositionWantedRespDTO>> listUserPositionWanteds(@RequestBody UserPositionWantedListQueryReqDTO listQuery) {
		return userPositionWantedRpc.listUserPositionWanteds(listQuery);
	}

	@Override
	public TableResultResponse<UserPositionWantedRespDTO> page(@RequestBody UserPositionWantedPageReqDTO pageReqDTO) {
		return userPositionWantedRpc.page(pageReqDTO);
	}
}

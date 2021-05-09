package com.db.chaomaxs.positionservice.rpc.positiontype.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.positionservice.rpc.positiontype.PositionKeywordExtendRpcImpl;
import com.db.chaomaxs.positionservice.rpc.positiontype.facade.api.PositionKeywordExtendApi;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 职务关键词-扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@RestController
public class PositionKeywordExtendRpcController implements PositionKeywordExtendApi {

	@Autowired
	private PositionKeywordExtendRpcImpl positionKeywordExtendRpc;

	@Override
	public BaseResponse save(@RequestBody PositionKeywordExtendCreateReqDTO createReqDTO) {
		return positionKeywordExtendRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody PositionKeywordExtendUpdateReqDTO updateReqDTO) {
		return positionKeywordExtendRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return positionKeywordExtendRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<PositionKeywordExtendRespDTO> getPositionKeywordExtendById(@PathVariable("id") Long id) {
		return positionKeywordExtendRpc.getPositionKeywordExtendById(id);
	}

	@Override
	public ObjectRestResponse<List<PositionKeywordExtendRespDTO>> listPositionKeywordExtends(@RequestBody PositionKeywordExtendListQueryReqDTO listQuery) {
		return positionKeywordExtendRpc.listPositionKeywordExtends(listQuery);
	}

	@Override
	public TableResultResponse<PositionKeywordExtendRespDTO> page(@RequestBody PositionKeywordExtendPageReqDTO pageReqDTO) {
		return positionKeywordExtendRpc.page(pageReqDTO);
	}
}

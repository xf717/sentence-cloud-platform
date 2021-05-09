package com.db.chaomaxs.positionservice.rpc.positiontype.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.positionservice.rpc.positiontype.PositionKeywordRpcImpl;
import com.db.chaomaxs.positionservice.rpc.positiontype.facade.api.PositionKeywordApi;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 内容管理-职位关键词信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@RestController
public class PositionKeywordRpcController implements PositionKeywordApi {

	@Autowired
	private PositionKeywordRpcImpl positionKeywordRpc;

	@Override
	public BaseResponse save(@RequestBody PositionKeywordCreateReqDTO createReqDTO) {
		return positionKeywordRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody PositionKeywordUpdateReqDTO updateReqDTO) {
		return positionKeywordRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return positionKeywordRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<PositionKeywordRespDTO> getPositionKeywordById(@PathVariable("id") Long id) {
		return positionKeywordRpc.getPositionKeywordById(id);
	}

	@Override
	public ObjectRestResponse<List<PositionKeywordRespDTO>> listPositionKeywords(@RequestBody PositionKeywordListQueryReqDTO listQuery) {
		return positionKeywordRpc.listPositionKeywords(listQuery);
	}

	@Override
	public TableResultResponse<PositionKeywordRespDTO> page(@RequestBody PositionKeywordPageReqDTO pageReqDTO) {
		return positionKeywordRpc.page(pageReqDTO);
	}
}

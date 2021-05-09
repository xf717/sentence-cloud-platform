package com.db.chaomaxs.systemservice.rpc.content.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.content.WorkContentExtendRpcImpl;
import com.db.chaomaxs.systemservice.rpc.content.facade.api.WorkContentExtendApi;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentExtendCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentExtendRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentExtendUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentExtendListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentExtendPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 内容管理-工作内容_扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@RestController
public class WorkContentExtendRpcController implements WorkContentExtendApi {

	@Autowired
	private WorkContentExtendRpcImpl workContentExtendRpc;

	@Override
	public BaseResponse save(@RequestBody WorkContentExtendCreateReqDTO createReqDTO) {
		return workContentExtendRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody WorkContentExtendUpdateReqDTO updateReqDTO) {
		return workContentExtendRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return workContentExtendRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<WorkContentExtendRespDTO> getWorkContentExtendById(@PathVariable("id") Long id) {
		return workContentExtendRpc.getWorkContentExtendById(id);
	}

	@Override
	public ObjectRestResponse<List<WorkContentExtendRespDTO>> listWorkContentExtends(@RequestBody WorkContentExtendListQueryReqDTO listQuery) {
		return workContentExtendRpc.listWorkContentExtends(listQuery);
	}

	@Override
	public TableResultResponse<WorkContentExtendRespDTO> page(@RequestBody WorkContentExtendPageReqDTO pageReqDTO) {
		return workContentExtendRpc.page(pageReqDTO);
	}
}

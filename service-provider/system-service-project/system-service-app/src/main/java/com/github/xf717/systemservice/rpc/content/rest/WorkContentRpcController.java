package com.github.xf717.systemservice.rpc.content.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.content.WorkContentRpcImpl;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentDetailRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentPageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentUpdateReqDTO;
import com.github.xf717.systemservice.rpc.content.facade.api.WorkContentApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 内容管理-工作内容息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@RestController
public class WorkContentRpcController implements WorkContentApi {

	@Autowired
	private WorkContentRpcImpl workContentRpc;

	@Override
	public BaseResponse save(@RequestBody WorkContentCreateReqDTO createReqDTO) {
		return workContentRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody WorkContentUpdateReqDTO updateReqDTO) {
		return workContentRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return workContentRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<WorkContentRespDTO> getWorkContentById(@PathVariable("id") Long id) {
		return workContentRpc.getWorkContentById(id);
	}

	@Override
	public ObjectRestResponse<List<WorkContentRespDTO>> listWorkContents(@RequestBody WorkContentListQueryReqDTO listQuery) {
		return workContentRpc.listWorkContents(listQuery);
	}

	@Override
	public TableResultResponse<WorkContentRespDTO> page(@RequestBody WorkContentPageReqDTO pageReqDTO) {
		return workContentRpc.page(pageReqDTO);
	}

	@Override
	public ObjectRestResponse<WorkContentDetailRespDTO> workContentDetail(){
		return workContentRpc.workContentDetail();
	}
}

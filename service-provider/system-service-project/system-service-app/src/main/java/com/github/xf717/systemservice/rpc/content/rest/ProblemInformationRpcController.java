package com.github.xf717.systemservice.rpc.content.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.content.ProblemInformationRpcImpl;
import com.github.xf717.systemservice.rpc.content.facade.api.ProblemInformationApi;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationUpdateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 内容管理-问题信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@RestController
public class ProblemInformationRpcController implements ProblemInformationApi {

	@Autowired
	private ProblemInformationRpcImpl problemInformationRpc;

	@Override
	public BaseResponse save(@RequestBody ProblemInformationCreateReqDTO createReqDTO) {
		return problemInformationRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody ProblemInformationUpdateReqDTO updateReqDTO) {
		return problemInformationRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return problemInformationRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<ProblemInformationRespDTO> getProblemInformationById(@PathVariable("id") Long id) {
		return problemInformationRpc.getProblemInformationById(id);
	}

	@Override
	public ObjectRestResponse<List<ProblemInformationRespDTO>> listProblemInformations(@RequestBody ProblemInformationListQueryReqDTO listQuery) {
		return problemInformationRpc.listProblemInformations(listQuery);
	}

	@Override
	public TableResultResponse<ProblemInformationRespDTO> page(@RequestBody ProblemInformationPageReqDTO pageReqDTO) {
		return problemInformationRpc.page(pageReqDTO);
	}
}

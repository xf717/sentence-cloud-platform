package com.db.chaomaxs.systemservice.rpc.content.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.content.ProblemInformationExtendRpcImpl;
import com.db.chaomaxs.systemservice.rpc.content.facade.api.ProblemInformationExtendApi;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationExtendCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationExtendRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationExtendUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationExtendListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationExtendPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 内容管理-问题扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@RestController
public class ProblemInformationExtendRpcController implements ProblemInformationExtendApi {

	@Autowired
	private ProblemInformationExtendRpcImpl problemInformationExtendRpc;

	@Override
	public BaseResponse save(@RequestBody ProblemInformationExtendCreateReqDTO createReqDTO) {
		return problemInformationExtendRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody ProblemInformationExtendUpdateReqDTO updateReqDTO) {
		return problemInformationExtendRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return problemInformationExtendRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<ProblemInformationExtendRespDTO> getProblemInformationExtendById(@PathVariable("id") Long id) {
		return problemInformationExtendRpc.getProblemInformationExtendById(id);
	}

	@Override
	public ObjectRestResponse<List<ProblemInformationExtendRespDTO>> listProblemInformationExtends(@RequestBody ProblemInformationExtendListQueryReqDTO listQuery) {
		return problemInformationExtendRpc.listProblemInformationExtends(listQuery);
	}

	@Override
	public TableResultResponse<ProblemInformationExtendRespDTO> page(@RequestBody ProblemInformationExtendPageReqDTO pageReqDTO) {
		return problemInformationExtendRpc.page(pageReqDTO);
	}
}

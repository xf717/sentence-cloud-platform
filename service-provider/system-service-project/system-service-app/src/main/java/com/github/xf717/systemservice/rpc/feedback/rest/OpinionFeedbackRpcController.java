package com.github.xf717.systemservice.rpc.feedback.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.feedback.OpinionFeedbackRpcImpl;
import com.github.xf717.systemservice.rpc.feedback.facade.api.OpinionFeedbackApi;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackCreateReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackRespDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackUpdateReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackListQueryReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 意见反馈信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@RestController
public class OpinionFeedbackRpcController implements OpinionFeedbackApi {

	@Autowired
	private OpinionFeedbackRpcImpl opinionFeedbackRpc;

	@Override
	public BaseResponse save(@RequestBody OpinionFeedbackCreateReqDTO createReqDTO) {
		return opinionFeedbackRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody OpinionFeedbackUpdateReqDTO updateReqDTO) {
		return opinionFeedbackRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return opinionFeedbackRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<OpinionFeedbackRespDTO> getOpinionFeedbackById(@PathVariable("id") Long id) {
		return opinionFeedbackRpc.getOpinionFeedbackById(id);
	}

	@Override
	public ObjectRestResponse<List<OpinionFeedbackRespDTO>> listOpinionFeedbacks(@RequestBody OpinionFeedbackListQueryReqDTO listQuery) {
		return opinionFeedbackRpc.listOpinionFeedbacks(listQuery);
	}

	@Override
	public TableResultResponse<OpinionFeedbackRespDTO> page(@RequestBody OpinionFeedbackPageReqDTO pageReqDTO) {
		return opinionFeedbackRpc.page(pageReqDTO);
	}


	@Override
	public ObjectRestResponse<OpinionFeedbackRespDTO> selectLastFeedbackByUserId(@RequestBody OpinionFeedbackListQueryReqDTO listQuery) {
		return opinionFeedbackRpc.selectLastFeedbackByUserId(listQuery);
	}
}

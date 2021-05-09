package com.github.xf717.systemservice.rpc.feedback.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.feedback.OpinionFeedbackImageRpcImpl;
import com.github.xf717.systemservice.rpc.feedback.facade.api.OpinionFeedbackImageApi;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackImageCreateReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackImageRespDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackImageUpdateReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackImageListQueryReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackImagePageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 意见反馈_图片
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@RestController
public class OpinionFeedbackImageRpcController implements OpinionFeedbackImageApi {

	@Autowired
	private OpinionFeedbackImageRpcImpl opinionFeedbackImageRpc;

	@Override
	public BaseResponse save(@RequestBody OpinionFeedbackImageCreateReqDTO createReqDTO) {
		return opinionFeedbackImageRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody OpinionFeedbackImageUpdateReqDTO updateReqDTO) {
		return opinionFeedbackImageRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return opinionFeedbackImageRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<OpinionFeedbackImageRespDTO> getOpinionFeedbackImageById(@PathVariable("id") Long id) {
		return opinionFeedbackImageRpc.getOpinionFeedbackImageById(id);
	}

	@Override
	public ObjectRestResponse<List<OpinionFeedbackImageRespDTO>> listOpinionFeedbackImages(@RequestBody OpinionFeedbackImageListQueryReqDTO listQuery) {
		return opinionFeedbackImageRpc.listOpinionFeedbackImages(listQuery);
	}

	@Override
	public TableResultResponse<OpinionFeedbackImageRespDTO> page(@RequestBody OpinionFeedbackImagePageReqDTO pageReqDTO) {
		return opinionFeedbackImageRpc.page(pageReqDTO);
	}
}

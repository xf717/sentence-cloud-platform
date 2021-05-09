package com.db.chaomaxs.companyservice.rpc.feedback.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.feedback.FeedbackRpcImpl;
import com.db.chaomaxs.companyservice.rpc.feedback.facade.api.FeedbackApi;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackRespDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 帮助与反馈
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@RestController
public class FeedbackRpcController implements FeedbackApi {

	@Autowired
	private FeedbackRpcImpl feedbackRpc;

	@Override
	public BaseResponse save(@RequestBody FeedbackCreateReqDTO feedbackCreateReqDTO) {
		return null;
	}

	@Override
	public BaseResponse update(@RequestBody FeedbackUpdateReqDTO feedbackUpdateReqDTO) {
		return null;
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return null;
	}

	@Override
	public ObjectRestResponse<FeedbackRespDTO> getFeedbackById(@PathVariable("id") Long id) {
		return null;
	}

	@Override
	public ObjectRestResponse<List<FeedbackRespDTO>> listFeedbacks(@RequestBody FeedbackListQueryReqDTO listQuery) {
		return null;
	}

	@Override
	public TableResultResponse<FeedbackRespDTO> page(@RequestBody FeedbackPageReqDTO page) {
		return null;
	}
}

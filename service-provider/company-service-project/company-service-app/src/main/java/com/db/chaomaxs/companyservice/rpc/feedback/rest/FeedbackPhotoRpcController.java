package com.db.chaomaxs.companyservice.rpc.feedback.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.feedback.FeedbackPhotoRpcImpl;
import com.db.chaomaxs.companyservice.rpc.feedback.facade.api.FeedbackPhotoApi;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoRespDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 帮助与反馈_图片说明
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@RestController
public class FeedbackPhotoRpcController implements FeedbackPhotoApi {

	@Autowired
	private FeedbackPhotoRpcImpl feedbackPhotoRpc;

	@Override
	public BaseResponse save(@RequestBody FeedbackPhotoCreateReqDTO feedbackPhotoCreateReqDTO) {
		return null;
	}

	@Override
	public BaseResponse update(@RequestBody FeedbackPhotoUpdateReqDTO feedbackPhotoUpdateReqDTO) {
		return null;
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return null;
	}

	@Override
	public ObjectRestResponse<FeedbackPhotoRespDTO> getFeedbackPhotoById(@PathVariable("id") Long id) {
		return null;
	}

	@Override
	public ObjectRestResponse<List<FeedbackPhotoRespDTO>> listFeedbackPhotos(@RequestBody FeedbackPhotoListQueryReqDTO listQuery) {
		return null;
	}

	@Override
	public TableResultResponse<FeedbackPhotoRespDTO> page(@RequestBody FeedbackPhotoPageReqDTO page) {
		return null;
	}
}

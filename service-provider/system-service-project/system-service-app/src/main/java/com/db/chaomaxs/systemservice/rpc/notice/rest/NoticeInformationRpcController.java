package com.db.chaomaxs.systemservice.rpc.notice.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.notice.NoticeInformationRpcImpl;
import com.db.chaomaxs.systemservice.rpc.notice.facade.api.NoticeInformationApi;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationRespDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通知信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@RestController
public class NoticeInformationRpcController implements NoticeInformationApi {

	@Autowired
	private NoticeInformationRpcImpl noticeInformationRpc;

	@Override
	public BaseResponse save(@RequestBody NoticeInformationCreateReqDTO createReqDTO) {
		return noticeInformationRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody NoticeInformationUpdateReqDTO updateReqDTO) {
		return noticeInformationRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return noticeInformationRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<NoticeInformationRespDTO> getNoticeInformationById(@PathVariable("id") Long id) {
		return noticeInformationRpc.getNoticeInformationById(id);
	}

	@Override
	public ObjectRestResponse<List<NoticeInformationRespDTO>> listNoticeInformations(@RequestBody NoticeInformationListQueryReqDTO listQuery) {
		return noticeInformationRpc.listNoticeInformations(listQuery);
	}

	@Override
	public TableResultResponse<NoticeInformationRespDTO> page(@RequestBody NoticeInformationPageReqDTO pageReqDTO) {
		return noticeInformationRpc.page(pageReqDTO);
	}
}

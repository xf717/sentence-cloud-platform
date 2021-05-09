package com.github.xf717.systemservice.rpc.notice.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.notice.NoticeInformationExtendRpcImpl;
import com.github.xf717.systemservice.rpc.notice.facade.api.NoticeInformationExtendApi;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendRespDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendUpdateReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 内容管理通知信息_扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@RestController
public class NoticeInformationExtendRpcController implements NoticeInformationExtendApi {

	@Autowired
	private NoticeInformationExtendRpcImpl noticeInformationExtendRpc;

	@Override
	public BaseResponse save(@RequestBody NoticeInformationExtendCreateReqDTO createReqDTO) {
		return noticeInformationExtendRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody NoticeInformationExtendUpdateReqDTO updateReqDTO) {
		return noticeInformationExtendRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return noticeInformationExtendRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<NoticeInformationExtendRespDTO> getNoticeInformationExtendById(@PathVariable("id") Long id) {
		return noticeInformationExtendRpc.getNoticeInformationExtendById(id);
	}

	@Override
	public ObjectRestResponse<List<NoticeInformationExtendRespDTO>> listNoticeInformationExtends(@RequestBody NoticeInformationExtendListQueryReqDTO listQuery) {
		return noticeInformationExtendRpc.listNoticeInformationExtends(listQuery);
	}

	@Override
	public TableResultResponse<NoticeInformationExtendRespDTO> page(@RequestBody NoticeInformationExtendPageReqDTO pageReqDTO) {
		return noticeInformationExtendRpc.page(pageReqDTO);
	}
}

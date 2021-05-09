package com.github.xf717.systemservice.rpc.content.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.content.AgreementInformationExtendRpcImpl;
import com.github.xf717.systemservice.rpc.content.facade.api.AgreementInformationExtendApi;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendUpdateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.AgreementInformationExtendPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 内容管理-协议信息_扩展息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@RestController
public class AgreementInformationExtendRpcController implements AgreementInformationExtendApi {

	@Autowired
	private AgreementInformationExtendRpcImpl agreementInformationExtendRpc;

	@Override
	public BaseResponse save(@RequestBody AgreementInformationExtendCreateReqDTO createReqDTO) {
		return agreementInformationExtendRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody AgreementInformationExtendUpdateReqDTO updateReqDTO) {
		return agreementInformationExtendRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return agreementInformationExtendRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<AgreementInformationExtendRespDTO> getAgreementInformationExtendById(@PathVariable("id") Long id) {
		return agreementInformationExtendRpc.getAgreementInformationExtendById(id);
	}

	@Override
	public ObjectRestResponse<List<AgreementInformationExtendRespDTO>> listAgreementInformationExtends(@RequestBody AgreementInformationExtendListQueryReqDTO listQuery) {
		return agreementInformationExtendRpc.listAgreementInformationExtends(listQuery);
	}

	@Override
	public TableResultResponse<AgreementInformationExtendRespDTO> page(@RequestBody AgreementInformationExtendPageReqDTO pageReqDTO) {
		return agreementInformationExtendRpc.page(pageReqDTO);
	}
}

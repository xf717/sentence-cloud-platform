package com.db.chaomaxs.systemservice.rpc.content.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.content.AgreementInformationRpcImpl;
import com.db.chaomaxs.systemservice.rpc.content.facade.api.AgreementInformationApi;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 内容管理-协议信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@RestController
public class AgreementInformationRpcController implements AgreementInformationApi {

	@Autowired
	private AgreementInformationRpcImpl agreementInformationRpc;

	@Override
	public BaseResponse save(@RequestBody AgreementInformationCreateReqDTO createReqDTO) {
		return agreementInformationRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody AgreementInformationUpdateReqDTO updateReqDTO) {
		return agreementInformationRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return agreementInformationRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<AgreementInformationRespDTO> getAgreementInformationById(@PathVariable("id") Long id) {
		return agreementInformationRpc.getAgreementInformationById(id);
	}

	@Override
	public ObjectRestResponse<List<AgreementInformationRespDTO>> listAgreementInformations(@RequestBody AgreementInformationListQueryReqDTO listQuery) {
		return agreementInformationRpc.listAgreementInformations(listQuery);
	}

	@Override
	public TableResultResponse<AgreementInformationRespDTO> page(@RequestBody AgreementInformationPageReqDTO pageReqDTO) {
		return agreementInformationRpc.page(pageReqDTO);
	}

	@Override
	public ObjectRestResponse<AgreementInformationRespDTO> getAgreementInformationByCode(@RequestParam("code") String code) {
		return agreementInformationRpc.getAgreementInformationByCode(code);
	}

}

package com.db.chaomaxs.companyservice.rpc.company.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.rpc.company.CompanyUserWordRpcImpl;
import com.db.chaomaxs.companyservice.rpc.company.facade.api.CompanyUserWordApi;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业常用语表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@RestController
public class CompanyUserWordRpcController implements CompanyUserWordApi {

	@Autowired
	private CompanyUserWordRpcImpl companyUserWordRpc;

	@Override
	public BaseResponse save(@RequestBody CompanyUserWordCreateReqDTO companyUserWordCreateReqDTO) {
		return null;
	}

	@Override
	public BaseResponse update(@RequestBody CompanyUserWordUpdateReqDTO companyUserWordUpdateReqDTO) {
		return null;
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return null;
	}

	@Override
	public ObjectRestResponse<CompanyUserWordRespDTO> getCompanyUserWordById(@PathVariable("id") Long id) {
		return null;
	}

	@Override
	public ObjectRestResponse<List<CompanyUserWordRespDTO>> listCompanyUserWords(@RequestBody CompanyUserWordListQueryReqDTO listQuery) {
		return null;
	}

	@Override
	public TableResultResponse<CompanyUserWordRespDTO> page(@RequestBody CompanyUserWordPageReqDTO page) {
		return null;
	}
}

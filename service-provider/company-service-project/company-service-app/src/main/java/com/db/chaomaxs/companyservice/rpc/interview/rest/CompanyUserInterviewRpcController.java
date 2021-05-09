package com.db.chaomaxs.companyservice.rpc.interview.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.interview.CompanyUserInterviewRpcImpl;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewHandoverReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewIdReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewRespDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateStateReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUsersRespDTO;
import com.db.chaomaxs.companyservice.rpc.interview.facade.api.CompanyUserInterviewApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业面试表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@RestController
public class CompanyUserInterviewRpcController implements CompanyUserInterviewApi {

    @Autowired
    private CompanyUserInterviewRpcImpl companyUserInterviewRpc;

    @Override
    public BaseResponse save(@RequestBody CompanyUserInterviewCreateReqDTO companyUserInterviewCreateReqDTO) {
        return companyUserInterviewRpc.save(companyUserInterviewCreateReqDTO);
    }

    @Override
    public BaseResponse update(@RequestBody CompanyUserInterviewUpdateReqDTO companyUserInterviewUpdateReqDTO) {
        return companyUserInterviewRpc.update(companyUserInterviewUpdateReqDTO);
    }

    @Override
    public BaseResponse updateState(@RequestBody CompanyUserInterviewUpdateStateReqDTO companyUserInterviewUpdateStateReqDTO) {
        return companyUserInterviewRpc.updateState(companyUserInterviewUpdateStateReqDTO);
    }


    @Override
    public ObjectRestResponse<CompanyUserInterviewRespDTO> getCompanyUserInterviewById(@PathVariable("id") Long id) {
        return companyUserInterviewRpc.getCompanyUserInterviewById(id);
    }

    @Override
    public ObjectRestResponse<List<CompanyUserInterviewRespDTO>> getCompanyUserInterviewByIds(@RequestBody CompanyUserInterviewIdReqDTO companyUserInterviewIdReqDTO) {
        return companyUserInterviewRpc.getCompanyUserInterviewByIds(companyUserInterviewIdReqDTO);
    }

    @Override
    public ObjectRestResponse<CompanyUserInterviewRespDTO> getByCompanyUserIdAndUserId(@RequestBody CompanyUserInterviewReqDTO companyUserInterviewReqDTO) {
        return companyUserInterviewRpc.getByCompanyUserIdAndUserId(companyUserInterviewReqDTO);
    }

    @Override
    public TableResultResponse<CompanyUserInterviewRespDTO> page(@RequestBody CompanyUserInterviewPageReqDTO page) {
        return companyUserInterviewRpc.page(page);
    }

    @Override
    public ObjectRestResponse<List<CompanyUserInterviewUsersRespDTO>> interviewList(CompanyUserInterviewListQueryReqDTO queryReqDTO) {
        return companyUserInterviewRpc.interviewList(queryReqDTO);
    }

    @Override
    public BaseResponse handover(@RequestBody CompanyUserInterviewHandoverReqDTO handoverReqDTO) {
        return companyUserInterviewRpc.handover(handoverReqDTO);
    }

}

package com.db.chaomaxs.companyservice.rpc.interview;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.manager.interview.CompanyUserInterviewManager;
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
import com.db.chaomaxs.companyservice.rpc.interview.facade.CompanyUserInterviewRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @data 2021-03-26 10:18:33
 */
@Slf4j
@Service
public class CompanyUserInterviewRpcImpl implements CompanyUserInterviewRpcFacade {

    @Autowired
    private CompanyUserInterviewManager companyUserInterviewManager;

    @Override
    public BaseResponse save(CompanyUserInterviewCreateReqDTO companyUserInterviewCreateReqDTO) {
        companyUserInterviewManager.saveCompanyUserInterview(companyUserInterviewCreateReqDTO);
        return BaseResponse.success("保存成功");
    }

    @Override
    public BaseResponse update(CompanyUserInterviewUpdateReqDTO companyUserInterviewUpdateReqDTO) {
        companyUserInterviewManager.updateCompanyUserInterview(companyUserInterviewUpdateReqDTO);
        return BaseResponse.success("修改成功");
    }

    @Override
    public BaseResponse updateState(CompanyUserInterviewUpdateStateReqDTO companyUserInterviewUpdateStateReqDTO) {
        companyUserInterviewManager.updateCompanyUserInterviewState(companyUserInterviewUpdateStateReqDTO);
        return BaseResponse.success("修改成功");
    }


    @Override
    public ObjectRestResponse<CompanyUserInterviewRespDTO> getCompanyUserInterviewById(Long id) {
        CompanyUserInterviewRespDTO companyUserInterviewDO = companyUserInterviewManager.getCompanyUserInterviewById(id);
        return new ObjectRestResponse<>().data(companyUserInterviewDO);
    }

    @Override
    public ObjectRestResponse<List<CompanyUserInterviewRespDTO>> getCompanyUserInterviewByIds(CompanyUserInterviewIdReqDTO companyUserInterviewIdReqDTO) {
        List<CompanyUserInterviewRespDTO> list = companyUserInterviewManager.getCompanyUserInterviewByIds(companyUserInterviewIdReqDTO);
        return new ObjectRestResponse<>().data(list);
    }

    @Override
    public ObjectRestResponse<CompanyUserInterviewRespDTO> getByCompanyUserIdAndUserId(CompanyUserInterviewReqDTO companyUserInterviewReqDTO) {
        CompanyUserInterviewRespDTO companyUserInterviewDO = companyUserInterviewManager.getByCompanyUserIdAndUserId(companyUserInterviewReqDTO);
        return new ObjectRestResponse<>().data(companyUserInterviewDO);
    }


    @Override
    public TableResultResponse<CompanyUserInterviewRespDTO> page(CompanyUserInterviewPageReqDTO pageReqDTO) {
        PageResult<CompanyUserInterviewRespDTO> pageResult = companyUserInterviewManager.pageCompanyUserInterview(pageReqDTO);
        TableResultResponse<CompanyUserInterviewRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(), pageResult.getList());
        return tableResultResponse;
    }

    @Override
    public ObjectRestResponse<List<CompanyUserInterviewUsersRespDTO>> interviewList(CompanyUserInterviewListQueryReqDTO queryReqDTO) {
        List<CompanyUserInterviewUsersRespDTO> list=companyUserInterviewManager.interviewList(queryReqDTO);
        return new ObjectRestResponse<>().data(list);
    }

    @Override
    public BaseResponse handover(CompanyUserInterviewHandoverReqDTO handoverReqDTO) {
        companyUserInterviewManager.handover(handoverReqDTO);
        return BaseResponse.success("面试信息交接成功");
    }

}

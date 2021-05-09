package com.db.chaomaxs.companyservice.manager.interview;

import com.db.chaomaxs.common.framework.vo.PageResult;
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
import com.db.chaomaxs.companyservice.service.interview.CompanyUserInterviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyUserInterviewManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyUserInterviewManager {

    @Autowired
    private CompanyUserInterviewService CompanyUserInterviewService;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveCompanyUserInterview(CompanyUserInterviewCreateReqDTO createReqDTO) {
        return CompanyUserInterviewService.saveCompanyUserInterview(createReqDTO);
    }

    /**
     * 更新数据
     *
     * @param updateReqDTO
     * @return
     */
    public int updateCompanyUserInterview(CompanyUserInterviewUpdateReqDTO updateReqDTO) {
        return CompanyUserInterviewService.updateCompanyUserInterview(updateReqDTO);
    }

    /**
     * 修改面试状态
     *
     * @param updateStateReqDTO
     * @return
     */
    public int updateCompanyUserInterviewState(CompanyUserInterviewUpdateStateReqDTO updateStateReqDTO) {
        return CompanyUserInterviewService.updateCompanyUserInterviewState(updateStateReqDTO);
    }

    /**
     * 根据id获取对象
     *
     * @param id
     * @return
     */
    public CompanyUserInterviewRespDTO getCompanyUserInterviewById(Long id) {
        return CompanyUserInterviewService.getCompanyUserInterviewById(id);
    }

    public CompanyUserInterviewRespDTO getByCompanyUserIdAndUserId(CompanyUserInterviewReqDTO companyUserInterviewReqDTO) {
        return CompanyUserInterviewService.getByCompanyUserIdAndUserId(companyUserInterviewReqDTO);
    }


    /**
     * 分类
     *
     * @param page
     * @return
     */
    public PageResult<CompanyUserInterviewRespDTO> pageCompanyUserInterview(CompanyUserInterviewPageReqDTO page) {
        return CompanyUserInterviewService.pageCompanyUserInterview(page);
    }

    public List<CompanyUserInterviewRespDTO> getCompanyUserInterviewByIds(CompanyUserInterviewIdReqDTO companyUserInterviewIdReqDTO) {
        return CompanyUserInterviewService.getCompanyUserInterviewByIds(companyUserInterviewIdReqDTO);
    }

    public List<CompanyUserInterviewUsersRespDTO> interviewList(CompanyUserInterviewListQueryReqDTO queryReqDTO) {
        return CompanyUserInterviewService.interviewList(queryReqDTO);
    }

    /**
     * 面试信息交接
     * @param companyUserInterviewHandoverReqDTO
     */
    public void handover(CompanyUserInterviewHandoverReqDTO companyUserInterviewHandoverReqDTO) {
        CompanyUserInterviewService.handover(companyUserInterviewHandoverReqDTO);
    }

}

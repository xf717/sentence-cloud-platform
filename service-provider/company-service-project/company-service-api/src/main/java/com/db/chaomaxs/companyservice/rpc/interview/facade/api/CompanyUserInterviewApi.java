package com.db.chaomaxs.companyservice.rpc.interview.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
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
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * 企业面试表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
public interface CompanyUserInterviewApi {

    /**
     * 添加数据
     *
     * @param createReqDTO 添加参数
     * @return
     */
    @PostMapping("/facade/companyUserInterview/save")
    BaseResponse save(@RequestBody CompanyUserInterviewCreateReqDTO createReqDTO);

    /**
     * 更新数据
     *
     * @param updateReqDTO 更新参数
     * @return
     */
    @PutMapping("/facade/companyUserInterview/update")
    BaseResponse update(@RequestBody CompanyUserInterviewUpdateReqDTO updateReqDTO);

    /**
     * 修改面试结果
     *
     * @return
     */
    @PostMapping("/facade/companyUserInterview/updateState")
    BaseResponse updateState(@RequestBody CompanyUserInterviewUpdateStateReqDTO updateStateReqDTO);


    /**
     * 根据Id查找
     *
     * @param id id
     * @return
     */
    @GetMapping("/facade/companyUserInterview/get/{id}")
    ObjectRestResponse<CompanyUserInterviewRespDTO> getCompanyUserInterviewById(@PathVariable("id") Long id);


    /**
     * 根据Id查找
     *
     * @param companyUserInterviewIdReqDTO
     * @return
     */
    @PostMapping("/facade/companyUserInterview/get/ids")
    ObjectRestResponse<List<CompanyUserInterviewRespDTO>> getCompanyUserInterviewByIds(@RequestBody CompanyUserInterviewIdReqDTO companyUserInterviewIdReqDTO);

    /**
     *
     * @param companyUserInterviewReqDTO
     * @return
     */
    @PostMapping("/facade/companyUserInterview/get")
    ObjectRestResponse<CompanyUserInterviewRespDTO> getByCompanyUserIdAndUserId(@RequestBody CompanyUserInterviewReqDTO companyUserInterviewReqDTO);



    /**
     * 查找数据显示分页
     *
     * @param pageReqDTO 分页参数
     * @return
     */
    @PostMapping("/facade/companyUserInterview/page")
    TableResultResponse<CompanyUserInterviewRespDTO> page(@RequestBody CompanyUserInterviewPageReqDTO pageReqDTO);


    /**
     * 已约面列表
     *
     * @param queryReqDTO
     * @return
     */
    @PostMapping("/facade/companyUserInterview/list")
    ObjectRestResponse<List<CompanyUserInterviewUsersRespDTO>> interviewList(@RequestBody CompanyUserInterviewListQueryReqDTO queryReqDTO);

    /**
     * 面试信息交接
     * @param handoverReqDTO
     * @return
     */
    @PostMapping("/facade/companyUserInterview/handover")
    BaseResponse handover(@RequestBody CompanyUserInterviewHandoverReqDTO handoverReqDTO);
}

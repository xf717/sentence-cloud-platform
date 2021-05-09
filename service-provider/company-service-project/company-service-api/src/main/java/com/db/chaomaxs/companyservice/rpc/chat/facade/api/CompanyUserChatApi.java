package com.db.chaomaxs.companyservice.rpc.chat.facade.api;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatRespDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatStatisticRespDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.PositionIdsReqDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * 企业我的沟通
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
public interface CompanyUserChatApi {

    /**
     * 添加数据
     *
     * @param createReqDTO 添加参数
     * @return
     */
    @PostMapping("/facade/companyUserChat/save")
    BaseResponse save(@RequestBody CompanyUserChatCreateReqDTO createReqDTO);


    @GetMapping("/facade/companyUserChat/get/{id}")
    ObjectRestResponse<CompanyUserChatRespDTO> getCompanyUserChatById(@PathVariable("id") Long id);

    /**
     * 查找数据显示分页
     *
     * @param pageReqDTO 分页参数
     * @return
     */
    @PostMapping("/facade/companyUserChat/page")
    TableResultResponse<CompanyUserChatRespDTO> page(@RequestBody CompanyUserChatPageReqDTO pageReqDTO);

    /**
     * 沟通过职位统计
     * @param positionIdsReqDTO
     */
    @PostMapping("/facade/statistic/getByPositionIds")
    Map<Long, CompanyUserChatStatisticRespDTO> getStatisticByPositionIds(@RequestBody PositionIdsReqDTO positionIdsReqDTO);

}

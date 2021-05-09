package com.db.chaomaxs.companyservice.rpc.statistic.facade.api;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticReqDTO;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticRespDTO;;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 企业我的足迹
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
public interface CompanyUserStatisticApi {


    /**
     * 根据Id查找
     *
     * @param companyUserStatisticReqDTO
     * @return
     */
    @PostMapping("/facade/statistic")
    ObjectRestResponse<CompanyUserStatisticRespDTO> getStatistic(@RequestBody CompanyUserStatisticReqDTO companyUserStatisticReqDTO);



}

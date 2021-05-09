package com.db.chaomaxs.companyservice.manager.statistic;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticReqDTO;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticRespDTO;
import com.db.chaomaxs.companyservice.service.collect.CompanyUserCollectService;
import com.db.chaomaxs.companyservice.service.company.CompanyUserChatService;
import com.db.chaomaxs.companyservice.service.delivery.CompanyDeliveryService;
import com.db.chaomaxs.companyservice.service.interview.CompanyUserInterviewService;
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
public class CompanyUserStatisticManager {
    @Autowired
    private CompanyUserChatService companyUserChatService;

    @Autowired
    private CompanyUserInterviewService companyUserInterviewService;

    @Autowired
    private CompanyUserCollectService companyUserCollectService;

    @Autowired
    private CompanyDeliveryService companyDeliveryService;


    public CompanyUserStatisticRespDTO getStatistic(CompanyUserStatisticReqDTO companyUserStatisticReqDTO) {
        CompanyUserStatisticRespDTO companyUserStatisticRespDTO = new CompanyUserStatisticRespDTO();
        companyUserStatisticRespDTO.setChatCount(companyUserChatService.count(companyUserStatisticReqDTO));
        companyUserStatisticRespDTO.setCollectCount(companyUserInterviewService.count(companyUserStatisticReqDTO));
        companyUserStatisticRespDTO.setDeliveryCount(companyUserCollectService.count(companyUserStatisticReqDTO));
        companyUserStatisticRespDTO.setInterviewCount(companyDeliveryService.count(companyUserStatisticReqDTO));
        return companyUserStatisticRespDTO;
    }

}

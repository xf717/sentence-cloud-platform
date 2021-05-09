package com.db.chaomaxs.companyservice.rpc.statistic;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.manager.statistic.CompanyUserStatisticManager;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticReqDTO;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticRespDTO;
import com.db.chaomaxs.companyservice.rpc.statistic.facade.CompanyUserStatisticRpcFacade;
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
public class CompanyUserStatisticRpcImpl implements CompanyUserStatisticRpcFacade {

    @Autowired
    private CompanyUserStatisticManager companyUserStatisticManager;


    @Override
    public ObjectRestResponse<CompanyUserStatisticRespDTO> getStatistic(CompanyUserStatisticReqDTO companyUserStatisticReqDTO) {
        return new ObjectRestResponse<>().data(companyUserStatisticManager.getStatistic(companyUserStatisticReqDTO));
    }
}

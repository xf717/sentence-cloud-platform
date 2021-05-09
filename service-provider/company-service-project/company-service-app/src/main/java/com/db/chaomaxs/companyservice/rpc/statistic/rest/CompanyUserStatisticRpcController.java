package com.db.chaomaxs.companyservice.rpc.statistic.rest;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.statistic.CompanyUserStatisticRpcImpl;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticReqDTO;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticRespDTO;
import com.db.chaomaxs.companyservice.rpc.statistic.facade.api.CompanyUserStatisticApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业我的足迹
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@RestController
public class CompanyUserStatisticRpcController implements CompanyUserStatisticApi {

  @Autowired
  private CompanyUserStatisticRpcImpl companyUserStatisticRpc;
  @Override
  public ObjectRestResponse<CompanyUserStatisticRespDTO> getStatistic(@RequestBody CompanyUserStatisticReqDTO companyUserStatisticReqDTO) {
    return companyUserStatisticRpc.getStatistic(companyUserStatisticReqDTO);
  }
}

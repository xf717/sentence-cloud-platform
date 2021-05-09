package com.db.chaomaxs.companyservice.rpc.track.facade;

import com.db.chaomaxs.companyservice.rpc.track.facade.api.CompanyUserTrackApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 企业我的足迹
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@FeignClient(value = "${chaomax.company.serviceId}", configuration = {})
public interface CompanyUserTrackRpcFacade extends CompanyUserTrackApi {

}

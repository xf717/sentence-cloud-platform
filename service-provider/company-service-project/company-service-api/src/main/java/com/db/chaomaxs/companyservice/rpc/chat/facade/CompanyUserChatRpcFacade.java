package com.db.chaomaxs.companyservice.rpc.chat.facade;

import com.db.chaomaxs.companyservice.rpc.chat.facade.api.CompanyUserChatApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 企业我的沟通
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@FeignClient(value = "${chaomax.company.serviceId}", configuration = {})
public interface CompanyUserChatRpcFacade extends CompanyUserChatApi {


}

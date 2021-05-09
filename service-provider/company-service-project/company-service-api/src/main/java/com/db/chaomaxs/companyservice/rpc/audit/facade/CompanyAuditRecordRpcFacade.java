package com.db.chaomaxs.companyservice.rpc.audit.facade;

import com.db.chaomaxs.companyservice.rpc.audit.facade.api.CompanyAuditRecordApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 公司_审核记录信息表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@FeignClient(value = "${chaomax.company.serviceId}", configuration = {})
public interface CompanyAuditRecordRpcFacade extends CompanyAuditRecordApi {

}

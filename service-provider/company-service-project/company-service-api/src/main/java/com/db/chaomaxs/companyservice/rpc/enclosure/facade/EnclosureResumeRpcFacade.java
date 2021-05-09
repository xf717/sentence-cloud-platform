package com.db.chaomaxs.companyservice.rpc.enclosure.facade;

import com.db.chaomaxs.companyservice.rpc.enclosure.facade.api.EnclosureResumeApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 企业附件简历
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@FeignClient(value = "${chaomax.company.serviceId}", configuration = {})
public interface EnclosureResumeRpcFacade extends EnclosureResumeApi {

}

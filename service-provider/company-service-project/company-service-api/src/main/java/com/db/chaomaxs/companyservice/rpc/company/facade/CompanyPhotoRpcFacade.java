package com.db.chaomaxs.companyservice.rpc.company.facade;

import com.db.chaomaxs.companyservice.rpc.company.facade.api.CompanyPhotoApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 公司_相册
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@FeignClient(value = "${chaomax.company.serviceId}", configuration = {})
public interface CompanyPhotoRpcFacade extends CompanyPhotoApi {

}

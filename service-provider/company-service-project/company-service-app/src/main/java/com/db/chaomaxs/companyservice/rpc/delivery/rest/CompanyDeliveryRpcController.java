package com.db.chaomaxs.companyservice.rpc.delivery.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.delivery.CompanyDeliveryRpcImpl;
import com.db.chaomaxs.companyservice.rpc.delivery.facade.api.CompanyDeliveryApi;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryRespDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryPageReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业投递表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@RestController
public class CompanyDeliveryRpcController implements CompanyDeliveryApi {

    @Autowired
    private CompanyDeliveryRpcImpl companyDeliveryRpc;

    @Override
    public BaseResponse save(@RequestBody CompanyDeliveryCreateReqDTO companyDeliveryCreateReqDTO) {
        return companyDeliveryRpc.save(companyDeliveryCreateReqDTO);
    }

    @Override
    public ObjectRestResponse<CompanyDeliveryRespDTO> getCompanyDeliveryById(@PathVariable("id") Long id) {
        return companyDeliveryRpc.getCompanyDeliveryById(id);
    }


    @Override
    public TableResultResponse<CompanyDeliveryRespDTO> page(@RequestBody CompanyDeliveryPageReqDTO page) {
        return companyDeliveryRpc.page(page);
    }
}

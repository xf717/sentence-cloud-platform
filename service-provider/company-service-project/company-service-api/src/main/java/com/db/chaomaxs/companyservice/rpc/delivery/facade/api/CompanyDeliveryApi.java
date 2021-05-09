package com.db.chaomaxs.companyservice.rpc.delivery.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryRespDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryUpdateReqDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 企业投递表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
public interface CompanyDeliveryApi {

    /**
     * 添加数据
     *
     * @param createReqDTO 添加参数
     * @return
     */
    @PostMapping("/facade/companyDelivery/save")
    BaseResponse save(@RequestBody CompanyDeliveryCreateReqDTO createReqDTO);


    /**
     * 根据Id查找
     *
     * @param id id
     * @return
     */
    @GetMapping("/facade/companyDelivery/get/{id}")
    ObjectRestResponse<CompanyDeliveryRespDTO> getCompanyDeliveryById(@PathVariable("id") Long id);


    /**
     * 查找数据显示分页
     *
     * @param pageReqDTO 分页参数
     * @return
     */
    @PostMapping("/facade/companyDelivery/page")
    TableResultResponse<CompanyDeliveryRespDTO> page(@RequestBody CompanyDeliveryPageReqDTO pageReqDTO);
}

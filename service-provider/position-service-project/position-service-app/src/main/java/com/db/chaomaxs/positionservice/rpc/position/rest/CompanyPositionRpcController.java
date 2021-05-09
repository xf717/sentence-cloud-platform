package com.db.chaomaxs.positionservice.rpc.position.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.positionservice.rpc.position.CompanyPositionRpcImpl;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionAuditReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionDetailRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionHandoverReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionUpdateStateDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.IdsReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.ManagementPositionPageRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.facade.api.CompanyPositionApi;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业_职位
 *
 * @author momo
 * @date 2021-03-29 16:36:57
 */
@RestController
public class CompanyPositionRpcController implements CompanyPositionApi {

    @Autowired
    private CompanyPositionRpcImpl companyPositionRpc;

    @Override
    public BaseResponse save(@RequestBody CompanyPositionCreateReqDTO createReqDTO) {
        return companyPositionRpc.save(createReqDTO);
    }

    @Override
    public BaseResponse update(@RequestBody CompanyPositionUpdateReqDTO updateReqDTO) {
        return companyPositionRpc.update(updateReqDTO);
    }

    @Override
    public BaseResponse remove(@PathVariable("id") Long id) {
        return companyPositionRpc.remove(id);
    }

    @Override
    public ObjectRestResponse<CompanyPositionDetailRespDTO> getCompanyPositionById(@PathVariable("id") Long id) {
        return companyPositionRpc.getCompanyPositionById(id);
    }


    @Override
    public TableResultResponse<CompanyPositionPageRespDTO> page(@RequestBody CompanyPositionPageReqDTO pageReqDTO) {
        return companyPositionRpc.page(pageReqDTO);
    }

    @Override
    public ObjectRestResponse<List<CompanyPositionRespDTO>> getCompanyPositionsByIds(@RequestBody IdsReqDTO idsReqDTO) {
        return companyPositionRpc.getCompanyPositionsByIds(idsReqDTO);
    }

    @Override
    public BaseResponse updateCompanyPositionStatus(@RequestBody CompanyPositionAuditReqDTO companyPositionAuditReqDTO) {
        return companyPositionRpc.updateCompanyPositionStatus(companyPositionAuditReqDTO);
    }

    @Override
    public TableResultResponse<ManagementPositionPageRespDTO> managementPage(@RequestBody CompanyPositionPageReqDTO pageReqDTO) {
        return companyPositionRpc.managementPage(pageReqDTO);
    }

    @Override
    public BaseResponse updateByCompanyUserId(
        CompanyPositionUpdateStateDTO companyPositionUpdateStateDTO) {
        return companyPositionRpc.updateByCompanyUserId(companyPositionUpdateStateDTO);
    }

    @Override
    public BaseResponse handover(CompanyPositionHandoverReqDTO companyPositionHandoverReqDTO) {
        return companyPositionRpc.handover(companyPositionHandoverReqDTO);
    }

}

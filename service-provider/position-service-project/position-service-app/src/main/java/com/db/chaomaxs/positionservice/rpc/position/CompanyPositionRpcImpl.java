package com.db.chaomaxs.positionservice.rpc.position;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.manager.position.CompanyPositionManager;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionAuditReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionDetailRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionHandoverReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionUpdateStateDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.IdsReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.ManagementPositionPageRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.facade.CompanyPositionRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author momo
 * @date 2021-03-29 16:36:57
 */
@Slf4j
@Service
public class CompanyPositionRpcImpl implements CompanyPositionRpcFacade {

    @Autowired
    private CompanyPositionManager companyPositionManager;

    @Override
    public BaseResponse save(CompanyPositionCreateReqDTO createReqDTO) {
        companyPositionManager.saveCompanyPosition(createReqDTO);
        return BaseResponse.success("保存成功");
    }

    @Override
    public BaseResponse update(CompanyPositionUpdateReqDTO updateReqDTO) {
        companyPositionManager.updateCompanyPosition(updateReqDTO);
        return BaseResponse.success("更新成功");
    }

    @Override
    public BaseResponse remove(Long id) {
        companyPositionManager.deleteCompanyPosition(id);
        return BaseResponse.success("删除成功");
    }

    @Override
    public ObjectRestResponse<CompanyPositionDetailRespDTO> getCompanyPositionById(Long id) {
        CompanyPositionDetailRespDTO companyPosition = companyPositionManager.getCompanyPositionById(id);
        return new ObjectRestResponse<>().data(companyPosition);
    }


    @Override
    public TableResultResponse<CompanyPositionPageRespDTO> page(CompanyPositionPageReqDTO pageReqDTO) {
        PageResult<CompanyPositionPageRespDTO> pageResult = companyPositionManager.pageCompanyPosition(pageReqDTO);
        TableResultResponse<CompanyPositionPageRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(), pageResult.getList());
        return tableResultResponse;
    }

    @Override
    public ObjectRestResponse<List<CompanyPositionRespDTO>> getCompanyPositionsByIds(IdsReqDTO idsReqDTO) {
        List<CompanyPositionRespDTO> list = companyPositionManager.getCompanyPositionsByIds(idsReqDTO);
        return new ObjectRestResponse<>().data(list);
    }

    @Override
    public BaseResponse updateCompanyPositionStatus(CompanyPositionAuditReqDTO companyPositionAuditReqDTO) {
        companyPositionManager.updateCompanyPositionStatus(companyPositionAuditReqDTO);
        return BaseResponse.success("审核成功");
    }

    @Override
    public TableResultResponse<ManagementPositionPageRespDTO> managementPage(CompanyPositionPageReqDTO pageReqDTO) {
        PageResult<ManagementPositionPageRespDTO> pageResult = companyPositionManager.managementPage(pageReqDTO);
        TableResultResponse<ManagementPositionPageRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(), pageResult.getList());
        return tableResultResponse;
    }

    @Override
    public BaseResponse updateByCompanyUserId(
        CompanyPositionUpdateStateDTO companyPositionUpdateStateDTO) {
        companyPositionManager.updateByCompanyUserId(companyPositionUpdateStateDTO);
        return BaseResponse.success("更新成功");
    }

    @Override
    public BaseResponse handover(CompanyPositionHandoverReqDTO companyPositionHandoverReqDTO) {
        companyPositionManager.handover(companyPositionHandoverReqDTO);
        return BaseResponse.success("职位交接成功");
    }


}

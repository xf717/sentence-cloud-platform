package com.db.chaomaxs.positionservice.manager.position;

import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.enums.position.PositionStatusEnum;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionAuditReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionDetailRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionHandoverReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionKeywordRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionUpdateStateDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.IdsReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.ManagementPositionPageRespDTO;
import com.db.chaomaxs.positionservice.service.position.CompanyPositionKeywordService;
import com.db.chaomaxs.positionservice.service.position.CompanyPositionService;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyPositionManager
 *
 * @author momo
 * @date 2021-03-29 16:36:57
 */
@Service
@Validated
public class CompanyPositionManager {

    @Autowired
    private CompanyPositionService companyPositionService;

    @Autowired
    private CompanyPositionKeywordService companyPositionKeywordService;


    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveCompanyPosition(CompanyPositionCreateReqDTO createReqDTO) {
        return companyPositionService.saveCompanyPosition(createReqDTO);
    }

    /**
     * 更新数据
     *
     * @param updateReqDTO
     * @return
     */
    public int updateCompanyPosition(CompanyPositionUpdateReqDTO updateReqDTO) {
        return companyPositionService.updateCompanyPosition(updateReqDTO);
    }

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    public int deleteCompanyPosition(Long id) {
        return companyPositionService.deleteCompanyPosition(id);
    }


    /**
     * 根据id获取对象
     *
     * @param id
     * @return
     */
    public CompanyPositionDetailRespDTO getCompanyPositionById(Long id) {
        CompanyPositionDetailRespDTO companyPositionRespDTO = companyPositionService.getCompanyPositionById(id);
        if (companyPositionRespDTO != null) {
            companyPositionRespDTO.setKeywordList(companyPositionKeywordService.getIdsByCompanyPositionId(companyPositionRespDTO.getId()));
        }
        return companyPositionRespDTO;
    }

    /**
     * 分类
     *
     * @param page
     * @return
     */
    public PageResult<CompanyPositionPageRespDTO> pageCompanyPosition(CompanyPositionPageReqDTO page) {
        return companyPositionService.pageCompanyPosition(page);
    }


    public List<CompanyPositionRespDTO> getCompanyPositionsByIds(IdsReqDTO idsReqDTO) {
        List<CompanyPositionRespDTO> respDTOList = companyPositionService.getCompanyPositionsByIds(idsReqDTO);
        if (CollectionUtils.isEmpty(respDTOList)) {
            return Collections.emptyList();
        }
        Set<Long> ids = respDTOList.stream().map(CompanyPositionRespDTO::getId).collect(Collectors.toSet());
        idsReqDTO.setIds(ids);
        //获取关键字
        Map<Long, List<CompanyPositionKeywordRespDTO>> map = companyPositionKeywordService.getIdsByCompanyPositionIds(idsReqDTO);
        for (CompanyPositionRespDTO companyPositionRespDTO : respDTOList) {
            companyPositionRespDTO.setKeywordList(map.get(companyPositionRespDTO.getId()));
            companyPositionRespDTO.setStatus(PositionStatusEnum.getByCode(Integer.valueOf(companyPositionRespDTO.getStatus())));
        }
        return respDTOList;
    }

    public int updateCompanyPositionStatus(CompanyPositionAuditReqDTO companyPositionAuditReqDTO) {
        return companyPositionService.updateCompanyPositionStatus(companyPositionAuditReqDTO);
    }

    public PageResult<ManagementPositionPageRespDTO> managementPage(CompanyPositionPageReqDTO pageReqDTO) {
        return companyPositionService.managementPage(pageReqDTO);
    }

    /**
     * 根据企业用户id修改职位状态
     * @param companyPositionUpdateStateDTO
     */
    public void updateByCompanyUserId(CompanyPositionUpdateStateDTO companyPositionUpdateStateDTO) {
        companyPositionService.updateByCompanyUserId(companyPositionUpdateStateDTO);
    }

    /**
     * 职位交接
     * @param companyPositionHandoverReqDTO
     */
    public void handover(CompanyPositionHandoverReqDTO companyPositionHandoverReqDTO) {
        companyPositionService.handover(companyPositionHandoverReqDTO);
    }

}

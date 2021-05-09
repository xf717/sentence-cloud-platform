package com.db.chaomaxs.positionservice.service.position;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.ServiceException;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.convert.position.CompanyPositionConvert;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.CompanyPositionAuditRecordDO;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.CompanyPositionDO;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.CompanyPositionExtendDO;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.CompanyPositionKeywordDO;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.GetCompanyPositionDO;
import com.db.chaomaxs.positionservice.dal.mysql.mapper.position.CompanyPositionAuditRecordMapper;
import com.db.chaomaxs.positionservice.dal.mysql.mapper.position.CompanyPositionExtendMapper;
import com.db.chaomaxs.positionservice.dal.mysql.mapper.position.CompanyPositionKeywordMapper;
import com.db.chaomaxs.positionservice.dal.mysql.mapper.position.CompanyPositionMapper;
import com.db.chaomaxs.positionservice.enums.PositionErrorCodeConstants;
import com.db.chaomaxs.positionservice.enums.position.PositionStatusEnum;
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
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyPositionService
 *
 * @author momo
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class CompanyPositionService {

    @Autowired
    private CompanyPositionMapper companyPositionMapper;

    @Autowired
    private CompanyPositionKeywordMapper companyPositionKeywordMapper;

    @Autowired
    private CompanyPositionExtendMapper companyPositionExtendMapper;

    @Autowired
    private CompanyPositionAuditRecordMapper companyPositionAuditRecordMapper;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    @Transactional(rollbackFor = ServiceException.class)
    public int saveCompanyPosition(CompanyPositionCreateReqDTO createReqDTO) {
        CompanyPositionDO companyPositionDO = CompanyPositionConvert.INSTANCE.convert(createReqDTO);
        companyPositionDO.setStatus(PositionStatusEnum.WAIT_AUDIT_POSITION.getCode());
        int result = companyPositionMapper.insert(companyPositionDO);
        Long id = companyPositionDO.getId();
        this.batchInsertCompanyPositionKeyword(createReqDTO.getKeywordIds(), id, createReqDTO.getCompanyUserId());
        this.saveCompanyPositionExtend(createReqDTO.getContent(), id, createReqDTO.getCompanyUserId());
        return result;
    }

    public void saveCompanyPositionExtend(String content, Long companyPositionId, Long companyUserId) {
        if (StringUtils.isBlank(content)) {
            return;
        }
        CompanyPositionExtendDO companyPositionExtendDO = new CompanyPositionExtendDO();
        companyPositionExtendDO.setContent(content);
        companyPositionExtendDO.setCompanyPositionId(companyPositionId);
        companyPositionExtendDO.setCreateBy(companyUserId);
        companyPositionExtendMapper.insert(companyPositionExtendDO);
    }

    public void batchInsertCompanyPositionKeyword(Set<Long> keywordIds, Long companyPositionId, Long companyUserId) {
        if (CollectionUtils.isEmpty(keywordIds)) {
            return;
        }
        List<CompanyPositionKeywordDO> companyPositionKeywordDOList = Lists.newArrayList();
        CompanyPositionKeywordDO companyPositionKeywordDO = null;
        for (Long keywordId : keywordIds) {
            companyPositionKeywordDO = new CompanyPositionKeywordDO();
            companyPositionKeywordDO.setPositionKeywordId(keywordId);
            companyPositionKeywordDO.setCompanyPositionId(companyPositionId);
            companyPositionKeywordDO.setCreateBy(companyUserId);
            companyPositionKeywordDOList.add(companyPositionKeywordDO);
        }
        companyPositionKeywordMapper.batchInsert(companyPositionKeywordDOList);
    }

    /**
     * 更新数据
     *
     * @param updateReqDTO
     * @return
     */
    @Transactional(rollbackFor = ServiceException.class)
    public int updateCompanyPosition(CompanyPositionUpdateReqDTO updateReqDTO) {
        CompanyPositionDO companyPositionDO = companyPositionMapper.selectById(updateReqDTO.getId());
        if (companyPositionDO == null) {
            throw ServiceExceptionUtil.exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
        }
        companyPositionDO = CompanyPositionConvert.INSTANCE.convert(updateReqDTO);
        int result = companyPositionMapper.updateById(companyPositionDO);
        this.updateCompanyPositionKeyword(updateReqDTO.getKeywordIds(), updateReqDTO.getId(), updateReqDTO.getCompanyUserId());
        this.updateCompanyPositionExtend(updateReqDTO.getContent(), updateReqDTO.getId(), updateReqDTO.getCompanyUserId());

        return result;
    }

    public void updateCompanyPositionKeyword(Set<Long> keywordIds, Long companyPositionId, Long companyUserId) {
        companyPositionKeywordMapper.deleteByCompanyPositionId(companyPositionId);
        this.batchInsertCompanyPositionKeyword(keywordIds, companyPositionId, companyUserId);
    }

    public int updateCompanyPositionExtend(String content, Long companyPositionId, Long companyUserId) {
        CompanyPositionExtendDO companyPositionExtendDO = new CompanyPositionExtendDO();
        companyPositionExtendDO.setContent(content);
        companyPositionExtendDO.setCompanyPositionId(companyPositionId);
        companyPositionExtendDO.setUpdateBy(companyUserId);
        int result = companyPositionExtendMapper.updateByCompanyPositionId(companyPositionExtendDO);
        return result;
    }

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    @Transactional(rollbackFor = ServiceException.class)
    public int deleteCompanyPosition(Long id) {
        if (companyPositionMapper.selectById(id) == null) {
            throw ServiceExceptionUtil.exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
        }
        int result = companyPositionMapper.deleteById(id);
        companyPositionKeywordMapper.softDeleteByCompanyPositionId(id);
        companyPositionExtendMapper.deleteByCompanyPositionId(id);
        return result;
    }


    /**
     * 根据id获取对象
     *
     * @param id
     * @return
     */
    public CompanyPositionDetailRespDTO getCompanyPositionById(Long id) {
        GetCompanyPositionDO companyPositionDO = companyPositionMapper.getById(id);
        if (companyPositionDO == null) {
            throw ServiceExceptionUtil.exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
        }
        return CompanyPositionConvert.INSTANCE.convertDetail(companyPositionDO);
    }

    /**
     * 分类
     *
     * @param page
     * @return
     */
    public PageResult<CompanyPositionPageRespDTO> pageCompanyPosition(CompanyPositionPageReqDTO page) {
        IPage<CompanyPositionDO> companyPositionPage = companyPositionMapper.selectPage(page);
        List<CompanyPositionPageRespDTO> list = Lists.newArrayList();
        for (CompanyPositionDO companyPositionDO : companyPositionPage.getRecords()) {
            CompanyPositionPageRespDTO companyPositionPageRespDTO = CompanyPositionConvert.INSTANCE.convertPageResp(companyPositionDO);
            companyPositionPageRespDTO.setStatus(PositionStatusEnum.getByCode(companyPositionDO.getStatus()));
            list.add(companyPositionPageRespDTO);
        }
        PageResult<CompanyPositionPageRespDTO> pageResult = new PageResult<CompanyPositionPageRespDTO>();
        pageResult.setList(list);
        pageResult.setTotal(companyPositionPage.getTotal());
        return pageResult;
    }

    public List<CompanyPositionRespDTO> getCompanyPositionsByIds(IdsReqDTO idsReqDTO) {
        List<CompanyPositionDO> companyPositionDOList = companyPositionMapper.getCompanyPositionsByIds(idsReqDTO.getIds());
        return CompanyPositionConvert.INSTANCE.convertList(companyPositionDOList);
    }

    @Transactional(rollbackFor = ServiceException.class)
    public int updateCompanyPositionStatus(CompanyPositionAuditReqDTO companyPositionAuditReqDTO) {
        int result = companyPositionMapper.updateById(CompanyPositionConvert.INSTANCE.convert(companyPositionAuditReqDTO));
        //只有审核失败，才有审核记录
        if (PositionStatusEnum.AUDIT_REFUSE_POSITION.getCode().equals(companyPositionAuditReqDTO.getStatus())) {
            this.saveCompanyPositionAuditRecord(companyPositionAuditReqDTO.getId(), companyPositionAuditReqDTO.getReason(), companyPositionAuditReqDTO.getAuditUserId());
        }
        return result;
    }

    public void saveCompanyPositionAuditRecord(Long companyPositionId, String reason, Long auditUserId) {
        CompanyPositionAuditRecordDO companyPositionAuditRecordDO = new CompanyPositionAuditRecordDO();
        companyPositionAuditRecordDO.setCompanyPositionId(companyPositionId);
        companyPositionAuditRecordDO.setAuditUserId(auditUserId);
        companyPositionAuditRecordDO.setReason(reason);
        companyPositionAuditRecordMapper.insert(companyPositionAuditRecordDO);
    }

    public PageResult<ManagementPositionPageRespDTO> managementPage(CompanyPositionPageReqDTO page) {
        IPage<CompanyPositionDO> companyPositionPage = companyPositionMapper.selectManagementPage(page);
        List<ManagementPositionPageRespDTO> list = Lists.newArrayList();
        for (CompanyPositionDO companyPositionDO : companyPositionPage.getRecords()) {
            ManagementPositionPageRespDTO managementPositionPageRespDTO = CompanyPositionConvert.INSTANCE.convertManagementPageResp(companyPositionDO);
            managementPositionPageRespDTO.setStatus(PositionStatusEnum.getByCode(companyPositionDO.getStatus()));
            list.add(managementPositionPageRespDTO);
        }
        PageResult<ManagementPositionPageRespDTO> pageResult = new PageResult<ManagementPositionPageRespDTO>();
        pageResult.setList(list);
        pageResult.setTotal(companyPositionPage.getTotal());
        return pageResult;
    }

    /**
     * 根据企业用户id修改职位状态
     * @param companyPositionUpdateStateDTO
     */
    public void updateByCompanyUserId(CompanyPositionUpdateStateDTO companyPositionUpdateStateDTO) {
        if (companyPositionUpdateStateDTO == null || companyPositionUpdateStateDTO.getCompanyUserId() == null) {
            throw ServiceExceptionUtil.exception(PositionErrorCodeConstants.PARAMETER_NULL.getCode());
        }
        companyPositionMapper.updateByCompanyUserId(companyPositionUpdateStateDTO);
    }

    /**
     * 职位交接
     * @param companyPositionHandoverReqDTO
     */
    public void handover(CompanyPositionHandoverReqDTO companyPositionHandoverReqDTO) {
        if (null == companyPositionHandoverReqDTO) {
            throw ServiceExceptionUtil
                .exception(PositionErrorCodeConstants.PARAMETER_NULL.getCode());
        }
        companyPositionMapper.handover(companyPositionHandoverReqDTO);
    }
}

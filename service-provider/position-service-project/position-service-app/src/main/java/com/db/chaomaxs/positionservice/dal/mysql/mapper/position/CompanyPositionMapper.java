package com.db.chaomaxs.positionservice.dal.mysql.mapper.position;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.CompanyPositionDO;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.GetCompanyPositionDO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionHandoverReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionUpdateStateDTO;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 企业_职位
 *
 * @author xiaofeng
 * @date 2021-03-29 16:36:57
 */
@Repository
public interface CompanyPositionMapper extends BaseMapper<CompanyPositionDO> {


    /**
     * 查询分页
     *
     * @param pageReqDTO
     * @return
     */
    default IPage<CompanyPositionDO> selectPage(CompanyPositionPageReqDTO pageReqDTO) {
        LambdaQueryWrapper<CompanyPositionDO> wrapper = Wrappers.lambdaQuery();
        wrapper.select(CompanyPositionDO::getId, CompanyPositionDO::getPositionName, CompanyPositionDO::getExperienceId,
                CompanyPositionDO::getEducationId, CompanyPositionDO::getProvinceCode, CompanyPositionDO::getCityCode,
                CompanyPositionDO::getAreaCode, CompanyPositionDO::getStartSalary, CompanyPositionDO::getEndSalary,
                CompanyPositionDO::getStatus, CompanyPositionDO::getBusinessDistrict)
                .eq(CompanyPositionDO::getCompanyUserId, pageReqDTO.getCompanyUserId());
        wrapper.eq(CompanyPositionDO::getCompanyUserId, pageReqDTO.getCompanyUserId());
        if (pageReqDTO.getStatus() != null) {
            wrapper.eq(CompanyPositionDO::getStatus, pageReqDTO.getStatus());
        }
        return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), wrapper);
    }


    /**
     * 系统后台查询
     * @param pageReqDTO
     * @return
     */
    default IPage<CompanyPositionDO> selectManagementPage(CompanyPositionPageReqDTO pageReqDTO) {
        LambdaQueryWrapper<CompanyPositionDO> wrapper = Wrappers.lambdaQuery();
        wrapper.select(CompanyPositionDO::getId, CompanyPositionDO::getPositionName, CompanyPositionDO::getPositionTypeId,
                CompanyPositionDO::getExperienceId, CompanyPositionDO::getEducationId,
                CompanyPositionDO::getProvinceCode, CompanyPositionDO::getCityCode,
                CompanyPositionDO::getStartSalary, CompanyPositionDO::getEndSalary,
                CompanyPositionDO::getStatus, CompanyPositionDO::getCompanyUserId, CompanyPositionDO::getCreateTime);
        if (pageReqDTO.getCompanyUserId() != null) {
            wrapper.eq(CompanyPositionDO::getCompanyUserId, pageReqDTO.getCompanyUserId());
        }
        return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), wrapper);
    }

    List<CompanyPositionDO> getCompanyPositionsByIds(@Param("ids") Set<Long> ids);

    GetCompanyPositionDO getById(@Param("id") Long id);


    /**
     * 根据企业用户修改职位状态
     *
     * @param companyPositionUpdateStateDTO
     */
    default void updateByCompanyUserId(CompanyPositionUpdateStateDTO companyPositionUpdateStateDTO) {
        update(null, Wrappers.<CompanyPositionDO>lambdaUpdate()
                .eq(CompanyPositionDO::getCompanyUserId, companyPositionUpdateStateDTO.getCompanyUserId())
                .set(CompanyPositionDO::getStatus, companyPositionUpdateStateDTO.getStatus()));
    }

    /**
     * 职位交接，修改职位用户id
     *
     * @param companyPositionHandoverReqDTO
     */
    default void handover(CompanyPositionHandoverReqDTO companyPositionHandoverReqDTO) {
        update(null, Wrappers.<CompanyPositionDO>lambdaUpdate()
                .eq(CompanyPositionDO::getCompanyUserId, companyPositionHandoverReqDTO.getUserId())
                .set(CompanyPositionDO::getCompanyUserId, companyPositionHandoverReqDTO.getHandoverUserId()));
    }
}

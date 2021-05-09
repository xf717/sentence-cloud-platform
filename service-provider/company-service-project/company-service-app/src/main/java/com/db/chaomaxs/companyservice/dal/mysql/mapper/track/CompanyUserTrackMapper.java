package com.db.chaomaxs.companyservice.dal.mysql.mapper.track;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.track.CompanyUserTrackDO;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackPageReqDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 企业我的足迹
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@Repository
public interface CompanyUserTrackMapper extends BaseMapper<CompanyUserTrackDO> {

    /**
     * 查询分页
     *
     * @param pageReqDTO
     * @return
     */
    default IPage<CompanyUserTrackDO> selectPage(CompanyUserTrackPageReqDTO pageReqDTO) {
        LambdaQueryWrapper<CompanyUserTrackDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(CompanyUserTrackDO::getId, CompanyUserTrackDO::getPositionId, CompanyUserTrackDO::getCompanyUserId, CompanyUserTrackDO::getUpdateTime)
                .eq(CompanyUserTrackDO::getUserId, pageReqDTO.getUserId());
        return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), queryWrapper);
    }

    CompanyUserTrackDO getByUserIdAndCompanyUserId(CompanyUserTrackDO companyUserTrackDO);

    int updateById(@Param("id") Long id);
}

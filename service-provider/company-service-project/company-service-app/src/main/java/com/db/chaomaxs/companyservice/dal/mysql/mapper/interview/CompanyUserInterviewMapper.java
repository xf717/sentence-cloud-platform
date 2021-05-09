package com.db.chaomaxs.companyservice.dal.mysql.mapper.interview;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.interview.CompanyUserInterviewDO;
import com.db.chaomaxs.companyservice.enums.interview.CompanyUserInterviewEnum;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewHandoverReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewIdReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewReqDTO;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticReqDTO;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 企业面试表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Repository
public interface CompanyUserInterviewMapper extends BaseMapper<CompanyUserInterviewDO> {

    /**
     * 根据参数查询数据
     *
     * @param queryReqDTO
     * @return
     */
    default List<CompanyUserInterviewDO> selectList(CompanyUserInterviewListQueryReqDTO queryReqDTO) {
        LambdaQueryWrapper<CompanyUserInterviewDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(CompanyUserInterviewDO::getId, CompanyUserInterviewDO::getUserId)
                .eq(CompanyUserInterviewDO::getCompanyUserId, queryReqDTO.getCompanyUserId())
                .ne(CompanyUserInterviewDO::getStatus, CompanyUserInterviewEnum.WAITING_ACCEPT_INTERVIEW.getCode())
                .ne(CompanyUserInterviewDO::getStatus, CompanyUserInterviewEnum.REFUSE_INTERVIEW.getCode());
        return selectList(queryWrapper);
    }

    /**
     * 查询分页
     *
     * @param pageReqDTO
     * @return
     */
    default IPage<CompanyUserInterviewDO> selectPage(CompanyUserInterviewPageReqDTO pageReqDTO) {
        LambdaQueryWrapper<CompanyUserInterviewDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(CompanyUserInterviewDO::getId, CompanyUserInterviewDO::getUserId, CompanyUserInterviewDO::getPositionId)
                .eq(CompanyUserInterviewDO::getCompanyUserId, pageReqDTO.getCompanyUserId())
                .ge(CompanyUserInterviewDO::getInterviemTime, LocalDate.now())
                .orderByDesc(CompanyUserInterviewDO::getInterviemTime);
        return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), queryWrapper);
    }



    CompanyUserInterviewDO getByCompanyUserIdAndUserId(CompanyUserInterviewReqDTO companyUserInterviewReqDTO);

    default List<CompanyUserInterviewDO> getCompanyUserInterviewByIds(CompanyUserInterviewIdReqDTO companyUserInterviewIdReqDTO) {
        return selectBatchIds(companyUserInterviewIdReqDTO.getIds());
    }

    default Integer selectCount(CompanyUserStatisticReqDTO companyUserStatisticReqDTO) {
        LambdaQueryWrapper<CompanyUserInterviewDO> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(CompanyUserInterviewDO::getCompanyUserId, companyUserStatisticReqDTO.getCompanyUserId())
                .eq(CompanyUserInterviewDO::getCompanyUserId, companyUserStatisticReqDTO.getCompanyUserId());
        return selectCount(wrapper);
    }

    /**
     * 面试信息用户id修改为交接用户id
     * @param companyUserInterviewHandoverReqDTO
     * @return
     */
    default void handover(CompanyUserInterviewHandoverReqDTO companyUserInterviewHandoverReqDTO) {
        update(null, Wrappers.<CompanyUserInterviewDO>lambdaUpdate()
            .eq(CompanyUserInterviewDO::getCompanyUserId, companyUserInterviewHandoverReqDTO.getUserId())
            .set(CompanyUserInterviewDO::getCompanyUserId, companyUserInterviewHandoverReqDTO.getHandoverUserId()));
    }

}

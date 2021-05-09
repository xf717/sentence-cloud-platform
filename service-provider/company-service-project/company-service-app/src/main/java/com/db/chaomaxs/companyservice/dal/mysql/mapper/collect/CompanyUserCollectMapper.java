package com.db.chaomaxs.companyservice.dal.mysql.mapper.collect;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.chat.CompanyUserChatDO;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.collect.CompanyUserCollectDO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.UserCollectPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticReqDTO;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 企业_用户_收藏
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Repository
public interface CompanyUserCollectMapper extends BaseMapper<CompanyUserCollectDO> {

    /**
     * 根据参数查询数据
     *
     * @param listReqDTO
     * @return
     */
    default List<CompanyUserCollectDO> selectList(CompanyUserCollectListQueryReqDTO listReqDTO) {
        return selectList(new QueryWrapperX<CompanyUserCollectDO>());
    }

    /**
     * 我的收藏
     *
     * @param pageReqDTO
     * @return
     */
    default IPage<CompanyUserCollectDO> selectPage(CompanyUserCollectPageReqDTO pageReqDTO) {
        LambdaQueryWrapper<CompanyUserCollectDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(CompanyUserCollectDO::getId, CompanyUserCollectDO::getPositionId, CompanyUserCollectDO::getUserId)
                .eq(CompanyUserCollectDO::getCompanyUserId, pageReqDTO.getCompanyUserId());
        return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), queryWrapper);
    }

    /**
     * 用户对我感兴趣
     * @param pageReqDTO
     * @return
     */
    default IPage<CompanyUserCollectDO> selectUserPage(UserCollectPageReqDTO pageReqDTO) {
        LambdaQueryWrapper<CompanyUserCollectDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(CompanyUserCollectDO::getId, CompanyUserCollectDO::getCompanyUserId, CompanyUserCollectDO::getPositionId)
                .eq(CompanyUserCollectDO::getUserId, pageReqDTO.getUserId());
        return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), queryWrapper);
    }

    CompanyUserCollectDO getByUserIdAndCompanyUserId(CompanyUserCollectDO companyUserCollectDO);

    default Integer selectCount(CompanyUserStatisticReqDTO companyUserStatisticReqDTO) {
        LambdaQueryWrapper<CompanyUserCollectDO> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(CompanyUserCollectDO::getCompanyUserId, companyUserStatisticReqDTO.getCompanyUserId())
                .eq(CompanyUserCollectDO::getCompanyUserId, companyUserStatisticReqDTO.getCompanyUserId());
        return selectCount(wrapper);
    }
}

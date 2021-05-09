package com.db.chaomaxs.companyservice.dal.mysql.mapper.chat;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.chat.CompanyUserChatDO;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.chat.CompanyUserChatStatisticsDO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticReqDTO;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 企业我的沟通
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Repository
public interface CompanyUserChatMapper extends BaseMapper<CompanyUserChatDO> {

    /**
     * 根据参数查询数据
     *
     * @param listReqDTO
     * @return
     */
    default List<CompanyUserChatDO> selectList(CompanyUserChatListQueryReqDTO listReqDTO) {
        return selectList(new QueryWrapperX<CompanyUserChatDO>());
    }

    /**
     * 查询分页
     *
     * @param pageReqDTO
     * @return
     */
    default IPage<CompanyUserChatDO> selectPage(CompanyUserChatPageReqDTO pageReqDTO) {
        LambdaQueryWrapper<CompanyUserChatDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(CompanyUserChatDO::getUserId)
                .eq(CompanyUserChatDO::getCompanyUserId, pageReqDTO.getCompanyUserId()).orderByDesc(CompanyUserChatDO::getUpdateTime);
        return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), queryWrapper);
    }

    CompanyUserChatDO getByUserIdAndCompanyUserId(CompanyUserChatDO companyUserChatDO);


    default Integer selectCount(CompanyUserStatisticReqDTO companyUserStatisticReqDTO) {
        LambdaQueryWrapper<CompanyUserChatDO> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(CompanyUserChatDO::getCompanyUserId, companyUserStatisticReqDTO.getCompanyUserId())
                .eq(CompanyUserChatDO::getCompanyUserId, companyUserStatisticReqDTO.getCompanyUserId());
        return selectCount(wrapper);
    }

    List<CompanyUserChatStatisticsDO> getStatisticByPositionIds(@Param("ids") Set<Long> ids);
}

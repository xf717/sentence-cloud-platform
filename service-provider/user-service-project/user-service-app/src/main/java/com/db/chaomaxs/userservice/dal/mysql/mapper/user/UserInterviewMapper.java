package com.db.chaomaxs.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserInterviewDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserStatisticReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 用户面试表
 *
 * @author momo
 * @date 2021-04-02 13:58:28
 */
@Repository
public interface UserInterviewMapper extends BaseMapper<UserInterviewDO> {

    /**
     * 根据参数查询数据
     *
     * @param listReqDTO
     * @return
     */
    default List<UserInterviewDO> selectList(UserInterviewListQueryReqDTO listReqDTO) {
        return selectList(new QueryWrapperX<UserInterviewDO>());
    }

    /**
     * 查询分页
     *
     * @param pageReqDTO
     * @return
     */
    default IPage<UserInterviewDO> selectPage(UserInterviewPageReqDTO pageReqDTO) {
        LambdaQueryWrapper<UserInterviewDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(UserInterviewDO::getId, UserInterviewDO::getUserId,
            UserInterviewDO::getCompanyUserInterviewId, UserInterviewDO::getStatus)
            .eq(UserInterviewDO::getUserId, pageReqDTO.getUserId());
        return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
            queryWrapper);
    }

    default Integer selectCount(UserStatisticReqDTO userStatisticReqDTO) {
        LambdaQueryWrapper<UserInterviewDO> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(UserInterviewDO::getUserId, userStatisticReqDTO.getUserId());
        return selectCount(wrapper);
    }
}

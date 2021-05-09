package com.db.chaomaxs.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserTrackDO;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserTrackStatisticsDO;
import com.db.chaomaxs.userservice.rpc.resume.dto.IdsReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserStatisticReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackPageReqDTO;
import java.util.List;
import java.util.Set;

import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackStatisticRespDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 我的足迹
 *
 * @author wst
 * @date 2021-03-29 12:47:47
 */
@Repository
public interface UserTrackMapper extends BaseMapper<UserTrackDO> {

    /**
     * 根据参数查询数据
     *
     * @param listReqDTO
     * @return
     */
    default List<UserTrackDO> selectList(UserTrackListQueryReqDTO listReqDTO) {
        return selectList(new QueryWrapperX<UserTrackDO>());
    }

    /**
     * 查询分页
     *
     * @param pageReqDTO
     * @return
     */
    default IPage<UserTrackDO> selectPage(UserTrackPageReqDTO pageReqDTO) {
        LambdaQueryWrapper<UserTrackDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(UserTrackDO::getId, UserTrackDO::getCompanyUserId, UserTrackDO::getPositionId)
                .eq(UserTrackDO::getUserId, pageReqDTO.getUserId());
        return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), queryWrapper);
    }

    UserTrackDO getByUserIdAndCompanyUserId(UserTrackDO userTrackDO);

    default Integer selectCount(UserStatisticReqDTO userStatisticReqDTO) {
        LambdaQueryWrapper<UserTrackDO> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(UserTrackDO::getUserId, userStatisticReqDTO.getUserId());
        return selectCount(wrapper);
    }

    int updateById(@Param("id") Long id);

    List<UserTrackStatisticsDO> getStatisticByPositionIds(@Param("ids") Set<Long> ids);
}

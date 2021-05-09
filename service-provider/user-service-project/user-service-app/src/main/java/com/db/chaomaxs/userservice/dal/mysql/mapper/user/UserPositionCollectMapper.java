package com.db.chaomaxs.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserPositionCollectDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionCollectListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionCollectPageReqDTO;
import java.util.List;
import com.db.chaomaxs.userservice.rpc.user.dto.UserStatisticReqDTO;
import org.springframework.stereotype.Repository;

/**
 * 用户_职位_收藏
 *
 * @author wst
 * @date 2021-03-29 12:47:47
 */
@Repository
public interface UserPositionCollectMapper extends BaseMapper<UserPositionCollectDO> {

    /**
     * 根据参数查询数据
     *
     * @param listReqDTO
     * @return
     */
    default List<UserPositionCollectDO> selectList(UserPositionCollectListQueryReqDTO listReqDTO) {
        return selectList(new QueryWrapperX<UserPositionCollectDO>());
    }

    /**
     * 查询分页
     *
     * @param pageReqDTO
     * @return
     */
    default IPage<UserPositionCollectDO> selectPage(UserPositionCollectPageReqDTO pageReqDTO) {
        LambdaQueryWrapper<UserPositionCollectDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(UserPositionCollectDO::getId, UserPositionCollectDO::getCompanyUserId, UserPositionCollectDO::getPositionId)
                .eq(UserPositionCollectDO::getUserId, pageReqDTO.getUserId());
        return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), queryWrapper);
    }

    UserPositionCollectDO getByUserIdAndCompanyUserId(UserPositionCollectDO userPositionCollectDO);

    default Integer selectCount(UserStatisticReqDTO userStatisticReqDTO) {
        LambdaQueryWrapper<UserPositionCollectDO> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(UserPositionCollectDO::getUserId, userStatisticReqDTO.getUserId());
        return selectCount(wrapper);
    }
}

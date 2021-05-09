package com.db.chaomaxs.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserChatDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserChatListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserChatPageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 用户_沟通
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Repository
public interface UserChatMapper extends BaseMapper<UserChatDO> {

    /**
     * 根据参数查询数据
     *
     * @param listReqDTO
     * @return
     */
    default List<UserChatDO> selectList(UserChatListQueryReqDTO listReqDTO) {
        return selectList(new QueryWrapperX<UserChatDO>());
    }

    /**
     * 查询分页
     *
     * @param pageReqDTO
     * @return
     */
    default IPage<UserChatDO> selectPage(UserChatPageReqDTO pageReqDTO) {
        LambdaQueryWrapper<UserChatDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(UserChatDO::getId, UserChatDO::getCompanyUserId)
                .eq(UserChatDO::getUserId, pageReqDTO.getUserId());
        return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), queryWrapper);
    }

    UserChatDO getByUserIdAndCompanyUserId(UserChatDO userChatDO);
}

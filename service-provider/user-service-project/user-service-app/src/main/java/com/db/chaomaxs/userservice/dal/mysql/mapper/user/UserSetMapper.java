package com.db.chaomaxs.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserSetDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserSetListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserSetPageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户_设置
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Repository
public interface UserSetMapper extends BaseMapper<UserSetDO> {

    /**
     * 根据参数查询数据
     *
     * @param listReqDTO
     * @return
     */
    default List<UserSetDO> selectList(UserSetListQueryReqDTO listReqDTO) {
        return selectList(new QueryWrapperX<UserSetDO>());
    }

    /**
     * 查询分页
     *
     * @param pageReqDTO
     * @return
     */
    default IPage<UserSetDO> selectPage(UserSetPageReqDTO pageReqDTO) {
        return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
                new QueryWrapperX<UserSetDO>());
    }

    UserSetDO getUserSetByUserIdAndCompanyUserId(@Param("userId") Long userId, @Param("companyUserId") Long companyUserId);
}

package com.github.xf717.userservice.dal.mysql.mapper.user;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserWordDO;
import com.github.xf717.userservice.rpc.user.dto.UserWordListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordPageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户_常用语
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Repository
public interface UserWordMapper extends BaseMapper<UserWordDO> {

    /**
     * 根据参数查询数据
     *
     * @param listReqDTO
     * @return
     */
    default List<UserWordDO> selectList(UserWordListQueryReqDTO listReqDTO) {
        return selectList(new QueryWrapperX<UserWordDO>());
    }

    /**
     * 查询分页
     *
     * @param pageReqDTO
     * @return
     */
    default IPage<UserWordDO> selectPage(UserWordPageReqDTO pageReqDTO) {
        LambdaQueryWrapper<UserWordDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(UserWordDO::getId, UserWordDO::getContent, UserWordDO::getSort)
                .eq(UserWordDO::getUserId, pageReqDTO.getUserId())
                .orderByDesc(UserWordDO::getSort);
        return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), queryWrapper);
    }

    Integer selectMaxSortByUserId(@Param("userId") Long userId);

    UserWordDO getById(@Param("id") Long id);
}

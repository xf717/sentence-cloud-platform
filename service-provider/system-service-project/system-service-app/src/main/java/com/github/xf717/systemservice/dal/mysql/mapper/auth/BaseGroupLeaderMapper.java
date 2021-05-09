package com.github.xf717.systemservice.dal.mysql.mapper.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.mapper.CommonMapper;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.systemservice.dal.mysql.dataobject.auth.BaseGroupLeaderDO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupLeaderListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupLeaderPageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Repository
public interface BaseGroupLeaderMapper extends CommonMapper<BaseGroupLeaderDO> {

  default List<BaseGroupLeaderDO> selectList(BaseGroupLeaderListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<BaseGroupLeaderDO>());
  }

  default IPage<BaseGroupLeaderDO> selectPage(BaseGroupLeaderPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<BaseGroupLeaderDO>());
  }

  /**
   * 根据组id 删除数据
   *
   * @param groupId
   * @auth xiaofeng
   */
  @Delete("DELETE FROM base_group_leader WHERE group_id = #{groupId}")
  void removeGroupLeadersById(@Param("groupId") Long groupId);

}

package com.db.chaomaxs.systemservice.dal.mysql.mapper.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.mapper.CommonMapper;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseGroupMemberDO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberPageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Repository
public interface BaseGroupMemberMapper extends CommonMapper<BaseGroupMemberDO> {

  default List<BaseGroupMemberDO> selectList(BaseGroupMemberListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<BaseGroupMemberDO>());
  }

  default IPage<BaseGroupMemberDO> selectPage(BaseGroupMemberPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<BaseGroupMemberDO>());
  }

  /**
   * 尝试一下在注解中写语句 根据组ID删除关联表中的数据
   *
   * @param groupId
   */
  @Delete("DELETE FROM base_group_member WHERE group_id = #{groupId}")
  void removeGroupMembersById(@Param("groupId") Long groupId);


}

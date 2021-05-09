package com.db.chaomaxs.systemservice.dal.mysql.mapper.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseElementDO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseElementListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseElementPageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Repository
public interface BaseElementMapper extends BaseMapper<BaseElementDO> {

  default List<BaseElementDO> selectList(BaseElementListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<BaseElementDO>());
  }

  default IPage<BaseElementDO> selectPage(BaseElementPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<BaseElementDO>());
  }


  public List<BaseElementDO> selectAuthorityElementByUserId(@Param("userId") Long userId);

  public List<BaseElementDO> selectAuthorityMenuElementByUserId(@Param("userId") Long userId,
      @Param("menuId") Long menuId);

  public List<BaseElementDO> selectAuthorityElementByClientId(@Param("clientId") String clientId);

  public List<BaseElementDO> selectAllElementPermissions();

}

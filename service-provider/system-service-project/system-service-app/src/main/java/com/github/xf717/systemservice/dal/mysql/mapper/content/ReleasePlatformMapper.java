package com.github.xf717.systemservice.dal.mysql.mapper.content;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.systemservice.dal.mysql.dataobject.content.ReleasePlatformDO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformPageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 发布平台
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Repository
public interface ReleasePlatformMapper extends BaseMapper<ReleasePlatformDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<ReleasePlatformDO> selectList(ReleasePlatformListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<ReleasePlatformDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<ReleasePlatformDO> selectPage(ReleasePlatformPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<ReleasePlatformDO>());
  }

}

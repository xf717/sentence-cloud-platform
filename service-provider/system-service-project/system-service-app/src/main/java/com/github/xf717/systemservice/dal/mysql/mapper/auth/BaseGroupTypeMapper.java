package com.github.xf717.systemservice.dal.mysql.mapper.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.systemservice.dal.mysql.dataobject.auth.BaseGroupTypeDO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypeListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypePageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Repository
public interface BaseGroupTypeMapper extends BaseMapper<BaseGroupTypeDO> {

  default List<BaseGroupTypeDO> selectList(BaseGroupTypeListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<BaseGroupTypeDO>());
  }

  default IPage<BaseGroupTypeDO> selectPage(BaseGroupTypePageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<BaseGroupTypeDO>());
  }

}

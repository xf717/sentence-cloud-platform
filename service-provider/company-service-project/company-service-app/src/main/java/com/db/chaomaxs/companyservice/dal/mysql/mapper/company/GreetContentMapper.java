package com.db.chaomaxs.companyservice.dal.mysql.mapper.company;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.GreetContentDO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentPageReqDTO;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 打招呼语
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Repository
public interface GreetContentMapper extends BaseMapper<GreetContentDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<GreetContentDO> selectList(GreetContentListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<GreetContentDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<GreetContentDO> selectPage(GreetContentPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<GreetContentDO>());
  }

  /**
   * 根据用户id
   * @param userId
   * @return
   */
  GreetContentDO selectByUserId(@Param("userId")Long userId);
}

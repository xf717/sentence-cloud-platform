package com.db.chaomaxs.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.mapper.CommonMapper;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserHideCompanyDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserHideCompanyListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserHideCompanyPageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户_屏蔽公司
 *
 * @author wst
 * @date 2021-03-29 12:47:48
 */
@Repository
public interface UserHideCompanyMapper extends CommonMapper<UserHideCompanyDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserHideCompanyDO> selectList(UserHideCompanyListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserHideCompanyDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserHideCompanyDO> selectPage(UserHideCompanyPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserHideCompanyDO>());
  }

  /**
   * 批量插入屏蔽公司
   * @param hideCompanyList
   * @return
   */
  int batchInsert(@Param("hideCompanyList")List<UserHideCompanyDO> hideCompanyList);

}

package com.github.xf717.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserRegisterCityDO;
import com.github.xf717.userservice.rpc.user.dto.UserRegisterCityListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRegisterCityPageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 用户注册城市表，注册时保存
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Repository
public interface UserRegisterCityMapper extends BaseMapper<UserRegisterCityDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserRegisterCityDO> selectList(UserRegisterCityListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserRegisterCityDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserRegisterCityDO> selectPage(UserRegisterCityPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserRegisterCityDO>());
  }

}

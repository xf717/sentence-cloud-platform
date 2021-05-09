package com.github.xf717.userservice.dal.mysql.mapper.resume;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserCredentialDO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialPageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户_资格证书表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Repository
public interface UserCredentialMapper extends BaseMapper<UserCredentialDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserCredentialDO> selectList(UserCredentialListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserCredentialDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserCredentialDO> selectPage(UserCredentialPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserCredentialDO>());
  }

  /**
   * 根据简历id 查询资格证书
   * @param resumeId
   * @return
   */
  List<UserCredentialDO> listCredentialByResumeId(@Param("resumeId")Long resumeId);

}

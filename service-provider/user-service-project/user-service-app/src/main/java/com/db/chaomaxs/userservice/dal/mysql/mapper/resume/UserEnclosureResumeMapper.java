package com.db.chaomaxs.userservice.dal.mysql.mapper.resume;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.resume.UserEnclosureResumeDO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEnclosureResumeListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEnclosureResumePageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户_附件_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Repository
public interface UserEnclosureResumeMapper extends BaseMapper<UserEnclosureResumeDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserEnclosureResumeDO> selectList(UserEnclosureResumeListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserEnclosureResumeDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserEnclosureResumeDO> selectPage(UserEnclosureResumePageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserEnclosureResumeDO>());
  }

  /**
   * 根据用户id查询 附件简历信息
   * @param userId
   * @return
   */
  List<UserEnclosureResumeDO> selectByUserId(@Param("userId") Long userId);

}

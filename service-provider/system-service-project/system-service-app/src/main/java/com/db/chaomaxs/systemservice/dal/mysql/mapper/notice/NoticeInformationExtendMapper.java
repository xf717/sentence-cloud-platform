package com.db.chaomaxs.systemservice.dal.mysql.mapper.notice;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.notice.NoticeInformationExtendDO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationExtendListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationExtendPageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 内容管理通知信息_扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@Repository
public interface NoticeInformationExtendMapper extends BaseMapper<NoticeInformationExtendDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<NoticeInformationExtendDO> selectList(
      NoticeInformationExtendListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<NoticeInformationExtendDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<NoticeInformationExtendDO> selectPage(NoticeInformationExtendPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<NoticeInformationExtendDO>());
  }

}

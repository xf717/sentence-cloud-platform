package com.db.chaomaxs.systemservice.dal.mysql.mapper.notice;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.notice.NoticeInformationDO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.notice.dto.NoticeInformationPageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 通知信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@Repository
public interface NoticeInformationMapper extends BaseMapper<NoticeInformationDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<NoticeInformationDO> selectList(NoticeInformationListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<NoticeInformationDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<NoticeInformationDO> selectPage(NoticeInformationPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<NoticeInformationDO>());
  }

}

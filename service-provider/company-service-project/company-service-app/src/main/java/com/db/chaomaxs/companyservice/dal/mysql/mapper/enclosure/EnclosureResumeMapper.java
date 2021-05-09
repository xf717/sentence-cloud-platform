package com.db.chaomaxs.companyservice.dal.mysql.mapper.enclosure;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.enclosure.EnclosureResumeDO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumePageReqDTO;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 企业附件简历
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Repository
public interface EnclosureResumeMapper extends BaseMapper<EnclosureResumeDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<EnclosureResumeDO> selectList(EnclosureResumeListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<EnclosureResumeDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<EnclosureResumeDO> selectPage(EnclosureResumePageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<EnclosureResumeDO>());
  }

}

package com.db.chaomaxs.companyservice.dal.mysql.mapper.audit;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.audit.CompanyAuditRecordDO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordPageReqDTO;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 公司_审核记录信息表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Repository
public interface CompanyAuditRecordMapper extends BaseMapper<CompanyAuditRecordDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<CompanyAuditRecordDO> selectList(CompanyAuditRecordListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<CompanyAuditRecordDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<CompanyAuditRecordDO> selectPage(CompanyAuditRecordPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<CompanyAuditRecordDO>());
  }

}

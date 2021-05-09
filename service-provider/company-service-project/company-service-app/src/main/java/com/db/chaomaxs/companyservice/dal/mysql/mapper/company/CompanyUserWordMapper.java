package com.db.chaomaxs.companyservice.dal.mysql.mapper.company;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.CompanyUserWordDO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordPageReqDTO;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 企业常用语表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Repository
public interface CompanyUserWordMapper extends BaseMapper<CompanyUserWordDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<CompanyUserWordDO> selectList(CompanyUserWordListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<CompanyUserWordDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<CompanyUserWordDO> selectPage(CompanyUserWordPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<CompanyUserWordDO>());
  }

}

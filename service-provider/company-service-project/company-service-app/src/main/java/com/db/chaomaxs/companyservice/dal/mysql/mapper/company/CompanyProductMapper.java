package com.db.chaomaxs.companyservice.dal.mysql.mapper.company;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.CompanyProductDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 公司_产品
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Repository
public interface CompanyProductMapper extends BaseMapper<CompanyProductDO> {

  /**
   * 获取公司产品
   *
   * @param companyId
   * @return
   */
  default List<CompanyProductDO> listProducts(Long companyId) {
    return selectList(Wrappers.<CompanyProductDO>lambdaQuery()
        .eq(CompanyProductDO::getCompanyId, companyId)
        .select(CompanyProductDO::getId,
            CompanyProductDO::getCompanyId,
            CompanyProductDO::getLogoUrl,
            CompanyProductDO::getProductName));
  }

  /**
   * 批量保存公司产品信息
   * @param companyProductDOs
   */
  void batchInsert(@Param("list") List<CompanyProductDO> companyProductDOs);

  /**
   * 根据companyId删除
   * @param companyId
   */
  default void deleteByCompanyId(Long companyId) {
    delete(Wrappers.<CompanyProductDO>lambdaQuery()
        .eq(CompanyProductDO::getCompanyId, companyId));
  }

}

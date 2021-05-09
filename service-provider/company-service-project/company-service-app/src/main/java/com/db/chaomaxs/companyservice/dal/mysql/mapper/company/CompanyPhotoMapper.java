package com.db.chaomaxs.companyservice.dal.mysql.mapper.company;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.CompanyPhotoDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 公司_相册
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Repository
public interface CompanyPhotoMapper extends BaseMapper<CompanyPhotoDO> {

  /**
   * 批量保存
   * @param companyPhotoDOs
   */
  void batchInsert(@Param("list") List<CompanyPhotoDO> companyPhotoDOs);

  /**
   * 获取公司相册
   * @param companyId
   * @return
   */
  default List<CompanyPhotoDO> selectByCompanyId(Long companyId) {
    return selectList(Wrappers.<CompanyPhotoDO>lambdaQuery()
        .eq(CompanyPhotoDO::getCompanyId, companyId)
        .select(CompanyPhotoDO::getId,
            CompanyPhotoDO::getCompanyId,
            CompanyPhotoDO::getPhotoUrl));
  }

  /**
   * 根据companyId删除
   * @param companyId
   */
  default void deleteByCompanyId(Long companyId) {
    delete(Wrappers.<CompanyPhotoDO>lambdaQuery()
        .eq(CompanyPhotoDO::getCompanyId, companyId));
  }

}

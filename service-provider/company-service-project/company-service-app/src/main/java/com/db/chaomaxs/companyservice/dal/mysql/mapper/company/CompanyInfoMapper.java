package com.db.chaomaxs.companyservice.dal.mysql.mapper.company;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.CompanyInfoDO;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 企业_基础信息
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Repository
public interface CompanyInfoMapper extends BaseMapper<CompanyInfoDO> {


  /**
   * 根据公司名称模糊查询
   * @param companyName
   * @return
   */
  default List<CompanyInfoDO> selectList(String companyName) {
    LambdaQueryWrapper<CompanyInfoDO> queryWrapper = Wrappers.lambdaQuery();
    if(null != companyName){
      queryWrapper.like(CompanyInfoDO::getFullName,companyName);
    }
    return selectList(queryWrapper);
  }


  /**
   *  根据公司ids 查询
   * @param ids
   * @return
   */
  List<CompanyInfoDO> listCompanyInfoByIds(@Param("ids") Set<Long> ids);

}

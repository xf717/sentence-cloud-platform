package com.db.chaomaxs.companyservice.dal.mysql.mapper.company;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.CompanyWelfareDO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfarePageReqDTO;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 公司福利
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Repository
public interface CompanyWelfareMapper extends BaseMapper<CompanyWelfareDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<CompanyWelfareDO> selectList(CompanyWelfareListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<CompanyWelfareDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<CompanyWelfareDO> selectPage(CompanyWelfarePageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<CompanyWelfareDO>());
  }

  /**
   * 批量保存默认类型
   * @param companyWelfareDOs
   */
  void batchSaveDefaultWelfare(@Param("companyWelfareDOs") List<CompanyWelfareDO> companyWelfareDOs);

  /**
   * 批量修改
   * @param companyWelfareDOs
   */
  void batchUpdateWelfareChoose(@Param("companyWelfareDOs") List<CompanyWelfareDO> companyWelfareDOs);

  /**
   * 获取默认福利信息
   * @param companyId
   * @param welfareType
   * @return
   */
  default List<CompanyWelfareDO> selectDefaultWelfare(Long companyId, Integer welfareType) {
    return selectList(Wrappers.<CompanyWelfareDO>lambdaQuery()
        .eq(CompanyWelfareDO::getCompanyId, companyId)
        .eq(CompanyWelfareDO::getWelfareType, welfareType)
        .select(CompanyWelfareDO::getId,
            CompanyWelfareDO::getCompanyId,
            CompanyWelfareDO::getName,
            CompanyWelfareDO::getIconUrl,
            CompanyWelfareDO::getWelfareType,
            CompanyWelfareDO::getParentId,
            CompanyWelfareDO::getChoose));
  }

  /**
   * 获取选中福利信息
   * @param companyId
   * @return
   */
  default List<CompanyWelfareDO> selectChooseWelfare(Long companyId) {
    return selectList(Wrappers.<CompanyWelfareDO>lambdaQuery()
        .eq(CompanyWelfareDO::getCompanyId, companyId)
        .eq(CompanyWelfareDO::getChoose, 1)
        .select(CompanyWelfareDO::getId,
            CompanyWelfareDO::getCompanyId,
            CompanyWelfareDO::getName,
            CompanyWelfareDO::getIconUrl,
            CompanyWelfareDO::getWelfareType,
            CompanyWelfareDO::getParentId,
            CompanyWelfareDO::getChoose));
  }

  /**
   * 获取所有福利信息
   * @param companyId
   * @return
   */
  default List<CompanyWelfareDO> selectAllWelfare(Long companyId) {
    return selectList(Wrappers.<CompanyWelfareDO>lambdaQuery()
        .eq(CompanyWelfareDO::getCompanyId, companyId)
        .select(CompanyWelfareDO::getId,
            CompanyWelfareDO::getCompanyId,
            CompanyWelfareDO::getName,
            CompanyWelfareDO::getIconUrl,
            CompanyWelfareDO::getWelfareType,
            CompanyWelfareDO::getParentId,
            CompanyWelfareDO::getChoose));
  }

}

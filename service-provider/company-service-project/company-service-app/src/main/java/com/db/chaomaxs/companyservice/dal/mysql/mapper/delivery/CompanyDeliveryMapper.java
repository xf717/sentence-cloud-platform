package com.db.chaomaxs.companyservice.dal.mysql.mapper.delivery;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.delivery.CompanyDeliveryDO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticReqDTO;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 企业投递表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Repository
public interface CompanyDeliveryMapper extends BaseMapper<CompanyDeliveryDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<CompanyDeliveryDO> selectList(CompanyDeliveryListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<CompanyDeliveryDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @returnCompanyUserCollectMapper
   */
  default IPage<CompanyDeliveryDO> selectPage(CompanyDeliveryPageReqDTO pageReqDTO) {
    LambdaQueryWrapper<CompanyDeliveryDO> queryWrapper = Wrappers.lambdaQuery();
    queryWrapper.select(CompanyDeliveryDO::getId, CompanyDeliveryDO::getUserId,
        CompanyDeliveryDO::getPositionId)
        .eq(CompanyDeliveryDO::getCompanyUserId, pageReqDTO.getCompanyUserId());
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), queryWrapper);
  }

  CompanyDeliveryDO getByUserIdAndCompanyUserId(CompanyDeliveryDO companyDeliveryDO);

  default Integer selectCount(CompanyUserStatisticReqDTO companyUserStatisticReqDTO) {
    LambdaQueryWrapper<CompanyDeliveryDO> wrapper = Wrappers.lambdaQuery();
    wrapper.eq(CompanyDeliveryDO::getCompanyUserId, companyUserStatisticReqDTO.getCompanyUserId())
        .eq(CompanyDeliveryDO::getCompanyUserId, companyUserStatisticReqDTO.getCompanyUserId());
    return selectCount(wrapper);
  }
}

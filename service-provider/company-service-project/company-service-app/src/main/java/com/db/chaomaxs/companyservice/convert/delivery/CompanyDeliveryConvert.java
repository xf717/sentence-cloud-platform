package com.db.chaomaxs.companyservice.convert.delivery;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.delivery.CompanyDeliveryDO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryRespDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * CompanyDeliveryConvert
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyDeliveryConvert {

  CompanyDeliveryConvert INSTANCE = Mappers.getMapper(CompanyDeliveryConvert.class);

  /**
   * 将 CompanyDeliveryDTO 转成 CompanyDeliveryVO
   *
   * @param createReqDTO
   * @return
   */
  CompanyDeliveryDO convert(CompanyDeliveryCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  CompanyDeliveryDO convert(CompanyDeliveryUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<CompanyDeliveryRespDTO> convertList(List<CompanyDeliveryDO> list);

  /**
   * 对象转换
   *
   * @param companyDeliveryDO
   * @return
   */
  CompanyDeliveryRespDTO convert(CompanyDeliveryDO companyDeliveryDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<CompanyDeliveryRespDTO> convertPage(IPage<CompanyDeliveryDO> page);


}

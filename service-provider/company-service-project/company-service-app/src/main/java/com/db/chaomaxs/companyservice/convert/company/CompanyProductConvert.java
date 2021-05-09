package com.db.chaomaxs.companyservice.convert.company;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.CompanyProductDO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * CompanyProductConvert
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyProductConvert {

  CompanyProductConvert INSTANCE = Mappers.getMapper(CompanyProductConvert.class);

  /**
   * 将 CompanyProductDTO 转成 CompanyProductVO
   *
   * @param createReqDTO
   * @return
   */
  CompanyProductDO convert(CompanyProductCreateReqDTO createReqDTO);

  /**
   * 将 createReqDTOs 转成 CompanyProductDOs
   *
   * @param createReqDTOs
   * @return
   */
  List<CompanyProductDO> convert(List<CompanyProductCreateReqDTO> createReqDTOs);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  CompanyProductDO convert(CompanyProductUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<CompanyProductRespDTO> convertList(List<CompanyProductDO> list);

  /**
   * 对象转换
   *
   * @param companyProductDO
   * @return
   */
  CompanyProductRespDTO convert(CompanyProductDO companyProductDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<CompanyProductRespDTO> convertPage(IPage<CompanyProductDO> page);


}

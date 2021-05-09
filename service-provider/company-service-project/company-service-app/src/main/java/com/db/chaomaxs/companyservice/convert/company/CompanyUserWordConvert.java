package com.db.chaomaxs.companyservice.convert.company;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.CompanyUserWordDO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * CompanyUserWordConvert
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyUserWordConvert {

  CompanyUserWordConvert INSTANCE = Mappers.getMapper(CompanyUserWordConvert.class);

  /**
   * 将 CompanyUserWordDTO 转成 CompanyUserWordVO
   *
   * @param createReqDTO
   * @return
   */
  CompanyUserWordDO convert(CompanyUserWordCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  CompanyUserWordDO convert(CompanyUserWordUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<CompanyUserWordRespDTO> convertList(List<CompanyUserWordDO> list);

  /**
   * 对象转换
   *
   * @param companyUserWordDO
   * @return
   */
  CompanyUserWordRespDTO convert(CompanyUserWordDO companyUserWordDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<CompanyUserWordRespDTO> convertPage(IPage<CompanyUserWordDO> page);


}

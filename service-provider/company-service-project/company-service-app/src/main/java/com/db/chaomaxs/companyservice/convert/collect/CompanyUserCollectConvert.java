package com.db.chaomaxs.companyservice.convert.collect;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.collect.CompanyUserCollectDO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectRespDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.UserCollectRespDTO;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * CompanyUserCollectConvert
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyUserCollectConvert {

  CompanyUserCollectConvert INSTANCE = Mappers.getMapper(CompanyUserCollectConvert.class);

  /**
   * 将 CompanyUserCollectDTO 转成 CompanyUserCollectVO
   *
   * @param createReqDTO
   * @return
   */
  CompanyUserCollectDO convert(CompanyUserCollectCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  CompanyUserCollectDO convert(CompanyUserCollectUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<CompanyUserCollectRespDTO> convertList(List<CompanyUserCollectDO> list);

  /**
   * 对象转换
   *
   * @param companyUserCollectDO
   * @return
   */
  CompanyUserCollectRespDTO convert(CompanyUserCollectDO companyUserCollectDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<CompanyUserCollectRespDTO> convertPage(IPage<CompanyUserCollectDO> page);


  @Mapping(source = "records", target = "list")
  PageResult<UserCollectRespDTO> convertUserPage(IPage<CompanyUserCollectDO> companyUserCollectPage);
}

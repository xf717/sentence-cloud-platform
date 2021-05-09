package com.db.chaomaxs.companyservice.convert.interview;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.interview.CompanyUserInterviewDO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewAndCompanyInfoRespDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewRespDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateStateReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUsersRespDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * CompanyUserInterviewConvert
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyUserInterviewConvert {

  CompanyUserInterviewConvert INSTANCE = Mappers.getMapper(CompanyUserInterviewConvert.class);

  /**
   * 将 CompanyUserInterviewDTO 转成 CompanyUserInterviewVO
   *
   * @param createReqDTO
   * @return
   */
  CompanyUserInterviewDO convert(CompanyUserInterviewCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  CompanyUserInterviewDO convert(CompanyUserInterviewUpdateReqDTO updateReqDTO);


  /**
   * 将更新转成DO
   *
   * @param updateStateReqDTO
   * @return
   */
  CompanyUserInterviewDO convert(CompanyUserInterviewUpdateStateReqDTO updateStateReqDTO);


  CompanyUserInterviewDO convert(CompanyUserInterviewQueryReqDTO companyUserInterviewQueryReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<CompanyUserInterviewRespDTO> convertList(List<CompanyUserInterviewDO> list);

  /**
   * 对象转换
   *
   * @param companyUserInterviewDO
   * @return
   */
  CompanyUserInterviewRespDTO convert(CompanyUserInterviewDO companyUserInterviewDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<CompanyUserInterviewRespDTO> convertPage(IPage<CompanyUserInterviewDO> page);


  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<CompanyUserInterviewUsersRespDTO> convertToList(List<CompanyUserInterviewDO> list);


  /**
   * list 转换
   * @param companyUserInterviewRespList
   * @return
   */
  List<CompanyUserInterviewAndCompanyInfoRespDTO> convertInterviewToList(
      List<CompanyUserInterviewRespDTO> companyUserInterviewRespList);


}

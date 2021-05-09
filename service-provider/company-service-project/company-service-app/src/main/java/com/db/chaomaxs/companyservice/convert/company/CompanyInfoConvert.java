package com.db.chaomaxs.companyservice.convert.company;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.CompanyInfoDO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyFullNameRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoDetailRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoListRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * CompanyInfoConvert
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyInfoConvert {

  CompanyInfoConvert INSTANCE = Mappers.getMapper(CompanyInfoConvert.class);

  /**
   * 将 CompanyInfoDTO 转成 CompanyInfoVO
   *
   * @param createReqDTO
   * @return
   */
  CompanyInfoDO convert(CompanyInfoCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  CompanyInfoDO convert(CompanyInfoUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<CompanyInfoRespDTO> convertList(List<CompanyInfoDO> list);

  /**
   * 对象转换
   *
   * @param companyInfoDO
   * @return
   */
  CompanyInfoRespDTO convert(CompanyInfoDO companyInfoDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<CompanyInfoRespDTO> convertPage(IPage<CompanyInfoDO> page);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<CompanyInfoListRespDTO> convertCompanyInfoList(List<CompanyInfoDO> list);

  /**
   * 公司基础信息转换
   *
   * @param companyInfo
   * @return
   */
  CompanyInfoDetailRespDTO convert(CompanyInfoRespDTO companyInfo);

  /**
   * list 转换
   * @param list
   * @return
   */
  List<CompanyFullNameRespDTO> convertToList(List<CompanyInfoDO> list);
}

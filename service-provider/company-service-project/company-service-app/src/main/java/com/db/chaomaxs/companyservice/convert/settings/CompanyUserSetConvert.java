package com.db.chaomaxs.companyservice.convert.settings;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.settings.CompanyUserSetDO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetRespDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * CompanyUserSetConvert
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@Mapper
public interface CompanyUserSetConvert {

  CompanyUserSetConvert INSTANCE = Mappers.getMapper(CompanyUserSetConvert.class);

  /**
   * 将 CompanyUserSetDTO 转成 CompanyUserSetVO
   *
   * @param createReqDTO
   * @return
   */
  CompanyUserSetDO convert(CompanyUserSetCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  CompanyUserSetDO convert(CompanyUserSetUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<CompanyUserSetRespDTO> convertList(List<CompanyUserSetDO> list);

  /**
   * 对象转换
   *
   * @param companyUserSetDO
   * @return
   */
  CompanyUserSetRespDTO convert(CompanyUserSetDO companyUserSetDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<CompanyUserSetRespDTO> convertPage(IPage<CompanyUserSetDO> page);

  CompanyUserSetDO convert(CompanyUserSetQueryReqDTO companyUserSetQueryReqDTO);


}

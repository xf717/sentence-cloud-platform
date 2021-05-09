package com.db.chaomaxs.companyservice.convert.company;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.CompanyPhotoDO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoRespDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * CompanyPhotoConvert
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyPhotoConvert {

  CompanyPhotoConvert INSTANCE = Mappers.getMapper(CompanyPhotoConvert.class);

  /**
   * 将 CompanyPhotoDTO 转成 CompanyPhotoVO
   *
   * @param createReqDTO
   * @return
   */
  CompanyPhotoDO convert(CompanyPhotoReqDTO createReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<CompanyPhotoRespDTO> convertList(List<CompanyPhotoDO> list);

  /**
   * 对象转换
   *
   * @param companyPhotoDO
   * @return
   */
  CompanyPhotoRespDTO convert(CompanyPhotoDO companyPhotoDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<CompanyPhotoRespDTO> convertPage(IPage<CompanyPhotoDO> page);

  /**
   * companyPhotoRespDTOS 转换
   * @param companyPhotoReqDTOS
   * @return
   */
  List<CompanyPhotoDO> convertCompanyPhotoDOs(List<CompanyPhotoReqDTO> companyPhotoReqDTOS);

}

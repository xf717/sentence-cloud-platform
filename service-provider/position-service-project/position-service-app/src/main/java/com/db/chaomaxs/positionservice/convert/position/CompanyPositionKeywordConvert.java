package com.db.chaomaxs.positionservice.convert.position;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.CompanyPositionKeywordDO;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.GetCompanyPositionKeywordDO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionKeywordCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionKeywordRespDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * CompanyPositionKeywordConvert
 *
 * @author momo
 * @date 2021-04-20 11:16:23
 */
@Mapper
public interface CompanyPositionKeywordConvert {

        CompanyPositionKeywordConvert INSTANCE = Mappers.getMapper(CompanyPositionKeywordConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      CompanyPositionKeywordDO convert(CompanyPositionKeywordCreateReqDTO createReqDTO);


    /**
     * list 转换
     *
     * @param list
     * @return
     */
    List<CompanyPositionKeywordRespDTO> convertList(List<GetCompanyPositionKeywordDO> list);
  /**
   * 对象转换
   *
   * @param companyPositionKeywordDO
   * @return
   */
      CompanyPositionKeywordRespDTO convert(CompanyPositionKeywordDO companyPositionKeywordDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<CompanyPositionKeywordRespDTO> convertPage(IPage<CompanyPositionKeywordDO> page);


}

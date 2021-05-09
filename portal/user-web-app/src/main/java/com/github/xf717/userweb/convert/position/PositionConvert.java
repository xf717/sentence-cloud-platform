package com.github.xf717.userweb.convert.position;

import com.github.xf717.common.framework.msg.TableData;
import com.github.xf717.positionservice.rpc.position.dto.CompanyPositionDetailRespDTO;
import com.github.xf717.positionservice.rpc.position.dto.CompanyPositionPageReqDTO;
import com.github.xf717.positionservice.rpc.position.dto.CompanyPositionPageRespDTO;
import com.github.xf717.positionservice.rpc.position.dto.CompanyPositionRespDTO;
import com.github.xf717.searchservice.rpc.position.dto.SearchPositionRespDTO;
import com.github.xf717.userweb.controller.position.dto.SearchPositionPageReqDTO;
import com.github.xf717.userweb.controller.position.vo.CompanyPositionVO;
import com.github.xf717.userweb.controller.position.vo.SearchPositionVO;
import com.github.xf717.userweb.service.postition.vo.PositionDetailVO;
import com.github.xf717.userweb.service.postition.vo.PositionVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换职位分类信息表
 *
 * @author ding
 * @date 2021-04-06 17:45:09
 */
@Mapper
public interface PositionConvert {

  PositionConvert INSTANCE = Mappers.getMapper(PositionConvert.class);


  /**
   * list 转换成 VO list
   *
   * @param companyPositionRespDTO
   * @return
   */

  PositionVO convert(CompanyPositionRespDTO companyPositionRespDTO);


  com.github.xf717.searchservice.rpc.position.dto.SearchPositionPageReqDTO convert(
      SearchPositionPageReqDTO positionSearchReq);

  TableData<SearchPositionVO> convert(TableData<SearchPositionRespDTO> data);

  TableData<CompanyPositionVO> convertCompanyPosition(TableData<CompanyPositionPageRespDTO> data);

  PositionDetailVO convert(CompanyPositionDetailRespDTO companyPositionDetailRespDTO);

  /**
   * 转换
   *
   * @param companyPositionPage
   * @return
   */
  CompanyPositionPageReqDTO convert(
      com.github.xf717.userweb.controller.position.dto.CompanyPositionPageReqDTO companyPositionPage);


}

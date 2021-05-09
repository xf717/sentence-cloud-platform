package com.db.chaomaxs.userweb.convert.position;

import com.db.chaomaxs.common.framework.msg.TableData;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionDetailRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionRespDTO;
import com.db.chaomaxs.searchservice.rpc.position.dto.SearchPositionRespDTO;
import com.db.chaomaxs.userweb.controller.position.dto.SearchPositionPageReqDTO;
import com.db.chaomaxs.userweb.controller.position.vo.CompanyPositionVO;
import com.db.chaomaxs.userweb.controller.position.vo.SearchPositionVO;
import com.db.chaomaxs.userweb.service.postition.vo.PositionDetailVO;
import com.db.chaomaxs.userweb.service.postition.vo.PositionVO;
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


  com.db.chaomaxs.searchservice.rpc.position.dto.SearchPositionPageReqDTO convert(
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
      com.db.chaomaxs.userweb.controller.position.dto.CompanyPositionPageReqDTO companyPositionPage);


}

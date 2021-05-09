package com.db.chaomaxs.companyweb.convert.company;

import com.db.chaomaxs.companyweb.controller.company.dto.CompanyUserWordPageDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.db.chaomaxs.companyweb.controller.company.dto.CompanyUserWordAddDTO;

import com.db.chaomaxs.companyweb.controller.company.dto.CompanyUserWordDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyUserWordUpdateDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyUserWordVO;

import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordPageReqDTO;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;

/**
 * 应用层实体对象转换企业常用语表
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyUserWordConvert {

        CompanyUserWordConvert INSTANCE = Mappers.getMapper(CompanyUserWordConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
    CompanyUserWordCreateReqDTO convert(CompanyUserWordAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
    CompanyUserWordUpdateReqDTO convert(CompanyUserWordUpdateDTO updateDTO);

  @Mappings({})
    CompanyUserWordListQueryReqDTO convert(CompanyUserWordDTO companyUserWordDTO);

  /**
* BO convert VO
*
* @param companyUserWordRespDTO 转换对象
* @return
*/
  @Mappings({})
      CompanyUserWordVO convert(CompanyUserWordRespDTO companyUserWordRespDTO);

  @Mappings({})
  List<CompanyUserWordVO> convertList(List<CompanyUserWordRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<CompanyUserWordVO> convert(
      TableResultResponse<CompanyUserWordRespDTO> tableResultResponse);

  @Mappings({})
    CompanyUserWordPageReqDTO convert(CompanyUserWordPageDTO companyUserWordPageDTO);

}

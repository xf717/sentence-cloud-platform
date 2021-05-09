package com.db.chaomaxs.companyweb.convert.collect;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectRespDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectUpdateReqDTO;
import com.db.chaomaxs.companyweb.controller.collect.dto.CompanyUserCollectAddDTO;
import com.db.chaomaxs.companyweb.controller.collect.dto.CompanyUserCollectPageDTO;
import com.db.chaomaxs.companyweb.controller.collect.dto.CompanyUserCollectUpdateDTO;
import com.db.chaomaxs.companyweb.controller.collect.vo.CompanyUserCollectVO;
import com.db.chaomaxs.companyweb.service.resume.vo.UserResumeInfoVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换企业_用户_收藏
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyUserCollectConvert {

  CompanyUserCollectConvert INSTANCE = Mappers.getMapper(CompanyUserCollectConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyUserCollectCreateReqDTO convert(CompanyUserCollectAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyUserCollectUpdateReqDTO convert(CompanyUserCollectUpdateDTO updateDTO);


  /**
   * BO convert VO
   *
   * @param companyUserCollectRespDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyUserCollectVO convert(CompanyUserCollectRespDTO companyUserCollectRespDTO);

  @Mappings({})
  List<CompanyUserCollectVO> convertList(List<CompanyUserCollectRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserResumeInfoVO> convert(
      TableResultResponse<CompanyUserCollectRespDTO> tableResultResponse);

  @Mappings({})
  CompanyUserCollectPageReqDTO convert(CompanyUserCollectPageDTO companyUserCollectPageDTO);

}

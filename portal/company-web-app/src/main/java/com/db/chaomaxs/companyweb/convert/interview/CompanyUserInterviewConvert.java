package com.db.chaomaxs.companyweb.convert.interview;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewRespDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateReqDTO;
import com.db.chaomaxs.companyweb.controller.interview.dto.CompanyUserInterviewAddDTO;
import com.db.chaomaxs.companyweb.controller.interview.dto.CompanyUserInterviewDTO;
import com.db.chaomaxs.companyweb.controller.interview.dto.CompanyUserInterviewPageDTO;
import com.db.chaomaxs.companyweb.controller.interview.dto.CompanyUserInterviewUpdateDTO;
import com.db.chaomaxs.companyweb.controller.interview.vo.CompanyUserInterviewVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换企业面试表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyUserInterviewConvert {

  CompanyUserInterviewConvert INSTANCE = Mappers.getMapper(CompanyUserInterviewConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyUserInterviewCreateReqDTO convert(CompanyUserInterviewAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyUserInterviewUpdateReqDTO convert(CompanyUserInterviewUpdateDTO updateDTO);

  @Mappings({})
  CompanyUserInterviewListQueryReqDTO convert(CompanyUserInterviewDTO companyUserInterviewDTO);

  /**
   * BO convert VO
   *
   * @param CompanyUserInterviewRespDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyUserInterviewVO convert(CompanyUserInterviewRespDTO companyUserInterviewRespDTO);

  @Mappings({})
  List<CompanyUserInterviewVO> convertList(List<CompanyUserInterviewRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<CompanyUserInterviewVO> convert(
      TableResultResponse<CompanyUserInterviewRespDTO> tableResultResponse);

  @Mappings({})
  CompanyUserInterviewPageReqDTO convert(CompanyUserInterviewPageDTO CompanyUserInterviewPageDTO);

}

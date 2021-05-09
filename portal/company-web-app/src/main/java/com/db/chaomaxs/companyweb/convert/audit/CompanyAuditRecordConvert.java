package com.db.chaomaxs.companyweb.convert.audit;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordRespDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordUpdateReqDTO;
import com.db.chaomaxs.companyweb.controller.audit.dto.CompanyAuditRecordAddDTO;
import com.db.chaomaxs.companyweb.controller.audit.dto.CompanyAuditRecordDTO;
import com.db.chaomaxs.companyweb.controller.audit.dto.CompanyAuditRecordPageDTO;
import com.db.chaomaxs.companyweb.controller.audit.dto.CompanyAuditRecordUpdateDTO;
import com.db.chaomaxs.companyweb.controller.audit.vo.CompanyAuditRecordVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换公司_审核记录信息表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyAuditRecordConvert {

  CompanyAuditRecordConvert INSTANCE = Mappers.getMapper(CompanyAuditRecordConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyAuditRecordCreateReqDTO convert(CompanyAuditRecordAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyAuditRecordUpdateReqDTO convert(CompanyAuditRecordUpdateDTO updateDTO);

  /**
   * @param companyAuditRecordDTO
   * @return
   */
  @Mappings({})
  CompanyAuditRecordListQueryReqDTO convert(CompanyAuditRecordDTO companyAuditRecordDTO);

  /**
   * BO convert VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  CompanyAuditRecordVO convert(CompanyAuditRecordRespDTO respDTO);

  /**
   * @param listResp
   * @return
   */
  @Mappings({})
  List<CompanyAuditRecordVO> convertList(List<CompanyAuditRecordRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<CompanyAuditRecordVO> convert(
      TableResultResponse<CompanyAuditRecordRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  CompanyAuditRecordPageReqDTO convert(CompanyAuditRecordPageDTO pageDTO);

}

package com.db.chaomaxs.companyservice.convert.audit;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.audit.CompanyAuditRecordDO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordRespDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * CompanyAuditRecordConvert
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface CompanyAuditRecordConvert {

  CompanyAuditRecordConvert INSTANCE = Mappers.getMapper(CompanyAuditRecordConvert.class);

  /**
   * 将 CompanyAuditRecordDTO 转成 CompanyAuditRecordVO
   *
   * @param createReqDTO
   * @return
   */
  CompanyAuditRecordDO convert(CompanyAuditRecordCreateReqDTO createReqDTO);

  /**
   * 将更新转成DO
   *
   * @param updateReqDTO
   * @return
   */
  CompanyAuditRecordDO convert(CompanyAuditRecordUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<CompanyAuditRecordRespDTO> convertList(List<CompanyAuditRecordDO> list);

  /**
   * 对象转换
   *
   * @param companyAuditRecordDO
   * @return
   */
  CompanyAuditRecordRespDTO convert(CompanyAuditRecordDO companyAuditRecordDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<CompanyAuditRecordRespDTO> convertPage(IPage<CompanyAuditRecordDO> page);


}

package com.db.chaomaxs.companyservice.service.audit;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.convert.audit.CompanyAuditRecordConvert;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.audit.CompanyAuditRecordDO;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.audit.CompanyAuditRecordMapper;
import com.db.chaomaxs.companyservice.enums.CompanyErrorCodeConstants;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordRespDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyAuditRecordService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class CompanyAuditRecordService {

  @Autowired
  private CompanyAuditRecordMapper companyAuditRecordMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveCompanyAuditRecord(CompanyAuditRecordCreateReqDTO createReqDTO) {
    return companyAuditRecordMapper
        .insert(CompanyAuditRecordConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateCompanyAuditRecord(CompanyAuditRecordUpdateReqDTO updateReqDTO) {
    CompanyAuditRecordDO companyAuditRecordDO = companyAuditRecordMapper
        .selectById(updateReqDTO.getId());
    if (companyAuditRecordDO == null) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    companyAuditRecordDO = CompanyAuditRecordConvert.INSTANCE.convert(updateReqDTO);
    int result = companyAuditRecordMapper.updateById(companyAuditRecordDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteCompanyAuditRecord(Long id) {
    if (companyAuditRecordMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = companyAuditRecordMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<CompanyAuditRecordRespDTO> listCompanyAuditRecords(
      CompanyAuditRecordListQueryReqDTO listQueryReqDTO) {
    List<CompanyAuditRecordDO> list = companyAuditRecordMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return CompanyAuditRecordConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public CompanyAuditRecordRespDTO getCompanyAuditRecordById(Long id) {
    CompanyAuditRecordDO CompanyAuditRecordDO = companyAuditRecordMapper.selectById(id);
    if (CompanyAuditRecordDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return CompanyAuditRecordConvert.INSTANCE.convert(CompanyAuditRecordDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<CompanyAuditRecordRespDTO> pageCompanyAuditRecord(
      CompanyAuditRecordPageReqDTO page) {
    IPage<CompanyAuditRecordDO> companyAuditRecordPage = companyAuditRecordMapper.selectPage(page);
    return CompanyAuditRecordConvert.INSTANCE.convertPage(companyAuditRecordPage);
  }


}

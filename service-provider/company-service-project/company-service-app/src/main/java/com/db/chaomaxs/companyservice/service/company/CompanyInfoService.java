package com.db.chaomaxs.companyservice.service.company;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.companyservice.convert.company.CompanyInfoConvert;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.CompanyInfoDO;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.company.CompanyInfoMapper;
import com.db.chaomaxs.companyservice.enums.CompanyErrorCodeConstants;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyFullNameRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoListReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoListRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyInfoService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class CompanyInfoService {

  @Autowired
  private CompanyInfoMapper companyInfoMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public Long saveCompanyInfo(CompanyInfoCreateReqDTO createReqDTO) {
    CompanyInfoDO companyInfoDO = CompanyInfoConvert.INSTANCE.convert(createReqDTO);
    companyInfoMapper.insert(companyInfoDO);
    return companyInfoDO.getId();
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateCompanyInfo(CompanyInfoUpdateReqDTO updateReqDTO) {
    CompanyInfoDO companyInfoDO = companyInfoMapper.selectById(updateReqDTO.getId());
    if (companyInfoDO == null) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.RESULT_NULL.getCode());
    }
    companyInfoDO = CompanyInfoConvert.INSTANCE.convert(updateReqDTO);
    int result = companyInfoMapper.updateById(companyInfoDO);
    return result;
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public CompanyInfoRespDTO getCompanyInfoById(Long id) {
    CompanyInfoDO CompanyInfoDO = companyInfoMapper.selectById(id);
    if (CompanyInfoDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.PARAMETER_NULL.getCode());
    }
    return CompanyInfoConvert.INSTANCE.convert(CompanyInfoDO);
  }

  public List<CompanyInfoListRespDTO> listCompanyInfoByIds(
      CompanyInfoListReqDTO companyInfoListReqDTO) {
    List<CompanyInfoDO> companyInfoList = companyInfoMapper
        .listCompanyInfoByIds(companyInfoListReqDTO.getIdsList());
    if (CollectionUtils.isEmpty(companyInfoList)) {
      return Collections.emptyList();
    }
    return CompanyInfoConvert.INSTANCE.convertCompanyInfoList(companyInfoList);

  }

  public CompanyInfoRespDTO getCompanyInfoByCompanyName(String companyName) {
    if (StringUtils.isEmpty(companyName)) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.PARAMETER_NULL.getCode());
    }
    CompanyInfoDO companyInfoDO = companyInfoMapper
        .selectOne(new LambdaQueryWrapper<CompanyInfoDO>()
            .eq(CompanyInfoDO::getFullName, companyName)
            .select(CompanyInfoDO::getId, CompanyInfoDO::getFullName));
    return CompanyInfoConvert.INSTANCE.convert(companyInfoDO);
  }

  public List<CompanyFullNameRespDTO> listCompanyName(String companyName) {
    List<CompanyInfoDO> list = companyInfoMapper.selectList(companyName);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return CompanyInfoConvert.INSTANCE.convertToList(list);
  }

}

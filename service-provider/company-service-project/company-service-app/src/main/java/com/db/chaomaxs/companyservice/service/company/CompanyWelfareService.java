package com.db.chaomaxs.companyservice.service.company;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.companyservice.convert.company.CompanyWelfareConvert;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.CompanyWelfareDO;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.company.CompanyWelfareMapper;
import com.db.chaomaxs.companyservice.enums.CompanyErrorCodeConstants;
import com.db.chaomaxs.companyservice.enums.welfare.CompanyWelfareTypeEnum;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareSaveReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareUpdateReqDTO;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyWelfareService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class CompanyWelfareService {

  /**
   * 默认福利类型companyId
   */
  private static final Long DEFAULT_WELFARE_TYPE_ID = -1L;

  @Autowired
  private CompanyWelfareMapper companyWelfareMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveCompanyWelfare(CompanyWelfareCreateReqDTO createReqDTO) {
    if (null == createReqDTO) {
      throw ServiceExceptionUtil.exception(CompanyErrorCodeConstants.PARAMETER_NULL.getCode());
    }
    return companyWelfareMapper.insert(CompanyWelfareConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateCompanyWelfare(CompanyWelfareUpdateReqDTO updateReqDTO) {
    if (null == updateReqDTO || null == updateReqDTO.getId()) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.PARAMETER_NULL.getCode());
    }
    CompanyWelfareDO companyWelfareDO = companyWelfareMapper.selectById(updateReqDTO.getId());
    if (companyWelfareDO == null) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.RESULT_NULL.getCode());
    }
    companyWelfareDO = CompanyWelfareConvert.INSTANCE.convert(updateReqDTO);
    int result = companyWelfareMapper.updateById(companyWelfareDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteCompanyWelfare(Long id) {
    if (companyWelfareMapper.selectById(id) == null) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.RESULT_NULL.getCode());
    }
    int result = companyWelfareMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<CompanyWelfareRespDTO> listCompanyWelfares(
      CompanyWelfareListQueryReqDTO listQueryReqDTO) {
    List<CompanyWelfareDO> list = companyWelfareMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return CompanyWelfareConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public CompanyWelfareRespDTO getCompanyWelfareById(Long id) {
    CompanyWelfareDO companyWelfareDO = companyWelfareMapper.selectById(id);
    if (companyWelfareDO == null) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.RESULT_NULL.getCode());
    }
    return CompanyWelfareConvert.INSTANCE.convert(companyWelfareDO);
  }

  /**
   * 获取选中福利类型
   * @param companyId
   * @return
   */
  public List<CompanyWelfareRespDTO> listWelfareTypes(Long companyId) {
    if (null == companyId) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.PARAMETER_NULL.getCode());
    }
    // 查询是否存在默认类型数据
    List<CompanyWelfareDO> defaultWelfareDOs =
        companyWelfareMapper.selectDefaultWelfare(companyId, CompanyWelfareTypeEnum.GENERAL.getValue());
    if (CollectionUtils.isEmpty(defaultWelfareDOs)) {
      // 为添加默认类型时返回表中默认类型数据
      return getDefaultWelfare();
    }
    // 查询选中福利类型
    List<CompanyWelfareDO> companyWelfareDOs = companyWelfareMapper.selectChooseWelfare(companyId);
    return CompanyWelfareConvert.INSTANCE.convertList(companyWelfareDOs);
  }

  /**
   * 获取默认福利类型
   * @return
   */
  public List<CompanyWelfareRespDTO> getDefaultWelfare() {
    List<CompanyWelfareDO> companyWelfareDOs =
        companyWelfareMapper.selectDefaultWelfare(DEFAULT_WELFARE_TYPE_ID, CompanyWelfareTypeEnum.GENERAL.getValue());
    if (CollectionUtils.isEmpty(companyWelfareDOs)) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.DEFAULT_WELFARE_NULL.getCode());
    }
    return CompanyWelfareConvert.INSTANCE.convertList(companyWelfareDOs);
  }

  /**
   * 保存默认福利类型
   * @param companyWelfareSaveReqDTOs
   */
  public void saveDefaultWelfare(List<CompanyWelfareSaveReqDTO> companyWelfareSaveReqDTOs) {
    if (CollectionUtils.isEmpty(companyWelfareSaveReqDTOs)) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.PARAMETER_NULL.getCode());
    }
    companyWelfareMapper.batchSaveDefaultWelfare(
        CompanyWelfareConvert.INSTANCE.convertToCompanyWelfareDOs(companyWelfareSaveReqDTOs));
  }

  /**
   * 批量修改
   * @param companyWelfareSaveReqDTOs
   */
  public void batchUpdateWelfareChoose(List<CompanyWelfareSaveReqDTO> companyWelfareSaveReqDTOs) {
    if (CollectionUtils.isEmpty(companyWelfareSaveReqDTOs)) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.PARAMETER_NULL.getCode());
    }
    companyWelfareMapper.batchUpdateWelfareChoose(
        CompanyWelfareConvert.INSTANCE.convertToCompanyWelfareDOs(companyWelfareSaveReqDTOs));
  }

  /**
   * 保存选中福利类型
   * @param companyWelfareSaveReqDTOs
   */
  @Transactional(rollbackFor = Exception.class)
  public void saveChooseWelfare(List<CompanyWelfareSaveReqDTO> companyWelfareSaveReqDTOs) {
    if (CollectionUtils.isEmpty(companyWelfareSaveReqDTOs)) {
      throw ServiceExceptionUtil.exception(CompanyErrorCodeConstants.PARAMETER_NULL.getCode());
    }
    // 验证是否添加默认类型
    checkDefaultWelfare(companyWelfareSaveReqDTOs);
    // 批量修改福利为选中状态
    List<CompanyWelfareSaveReqDTO> saveReqDTOs = companyWelfareSaveReqDTOs.stream()
        .filter(v -> !(CompanyWelfareTypeEnum.GENERAL.getValue().equals(v.getWelfareType())
            && v.getParentId() == 0)).collect(Collectors.toList());
    saveReqDTOs.stream().forEach(v -> {
      v.setChoose(1);
    });
    batchUpdateWelfareChoose(saveReqDTOs);
  }

  /**
   * 检查是否添加默认类型，未添加则添加
   */
  private void checkDefaultWelfare(List<CompanyWelfareSaveReqDTO> companyWelfareSaveReqDTOs) {
    // 判断是否已添加默认类型
    CompanyWelfareSaveReqDTO companyWelfareSaveReqDTO = companyWelfareSaveReqDTOs.stream()
        .filter(v -> CompanyWelfareTypeEnum.GENERAL.getValue().equals(v.getWelfareType()) && v.getParentId() == 0)
        .findFirst().orElse(null);
    if (companyWelfareSaveReqDTO == null) {
      return;
    }
    Map<Long, CompanyWelfareSaveReqDTO> welfareSaveReqDTOMap = companyWelfareSaveReqDTOs.stream()
        .filter(v -> CompanyWelfareTypeEnum.GENERAL.getValue().equals(v.getWelfareType())
            && v.getParentId() == 0)
        .collect(Collectors.toMap(CompanyWelfareSaveReqDTO::getId, a -> a, (k1, k2) -> k2));
    // 获取默认类型
    List<CompanyWelfareRespDTO> defaultWelfares = getDefaultWelfare();
    defaultWelfares.stream().forEach(v -> {
      v.setChoose(null == welfareSaveReqDTOMap.get(v.getId()) ? 0 : 1);
      v.setParentId(v.getId());
      v.setName("");
    });
    // 添加默认类型
    saveDefaultWelfare(CompanyWelfareConvert.INSTANCE.convertToCompanyWelfareSaveReqDTOs(defaultWelfares));
  }

  /**
   * 获取所有福利类型
   * @param companyId
   * @return
   */
  public List<CompanyWelfareRespDTO> listAllWelfare(Long companyId) {
    if (null == companyId) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.PARAMETER_NULL.getCode());
    }
    List<CompanyWelfareDO> companyWelfareDOs = companyWelfareMapper.selectAllWelfare(companyId);
    if (CollectionUtils.isEmpty(companyWelfareDOs)) {
      return Lists.newArrayList();
    }
    List<CompanyWelfareRespDTO> companyWelfareRespDTOs = CompanyWelfareConvert.INSTANCE
        .convertList(companyWelfareDOs);
    Map<Long, CompanyWelfareRespDTO> defaultWelfareMap = getDefaultWelfare().stream()
        .collect(Collectors.toMap(CompanyWelfareRespDTO::getId, a -> a, (k1, k2) -> k2));
    companyWelfareRespDTOs.stream()
        .filter(v -> CompanyWelfareTypeEnum.GENERAL.getValue().equals(v.getWelfareType())).collect(Collectors.toList())
        .forEach(v -> {
          v.setName(null == defaultWelfareMap.get(v.getParentId()) ? null : defaultWelfareMap.get(v.getParentId()).getName());
        });
    return companyWelfareRespDTOs;
  }

}

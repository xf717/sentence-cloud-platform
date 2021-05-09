package com.db.chaomaxs.companyservice.service.interview;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.convert.interview.CompanyUserInterviewConvert;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.interview.CompanyUserInterviewDO;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.company.CompanyInfoMapper;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.interview.CompanyUserInterviewMapper;
import com.db.chaomaxs.companyservice.enums.CompanyErrorCodeConstants;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewHandoverReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewIdReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewRespDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateStateReqDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUsersRespDTO;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyUserInterviewService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class CompanyUserInterviewService {

  @Autowired
  private CompanyUserInterviewMapper companyUserInterviewMapper;

  @Autowired
  private CompanyInfoMapper companyInfoMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveCompanyUserInterview(CompanyUserInterviewCreateReqDTO createReqDTO) {
    return companyUserInterviewMapper
        .insert(CompanyUserInterviewConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateCompanyUserInterview(CompanyUserInterviewUpdateReqDTO updateReqDTO) {
    CompanyUserInterviewDO companyUserInterviewDO = companyUserInterviewMapper
        .selectById(updateReqDTO.getId());
    if (companyUserInterviewDO == null) {
      throw ServiceExceptionUtil.exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return companyUserInterviewMapper
        .updateById(CompanyUserInterviewConvert.INSTANCE.convert(updateReqDTO));
  }

  public int updateCompanyUserInterviewState(
      CompanyUserInterviewUpdateStateReqDTO updateStateReqDTO) {
    CompanyUserInterviewDO companyUserInterviewDO = companyUserInterviewMapper
        .selectById(updateStateReqDTO.getId());
    if (companyUserInterviewDO == null) {
      throw ServiceExceptionUtil.exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    companyUserInterviewDO = CompanyUserInterviewConvert.INSTANCE.convert(updateStateReqDTO);
    int result = companyUserInterviewMapper.updateById(companyUserInterviewDO);
    return result;
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public CompanyUserInterviewRespDTO getCompanyUserInterviewById(Long id) {
    CompanyUserInterviewDO companyUserInterviewDO = companyUserInterviewMapper.selectById(id);
    if (companyUserInterviewDO == null) {
      throw ServiceExceptionUtil.exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return CompanyUserInterviewConvert.INSTANCE.convert(companyUserInterviewDO);
  }

  public CompanyUserInterviewRespDTO getByCompanyUserIdAndUserId(
      CompanyUserInterviewReqDTO companyUserInterviewReqDTO) {
    CompanyUserInterviewDO companyUserInterviewDO = companyUserInterviewMapper
        .getByCompanyUserIdAndUserId(companyUserInterviewReqDTO);
    return CompanyUserInterviewConvert.INSTANCE.convert(companyUserInterviewDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<CompanyUserInterviewRespDTO> pageCompanyUserInterview(
      CompanyUserInterviewPageReqDTO page) {
    IPage<CompanyUserInterviewDO> CompanyUserInterviewPage = companyUserInterviewMapper
        .selectPage(page);
    return CompanyUserInterviewConvert.INSTANCE.convertPage(CompanyUserInterviewPage);
  }

  public List<CompanyUserInterviewRespDTO> getCompanyUserInterviewByIds(
      CompanyUserInterviewIdReqDTO companyUserInterviewIdReqDTO) {
    if (CollectionUtils.isEmpty(companyUserInterviewIdReqDTO.getIds())) {
      return Collections.emptyList();
    }
    List<CompanyUserInterviewDO> companyUserInterviewDOList = companyUserInterviewMapper
        .getCompanyUserInterviewByIds(companyUserInterviewIdReqDTO);
    if (CollectionUtils.isEmpty(companyUserInterviewDOList)) {
      return Collections.emptyList();
    }
    return CompanyUserInterviewConvert.INSTANCE.convertList(companyUserInterviewDOList);
  }

  public List<CompanyUserInterviewUsersRespDTO> interviewList(
      CompanyUserInterviewListQueryReqDTO queryReqDTO) {
    List<CompanyUserInterviewDO> list = companyUserInterviewMapper.selectList(queryReqDTO);
    return CompanyUserInterviewConvert.INSTANCE.convertToList(list);
  }

  public Integer count(CompanyUserStatisticReqDTO companyUserStatisticReqDTO) {
    return companyUserInterviewMapper.selectCount(companyUserStatisticReqDTO);
  }

//  public List<CompanyUserInterviewAndCompanyInfoRespDTO> listCompanyUserInterviewByIds(
//      CompanyUserInterviewIdReqDTO companyUserInterviewIdReqDTO) {
//    List<CompanyUserInterviewRespDTO> companyUserInterviewRespList = getCompanyUserInterviewByIds(
//        companyUserInterviewIdReqDTO);
//    if (CollectionUtils.isEmpty(companyUserInterviewRespList)) {
//      return Collections.emptyList();
//    }
//    List<CompanyUserInterviewAndCompanyInfoRespDTO> respList = CompanyUserInterviewConvert.INSTANCE
//        .convertInterviewToList(companyUserInterviewRespList);
//    Set<Long> companyIds = companyUserInterviewRespList.stream()
//        .map(CompanyUserInterviewRespDTO::getCompanyId).collect(Collectors.toSet());
//    List<CompanyInfoDO> companyInfoList = companyInfoMapper.listCompanyInfoByIds(companyIds);
//    Map<Long, CompanyInfoDO> companyInfoMap = companyInfoList.stream().collect(Collectors.
//        toMap(CompanyInfoDO::getId, a -> a, (k1, k2) -> k1));
//    for (CompanyUserInterviewAndCompanyInfoRespDTO dto : respList) {
//      if (companyInfoMap.get(dto.getCompanyId()) != null) {
//        dto.setDevelopmentStageDictionaryId(companyInfoMap
//            .get(dto.getCompanyId()).getDevelopmentStageDictionaryId());
//        dto.setScopeDictionaryId(companyInfoMap.get(dto.getCompanyId()).getScopeDictionaryId());
//        dto.setFullName(companyInfoMap.get(dto.getCompanyId()).getFullName());
//        dto.setIndustryName(companyInfoMap.get(dto.getCompanyId()).getIndustryName());
//      }
//    }
//    return respList;
//  }

  /**
   * 面试信息交接
   * @param companyUserInterviewHandoverReqDTO
   */
  public void handover(CompanyUserInterviewHandoverReqDTO companyUserInterviewHandoverReqDTO) {
    if (null == companyUserInterviewHandoverReqDTO) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.PARAMETER_NULL.getCode());
    }
    companyUserInterviewMapper.handover(companyUserInterviewHandoverReqDTO);
  }


}

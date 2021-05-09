package com.db.chaomaxs.companyservice.service.company;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.convert.company.CompanyUserWordConvert;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.CompanyUserWordDO;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.company.CompanyUserWordMapper;
import com.db.chaomaxs.companyservice.enums.CompanyErrorCodeConstants;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyUserWordService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class CompanyUserWordService {

  @Autowired
  private CompanyUserWordMapper companyUserWordMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveCompanyUserWord(CompanyUserWordCreateReqDTO createReqDTO) {
    return companyUserWordMapper.insert(CompanyUserWordConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateCompanyUserWord(CompanyUserWordUpdateReqDTO updateReqDTO) {
    CompanyUserWordDO companyUserWordDO = companyUserWordMapper.selectById(updateReqDTO.getId());
    if (companyUserWordDO == null) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    companyUserWordDO = CompanyUserWordConvert.INSTANCE.convert(updateReqDTO);
    int result = companyUserWordMapper.updateById(companyUserWordDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteCompanyUserWord(Long id) {
    if (companyUserWordMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = companyUserWordMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<CompanyUserWordRespDTO> listCompanyUserWords(
      CompanyUserWordListQueryReqDTO listQueryReqDTO) {
    List<CompanyUserWordDO> list = companyUserWordMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return CompanyUserWordConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public CompanyUserWordRespDTO getCompanyUserWordById(Long id) {
    CompanyUserWordDO CompanyUserWordDO = companyUserWordMapper.selectById(id);
    if (CompanyUserWordDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return CompanyUserWordConvert.INSTANCE.convert(CompanyUserWordDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<CompanyUserWordRespDTO> pageCompanyUserWord(CompanyUserWordPageReqDTO page) {
    IPage<CompanyUserWordDO> companyUserWordPage = companyUserWordMapper.selectPage(page);
    return CompanyUserWordConvert.INSTANCE.convertPage(companyUserWordPage);
  }


}

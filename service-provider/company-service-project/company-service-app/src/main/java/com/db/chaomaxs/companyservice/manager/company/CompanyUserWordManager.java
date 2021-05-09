package com.db.chaomaxs.companyservice.manager.company;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordUpdateReqDTO;
import com.db.chaomaxs.companyservice.service.company.CompanyUserWordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyUserWordManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyUserWordManager {

  @Autowired
  private CompanyUserWordService companyUserWordService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveCompanyUserWord(CompanyUserWordCreateReqDTO createReqDTO) {
    return companyUserWordService.saveCompanyUserWord(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateCompanyUserWord(CompanyUserWordUpdateReqDTO updateReqDTO) {
    return companyUserWordService.updateCompanyUserWord(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteCompanyUserWord(Long id) {
    return companyUserWordService.deleteCompanyUserWord(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<CompanyUserWordRespDTO> listCompanyUserWords(
      CompanyUserWordListQueryReqDTO listQueryReqDTO) {
    return companyUserWordService.listCompanyUserWords(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public CompanyUserWordRespDTO getCompanyUserWordById(Long id) {
    return companyUserWordService.getCompanyUserWordById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<CompanyUserWordRespDTO> pageCompanyUserWord(CompanyUserWordPageReqDTO page) {
    return companyUserWordService.pageCompanyUserWord(page);
  }


}

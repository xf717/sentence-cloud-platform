package com.db.chaomaxs.companyservice.manager.collect;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.rpc.collect.dto.*;
import com.db.chaomaxs.companyservice.service.collect.CompanyUserCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyUserCollectManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyUserCollectManager {

  @Autowired
  private CompanyUserCollectService companyUserCollectService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveCompanyUserCollect(CompanyUserCollectCreateReqDTO createReqDTO) {
    return companyUserCollectService.saveCompanyUserCollect(createReqDTO);
  }


  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteCompanyUserCollect(Long id) {
    return companyUserCollectService.deleteCompanyUserCollect(id);
  }

  /**
   * 根据id获取对象
   * @param id
   * @return
   */
  public CompanyUserCollectRespDTO getCompanyUserCollectById(Long id) {
    return companyUserCollectService.getCompanyUserCollectById(id);
  }

  /**
   * 我的收藏
   *
   * @param page
   * @return
   */
  public PageResult<CompanyUserCollectRespDTO> pageCompanyUserCollect(CompanyUserCollectPageReqDTO page) {
    return companyUserCollectService.pageCompanyUserCollect(page);
  }

  /**
   * 用户收藏
   *
   * @param page
   * @return
   */
  public PageResult<UserCollectRespDTO> pageCompanyUserCollect(UserCollectPageReqDTO page) {
    return companyUserCollectService.pageUserCollect(page);
  }


}

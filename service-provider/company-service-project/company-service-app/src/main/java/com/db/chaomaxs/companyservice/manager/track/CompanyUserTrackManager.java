package com.db.chaomaxs.companyservice.manager.track;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackRespDTO;
import com.db.chaomaxs.companyservice.service.track.CompanyUserTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyUserTrackManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@Service
@Validated
public class CompanyUserTrackManager {

  @Autowired
  private CompanyUserTrackService companyUserTrackService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveCompanyUserTrack(CompanyUserTrackCreateReqDTO createReqDTO) {
    return companyUserTrackService.saveCompanyUserTrack(createReqDTO);
  }


  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<CompanyUserTrackRespDTO> pageCompanyUserTrack(CompanyUserTrackPageReqDTO page) {
    return companyUserTrackService.pageCompanyUserTrack(page);
  }


    public CompanyUserTrackRespDTO getCompanyUserTrackById(Long id) {
      return companyUserTrackService.getCompanyUserTrackById(id);
    }
}

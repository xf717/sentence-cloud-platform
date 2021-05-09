package com.db.chaomaxs.companyservice.manager.enclosure;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumePageReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeRespDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeUpdateReqDTO;
import com.db.chaomaxs.companyservice.service.enclosure.EnclosureResumeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * EnclosureResumeManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class EnclosureResumeManager {

  @Autowired
  private EnclosureResumeService enclosureResumeService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveEnclosureResume(EnclosureResumeCreateReqDTO createReqDTO) {
    return enclosureResumeService.saveEnclosureResume(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateEnclosureResume(EnclosureResumeUpdateReqDTO updateReqDTO) {
    return enclosureResumeService.updateEnclosureResume(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteEnclosureResume(Long id) {
    return enclosureResumeService.deleteEnclosureResume(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<EnclosureResumeRespDTO> listEnclosureResumes(
      EnclosureResumeListQueryReqDTO listQueryReqDTO) {
    return enclosureResumeService.listEnclosureResumes(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public EnclosureResumeRespDTO getEnclosureResumeById(Long id) {
    return enclosureResumeService.getEnclosureResumeById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<EnclosureResumeRespDTO> pageEnclosureResume(EnclosureResumePageReqDTO page) {
    return enclosureResumeService.pageEnclosureResume(page);
  }


}
